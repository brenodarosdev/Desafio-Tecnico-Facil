package br.com.f1rst.gestaodefuncionarios.funcionario.application.api;

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
    public FuncionarioCriadoResponse getBuscaFuncionarioPorId(UUID idFuncionario) {
        log.info("[inicia] FuncionarioController - getBuscaFuncionarioPorId");
        FuncionarioCriadoResponse funcionarioResponse = funcionarioService.buscaFuncionarioPorId(idFuncionario);
        log.info("[finaliza] FuncionarioController - getBuscaFuncionarioPorId");
        return funcionarioResponse;
    }

    @Override
    public void patchAlteraFuncionario(AlteraFuncionarioRequest alteraFuncionarioRequest, UUID idFuncionario) {
        log.info("[inicia] FuncionarioController - patchAlteraFuncionario");
        funcionarioService.alteraFuncionario(alteraFuncionarioRequest, idFuncionario);
        log.info("[finaliza] FuncionarioController - patchAlteraFuncionario");
    }

    @Override
    public void deleteDeletaFuncionario(UUID idFuncionario) {
        log.info("[inicia] FuncionarioController - deleteDeletaFuncionario");
        funcionarioService.deletaFuncionario(idFuncionario);
        log.info("[finaliza] FuncionarioController - deleteDeletaFuncionario");
    }
}
