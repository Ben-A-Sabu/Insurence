package com.example.apigateway.config.security;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;

@Component
public class JwtUtil {
    private static final String SECRET = "INSURANCE_SECRET_12345678901234567890";

    public void validate(String token) {
        Jwts.parserBuilder()
            .setSigningKey(SECRET.getBytes())
            .build()
            .parseClaimsJws(token); 
    }
}
