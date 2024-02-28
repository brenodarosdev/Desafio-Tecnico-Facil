package br.com.f1rst.gestaodefuncionarios.endereco.application.api;


import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface EnderecoAPI {
    @ResponseStatus(code = HttpStatus.CREATED)
    EnderecoCriadoResponse postNovoEndereco(@Valid @RequestBody EnderecoNovoRequest novoEndereco);
}
