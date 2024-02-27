package br.com.f1rst.gestaodefuncionarios.endereco.application.api;

import br.com.f1rst.gestaodefuncionarios.endereco.domain.EstadoBrasileiro;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;

@Value
public class EnderecoRequest {
    @NotBlank(message = "O campo cep não pode estar em branco")
    @Size(min = 8, max = 8, message = "O cep deve ter 8 caracteres")
    private String cep;
    @NotNull(message = "O campo estadoBrasileiro não pode ser nulo")
    private EstadoBrasileiro estadoBrasileiro;
    @NotBlank(message = "O campo cidade não pode estar em branco")
    private String cidade;
    @NotBlank(message = "O campo bairro não pode estar em branco")
    private String bairro;
    @NotBlank(message = "O campo rua não pode estar em branco")
    private String rua;
    @NotBlank(message = "O campo numeroDaCasa não pode estar em branco")
    private String numeroDaCasa;
}
