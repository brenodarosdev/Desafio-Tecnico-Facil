package br.com.f1rst.gestaodefuncionarios.funcionario.application.api;

import br.com.f1rst.gestaodefuncionarios.funcionario.domain.EnderecoFuncionario;
import lombok.Value;

import java.math.BigDecimal;

@Value
public class FuncionarioRequest {
    private String nomeCompleto;
    private String designacao;
    private BigDecimal salario;
    private String telefone;
    private EnderecoFuncionario endereco;
}
