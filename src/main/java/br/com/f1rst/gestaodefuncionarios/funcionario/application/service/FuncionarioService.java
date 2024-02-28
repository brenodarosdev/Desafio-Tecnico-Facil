package br.com.f1rst.gestaodefuncionarios.funcionario.application.service;

import br.com.f1rst.gestaodefuncionarios.funcionario.application.api.FuncionarioCriadoResponse;
import br.com.f1rst.gestaodefuncionarios.funcionario.application.api.FuncionarioNovoRequest;

public interface FuncionarioService {
    FuncionarioCriadoResponse criaNovoFuncionario(FuncionarioNovoRequest funcionarioNovoRequest);
}
