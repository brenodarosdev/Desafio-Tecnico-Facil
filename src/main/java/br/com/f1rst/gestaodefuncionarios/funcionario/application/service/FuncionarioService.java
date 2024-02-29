package br.com.f1rst.gestaodefuncionarios.funcionario.application.service;

import br.com.f1rst.gestaodefuncionarios.funcionario.application.api.AlteraFuncionarioRequest;
import br.com.f1rst.gestaodefuncionarios.funcionario.application.api.FuncionarioCriadoResponse;
import br.com.f1rst.gestaodefuncionarios.funcionario.application.api.FuncionarioDetalhadoResponse;
import br.com.f1rst.gestaodefuncionarios.funcionario.application.api.FuncionarioNovoRequest;

import java.util.UUID;

public interface FuncionarioService {
    FuncionarioCriadoResponse criaNovoFuncionario(FuncionarioNovoRequest funcionarioNovoRequest);
    FuncionarioDetalhadoResponse buscaFuncionarioPorId(UUID idFuncionario);
    void alteraFuncionario(AlteraFuncionarioRequest alteraFuncionarioRequest, UUID idFuncionario);
    void deletaFuncionario(UUID idFuncionario);
}
