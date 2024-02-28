package br.com.f1rst.gestaodefuncionarios.funcionario.infra;

import br.com.f1rst.gestaodefuncionarios.funcionario.domain.Funcionario;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface FuncionarioSpringDataMongoDBRepository extends MongoRepository<Funcionario, UUID> {
}
