package com.example.komponente_spring.security.service.impl;

import com.example.komponente_spring.security.service.TokenService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {

    @Value("${oauth.jwt.secret}")
    private String jwtSecret;

    @Override
    public String generate(Claims claims) {
        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, jwtSecret)
                .compact();
    }

    @Override
    public Claims parseToken(String jwt) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(jwtSecret)
                    .parseClaimsJws(jwt)
                    .getBody();
        } catch (Exception e) {
            return null;
        }
        return claims;
    }

    @Override
    public Long getUserIdFromToken(String token) {
        Claims claims = parseToken(token);

        return claims.get("id", Long.class);
    }
}
