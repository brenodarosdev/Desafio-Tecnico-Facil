package br.com.f1rst.gestaodefuncionarios.funcionario.application.api;

import br.com.f1rst.gestaodefuncionarios.endereco.domain.Endereco;
import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.util.UUID;

@Value
@Builder
public class FuncionarioResponse {
    private UUID idFuncionario;
    private String nomeCompleto;
    private String designacao;
    private BigDecimal salario;
    private String telefone;
    private Endereco endereco;
}
