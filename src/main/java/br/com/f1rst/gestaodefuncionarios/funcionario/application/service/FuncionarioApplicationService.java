package br.com.f1rst.gestaodefuncionarios.funcionario.application.service;

import br.com.f1rst.gestaodefuncionarios.endereco.application.repositrory.EnderecoRepository;
import br.com.f1rst.gestaodefuncionarios.endereco.domain.Endereco;
import br.com.f1rst.gestaodefuncionarios.funcionario.application.api.AlteraFuncionarioRequest;
import br.com.f1rst.gestaodefuncionarios.funcionario.application.api.FuncionarioCriadoResponse;
import br.com.f1rst.gestaodefuncionarios.funcionario.application.api.FuncionarioNovoRequest;
import br.com.f1rst.gestaodefuncionarios.funcionario.application.repository.FuncionarioRepository;
import br.com.f1rst.gestaodefuncionarios.funcionario.domain.Funcionario;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;


@RequiredArgsConstructor
@Service
@Log4j2
public class FuncionarioApplicationService implements FuncionarioService{
    private final FuncionarioRepository funcionarioRepository;
    private final EnderecoRepository enderecoRepository;

    @Override
    public FuncionarioCriadoResponse criaNovoFuncionario(FuncionarioNovoRequest funcionarioNovoRequest) {
        log.info("[inicia] FuncionarioApplicationService - criaNovoFuncionario");
        enderecoRepository.salva(new Endereco(funcionarioNovoRequest.getEnderecoNovo()));
        Funcionario funcionario = funcionarioRepository.salva(new Funcionario(funcionarioNovoRequest));
        log.info("[finaliza] FuncionarioApplicationService - criaNovoFuncionario");
        return new FuncionarioCriadoResponse(funcionario);
    }

    @Override
    public FuncionarioCriadoResponse buscaFuncionarioPorId(UUID idFuncionario) {
        log.info("[inicia] FuncionarioApplicationService - buscaFuncionarioPorId");
        // TODO BuscaEnderecoPorId
        Funcionario funcionario = funcionarioRepository.funcionarioPorId(idFuncionario);
        log.info("[finaliza] FuncionarioApplicationService - buscaFuncionarioPorId");
        return new FuncionarioCriadoResponse(funcionario);
    }

    @Override
    public void alteraFuncionario(AlteraFuncionarioRequest alteraFuncionarioRequest, UUID idFuncionario) {
        log.info("[inicia] FuncionarioApplicationService - alteraFuncionario");
        log.info("[finaliza] FuncionarioApplicationService - alteraFuncionario");
    }
}
