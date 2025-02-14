package com.artigo.springsecurity.jwt.linkedin.backend.business.mapstruct.cliente;

import com.artigo.springsecurity.jwt.linkedin.backend.infra.entity.cliente.Cliente;
import com.artigo.springsecurity.jwt.linkedin.backend.controller.dto.response.cliente.ClienteResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING
        , unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ClienteMapStruct {

    ClienteResponseDto converterParaResponseDto(Cliente cliente);

    List<ClienteResponseDto> converterListaParaResponseDto(List<Cliente> clienteList);
}
