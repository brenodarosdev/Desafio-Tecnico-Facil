package br.com.f1rst.gestaodefuncionarios.funcionario.application.api;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Value;

import java.math.BigDecimal;

@Value
public class AlteraFuncionarioRequest {
    @NotBlank(message = "O campo nomeCompleto não pode estar em branco")
    private String nomeCompleto;
    @NotBlank(message = "O campo designacao não pode estar em branco")
    private String designacao;
    @DecimalMin(value = "0.0")
    private BigDecimal salario;
    @NotBlank(message = "O campo telefone não pode estar em branco")
    @Size(min = 10, max = 11, message = "O campo telefone deve ter entre 10 e 11 caracteres")
    // TODO Indexar
    private String telefone;
}
