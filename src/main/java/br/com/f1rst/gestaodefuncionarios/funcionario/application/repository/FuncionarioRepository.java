package br.com.f1rst.gestaodefuncionarios.funcionario.application.repository;

import br.com.f1rst.gestaodefuncionarios.funcionario.domain.Funcionario;

public interface FuncionarioRepository {
    Funcionario salva(Funcionario funcionario);
}
