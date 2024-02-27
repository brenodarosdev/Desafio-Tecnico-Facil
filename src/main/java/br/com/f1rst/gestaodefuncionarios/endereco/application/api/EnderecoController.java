package br.com.f1rst.gestaodefuncionarios.endereco.application.api;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Log4j2
public class EnderecoController implements EnderecoAPI {
    @Override
    public EnderecoCriadoResponse postNovoEndereco(EnderecoRequest novoEndereco, UUID idFuncionario) {
        log.info("[inicia] EnderecoController - postNovoEndereco");
        log.info("[finaliza] EnderecoController - postNovoEndereco");
        return null;
    }
}
