package com.claim_service.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;

@Component
public class JwtUtil {

    private static final String SECRET =
            "insurance-secret-insurance-secret-insurance";
    private final Key key = Keys.hmacShaKeyFor(SECRET.getBytes());

    public Claims extractClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public Long extractUserId(String token) {
        return Long.parseLong(
                extractClaims(token).getSubject()
        );
    }
    public String extractRole(String token) {
        return extractClaims(token)
                .get("role", String.class);
    }
}