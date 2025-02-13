package com.artigo.springsecurity.jwt.linkedin.backend.cliente.mapstruct;

import com.artigo.springsecurity.jwt.linkedin.backend.cliente.Cliente;
import com.artigo.springsecurity.jwt.linkedin.backend.cliente.dto.response.ClienteResponseDto;
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
