package com.artigo.springsecurity.jwt.linkedin.backend.cliente;

import com.artigo.springsecurity.jwt.linkedin.backend.user.Users;
import com.artigo.springsecurity.jwt.linkedin.backend.user.enums.UserRole;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "tb_clientes")
public class Cliente extends Users implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false)
    private String apelido;

    public Cliente() {
    }

    public Cliente(String email, String senha, UserRole role, String cpf, String apelido) {
        super(email, senha, role);
        this.cpf = cpf;
        this.apelido = apelido;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }
}
