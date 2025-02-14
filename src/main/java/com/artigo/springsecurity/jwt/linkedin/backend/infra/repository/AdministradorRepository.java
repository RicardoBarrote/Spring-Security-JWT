package com.artigo.springsecurity.jwt.linkedin.backend.infra.repository;

import com.artigo.springsecurity.jwt.linkedin.backend.infra.entity.administrador.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AdministradorRepository extends JpaRepository<Administrador, UUID> {
    Optional<Administrador> findByNome(String nome);
}
