package br.com.f1rst.gestaodefuncionarios.endereco.application.service;

import br.com.f1rst.gestaodefuncionarios.endereco.application.api.EnderecoRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class EnderecoApplicationService implements EnderecoService {
    @Override
    public EnderecoRequest criaNovoEndereco(EnderecoRequest novoEndereco) {
        log.info("[inicia] EnderecoApplicationService - criaNovoEndereco");
        log.info("[finaliza] EnderecoApplicationService - criaNovoEndereco");
        return null;
    }
}
