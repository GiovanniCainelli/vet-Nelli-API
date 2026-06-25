package com.vetnelliFront.vetnelliFront.auth.service;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secret; 

    @Value("${jwt.expiration}")
    private long expiration;

    public String gerarToken(UserDetails userDetails) { 
        return Jwts.builder()
                .setSubject(userDetails.getUsername()) 
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSignKey(), SignatureAlgorithm.HS256) 
                .compact(); 
    }

    private Key getSignKey() {
        byte[] keyBytes = secret.getBytes(); 
        return Keys.hmacShaKeyFor(keyBytes);
    }

    private Claims extrairTodosClaims(String token) { 
        return Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token).getBody();
    }

    private <T> T extrairClaim(String token, Function<Claims, T> claimsResolver) { 
        Claims claims = extrairTodosClaims(token);
        return claimsResolver.apply(claims);
    }

    @SuppressWarnings("null")
    private Date extrairExpiracao(String token) { 
        return extrairClaim(token, Claims::getExpiration);
    }

    private boolean tokenExpirado(String token) { 
        return extrairExpiracao(token).before(new Date());
    }

    public boolean tokenValido(String token, UserDetails userDetails) {
        String email = extrairEmail(token);
        return email.equals(userDetails.getUsername()) && !tokenExpirado(token);
    }

    @SuppressWarnings("null")
    public String extrairEmail(String token) {
        return extrairClaim(token, Claims::getSubject);
    }
}
