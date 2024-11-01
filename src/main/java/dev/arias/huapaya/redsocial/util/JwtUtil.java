package dev.arias.huapaya.redsocial.util;

import java.util.Date;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtUtil {

    private final int TOKEN_MINUTE = 5;

    private final String SECRET_KEY = "Yn1902WoFt44P24FKqwGcrZj1jL4UmydziE";

    public String generateToken(UserDetails userDetails, Map<String, Object> extraClaims) {
        String token = "";
        Date issuedAt = new Date(System.currentTimeMillis());
        Date expiration = new Date((this.TOKEN_MINUTE * 60 * 1000) + issuedAt.getTime());
        token = Jwts.builder()
                .header()
                .type("JWT")
                .and()
                .subject(userDetails.getUsername())
                .issuedAt(issuedAt)
                .expiration(expiration)
                .claims(extraClaims)
                .signWith(this.generateKey(), Jwts.SIG.HS256)
                .compact();
        return token;
    }

    private SecretKey generateKey() {
        byte[] password = this.SECRET_KEY.getBytes();
        return Keys.hmacShaKeyFor(password);
    }

    private Claims extractAllClaims(String jwt) {
        return Jwts.parser().verifyWith(generateKey()).build().parseSignedClaims(jwt).getPayload();
    }

    public String extractUsername(String jwt) {
        return this.extractAllClaims(jwt).getSubject();
    }

}
