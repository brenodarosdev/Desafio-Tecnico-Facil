package br.com.f1rst.gestaodefuncionarios.util;

import br.com.f1rst.gestaodefuncionarios.funcionario.application.api.FuncionarioCriadoResponse;
import br.com.f1rst.gestaodefuncionarios.funcionario.application.api.FuncionarioNovoRequest;
import br.com.f1rst.gestaodefuncionarios.funcionario.domain.Funcionario;

import java.math.BigDecimal;
import java.util.UUID;

import static br.com.f1rst.gestaodefuncionarios.util.EnderecoCreator.*;

public class FuncionarioCreator {
    private static final UUID idFuncionario1 = UUID.fromString("3deb33b6-8a91-41d4-8afb-72f75cfd7780");
    private static final UUID idFuncionario2 = UUID.fromString("6573dac8-9134-407c-b657-5eba735184b3");

    public static Funcionario criaFuncionario() {
        return Funcionario.builder().idFuncionario(idFuncionario1)
                .idEndereco(idEndereco1)
                .nomeCompleto("Teste da Silva")
                .designacao("TI")
                .salario(new BigDecimal(6000))
                .telefone("12345678912")
                .build();
    }

    public static FuncionarioNovoRequest CriaFuncionarioNovoRequest() {
        BigDecimal salario = new BigDecimal(6000);
        FuncionarioNovoRequest novoRequest = new FuncionarioNovoRequest("Teste da Silva",
                "TI", salario, "12345678912", criaEnderecoNovoRequest());
        return novoRequest;
    }

    public static FuncionarioCriadoResponse CriaFucionarioCriadoResponse() {
        BigDecimal salario = new BigDecimal(6000);
        FuncionarioCriadoResponse novoRequest = new FuncionarioCriadoResponse(criaFuncionario(), criaEndereco());
        return novoRequest;
    }
}
