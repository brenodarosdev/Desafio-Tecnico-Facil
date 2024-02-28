package br.com.f1rst.gestaodefuncionarios.funcionario.application.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@Tag(name = "Funcionário")
@RequestMapping("/funcionario")
public interface FuncionarioAPI {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    @Operation(summary = "Cria novo funcionário")
    FuncionarioCriadoResponse postNovoFuncionario(@Valid @RequestBody FuncionarioNovoRequest funcionarioNovoRequest);

    @GetMapping("/{idFunciona" +
            "rio}")
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary = "Busca Funcionário por ID")
    FuncionarioCriadoResponse getBuscaFuncionarioPorId(@PathVariable UUID idFuncionario);
}
