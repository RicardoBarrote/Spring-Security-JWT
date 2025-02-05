package com.artigo.springsecurity.jwt.linkedin.backend.user.enums;

public enum UserRole {

    ADMIN("ADMIN"),
    LOJISTA("LOJISTA"),
    CLIENTE("CLIENTE");

    private String tipo;

    UserRole(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
