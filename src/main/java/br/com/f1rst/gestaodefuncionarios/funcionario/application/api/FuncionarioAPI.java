package br.com.f1rst.gestaodefuncionarios.funcionario.application.api;

import br.com.f1rst.gestaodefuncionarios.endereco.application.api.EnderecoCriadoResponse;
import br.com.f1rst.gestaodefuncionarios.endereco.application.api.EnderecoNovoRequest;
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
    FuncionarioDetalhadoResponse getBuscaFuncionarioPorId(@PathVariable UUID idFuncionario);

    @GetMapping("/{idFuncionario}/endereco")
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary = "Busca Endereço por ID do Funcionário")
    EnderecoCriadoResponse getBuscaEnderecoPorIdDoFuncionario(@PathVariable UUID idFuncionario);

    @PatchMapping("/editaFuncionario/{idFuncionario}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @Operation(summary = "Altera Funcionário")
    void patchAlteraFuncionario(@Valid @RequestBody AlteraFuncionarioRequest alteraFuncionarioRequest,
                                @PathVariable UUID idFuncionario);

    @PatchMapping("/editaEndereco/{idFuncionario}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @Operation(summary = "Altera Endereco do Funcionário")
    void patchAlteraEnderecoPorIdDoFuncionario(@Valid @RequestBody EnderecoNovoRequest alteraEnderecoRequest,
                                               @PathVariable UUID idFuncionario);

    @DeleteMapping("/deletafuncionario/{idFuncionario}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @Operation(summary = "Deleta Funcionário")
    void deleteDeletaFuncionario(@PathVariable UUID idFuncionario);
}
