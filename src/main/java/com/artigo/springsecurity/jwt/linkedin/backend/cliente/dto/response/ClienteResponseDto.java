package com.artigo.springsecurity.jwt.linkedin.backend.cliente.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ClienteResponseDto(@Email String email,
                                 @NotBlank
                                 @NotNull
                                 String apelido) {
}
