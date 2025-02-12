package com.artigo.springsecurity.jwt.linkedin.backend.login.service;

import com.artigo.springsecurity.jwt.linkedin.backend.infra.configuration.jwt.JwtTokenService;
import com.artigo.springsecurity.jwt.linkedin.backend.login.dto.LoginDto;
import com.artigo.springsecurity.jwt.linkedin.backend.user.Users;
import jakarta.transaction.Transactional;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final AuthenticationManager manager;
    private final JwtTokenService tokenService;

    public LoginService(AuthenticationManager manager, JwtTokenService tokenService) {
        this.manager = manager;
        this.tokenService = tokenService;
    }

    @Transactional
    public String login(LoginDto dto) throws BadCredentialsException {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(dto.email(), dto.senha());
        Authentication authentication = manager.authenticate(authenticationToken);

        return tokenService.gerarTokenJwt((Users) authentication.getPrincipal());
    }
}
