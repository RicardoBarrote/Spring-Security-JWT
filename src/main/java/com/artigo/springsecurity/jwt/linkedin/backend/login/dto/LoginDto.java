package com.artigo.springsecurity.jwt.linkedin.backend.login.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LoginDto(@Email
                       String email,
                       @NotNull
                       @NotBlank
                       String senha) {
}
