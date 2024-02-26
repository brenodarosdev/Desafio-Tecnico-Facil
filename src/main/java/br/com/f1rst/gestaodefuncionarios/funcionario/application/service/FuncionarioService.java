package br.com.f1rst.gestaodefuncionarios.funcionario.application.service;

import br.com.f1rst.gestaodefuncionarios.funcionario.application.api.FuncionarioRequest;
import br.com.f1rst.gestaodefuncionarios.funcionario.application.api.FuncionarioResponse;

public interface FuncionarioService {
    FuncionarioResponse criaNovoFuncionario(FuncionarioRequest funcionarioRequest);
}
