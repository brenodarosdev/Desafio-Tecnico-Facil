package br.com.f1rst.gestaodefuncionarios.endereco.application.service;

import br.com.f1rst.gestaodefuncionarios.endereco.application.api.EnderecoCriadoResponse;
import br.com.f1rst.gestaodefuncionarios.endereco.application.api.EnderecoRequest;
import br.com.f1rst.gestaodefuncionarios.endereco.application.repositrory.EnderecoRepository;
import br.com.f1rst.gestaodefuncionarios.endereco.domain.Endereco;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Log4j2
public class EnderecoApplicationService implements EnderecoService {
    private final EnderecoRepository enderecoRepository;

    @Override
    public EnderecoCriadoResponse criaNovoEndereco(EnderecoRequest novoEnderecoRequest) {
        log.info("[inicia] EnderecoApplicationService - criaNovoEndereco");
        Endereco endereco =  enderecoRepository.salva(new Endereco(novoEnderecoRequest));
        log.info("[finaliza] EnderecoApplicationService - criaNovoEndereco");
        return new EnderecoCriadoResponse(endereco);
    }
}
