package br.com.f1rst.gestaodefuncionarios.funcionario.infra;

import br.com.f1rst.gestaodefuncionarios.funcionario.application.repository.FuncionarioRepository;
import br.com.f1rst.gestaodefuncionarios.funcionario.domain.Funcionario;
import br.com.f1rst.gestaodefuncionarios.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@RequiredArgsConstructor
@Repository
@Log4j2
public class FuncionarioInfraRepository implements FuncionarioRepository {
    private final FuncionarioSpringDataMongoDBRepository funcionarioSpringDataMongoDBRepository;

    @Override
    public Funcionario salva(Funcionario funcionario) {
        log.info("[inicia] FuncionarioInfraRepository - salva");
        try {
            funcionarioSpringDataMongoDBRepository.save(funcionario);
        } catch(DataIntegrityViolationException e) {
            throw APIException.build(HttpStatus.BAD_REQUEST, "Já existe um funcionário cadastrado com este telefone");
        }
        log.info("[finaliza] FuncionarioInfraRepository - salva");
        return funcionario;
    }

    @Override
    public Funcionario funcionarioPorId(UUID idFuncionario) {
        log.info("[inicia] FuncionarioInfraRepository - funcionarioPorId");
        Funcionario funcionario = funcionarioSpringDataMongoDBRepository.findByIdFuncionario(idFuncionario)
                .orElseThrow(() -> APIException.build(HttpStatus.BAD_REQUEST, "Funcionário não encontrado!"));
        log.info("[finaliza] FuncionarioInfraRepository - funcionarioPorId");
        return funcionario;
    }

    @Override
    public void deletaFuncionarioPorId(UUID idFuncionario) {
        log.info("[inicia] FuncionarioInfraRepository - deletaFuncionarioPorId");
        funcionarioSpringDataMongoDBRepository.deleteByIdFuncionario(idFuncionario);
        log.info("[finaliza] FuncionarioInfraRepository - deletaFuncionarioPorId");
    }
}
