package com.artigo.springsecurity.jwt.linkedin.backend.infra.repository;

import com.artigo.springsecurity.jwt.linkedin.backend.infra.entity.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ClienteRepository extends JpaRepository<Cliente, UUID> {
    Optional<Cliente> findByApelido(String apelido);
}
