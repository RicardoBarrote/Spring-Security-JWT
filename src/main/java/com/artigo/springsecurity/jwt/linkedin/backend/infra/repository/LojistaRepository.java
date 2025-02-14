package com.artigo.springsecurity.jwt.linkedin.backend.infra.repository;

import com.artigo.springsecurity.jwt.linkedin.backend.infra.entity.lojista.Lojista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface LojistaRepository extends JpaRepository<Lojista, UUID> {
    Optional<Lojista> findByRazaosocial(String razaosocial);
}
