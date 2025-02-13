package com.artigo.springsecurity.jwt.linkedin.backend.cliente.service;

import com.artigo.springsecurity.jwt.linkedin.backend.cliente.Cliente;
import com.artigo.springsecurity.jwt.linkedin.backend.cliente.dto.ClienteAtualizarDto;
import com.artigo.springsecurity.jwt.linkedin.backend.cliente.dto.ClienteResponseDto;
import com.artigo.springsecurity.jwt.linkedin.backend.cliente.dto.ClienteRequestDto;
import com.artigo.springsecurity.jwt.linkedin.backend.cliente.exception.ClienteNotFoundException;
import com.artigo.springsecurity.jwt.linkedin.backend.cliente.mapstruct.ClienteMapStruct;
import com.artigo.springsecurity.jwt.linkedin.backend.cliente.repository.ClienteRepository;
import com.artigo.springsecurity.jwt.linkedin.backend.user.exception.EmailJaCadastradoException;
import com.artigo.springsecurity.jwt.linkedin.backend.user.repository.UserRepository;
import com.artigo.springsecurity.jwt.linkedin.backend.user.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClienteService {

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
    private void validarEmail(String email) {
        if (userRepository.findByEmail(email) != null) {
            throw new EmailJaCadastradoException("Email já cadastrado!");
        }
    }
}
