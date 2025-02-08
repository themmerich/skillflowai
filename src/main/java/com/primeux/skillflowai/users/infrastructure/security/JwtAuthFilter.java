package com.primeux.skillflowai.users.infrastructure.security;

import com.primeux.skillflowai.app.tenant.TenantContext;
import com.primeux.skillflowai.users.core.domain.model.Email;
import com.primeux.skillflowai.users.core.domain.model.User;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtUtils jwtUtils;

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain) throws ServletException, IOException {

        // TODO: Oauth2 Prozess implementieren, mit Token-Refresh etc.
        // Außerdem beim User einbauen, dass diese inaktiv geschaltet werden können + nach der Registrierung die Email einmal verifiziert werden muss

        log.debug("Current auth before processing: {}",
                SecurityContextHolder.getContext().getAuthentication());

        final String token = extractToken(request);
        try {
            if (token != null && jwtUtils.validateToken(token)) {
                setTenantFromToken(token);
                // we have a valid token, so we can extract the user data from the token and add it to the SecurityContext
                Authentication auth = getAuthentication(token, request);
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
            filterChain.doFilter(request, response);
        } finally {
            if (SecurityContextHolder.getContext().getAuthentication() == null) {
                log.warn("Security context was cleared during filter chain execution");
            }
            TenantContext.clear();
        }
        log.debug("Final auth state: {}",
                SecurityContextHolder.getContext().getAuthentication());
    }

    private void setTenantFromToken(String token) {
        String allowedTenant = jwtUtils.getTenantIdFromToken(token);
        if (allowedTenant == null) {
            // should never happen
            throw new RuntimeException("No tenant in JWT token. This is not allowed");
        }
        TenantContext.setCurrentTenant(allowedTenant);
    }

    private String extractToken(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer ")) {
            return header.substring(7);
        }
        return null;
    }

    private Authentication getAuthentication(String token, HttpServletRequest request) {
        String username = jwtUtils.getUsernameFromToken(token);
        User user = new User();
        user.setEmail(Email.of(username));
        SkillflowUserDetails userDetails = new SkillflowUserDetails(user);
        List<String> authorities = jwtUtils.getAuthoritiesFromToken(token);
        //TODO: OrganizationId (Mandantenkennung) in das Token aufnehmen und hier im Context setzen
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username, null, authorities.stream().map(SimpleGrantedAuthority::new).toList());
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        return authentication;
    }
}
