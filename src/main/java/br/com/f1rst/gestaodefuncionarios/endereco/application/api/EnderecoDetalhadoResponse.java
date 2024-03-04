package br.com.f1rst.gestaodefuncionarios.endereco.application.api;

import br.com.f1rst.gestaodefuncionarios.endereco.domain.Endereco;
import br.com.f1rst.gestaodefuncionarios.endereco.domain.EstadoBrasileiro;
import lombok.Value;

import java.util.UUID;

@Value
public class EnderecoDetalhadoResponse {
    private UUID idEndereco;
    private String cep;
    private EstadoBrasileiro estadoBrasileiro;
    private String cidade;
    private String bairro;
    private String rua;
    private String numeroDaCasa;

    public EnderecoDetalhadoResponse(Endereco endereco) {
        this.idEndereco = endereco.getIdEndereco();
        this.cep = endereco.getCep();
        this.estadoBrasileiro = endereco.getEstadoBrasileiro();
        this.cidade = endereco.getCidade();
        this.bairro = endereco.getBairro();
        this.rua = endereco.getRua();
        this.numeroDaCasa = endereco.getNumeroDaCasa();
    }
}
