package com.artigo.springsecurity.jwt.linkedin.backend.administrador;

import com.artigo.springsecurity.jwt.linkedin.backend.user.Users;
import com.artigo.springsecurity.jwt.linkedin.backend.user.enums.UserRole;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "tb_administradores")
public class Administrador extends Users implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Column(nullable = false)
    private String nome;

    @OneToOne(cascade = CascadeType.ALL)
    private Users users;

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
