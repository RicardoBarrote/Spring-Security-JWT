package com.artigo.springsecurity.jwt.linkedin.backend.infra.config.security;

import com.artigo.springsecurity.jwt.linkedin.backend.infra.config.security.filter.FiltroDeSeguranca;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class ConfigurationSecurity {

    private final FiltroDeSeguranca filtroDeSeguranca;

    public ConfigurationSecurity(FiltroDeSeguranca filtroDeSeguranca) {
        this.filtroDeSeguranca = filtroDeSeguranca;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
        return security.csrf(
                        AbstractHttpConfigurer::disable
                ).sessionManagement(s ->
                        s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(a ->
                        a.requestMatchers("/",
                                        "/index.html",
                                        "/login.html",
                                        "/autenticado.html",
                                        "papel.html",
                                        "registrarCliente.html",
                                        "/css/**",
                                        "/js/**",
                                        "/images/**").permitAll()
                                .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                                .requestMatchers(HttpMethod.POST, "/clientes").permitAll()
                                .requestMatchers(HttpMethod.GET, "/clientes").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.GET, "/clientes/{id}").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.PUT, "/clientes").hasRole("CLIENTE")
                                .requestMatchers(HttpMethod.DELETE, "/clientes/{id}").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.POST, "/lojistas").permitAll()
                                .requestMatchers(HttpMethod.GET, "/lojistas").permitAll()
                                .requestMatchers(HttpMethod.GET, "/lojistas/{id}").permitAll()
                                .requestMatchers(HttpMethod.PUT, "/lojistas").permitAll()
                                .requestMatchers(HttpMethod.DELETE, "/lojistas/{id}").permitAll()
                                .anyRequest().authenticated()
                )
                .addFilterBefore(filtroDeSeguranca, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
