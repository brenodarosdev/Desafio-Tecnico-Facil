package br.com.f1rst.gestaodefuncionarios.endereco.infra;

import br.com.f1rst.gestaodefuncionarios.endereco.domain.Endereco;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface EnderecoSpringDataMongoDBRepository extends MongoRepository<Endereco, UUID> {
}
