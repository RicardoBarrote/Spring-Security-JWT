package com.artigo.springsecurity.jwt.linkedin.backend.business.service.jwt;

import com.artigo.springsecurity.jwt.linkedin.backend.infra.entity.user.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class JwtTokenService {

    @Value("${chave.secreta.artigo}")
    private String chaveSecreta;

    private Algorithm algorithm(String chave) {
        return Algorithm.HMAC256(chave);
    }

    public String gerarTokenJwt(User user) throws JWTCreationException {
        return JWT.create()
                .withIssuer("auth-artigo")
                .withSubject(user.getEmail())
                .withExpiresAt(Instant.now().plusSeconds(10800))
                .sign(algorithm(chaveSecreta));
    }

    public String validarToken(String token) throws JWTVerificationException {
        return JWT.require(algorithm(chaveSecreta))
                .withIssuer("auth-artigo")
                .build()
                .verify(token)
                .getSubject();
    }
}
