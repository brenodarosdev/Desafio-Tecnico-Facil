package br.com.f1rst.gestaodefuncionarios.funcionario.application.service;

import br.com.f1rst.gestaodefuncionarios.endereco.application.api.*;
import br.com.f1rst.gestaodefuncionarios.endereco.application.repositrory.EnderecoRepository;
import br.com.f1rst.gestaodefuncionarios.endereco.domain.Endereco;
import br.com.f1rst.gestaodefuncionarios.funcionario.application.api.*;
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
        Funcionario funcionario = funcionarioRepository.salva(new Funcionario(funcionarioNovoRequest));
        Endereco endereco = enderecoRepository.salva(new Endereco(funcionarioNovoRequest.getEnderecoNovo(),
                funcionario.getIdEndereco()));
        log.info("[finaliza] FuncionarioApplicationService - criaNovoFuncionario");
        return new FuncionarioCriadoResponse(funcionario, endereco);
    }

    @Override
    public FuncionarioDetalhadoResponse buscaFuncionarioPorId(UUID idFuncionario) {
        log.info("[inicia] FuncionarioApplicationService - buscaFuncionarioPorId");
        Funcionario funcionario = funcionarioRepository.funcionarioPorId(idFuncionario);
        log.info("[finaliza] FuncionarioApplicationService - buscaFuncionarioPorId");
        return new FuncionarioDetalhadoResponse(funcionario);
    }

    @Override
    public EnderecoCriadoResponse buscaEnderecoPorIdDoFuncionario(UUID idFuncionario) {
        log.info("[inicia] FuncionarioApplicationService - buscaEnderecoPorIdDoFuncionario");
        Funcionario funcionario = funcionarioRepository.funcionarioPorId(idFuncionario);
        Endereco endereco = enderecoRepository.enderecoPorId(funcionario.getIdEndereco());
        log.info("[finaliza] FuncionarioApplicationService - buscaEnderecoPorIdDoFuncionario");
        return new EnderecoCriadoResponse(endereco);
    }

    @Override
    public void alteraFuncionario(AlteraFuncionarioRequest alteraFuncionarioRequest, UUID idFuncionario) {
        log.info("[inicia] FuncionarioApplicationService - alteraFuncionario");
        Funcionario funcionario = funcionarioRepository.funcionarioPorId(idFuncionario);
        funcionario.alteraFuncionario(alteraFuncionarioRequest);
        funcionarioRepository.salva(funcionario);
        log.info("[finaliza] FuncionarioApplicationService - alteraFuncionario");
    }

    @Override
    public void alteraEnderecoPorIdDoFuncionario(EnderecoNovoRequest alteraEnderecoRequest, UUID idFuncionario) {
        log.info("[inicia] FuncionarioApplicationService - alteraEnderecoPorIdDoFuncionario");
        Funcionario funcionario = funcionarioRepository.funcionarioPorId(idFuncionario);
        Endereco endereco = enderecoRepository.enderecoPorId(funcionario.getIdEndereco());
        endereco.alteraEndereco(alteraEnderecoRequest);
        enderecoRepository.salva(endereco);
        log.info("[finaliza] FuncionarioApplicationService - alteraEnderecoPorIdDoFuncionario");
    }

    @Override
    public void deletaFuncionario(UUID idFuncionario) {
        log.info("[inicia] FuncionarioApplicationService - deletaFuncionario");
        Funcionario funcionario = funcionarioRepository.funcionarioPorId(idFuncionario);
        UUID idEndereco = funcionario.getIdEndereco();
        enderecoRepository.enderecoPorId(idEndereco);
        enderecoRepository.deletaEnderecoPorId(idEndereco);
        funcionarioRepository.deletaFuncionarioPorId(idFuncionario);
        log.info("[finaliza] FuncionarioApplicationService - deletaFuncionario");
    }
}
