package com.artigo.springsecurity.jwt.linkedin.backend.controller.dto.request.cliente;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ClienteAtualizarDto(@Email
                                  String emailAtualizado,
                                  @NotBlank
                                  @NotNull
                                  String apelidoAtualizado) {
}
