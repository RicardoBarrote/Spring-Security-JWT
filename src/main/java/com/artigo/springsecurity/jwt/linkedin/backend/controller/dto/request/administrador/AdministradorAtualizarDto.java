package com.artigo.springsecurity.jwt.linkedin.backend.controller.dto.request.administrador;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AdministradorAtualizarDto(@Email
                                        String email,
                                        @NotNull
                                        @NotBlank
                                        String nome) {
}
