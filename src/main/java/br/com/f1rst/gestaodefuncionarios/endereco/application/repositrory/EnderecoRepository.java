package br.com.f1rst.gestaodefuncionarios.endereco.application.repositrory;

import br.com.f1rst.gestaodefuncionarios.endereco.domain.Endereco;

import java.util.UUID;

public interface EnderecoRepository {
    Endereco salva(Endereco endereco);
    Endereco enderecoPorId(UUID idEndereco);
    void deletaEnderecoPorId(UUID idEndereco);
}
