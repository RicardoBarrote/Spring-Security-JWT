package com.artigo.springsecurity.jwt.linkedin.backend.user.repository;

import com.artigo.springsecurity.jwt.linkedin.backend.user.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;

public interface UserRepository extends JpaRepository<Users, UUID> {

    UserDetails findByEmail(String email);
}
