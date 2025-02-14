package com.artigo.springsecurity.jwt.linkedin.backend.infra.repository;

import com.artigo.springsecurity.jwt.linkedin.backend.infra.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    UserDetails findByEmail(String email);
}
