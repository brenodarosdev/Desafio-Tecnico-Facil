package br.com.f1rst.gestaodefuncionarios.funcionario.application.api;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class FuncionarioController implements FuncionarioAPI {
    @Override
    public FuncionarioResponse postNovoFuncionario(FuncionarioRequest funcionarioRequest) {
        log.info("[inicia] FuncionarioController - postNovoFuncionario");
        log.info("[finaliza] FuncionarioController - postNovoFuncionario");
        return null;
    }
}
