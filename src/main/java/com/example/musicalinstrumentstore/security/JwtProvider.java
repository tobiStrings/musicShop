package com.example.musicalinstrumentstore.security;

import com.example.musicalinstrumentstore.exceptions.MusicStoreException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.security.*;
import java.security.cert.CertificateException;
import java.time.Instant;
import java.util.Date;
@Service
public class JwtProvider {
    private KeyStore keystore;

    @Value("${jwt.expiration.time}")
    private Long tokenExpirationDate;

    @PostConstruct
    public void init() throws MusicStoreException {
        try {
            keystore = KeyStore.getInstance("JKS");
            InputStream resourceAsStream = getClass().getResourceAsStream("/springblog.jks");
            keystore.load(resourceAsStream, "secret".toCharArray());
        } catch (KeyStoreException | CertificateException | NoSuchAlgorithmException | IOException e) {
            throw new MusicStoreException("Exception occurred while loading keystore");
        }
    }

    public String generateToken(Authentication authentication){
        String username = authentication.getName();
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(Date.from(Instant.now().plusMillis(tokenExpirationDate)))
                .signWith(SignatureAlgorithm.HS256, "secretabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ98712334567")
                .compact();
    }

    private Key getPrivateKey() throws MusicStoreException {
        try {
            return  keystore.getKey("springblog", "secret".toCharArray());
        } catch (KeyStoreException | NoSuchAlgorithmException | UnrecoverableKeyException e) {
            throw new MusicStoreException("Exception occurred while retrieving public key from key store");
        }
    }

    public boolean validateToken(String jwt) throws MusicStoreException {
        Jwts.parserBuilder()
                .setSigningKey(getPublicKey())
                .build().parseClaimsJws(jwt);
        return true;
    }

    private PublicKey getPublicKey() throws MusicStoreException {
        try {
            return keystore.getCertificate("springblog").getPublicKey();
        } catch (KeyStoreException e) {
            throw new MusicStoreException("Exception occurred while retrieving public key from key store");
        }
    }

    public String getEmailFromToken(String token) throws MusicStoreException {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(getPublicKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    public Long getExpirationTime(){
        return tokenExpirationDate;
    }

    public String generateTokenWithUsername(String username) throws MusicStoreException {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(Date.from(Instant.now()))
                .signWith(getPrivateKey())
                .setExpiration(Date.from(Instant.now().plusMillis(tokenExpirationDate)))
                .compact();
    }
}
