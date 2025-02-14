package com.artigo.springsecurity.jwt.linkedin.backend.controller.login;

import com.artigo.springsecurity.jwt.linkedin.backend.business.service.login.LoginService;
import com.artigo.springsecurity.jwt.linkedin.backend.controller.dto.request.login.LoginDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/auth")
public class LoginController {

    private final LoginService service;

    public LoginController(LoginService service) {
        this.service = service;
    }

    @PostMapping(value = "/login")
    public ResponseEntity<String> login(@RequestBody @Valid LoginDto dto) {
        return ResponseEntity.status(HttpStatus.OK).body(service.login(dto));
    }
}
