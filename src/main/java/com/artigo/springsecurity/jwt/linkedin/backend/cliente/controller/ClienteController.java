package com.artigo.springsecurity.jwt.linkedin.backend.cliente.controller;

import com.artigo.springsecurity.jwt.linkedin.backend.cliente.dto.request.ClienteAtualizarDto;
import com.artigo.springsecurity.jwt.linkedin.backend.cliente.dto.response.ClienteResponseDto;
import com.artigo.springsecurity.jwt.linkedin.backend.cliente.dto.request.ClienteRequestDto;
import com.artigo.springsecurity.jwt.linkedin.backend.cliente.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*")
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

    @GetMapping
    public ResponseEntity<List<ClienteResponseDto>> listar() {
        return ResponseEntity.status(HttpStatus.OK).body(service.listar());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClienteResponseDto> buscar(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.buscar(id));
    }

    @PutMapping
    public ResponseEntity<Void> atualizar(@RequestParam(value = "apelido", required = false) String apelido, @RequestBody @Valid ClienteAtualizarDto dto) {
        service.atualizar(apelido, dto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        service.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
