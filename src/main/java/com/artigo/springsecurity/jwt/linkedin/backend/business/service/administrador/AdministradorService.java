package com.artigo.springsecurity.jwt.linkedin.backend.business.service.administrador;

import com.artigo.springsecurity.jwt.linkedin.backend.business.mapstruct.administrador.AdministradorMapStruct;
import com.artigo.springsecurity.jwt.linkedin.backend.business.service.administrador.interfaces.IAdministrador;
import com.artigo.springsecurity.jwt.linkedin.backend.business.service.user.interfaceUser.IValidarLogin;
import com.artigo.springsecurity.jwt.linkedin.backend.controller.dto.request.administrador.AdministradorAtualizarDto;
import com.artigo.springsecurity.jwt.linkedin.backend.controller.dto.request.administrador.AdministradorRequestDto;
import com.artigo.springsecurity.jwt.linkedin.backend.controller.dto.response.administrador.AdministradorResponseDto;
import com.artigo.springsecurity.jwt.linkedin.backend.infra.entity.administrador.Administrador;
import com.artigo.springsecurity.jwt.linkedin.backend.infra.exception.AdministradorNotFoundException;
import com.artigo.springsecurity.jwt.linkedin.backend.infra.exception.EmailJaCadastradoException;
import com.artigo.springsecurity.jwt.linkedin.backend.infra.repository.AdministradorRepository;
import com.artigo.springsecurity.jwt.linkedin.backend.infra.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AdministradorService implements IAdministrador, IValidarLogin {

    private final AdministradorRepository repository;
    private final UserRepository userRepository;
    private final AdministradorMapStruct mapStruct;

    public AdministradorService(AdministradorRepository repository, UserRepository userRepository, AdministradorMapStruct mapStruct) {
        this.repository = repository;
        this.userRepository = userRepository;
        this.mapStruct = mapStruct;
    }


    //Metodos da interface IAdministrador
    @Transactional
    @Override
    public void criar(AdministradorRequestDto dto) {
        validarEmail(dto.email());

        String senhaCriptografada = new BCryptPasswordEncoder().encode(dto.senha());
        Administrador administrador = new Administrador(dto.email(), senhaCriptografada, dto.nome());

        repository.save(administrador);
    }

    @Override
    public List<AdministradorResponseDto> listar() {
        return mapStruct.listarResponseDto(repository.findAll());
    }

    @Override
    public AdministradorResponseDto buscar(UUID id) {
        return mapStruct.buscarResponseDto(repository.findById(id).orElseThrow(() -> new AdministradorNotFoundException("Administrador não existe! Id informado: " + id)));
    }

    @Transactional
    @Override
    public AdministradorAtualizarDto atualizar(String nomeAntigo, AdministradorAtualizarDto dto) {
        return repository.findByNome(nomeAntigo)
                .map(a -> {
                    a.setEmail(dto.email());
                    a.setNome(dto.nome());
                    return mapStruct.paraAdministradorAtualizar(repository.save(a));
                }).orElseThrow(() -> new AdministradorNotFoundException("Não foi possível atualizar o Administrador! nome: " + nomeAntigo + ", não foi encontrado."));
    }

    @Transactional
    @Override
    public void deletar(UUID id) {
        if (!repository.existsById(id)) {
            throw new AdministradorNotFoundException("Não foi possível remover o Administrador! Id: " + id + ", não foi encontrado.");
        }
        repository.deleteById(id);
    }


    //Metodos da interface IValidarLogin.
    @Override
    public void validarEmail(String email) {
        if (userRepository.findByEmail(email) != null) {
            throw new EmailJaCadastradoException("Email já cadastrado!");
        }
    }
}
