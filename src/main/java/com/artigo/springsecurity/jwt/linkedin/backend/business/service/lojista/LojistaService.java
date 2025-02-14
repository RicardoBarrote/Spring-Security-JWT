package com.artigo.springsecurity.jwt.linkedin.backend.business.service.lojista;

import com.artigo.springsecurity.jwt.linkedin.backend.infra.entity.lojista.Lojista;
import com.artigo.springsecurity.jwt.linkedin.backend.controller.dto.request.lojista.LojistaAtualizarDto;
import com.artigo.springsecurity.jwt.linkedin.backend.controller.dto.request.lojista.LojistaRequestDto;
import com.artigo.springsecurity.jwt.linkedin.backend.controller.dto.response.lojista.LojistaResponseDto;
import com.artigo.springsecurity.jwt.linkedin.backend.infra.exception.LojistaNotFoundException;
import com.artigo.springsecurity.jwt.linkedin.backend.business.mapstruct.lojista.LojistaMapStruct;
import com.artigo.springsecurity.jwt.linkedin.backend.infra.repository.LojistaRepository;
import com.artigo.springsecurity.jwt.linkedin.backend.business.service.user.interfaceUser.IValidarLogin;
import com.artigo.springsecurity.jwt.linkedin.backend.infra.exception.EmailJaCadastradoException;
import com.artigo.springsecurity.jwt.linkedin.backend.infra.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LojistaService implements IValidarLogin {

    private final LojistaRepository repository;
    private final UserRepository userRepository;
    private final LojistaMapStruct mapStruct;

    public LojistaService(LojistaRepository repository, UserRepository userRepository, LojistaMapStruct mapStruct) {
        this.repository = repository;
        this.userRepository = userRepository;
        this.mapStruct = mapStruct;
    }

    @Transactional
    public void criar(LojistaRequestDto dto) {
        String criptografarSenha = new BCryptPasswordEncoder().encode(dto.senha());
        Lojista lojista = new Lojista(dto.email(), criptografarSenha, dto.role(), dto.cnpj(), dto.razaosocial());

        repository.save(lojista);
    }

    public List<LojistaResponseDto> listar() {
        return mapStruct.listarLojistaResponseDto(repository.findAll());

    }

    public LojistaResponseDto buscar(UUID id) {
        return mapStruct.converterParaResponseDto(repository.findById(id)
                .orElseThrow(() -> new LojistaNotFoundException("Lojista não encontrado! id: " + id)));
    }

    @Transactional
    public void atualizar(String razaosocial, LojistaAtualizarDto dto) {
        repository.findByRazaosocial(razaosocial)
                .map(l -> {
                    l.setEmail(dto.emailAtualizado());
                    l.setRazaosocial(dto.razaosocialAtualizado());
                    return repository.save(l);
                }).orElseThrow(() -> new LojistaNotFoundException("Não foi possível atualizar o Lojista!"));
    }

    @Transactional
    public void deletar(UUID id) {
        if (!repository.existsById(id)) {
            throw new LojistaNotFoundException("Não foi possível deletar o Lojista! Id: " + id);
        }
        repository.deleteById(id);
    }

    @Override
    public void validarEmail(String email) {
        if (userRepository.findByEmail(email) != null) {
            throw new EmailJaCadastradoException("Email já está cadastrado! Email: " + email);
        }
    }
}
