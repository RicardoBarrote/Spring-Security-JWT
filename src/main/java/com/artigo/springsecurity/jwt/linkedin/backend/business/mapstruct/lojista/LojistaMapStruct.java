package com.artigo.springsecurity.jwt.linkedin.backend.business.mapstruct.lojista;

import com.artigo.springsecurity.jwt.linkedin.backend.infra.entity.lojista.Lojista;
import com.artigo.springsecurity.jwt.linkedin.backend.controller.dto.response.lojista.LojistaResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface LojistaMapStruct {

    List<LojistaResponseDto> listarLojistaResponseDto(List<Lojista> lojistaList);

    LojistaResponseDto converterParaResponseDto(Lojista lojista);
}
