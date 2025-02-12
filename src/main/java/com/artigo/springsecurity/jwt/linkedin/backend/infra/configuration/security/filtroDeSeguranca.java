package com.artigo.springsecurity.jwt.linkedin.backend.infra.configuration.security;

import com.artigo.springsecurity.jwt.linkedin.backend.infra.configuration.jwt.JwtTokenService;
import com.artigo.springsecurity.jwt.linkedin.backend.user.repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class filtroDeSeguranca extends OncePerRequestFilter {

    private final JwtTokenService tokenService;
    private final UserRepository userRepository;

    public filtroDeSeguranca(JwtTokenService tokenService, UserRepository userRepository) {
        this.tokenService = tokenService;
        this.userRepository = userRepository;
    }

    //Iremos estender a OncePerRequestFilter para que a cada requisição do usuário será feito um pente fino para pegar as informações do token caso haja.


    //O metodo doFilterInternal é o que será chamado antes do proprio filtro do Spring Security, então e aqui que iremos pegar as informacoes dentro do token
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = recuperarToken(request);
        if (token != null) {
            String email = tokenService.validarToken(token);
            UserDetails userDetails = userRepository.findByEmail(email);
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }
        filterChain.doFilter(request, response);
    }


    private String recuperarToken(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (header == null) {
            return null;
        }
        return header.replace("Bearer ", "");
    }

    //Por padrão nas requisições  Http quando enviamos um header de autorizacao que contem um token, iremos identificar o token, nesse caso um Bearer Token,
    //então iremos cortar esse nome Bearer para pegarmos apenas o nosso token
}
