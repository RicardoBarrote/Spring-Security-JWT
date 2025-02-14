package com.artigo.springsecurity.jwt.linkedin.backend.business.service.administrador.interfaces;

import com.artigo.springsecurity.jwt.linkedin.backend.controller.dto.request.administrador.AdministradorAtualizarDto;
import com.artigo.springsecurity.jwt.linkedin.backend.controller.dto.request.administrador.AdministradorRequestDto;
import com.artigo.springsecurity.jwt.linkedin.backend.controller.dto.response.administrador.AdministradorResponseDto;

import java.util.List;
import java.util.UUID;

public interface IAdministrador {

    void criar(AdministradorRequestDto dto);

    List<AdministradorResponseDto> listar();

    AdministradorResponseDto buscar(UUID id);

    AdministradorAtualizarDto atualizar (String nomeAntigo, AdministradorAtualizarDto dto);

    void deletar(UUID id);
}
