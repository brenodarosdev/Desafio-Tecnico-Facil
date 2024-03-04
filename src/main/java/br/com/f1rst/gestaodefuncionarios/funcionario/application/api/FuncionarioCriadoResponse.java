package br.com.f1rst.gestaodefuncionarios.funcionario.application.api;

import br.com.f1rst.gestaodefuncionarios.endereco.domain.Endereco;
import br.com.f1rst.gestaodefuncionarios.funcionario.domain.Funcionario;
import lombok.Value;

import java.math.BigDecimal;
import java.util.UUID;

@Value
public class FuncionarioCriadoResponse {
    private UUID idFuncionario;
    private UUID idEndereco;
    private String nomeCompleto;
    private String designacao;
    private BigDecimal salario;
    private String telefone;
    private Endereco endereco;

    public FuncionarioCriadoResponse(Funcionario funcionario, Endereco endereco) {
        this.idFuncionario = funcionario.getIdFuncionario();
        this.idEndereco = funcionario.getIdEndereco();
        this.nomeCompleto = funcionario.getNomeCompleto();
        this.designacao = funcionario.getDesignacao();
        this.salario = funcionario.getSalario();
        this.telefone = funcionario.getTelefone();
        this.endereco = endereco;
    }
}
