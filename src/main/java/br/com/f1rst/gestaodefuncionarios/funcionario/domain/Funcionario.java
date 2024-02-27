package br.com.f1rst.gestaodefuncionarios.funcionario.domain;

import br.com.f1rst.gestaodefuncionarios.endereco.domain.Endereco;
import br.com.f1rst.gestaodefuncionarios.funcionario.application.api.FuncionarioNovoRequest;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.math.BigDecimal;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Funcionario {
    @Id
    @Indexed(unique = true)
    private UUID idFuncionario;
    // TODO idEndereco
    @NotBlank(message = "O campo nomeCompleto não pode estar em branco")
    private String nomeCompleto;
    @NotBlank(message = "O campo designacao não pode estar em branco")
    private String designacao;
    @DecimalMin(value = "0.0")
    private BigDecimal salario;
    @NotBlank(message = "O campo telefone não pode estar em branco")
    @Size(min = 10, max = 11, message = "O campo telefone deve ter entre 10 e 11 caracteres")
    private String telefone;
    @DBRef
    private Endereco endereco;

    public Funcionario(FuncionarioNovoRequest funcionarioNovoRequest) {
        this.idFuncionario = UUID.randomUUID();
        this.nomeCompleto = funcionarioNovoRequest.getNomeCompleto();
        this.designacao = funcionarioNovoRequest.getDesignacao();
        this.salario = funcionarioNovoRequest.getSalario();
        this.telefone = funcionarioNovoRequest.getTelefone();
        // TODO Impementar enderecoRequest
        // this.endereco = enderecoRequest.getEndereco();
    }
}
