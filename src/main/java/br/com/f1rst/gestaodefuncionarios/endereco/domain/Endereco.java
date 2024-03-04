package br.com.f1rst.gestaodefuncionarios.endereco.domain;

import br.com.f1rst.gestaodefuncionarios.endereco.application.api.EnderecoNovoRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
@Document(collection = "Endereco")
public class Endereco {
    @Id
    @Indexed
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

    public Endereco(EnderecoNovoRequest enderecoNovoRequest, UUID idEndereco) {
        this.idEndereco = idEndereco;
        this.cep = enderecoNovoRequest.getCep();
        this.estadoBrasileiro = enderecoNovoRequest.getEstadoBrasileiro();
        this.cidade = enderecoNovoRequest.getCidade();
        this.bairro = enderecoNovoRequest.getBairro();
        this.rua = enderecoNovoRequest.getRua();
        this.numeroDaCasa = enderecoNovoRequest.getNumeroDaCasa();
    }

    public void alteraEndereco(EnderecoNovoRequest alteraEnderecoRequest) {
        this.cep = alteraEnderecoRequest.getCep();
        this.estadoBrasileiro = alteraEnderecoRequest.getEstadoBrasileiro();
        this.cidade = alteraEnderecoRequest.getCidade();
        this.bairro = alteraEnderecoRequest.getBairro();
        this.rua = alteraEnderecoRequest.getRua();
        this.numeroDaCasa = alteraEnderecoRequest.getNumeroDaCasa();
    }
}
