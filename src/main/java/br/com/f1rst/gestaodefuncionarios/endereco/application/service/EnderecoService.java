package br.com.f1rst.gestaodefuncionarios.endereco.application.service;

import br.com.f1rst.gestaodefuncionarios.endereco.application.api.EnderecoCriadoResponse;
import br.com.f1rst.gestaodefuncionarios.endereco.application.api.EnderecoNovoRequest;

public interface EnderecoService {
    EnderecoCriadoResponse criaNovoEndereco(EnderecoNovoRequest novoEndereco);
}