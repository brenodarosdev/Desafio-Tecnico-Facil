package br.com.f1rst.gestaodefuncionarios.endereco.application.api;

import br.com.f1rst.gestaodefuncionarios.endereco.application.service.EnderecoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Log4j2
public class EnderecoController implements EnderecoAPI {
    private final EnderecoService enderecoService;

    @Override
    public EnderecoCriadoResponse postNovoEndereco(EnderecoNovoRequest novoEndereco) {
        log.info("[inicia] EnderecoController - postNovoEndereco");
        EnderecoCriadoResponse enderecoCriado = enderecoService.criaNovoEndereco(novoEndereco);
        log.info("[finaliza] EnderecoController - postNovoEndereco");
        return enderecoCriado;
    }
}
