package br.com.f1rst.gestaodefuncionarios.endereco.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Endereco {
    @Id
    private UUID idEndereco;
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

    public Endereco(String cep, EstadoBrasileiro estadoBrasileiro, String cidade, String bairro,
                    String rua, String numeroDaCasa) {
        this.cep = cep;
        this.estadoBrasileiro = estadoBrasileiro;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numeroDaCasa = numeroDaCasa;
    }
}
