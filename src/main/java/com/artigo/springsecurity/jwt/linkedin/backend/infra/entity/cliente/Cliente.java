package com.artigo.springsecurity.jwt.linkedin.backend.infra.entity.cliente;

import com.artigo.springsecurity.jwt.linkedin.backend.infra.entity.user.User;
import com.artigo.springsecurity.jwt.linkedin.backend.infra.enums.UserRole;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "tb_clientes")
public class Cliente extends User implements Serializable {

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
