package com.artigo.springsecurity.jwt.linkedin.backend.cliente.service;

import com.artigo.springsecurity.jwt.linkedin.backend.cliente.repository.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }


}
