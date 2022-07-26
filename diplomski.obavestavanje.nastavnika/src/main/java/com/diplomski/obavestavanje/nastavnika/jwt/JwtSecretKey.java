package com.diplomski.obavestavanje.nastavnika.jwt;

import io.jsonwebtoken.security.Keys;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.crypto.SecretKey;

@Configuration
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class JwtSecretKey {
    private final JwtConfig jwtConfig;
    @Bean
    public SecretKey getSecretKey(){
        return Keys.hmacShaKeyFor(jwtConfig.getSecretKey().getBytes());
    }
}
