package br.com.f1rst.gestaodefuncionarios.funcionario.application.service;

import br.com.f1rst.gestaodefuncionarios.endereco.application.api.EnderecoCriadoResponse;
import br.com.f1rst.gestaodefuncionarios.endereco.application.api.EnderecoNovoRequest;
import br.com.f1rst.gestaodefuncionarios.endereco.application.repositrory.EnderecoRepository;
import br.com.f1rst.gestaodefuncionarios.endereco.domain.Endereco;
import br.com.f1rst.gestaodefuncionarios.funcionario.application.api.FuncionarioCriadoResponse;
import br.com.f1rst.gestaodefuncionarios.funcionario.application.api.FuncionarioDetalhadoResponse;
import br.com.f1rst.gestaodefuncionarios.funcionario.application.api.FuncionarioNovoRequest;
import br.com.f1rst.gestaodefuncionarios.funcionario.application.repository.FuncionarioRepository;
import br.com.f1rst.gestaodefuncionarios.funcionario.domain.Funcionario;
import br.com.f1rst.gestaodefuncionarios.util.EnderecoCreator;
import br.com.f1rst.gestaodefuncionarios.util.FuncionarioCreator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FuncionarioApplicationServiceTest {
    @InjectMocks
    private FuncionarioApplicationService funcionarioApplicationService;
    @Mock
    private FuncionarioRepository funcionarioRepository;
    @Mock
    private EnderecoRepository enderecoRepository;

    @Test
    void deveCriarNovoFuncionario() {
        //Dado - Given
        Funcionario fucionario = FuncionarioCreator.criaFuncionario();
        FuncionarioNovoRequest funcionarioNovoRequest = FuncionarioCreator.CriaFuncionarioNovoRequest();
        EnderecoNovoRequest enderecoNovoRequest = EnderecoCreator.criaEnderecoNovoRequest();
        //Quando - When
        when(funcionarioRepository.salva(any())).thenReturn(new Funcionario(funcionarioNovoRequest));
        when(enderecoRepository.salva(any())).thenReturn(new Endereco(enderecoNovoRequest, fucionario.getIdEndereco()));
        FuncionarioCriadoResponse funcionarioCriadoResponse = funcionarioApplicationService.criaNovoFuncionario(funcionarioNovoRequest);
        //Então - Then
        assertNotNull(funcionarioCriadoResponse);
        assertEquals(FuncionarioCriadoResponse.class, funcionarioCriadoResponse.getClass());
        assertEquals(Endereco.class, funcionarioCriadoResponse.getEndereco().getClass());
        assertEquals(UUID.class, funcionarioCriadoResponse.getIdFuncionario().getClass());
        assertEquals(UUID.class, funcionarioCriadoResponse.getIdEndereco().getClass());
    }

    @Test
    void deveBuscarFuncionarioPorId() {
        //Dado - Given
        Funcionario fucionario = FuncionarioCreator.criaFuncionario();
        UUID idFuncionario = fucionario.getIdFuncionario();
        //Quando - When
        when(funcionarioRepository.funcionarioPorId(idFuncionario)).thenReturn(fucionario);
        FuncionarioDetalhadoResponse funcionarioDetalhadoResponse = funcionarioApplicationService.buscaFuncionarioPorId(idFuncionario);
        //Então - Then
        verify(funcionarioRepository, times(1)).funcionarioPorId(idFuncionario);
        assertEquals(FuncionarioDetalhadoResponse.class, funcionarioDetalhadoResponse.getClass());
        assertNotNull(funcionarioDetalhadoResponse);
    }

    @Test
    void deveBuscarEnderecoPorIdDoFuncionario() {
        //Dado - Given
        Funcionario funcionarioCriado = FuncionarioCreator.criaFuncionario();
        UUID idFuncionario = funcionarioCriado.getIdFuncionario();
        Endereco enderecoCriado = EnderecoCreator.criaEndereco();
        UUID idEndereco = enderecoCriado.getIdEndereco();
        //Quando - When
        when(funcionarioRepository.funcionarioPorId(idFuncionario)).thenReturn(funcionarioCriado);
        when(enderecoRepository.enderecoPorId(idEndereco)).thenReturn(enderecoCriado);
        EnderecoCriadoResponse enderecoCriadoResponse = funcionarioApplicationService
                .buscaEnderecoPorIdDoFuncionario(idFuncionario);
        //Então - Then
        verify(funcionarioRepository, times(1)).funcionarioPorId(idFuncionario);
        verify(enderecoRepository, times(1)).enderecoPorId(funcionarioCriado.getIdEndereco());
        assertEquals(EnderecoCriadoResponse.class, enderecoCriadoResponse.getClass());
        assertNotNull(enderecoCriadoResponse);
    }
}