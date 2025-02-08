package com.primeux.skillflowai.users.infrastructure.security;

import com.primeux.skillflowai.app.tenant.TenantContext;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

//@Component
class TenantFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            // Beispiel: Tenant aus einem HTTP-Header extrahieren
            String tenantId = request.getHeader("x-tenant-id");

            /*if (tenantId == null || tenantId.isEmpty()) {
                throw new RuntimeException("Missing tenant in header");
            }*/
            TenantContext.setCurrentTenant(tenantId);
            filterChain.doFilter(request, response);
        } finally {
            TenantContext.clear();
        }
    }
}
