package com.artigo.springsecurity.jwt.linkedin.backend.lojista.controller;

import com.artigo.springsecurity.jwt.linkedin.backend.lojista.dto.request.LojistaAtualizarDto;
import com.artigo.springsecurity.jwt.linkedin.backend.lojista.dto.request.LojistaRequestDto;
import com.artigo.springsecurity.jwt.linkedin.backend.lojista.dto.response.LojistaResponseDto;
import com.artigo.springsecurity.jwt.linkedin.backend.lojista.service.LojistaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/lojistas")
public class LojistaController {

    private final LojistaService service;

    public LojistaController(LojistaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> criar(@RequestBody @Valid LojistaRequestDto dto) {
        service.criar(dto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping
    public ResponseEntity<List<LojistaResponseDto>> listar() {
        return ResponseEntity.status(HttpStatus.OK).body(service.listar());
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<LojistaResponseDto> buscar(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.buscar(id));
    }

    @PutMapping
    public ResponseEntity<Void> atualizar(@RequestParam(value = "razaosocial", required = false) String razaosocial, @RequestBody @Valid LojistaAtualizarDto dto) {
        service.atualizar(razaosocial, dto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        service.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
