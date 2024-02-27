package br.com.f1rst.gestaodefuncionarios.endereco.application.service;

import br.com.f1rst.gestaodefuncionarios.endereco.application.api.EnderecoRequest;

public interface EnderecoService {
    EnderecoRequest criaNovoEndereco(EnderecoRequest novoEndereco);
}
