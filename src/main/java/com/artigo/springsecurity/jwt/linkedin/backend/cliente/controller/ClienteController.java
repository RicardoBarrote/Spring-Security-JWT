package com.artigo.springsecurity.jwt.linkedin.backend.cliente.controller;

import com.artigo.springsecurity.jwt.linkedin.backend.cliente.dto.ClienteRequestDto;
import com.artigo.springsecurity.jwt.linkedin.backend.cliente.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> criar(@RequestBody @Valid ClienteRequestDto dto) {
        service.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
