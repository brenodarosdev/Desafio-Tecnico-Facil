package br.com.f1rst.gestaodefuncionarios.funcionario.application.service;

import br.com.f1rst.gestaodefuncionarios.funcionario.application.api.FuncionarioRequest;
import br.com.f1rst.gestaodefuncionarios.funcionario.application.api.FuncionarioResponse;
import br.com.f1rst.gestaodefuncionarios.funcionario.application.repository.FuncionarioRepository;
import br.com.f1rst.gestaodefuncionarios.funcionario.domain.Funcionario;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Log4j2
public class FuncionarioApplicationService implements FuncionarioService{

    private final FuncionarioRepository funcionarioRepository;

    @Override
    public FuncionarioResponse criaNovoFuncionario(FuncionarioRequest funcionarioRequest) {
        log.info("[inicia] FuncionarioApplicationService - criaNovoFuncionario");
        Funcionario funcionario = funcionarioRepository.salva(new Funcionario(funcionarioRequest));
        log.info("[finaliza] FuncionarioApplicationService - criaNovoFuncionario");
        return FuncionarioResponse.builder()
                .idFuncionario(funcionario.getIdFuncionario())
                .build();
    }
}
