package br.com.f1rst.gestaodefuncionarios.funcionario.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.math.BigDecimal;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Funcionario {
    @Id
    @Indexed(unique = true)
    private UUID idFuncionario;
    @NotBlank(message = "O campo nomeCompleto não pode estar em branco")
    private String nomeCompleto;
    @NotBlank(message = "O campo designacao não pode estar em branco")
    private String designacao;
    @NotBlank(message = "O campo salario não pode estar em branco")
    private BigDecimal salario;
    // TODO Mudar mensagem para tratamento de exceção
    @NotBlank(message = "O campo telefone não pode estar em branco")
    @Size(min = 10, max = 11, message = "O campo telefone deve ter entre 10 e 11 caracteres")
    private String telefone;
    private EnderecoFuncionario endereco;

    public Funcionario(UUID idFuncionario, String nomeCompleto, String designacao, BigDecimal salario, String telefone,
                       EnderecoFuncionario endereco) {
        this.idFuncionario = idFuncionario;
        this.nomeCompleto = nomeCompleto;
        this.designacao = designacao;
        this.salario = salario;
        this.telefone = telefone;
        this.endereco = endereco;
    }
}
