package com.artigo.springsecurity.jwt.linkedin.backend.infra.entity.administrador;

import com.artigo.springsecurity.jwt.linkedin.backend.infra.entity.user.User;
import com.artigo.springsecurity.jwt.linkedin.backend.infra.enums.UserRole;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "tb_administradores")
public class Administrador extends User implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Column(nullable = false)
    private String nome;

    public Administrador() {
    }

    public Administrador(String email, String senha, UserRole role, String nome) {
        super(email, senha, role);
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
