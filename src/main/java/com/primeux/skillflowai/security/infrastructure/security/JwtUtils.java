package com.primeux.skillflowai.security.infrastructure.security;

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

    @Value("${jwt.secret_key}")
    private String secretKey;

    @Getter
    @Value("${jwt.expiration_in_ms}")
    private long expirationInMs;


    public String generateToken(SkillflowUserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }

    public String generateToken(Map<String, Object> claims, SkillflowUserDetails userDetails) {
        return generateToken(claims, userDetails, expirationInMs);
    }

    private String generateToken(Map<String, Object> additionalClaims, SkillflowUserDetails userDetails, long expirationMs) {
        if (additionalClaims == null) {
            additionalClaims = new HashMap<>();
        }
        additionalClaims.put(CLAIM_AUTHORITIES, userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList());

        return Jwts.builder()
                .claims()
                .add(additionalClaims)
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

    public List<String> getAuthoritiesFromToken(String token) {
        return extractAllClaims(token).get(CLAIM_AUTHORITIES, List.class);
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