package com.example.demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JwtUtil {

    private static final String SECRET =
            "my-super-secret-key-for-jwt-auth-123456";

    private static final Key KEY =
            Keys.hmacShaKeyFor(SECRET.getBytes());

    public static String generateToken(String username) {

        return Jwts.builder()
                .setSubject(username)
                .claim("role", "ADMIN")
                .setIssuedAt(new Date())
                .setExpiration(
                        new Date(System.currentTimeMillis() + 60 * 60 * 1000)
                )
                .signWith(KEY, SignatureAlgorithm.HS256)
                .compact();
    }

    public static Jws<Claims> validateToken(String token) {

        return Jwts.parserBuilder()
                .setSigningKey(KEY)
                .build()
                .parseClaimsJws(token);
    }
}
