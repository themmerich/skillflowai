package com.primeux.skillflowai.users.infrastructure.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Component
class JwtUtils {

    private static final String CLAIM_AUTHORITIES = "authorities";
    private static final String CLAIM_TENANT_ID = "tenantId";

    @Value("${jwt.secret_key}")
    private String secretKey;

    @Getter
    @Value("${jwt.expiration_access_in_ms}")
    private long expirationAccessInMs;

    @Getter
    @Value("${jwt.expiration_refresh_in_ms}")
    private long expirationRefreshInMs;


    public String generateRefreshToken(SkillflowUserDetails userDetails) {
        return generateToken(addOrCreateDefaultClaims(userDetails), userDetails, expirationRefreshInMs);
    }

    public String generateAccessToken(SkillflowUserDetails userDetails) {
        HashMap<String, Object> claims = addOrCreateDefaultClaims(userDetails);
        claims.put(CLAIM_AUTHORITIES, userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList());

        return generateToken(claims, userDetails, expirationAccessInMs);
    }

    private HashMap<String, Object> addOrCreateDefaultClaims(SkillflowUserDetails userDetails) {
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put(CLAIM_TENANT_ID, userDetails.getTenantId());
        return resultMap;
    }

    private String generateToken(Map<String, Object> claims, SkillflowUserDetails userDetails, long expirationMs) {
        return Jwts.builder()
                .claims()
                .add(claims)
                .subject(userDetails.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + expirationMs))
                .and()
                .signWith(getSigningKey())
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            return !isExpired(token);
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    private boolean isExpired(String token) {
        return extractClaim(token, Claims::getExpiration).toInstant().isBefore(Instant.now());
    }

    public String getUsernameFromToken(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public String getTenantIdFromToken(String token) {
        return extractAllClaims(token).get(CLAIM_TENANT_ID, String.class);
    }

    public List<String> getAuthoritiesFromToken(String token) {
        return extractClaim(token, claims -> claims.get(CLAIM_AUTHORITIES, List.class));
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts
                .parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    private SecretKey getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}