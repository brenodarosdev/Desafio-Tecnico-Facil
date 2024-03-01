package br.com.f1rst.gestaodefuncionarios.funcionario.infra;

import br.com.f1rst.gestaodefuncionarios.funcionario.application.repository.FuncionarioRepository;
import br.com.f1rst.gestaodefuncionarios.funcionario.domain.Funcionario;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
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
        funcionarioSpringDataMongoDBRepository.save(funcionario);
        log.info("[finaliza] FuncionarioInfraRepository - salva");
        return funcionario;
    }

    @Override
    public Funcionario funcionarioPorId(UUID idFuncionario) {
        log.info("[inicia] FuncionarioInfraRepository - funcionarioPorId");
        // TODO Adicionar tratamento de exceção (Handler)
        Funcionario funcionario = funcionarioSpringDataMongoDBRepository.findByIdFuncionario(idFuncionario)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado!"));
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
