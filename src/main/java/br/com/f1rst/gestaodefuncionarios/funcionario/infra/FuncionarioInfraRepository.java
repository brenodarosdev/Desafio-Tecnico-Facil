package br.com.f1rst.gestaodefuncionarios.funcionario.infra;

import br.com.f1rst.gestaodefuncionarios.funcionario.application.repository.FuncionarioRepository;
import br.com.f1rst.gestaodefuncionarios.funcionario.domain.Funcionario;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@Repository
@Log4j2
public class FuncionarioInfraRepository implements FuncionarioRepository {
    @Override
    public Funcionario salva(Funcionario funcionario) {
        log.info("[inicia] FuncionarioInfraRepository - salva");

        log.info("[finaliza] FuncionarioInfraRepository - salva");
        return funcionario;
    }
}
