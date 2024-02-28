package br.com.f1rst.gestaodefuncionarios.endereco.infra;

import br.com.f1rst.gestaodefuncionarios.endereco.application.repositrory.EnderecoRepository;
import br.com.f1rst.gestaodefuncionarios.endereco.domain.Endereco;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
@Log4j2
public class EnderecoInfraRepository implements EnderecoRepository {
    private final EnderecoSpringDataMongoDBRepository enderecoSpringDataMongoDBRepository;

    @Override
    public Endereco salva(Endereco endereco) {
        log.info("[inicia] EnderecoInfraRepository - salva");
        enderecoSpringDataMongoDBRepository.save(endereco);
        log.info("[finaliza] EnderecoInfraRepository - salva");
        return endereco;
    }
}
