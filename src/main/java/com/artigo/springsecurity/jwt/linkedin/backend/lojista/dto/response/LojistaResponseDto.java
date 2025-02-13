package com.artigo.springsecurity.jwt.linkedin.backend.lojista.dto.response;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LojistaResponseDto(@Email
                                 String email,
                                 @NotNull
                                 @NotBlank
                                 String razaosocial) {
}
