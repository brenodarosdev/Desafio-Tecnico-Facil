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
    @Operation(summary = "Cria novo Funcionário")
    FuncionarioCriadoResponse postNovoFuncionario(@Valid @RequestBody FuncionarioNovoRequest funcionarioNovoRequest);

    @GetMapping("/{idFuncionario}")
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary = "Busca Funcionário por ID")
    // TODO Criar um response para retornar só o funcionario (Necessário adicionar idEndereco ao funcionario)
    FuncionarioCriadoResponse getBuscaFuncionarioPorId(@PathVariable UUID idFuncionario);

    @PatchMapping("/{idFuncionario}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @Operation(summary = "Altera Funcionário")
    void patchAlteraFuncionario(@Valid @RequestBody AlteraFuncionarioRequest alteraFuncionarioRequest,
                                @PathVariable UUID idFuncionario);

    // TODO Criar patch para alterar endereco do funcionario
}
