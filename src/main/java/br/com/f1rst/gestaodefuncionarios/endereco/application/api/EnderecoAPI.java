package br.com.f1rst.gestaodefuncionarios.endereco.application.api;


import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/{idFuncionario}/endereco")
public interface EnderecoAPI {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    @Operation(summary = "Cria novo Endereço")
    EnderecoCriadoResponse postNovoEndereco(@Valid @RequestBody EnderecoRequest novoEndereco, @PathVariable UUID idFuncionario);
}
