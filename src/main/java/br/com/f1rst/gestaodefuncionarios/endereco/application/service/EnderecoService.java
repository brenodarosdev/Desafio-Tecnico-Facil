package br.com.f1rst.gestaodefuncionarios.endereco.application.service;

import br.com.f1rst.gestaodefuncionarios.endereco.application.api.EnderecoCriadoResponse;
import br.com.f1rst.gestaodefuncionarios.endereco.application.api.EnderecoRequest;

public interface EnderecoService {
    EnderecoCriadoResponse criaNovoEndereco(EnderecoRequest novoEndereco);
}