package com.artigo.springsecurity.jwt.linkedin.backend.lojista.dto.request;

import com.artigo.springsecurity.jwt.linkedin.backend.user.enums.UserRole;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LojistaRequestDto(@Email
                                String email,
                                @NotNull
                                @NotBlank
                                String senha,
                                @Enumerated(EnumType.STRING)
                                UserRole role,
                                @NotNull
                                @NotBlank
                                String cnpj,
                                @NotNull
                                @NotBlank
                                String razaosocial) {
}
