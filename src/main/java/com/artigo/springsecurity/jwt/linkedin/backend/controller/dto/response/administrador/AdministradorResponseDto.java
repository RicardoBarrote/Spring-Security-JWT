package com.artigo.springsecurity.jwt.linkedin.backend.controller.dto.response.administrador;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AdministradorResponseDto(@Email
                                       String email,
                                       @NotBlank
                                       @NotNull
                                       String nome) {
}
