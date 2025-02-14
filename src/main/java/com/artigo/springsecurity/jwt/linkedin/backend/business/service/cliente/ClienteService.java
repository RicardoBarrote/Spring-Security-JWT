package com.artigo.springsecurity.jwt.linkedin.backend.business.service.cliente;

import com.artigo.springsecurity.jwt.linkedin.backend.business.mapstruct.cliente.ClienteMapStruct;
import com.artigo.springsecurity.jwt.linkedin.backend.infra.entity.cliente.Cliente;
import com.artigo.springsecurity.jwt.linkedin.backend.controller.dto.request.cliente.ClienteAtualizarDto;
import com.artigo.springsecurity.jwt.linkedin.backend.controller.dto.request.cliente.ClienteRequestDto;
import com.artigo.springsecurity.jwt.linkedin.backend.controller.dto.response.cliente.ClienteResponseDto;
import com.artigo.springsecurity.jwt.linkedin.backend.infra.exception.ClienteNotFoundException;
import com.artigo.springsecurity.jwt.linkedin.backend.infra.repository.ClienteRepository;
import com.artigo.springsecurity.jwt.linkedin.backend.business.service.user.interfaceUser.IValidarLogin;
import com.artigo.springsecurity.jwt.linkedin.backend.infra.exception.EmailJaCadastradoException;
import com.artigo.springsecurity.jwt.linkedin.backend.infra.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClienteService implements IValidarLogin {

    private final ClienteRepository repository;
    private final UserRepository userRepository;
    private final ClienteMapStruct mapStruct;

    public ClienteService(ClienteRepository repository, UserRepository userRepository, ClienteMapStruct mapStruct) {
        this.repository = repository;
        this.userRepository = userRepository;
        this.mapStruct = mapStruct;
    }

    @Transactional
    public void criar(ClienteRequestDto dto) {
        validarEmail(dto.email());
        String criptografarSenha = new BCryptPasswordEncoder().encode(dto.senha());
        Cliente cliente = new Cliente(dto.email(), criptografarSenha, dto.role(), dto.cpf(), dto.apelido());

        repository.save(cliente);
    }

    public List<ClienteResponseDto> listar() {
        return mapStruct.converterListaParaResponseDto(repository.findAll());
    }

    public ClienteResponseDto buscar(UUID id) {
        return mapStruct.converterParaResponseDto(repository.findById(id).orElseThrow(() -> new ClienteNotFoundException("CLiente não encontrado! Id: " + id)));
    }

    @Transactional
    public void atualizar(String apelido, ClienteAtualizarDto dto) {
        repository.findByApelido(apelido)
                .map(c -> {
                    c.setEmail(dto.emailAtualizado());
                    c.setApelido(dto.apelidoAtualizado());
                    return repository.save(c);
                }).orElseThrow(() -> new ClienteNotFoundException("Não foi possível atualizar o cliente!"));
    }

    @Transactional
    public void deletar(UUID id) {
        if (!repository.existsById(id)) {
            throw new ClienteNotFoundException("Cliente não encontrado! Id: " + id);
        }
        repository.deleteById(id);
    }


    //Metodos auxiliares
    @Override
    public void validarEmail(String email) {
        if (userRepository.findByEmail(email) != null) {
            throw new EmailJaCadastradoException("Email já está cadastrado! Email: " + email);
        }
    }
}
