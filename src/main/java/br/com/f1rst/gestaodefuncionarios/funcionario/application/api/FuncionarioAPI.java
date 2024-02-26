package br.com.f1rst.gestaodefuncionarios.funcionario.application.api;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/funcionario")
public interface FuncionarioAPI {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    @Operation(summary = "Cria novo funcionário")
    FuncionarioResponse postNovoFuncionario(@Valid @RequestBody FuncionarioRequest funcionarioRequest);
}
