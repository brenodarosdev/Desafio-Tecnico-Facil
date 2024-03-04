package br.com.f1rst.gestaodefuncionarios.util;

import br.com.f1rst.gestaodefuncionarios.funcionario.application.api.AlteraFuncionarioRequest;
import br.com.f1rst.gestaodefuncionarios.funcionario.application.api.FuncionarioNovoRequest;
import br.com.f1rst.gestaodefuncionarios.funcionario.domain.Funcionario;

import java.math.BigDecimal;
import java.util.UUID;

import static br.com.f1rst.gestaodefuncionarios.util.EnderecoCreator.criaEnderecoNovoRequest;
import static br.com.f1rst.gestaodefuncionarios.util.EnderecoCreator.idEndereco1;

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

    public static FuncionarioNovoRequest criaFuncionarioNovoRequest() {
        BigDecimal salario = new BigDecimal(6000);
        return new FuncionarioNovoRequest("Teste da Silva",
                "TI", salario, "12345678912", criaEnderecoNovoRequest());
    }

    public static AlteraFuncionarioRequest alteraFuncionarioRequest() {
        BigDecimal salario = new BigDecimal(6000);
        return new AlteraFuncionarioRequest("Teste da Silva", "TI",
                salario, "12345678912");
    }
}
