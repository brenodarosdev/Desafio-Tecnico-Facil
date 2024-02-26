package br.com.f1rst.gestaodefuncionarios.funcionario.application.api;

import br.com.f1rst.gestaodefuncionarios.funcionario.application.service.FuncionarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
public class FuncionarioController implements FuncionarioAPI {
    private final FuncionarioService funcionarioService;

    @Override
    public FuncionarioResponse postNovoFuncionario(FuncionarioRequest funcionarioRequest) {
        log.info("[inicia] FuncionarioController - postNovoFuncionario");
        FuncionarioResponse funcionarioCriado = funcionarioService.criaNovoFuncionario(funcionarioRequest);
        log.info("[finaliza] FuncionarioController - postNovoFuncionario");
        return null;
    }
}
