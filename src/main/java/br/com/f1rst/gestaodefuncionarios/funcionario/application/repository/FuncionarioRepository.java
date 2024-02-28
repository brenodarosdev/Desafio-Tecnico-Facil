package br.com.f1rst.gestaodefuncionarios.funcionario.application.repository;

import br.com.f1rst.gestaodefuncionarios.funcionario.domain.Funcionario;

import java.util.UUID;

public interface FuncionarioRepository {
    Funcionario salva(Funcionario funcionario);
    Funcionario funcionarioPorId(UUID idFuncionario);
}
