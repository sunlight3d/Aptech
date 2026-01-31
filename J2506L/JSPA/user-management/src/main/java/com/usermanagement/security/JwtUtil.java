package com.usermanagement.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtUtil {
    private final String SECRET_KEY = "Cp9IfjQm3Z3MQLxXMZeYq7oq55KNT1mdWsBql/FhWZo=";
    //sẽ cho vào biến môi trường, có thể tạo bằng lệnh: openssl rand -base64 32

    private static final long EXPIRATION =
            1000L * 60 * 60 * 24 * 30; // 30 days


    // Tạo SecretKey từ String theo chuẩn mới
    private SecretKey getSigningKey() {
        byte[] keyBytes = SECRET_KEY.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateToken(String username, String role) {
        return Jwts.builder()
                .subject(username)                 // Thay setSubject() -> subject()
                .claim("role", role)
                .issuedAt(new Date())              // Thay setIssuedAt() -> issuedAt()
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION)) // Thay setExpiration()
                .signWith(getSigningKey())         // Không cần truyền Algorithm, JJWT tự suy ra từ độ dài key
                .compact();
    }

    public String getUsername(String token) {
        return parse(token).getSubject();
    }

    public String getRole(String token) {
        return parse(token).get("role", String.class);
    }

    private Claims parse(String token) {
        return Jwts.parser()
                .verifyWith(getSigningKey()) // Thay setSigningKey bằng verifyWith
                .build()                     // PHẢI có hàm này để tạo ra JwtParser
                .parseSignedClaims(token)    // Thay parseClaimsJws bằng parseSignedClaims
                .getPayload();               // Thay getBody bằng getPayload
    }
}
