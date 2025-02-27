package com.artigo.springsecurity.jwt.linkedin.backend.infra.exception;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class PadraoDeErro {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime momento;
    private Integer status;
    private String mensagem;
    private String caminho;

    public PadraoDeErro(LocalDateTime momento, Integer status, String mensagem, String caminho) {
        this.momento = momento;
        this.status = status;
        this.mensagem = mensagem;
        this.caminho = caminho;
    }

    public LocalDateTime getMomento() {
        return momento;
    }

    public void setMomento(LocalDateTime momento) {
        this.momento = momento;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }
}
