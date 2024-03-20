package br.com.f1rst.gestaodefuncionarios.funcionario.application.api;

import br.com.f1rst.gestaodefuncionarios.endereco.domain.Endereco;
import br.com.f1rst.gestaodefuncionarios.funcionario.domain.Funcionario;
import lombok.Value;

import java.util.UUID;

@Value
public class FuncionarioCriadoResponse {
    private UUID idFuncionario;
    private UUID idEndereco;

    public FuncionarioCriadoResponse(Funcionario funcionario, Endereco endereco) {
        this.idFuncionario = funcionario.getIdFuncionario();
        this.idEndereco = funcionario.getIdEndereco();
    }
}
