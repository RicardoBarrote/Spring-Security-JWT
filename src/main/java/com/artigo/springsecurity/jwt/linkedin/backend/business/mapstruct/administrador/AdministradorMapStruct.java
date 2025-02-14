package com.artigo.springsecurity.jwt.linkedin.backend.business.mapstruct.administrador;

import com.artigo.springsecurity.jwt.linkedin.backend.controller.dto.request.administrador.AdministradorAtualizarDto;
import com.artigo.springsecurity.jwt.linkedin.backend.controller.dto.response.administrador.AdministradorResponseDto;
import com.artigo.springsecurity.jwt.linkedin.backend.infra.entity.administrador.Administrador;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface AdministradorMapStruct {

    List<AdministradorResponseDto> listarResponseDto(List<Administrador> administradors);

    AdministradorResponseDto buscarResponseDto(Administrador administrador);

    AdministradorAtualizarDto paraAdministradorAtualizar (Administrador administrador);
}
