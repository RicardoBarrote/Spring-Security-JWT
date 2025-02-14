package com.artigo.springsecurity.jwt.linkedin.backend.controller.administrador;

import com.artigo.springsecurity.jwt.linkedin.backend.business.service.administrador.AdministradorService;
import com.artigo.springsecurity.jwt.linkedin.backend.controller.dto.request.administrador.AdministradorAtualizarDto;
import com.artigo.springsecurity.jwt.linkedin.backend.controller.dto.request.administrador.AdministradorRequestDto;
import com.artigo.springsecurity.jwt.linkedin.backend.controller.dto.response.administrador.AdministradorResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/administradores")
public class AdministradorController {

    private final AdministradorService service;

    public AdministradorController(AdministradorService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> criar(@RequestBody @Valid AdministradorRequestDto dto) {
        service.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<AdministradorResponseDto>> listar() {
        return ResponseEntity.status(HttpStatus.OK).body(service.listar());
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<AdministradorResponseDto> buscar(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.buscar(id));
    }

    @PutMapping
    public ResponseEntity<String> atualizar(@RequestParam(value = "nomeAntigo", required = false) String nomeAntigo, @RequestBody @Valid AdministradorAtualizarDto dto) {
        service.atualizar(nomeAntigo, dto);
        return ResponseEntity.status(HttpStatus.OK).body("Atualizado com sucesso!");
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        service.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
