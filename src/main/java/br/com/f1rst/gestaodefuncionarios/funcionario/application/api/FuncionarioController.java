package br.com.f1rst.gestaodefuncionarios.funcionario.application.api;

import br.com.f1rst.gestaodefuncionarios.endereco.application.api.EnderecoDetalhadoResponse;
import br.com.f1rst.gestaodefuncionarios.endereco.application.api.EnderecoNovoRequest;
import br.com.f1rst.gestaodefuncionarios.funcionario.application.service.FuncionarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Log4j2
@RequiredArgsConstructor
public class FuncionarioController implements FuncionarioAPI {
    private final FuncionarioService funcionarioService;

    @Override
    public FuncionarioCriadoResponse postNovoFuncionario(FuncionarioNovoRequest funcionarioNovoRequest) {
        log.info("[inicia] FuncionarioController - postNovoFuncionario");
        FuncionarioCriadoResponse funcionarioCriado = funcionarioService.criaNovoFuncionario(funcionarioNovoRequest);
        log.info("[finaliza] FuncionarioController - postNovoFuncionario");
        return funcionarioCriado;
    }

    @Override
    public FuncionarioDetalhadoResponse getBuscaFuncionarioPorId(UUID idFuncionario) {
        log.info("[inicia] FuncionarioController - getBuscaFuncionarioPorId");
        FuncionarioDetalhadoResponse funcionarioResponse = funcionarioService.buscaFuncionarioPorId(idFuncionario);
        log.info("[finaliza] FuncionarioController - getBuscaFuncionarioPorId");
        return funcionarioResponse;
    }

    @Override
    public EnderecoDetalhadoResponse getBuscaEnderecoPorIdDoFuncionario(UUID idFuncionario) {
        log.info("[inicia] FuncionarioController - getBuscaEnderecoPorIdDoFuncionario");
        EnderecoDetalhadoResponse enderecoDetalhadoResponse = funcionarioService.buscaEnderecoPorIdDoFuncionario(idFuncionario);
        log.info("[finaliza] FuncionarioController - getBuscaEnderecoPorIdDoFuncionario");
        return enderecoDetalhadoResponse;
    }

    @Override
    public void patchAlteraFuncionario(AlteraFuncionarioRequest alteraFuncionarioRequest, UUID idFuncionario) {
        log.info("[inicia] FuncionarioController - patchAlteraFuncionario");
        funcionarioService.alteraFuncionario(alteraFuncionarioRequest, idFuncionario);
        log.info("[finaliza] FuncionarioController - patchAlteraFuncionario");
    }

    @Override
    public void patchAlteraEnderecoPorIdDoFuncionario(EnderecoNovoRequest alteraEnderecoRequest, UUID idFuncionario) {
        log.info("[inicia] FuncionarioController - patchAlteraEnderecoPorIdDoFuncionario");
        funcionarioService.alteraEnderecoPorIdDoFuncionario(alteraEnderecoRequest, idFuncionario);
        log.info("[finaliza] FuncionarioController - patchAlteraEnderecoPorIdDoFuncionario");
    }

    @Override
    public void deleteDeletaFuncionario(UUID idFuncionario) {
        log.info("[inicia] FuncionarioController - deleteDeletaFuncionario");
        funcionarioService.deletaFuncionario(idFuncionario);
        log.info("[finaliza] FuncionarioController - deleteDeletaFuncionario");
    }
}
