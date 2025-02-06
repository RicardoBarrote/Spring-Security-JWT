package com.artigo.springsecurity.jwt.linkedin.backend.cliente.dto;

import com.artigo.springsecurity.jwt.linkedin.backend.user.enums.UserRole;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

public record ClienteRequestDto(@Email
                                String email,
                                @NotNull
                                @NotBlank
                                String senha,
                                @Enumerated(EnumType.STRING)
                                UserRole role,
                                @CPF
                                String cpf,
                                @NotNull
                                @NotBlank
                                String apelido) {
}
