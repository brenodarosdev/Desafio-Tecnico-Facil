package br.com.f1rst.gestaodefuncionarios.util;

import br.com.f1rst.gestaodefuncionarios.endereco.application.api.EnderecoNovoRequest;
import br.com.f1rst.gestaodefuncionarios.endereco.domain.Endereco;
import br.com.f1rst.gestaodefuncionarios.endereco.domain.EstadoBrasileiro;

import java.util.UUID;

public class EnderecoCreator {
    static final UUID idEndereco1 = UUID.fromString("3fa85f64-5717-4562-b3fc-2c963f66afa6");
    static final UUID idEndereco2 = UUID.fromString("64e0e1bf-d6f6-4933-94bb-a5227a1adbcf");

    public static Endereco criaEndereco() {
        return Endereco.builder().idEndereco(idEndereco1)
                .cep("12345678")
                .estadoBrasileiro(EstadoBrasileiro.BA)
                .cidade("Eunápolis")
                .bairro("Centro")
                .rua("rua inventada")
                .numeroDaCasa("123a")
                .build();
    }

    public static EnderecoNovoRequest criaEnderecoNovoRequest() {
        EnderecoNovoRequest novoRequest = new EnderecoNovoRequest("12345678",
               EstadoBrasileiro.BA , "salario", "12345678912", "abc", "134");
        return novoRequest;
    }
}
