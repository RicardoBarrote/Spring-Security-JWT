package com.artigo.springsecurity.jwt.linkedin.backend.cliente.service;

import com.artigo.springsecurity.jwt.linkedin.backend.cliente.Cliente;
import com.artigo.springsecurity.jwt.linkedin.backend.cliente.dto.ClienteRequestDto;
import com.artigo.springsecurity.jwt.linkedin.backend.cliente.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void criar(ClienteRequestDto dto) {
        String criptografarSenha = new BCryptPasswordEncoder().encode(dto.senha());
        Cliente cliente = new Cliente(dto.email(), criptografarSenha, dto.role(), dto.cpf(), dto.apelido());

        repository.save(cliente);
    }

}
