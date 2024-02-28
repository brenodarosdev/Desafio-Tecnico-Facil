package br.com.f1rst.gestaodefuncionarios.endereco.application.repositrory;

import br.com.f1rst.gestaodefuncionarios.endereco.domain.Endereco;

public interface EnderecoRepository {
    Endereco salva(Endereco endereco);
}
