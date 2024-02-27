package br.com.f1rst.gestaodefuncionarios.endereco.application.api;


import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/endereco")
public interface EnderecoAPI {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    EnderecoCriadoResponse postNovoEndereco(@Valid @RequestBody EnderecoRequest novoEndereco);
}
