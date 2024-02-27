package br.com.f1rst.gestaodefuncionarios.funcionario.application.service;

import br.com.f1rst.gestaodefuncionarios.funcionario.application.api.FuncionarioRequest;
import br.com.f1rst.gestaodefuncionarios.funcionario.application.api.FuncionarioResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class FuncionarioApplicationService implements FuncionarioService{

    @Override
    public FuncionarioResponse criaNovoFuncionario(FuncionarioRequest funcionarioRequest) {
        log.info("[inicia] FuncionarioApplicationService - criaNovoFuncionario");
        log.info("[finaliza] FuncionarioApplicationService - criaNovoFuncionario");
        return null;
    }
}
