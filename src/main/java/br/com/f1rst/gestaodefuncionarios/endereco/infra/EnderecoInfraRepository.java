package br.com.f1rst.gestaodefuncionarios.endereco.infra;

import br.com.f1rst.gestaodefuncionarios.endereco.application.repositrory.EnderecoRepository;
import br.com.f1rst.gestaodefuncionarios.endereco.domain.Endereco;
import br.com.f1rst.gestaodefuncionarios.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.UUID;

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

    @Override
    public Endereco enderecoPorId(UUID idEndereco) {
        log.info("[inicia] EnderecoInfraRepository - enderecoPorId");
        Endereco endereco = enderecoSpringDataMongoDBRepository.findByIdEndereco(idEndereco)
                .orElseThrow(() -> APIException.build(HttpStatus.BAD_REQUEST, "Endereço não encontrado!"));
        log.info("[finaliza] EnderecoInfraRepository - enderecoPorId");
        return endereco;
    }

    @Override
    public void deletaEnderecoPorId(UUID idEndereco) {
        log.info("[inicia] EnderecoInfraRepository - deletaEnderecoPorId");
        enderecoSpringDataMongoDBRepository.deleteByIdEndereco(idEndereco);
        log.info("[finaliza] EnderecoInfraRepository - deletaEnderecoPorId");
    }
}
