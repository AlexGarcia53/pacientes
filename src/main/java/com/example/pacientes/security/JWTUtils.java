package com.example.pacientes.security;

import com.example.pacientes.entity.Paciente;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;

@Service
public class JWTUtils {
    private static final String SECRET_KEY = "YoHagoLoQueMeDeLaGana+YoFuiQuienPagoMiCubana+Chao+HablamosManana";

    public String generateToken(Paciente paciente) {
        Claims claims = Jwts.claims();
        claims.put("id", paciente.getId());
        claims.put("nombre", paciente.getNombre());
        claims.put("nss", paciente.getNss());
        claims.put("rol", "PACIENTE");

        return Jwts
                .builder()
                .setClaims(claims)
                .setSubject(paciente.getEmail())
                //.setIssuedAt(new Date(System.currentTimeMillis()))
                //.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

//    private boolean isTokenExpired(String token) {
//        return extractExpiration(token).before(new Date());
//    }

    private Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
