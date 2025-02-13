package com.artigo.springsecurity.jwt.linkedin.backend.lojista.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LojistaAtualizarDto(@Email String emailAtualizado,
                                  @NotBlank
                                  @NotNull
                                  String razaosocialAtualizado) {
}
