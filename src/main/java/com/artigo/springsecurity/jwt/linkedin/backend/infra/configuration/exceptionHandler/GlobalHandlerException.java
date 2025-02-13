package com.artigo.springsecurity.jwt.linkedin.backend.infra.configuration.exceptionHandler;

import com.artigo.springsecurity.jwt.linkedin.backend.cliente.exception.ClienteNotFoundException;
import com.artigo.springsecurity.jwt.linkedin.backend.user.exception.EmailJaCadastradoException;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(EmailJaCadastradoException.class)
    public ResponseEntity<PadraoDeErro> EmailJaCadastradoException(EmailJaCadastradoException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.CONFLICT;
        PadraoDeErro padraoDeErro = new PadraoDeErro(LocalDateTime.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(padraoDeErro);
    }

    @ExceptionHandler(ClienteNotFoundException.class)
    public ResponseEntity<PadraoDeErro> ClienteNotFoundException(ClienteNotFoundException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        PadraoDeErro padraoDeErro = new PadraoDeErro(LocalDateTime.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(padraoDeErro);
    }

    @ExceptionHandler(JWTCreationException.class)
    public ResponseEntity<PadraoDeErro> JWTCreationException(JWTCreationException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        PadraoDeErro padraoDeErro = new PadraoDeErro(LocalDateTime.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(padraoDeErro);
    }

    @ExceptionHandler(JWTVerificationException.class)
    public ResponseEntity<PadraoDeErro> JWTVerificationException(JWTVerificationException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        PadraoDeErro padraoDeErro = new PadraoDeErro(LocalDateTime.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(padraoDeErro);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<PadraoDeErro> BadCredentialsException(BadCredentialsException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.UNAUTHORIZED;
        PadraoDeErro padraoDeErro = new PadraoDeErro(LocalDateTime.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(padraoDeErro);
    }

    @ExceptionHandler(AccountExpiredException.class)
    public ResponseEntity<PadraoDeErro> AccountExpiredException(AccountExpiredException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.UNAUTHORIZED;
        PadraoDeErro padraoDeErro = new PadraoDeErro(LocalDateTime.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(padraoDeErro);
    }

    @ExceptionHandler(DisabledException.class)
    public ResponseEntity<PadraoDeErro> DisabledException(DisabledException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.FORBIDDEN;
        PadraoDeErro padraoDeErro = new PadraoDeErro(LocalDateTime.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(padraoDeErro);
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<PadraoDeErro> UsernameNotFoundException(UsernameNotFoundException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        PadraoDeErro padraoDeErro = new PadraoDeErro(LocalDateTime.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(padraoDeErro);
    }

    @ExceptionHandler(LockedException.class)
    public ResponseEntity<PadraoDeErro> LockedException(LockedException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.LOCKED;
        PadraoDeErro padraoDeErro = new PadraoDeErro(LocalDateTime.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(padraoDeErro);
    }

    @ExceptionHandler(CredentialsExpiredException.class)
    public ResponseEntity<PadraoDeErro> CredentialsExpiredException(CredentialsExpiredException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.UNAUTHORIZED;
        PadraoDeErro padraoDeErro = new PadraoDeErro(LocalDateTime.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(padraoDeErro);
    }

    @ExceptionHandler(AuthenticationServiceException.class)
    public ResponseEntity<PadraoDeErro> AuthenticationServiceException(AuthenticationServiceException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        PadraoDeErro padraoDeErro = new PadraoDeErro(LocalDateTime.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(padraoDeErro);
    }

    @ExceptionHandler(InsufficientAuthenticationException.class)
    public ResponseEntity<PadraoDeErro> InsufficientAuthenticationException(InsufficientAuthenticationException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.UNAUTHORIZED;
        PadraoDeErro padraoDeErro = new PadraoDeErro(LocalDateTime.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(padraoDeErro);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<PadraoDeErro> MethodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        PadraoDeErro padraoDeErro = new PadraoDeErro(LocalDateTime.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(padraoDeErro);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<PadraoDeErro> HttpMessageNotReadableException(HttpMessageNotReadableException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        PadraoDeErro padraoDeErro = new PadraoDeErro(LocalDateTime.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(padraoDeErro);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<PadraoDeErro> DataIntegrityViolationException(DataIntegrityViolationException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        PadraoDeErro padraoDeErro = new PadraoDeErro(LocalDateTime.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(padraoDeErro);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<PadraoDeErro> MethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        PadraoDeErro padraoDeErro = new PadraoDeErro(LocalDateTime.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(padraoDeErro);
    }

}
