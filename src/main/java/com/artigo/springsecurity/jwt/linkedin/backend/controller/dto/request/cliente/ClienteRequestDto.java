package com.artigo.springsecurity.jwt.linkedin.backend.controller.dto.request.cliente;

import com.artigo.springsecurity.jwt.linkedin.backend.infra.enums.UserRole;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ClienteRequestDto(@Email
                                String email,
                                @NotNull
                                @NotBlank
                                String senha,
                                @Enumerated(EnumType.STRING)
                                UserRole role,
                                @NotNull
                                @NotBlank
                                String cpf,
                                @NotNull
                                @NotBlank
                                String apelido) {
}
