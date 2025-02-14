package com.artigo.springsecurity.jwt.linkedin.backend.infra.entity.lojista;

import com.artigo.springsecurity.jwt.linkedin.backend.infra.entity.user.User;
import com.artigo.springsecurity.jwt.linkedin.backend.infra.enums.UserRole;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "tb_lojistas")
public  class Lojista extends User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Column(nullable = false, unique = true)
    private String cnpj;

    @Column(nullable = false)
    private String razaosocial;

    public Lojista() {
    }

    public Lojista(String email, String senha, UserRole role, String cnpj, String razaosocial) {
        super(email, senha, role);
        this.cnpj = cnpj;
        this.razaosocial = razaosocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaosocial() {
        return razaosocial;
    }

    public void setRazaosocial(String razaosocial) {
        this.razaosocial = razaosocial;
    }
}
