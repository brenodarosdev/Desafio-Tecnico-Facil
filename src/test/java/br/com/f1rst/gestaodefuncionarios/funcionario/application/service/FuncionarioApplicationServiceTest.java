package br.com.f1rst.gestaodefuncionarios.funcionario.application.service;

import br.com.f1rst.gestaodefuncionarios.endereco.application.api.EnderecoDetalhadoResponse;
import br.com.f1rst.gestaodefuncionarios.endereco.application.api.EnderecoNovoRequest;
import br.com.f1rst.gestaodefuncionarios.endereco.application.repositrory.EnderecoRepository;
import br.com.f1rst.gestaodefuncionarios.endereco.domain.Endereco;
import br.com.f1rst.gestaodefuncionarios.funcionario.application.api.AlteraFuncionarioRequest;
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
        Funcionario funcionario = FuncionarioCreator.criaFuncionario();
        FuncionarioNovoRequest funcionarioNovoRequest = FuncionarioCreator.criaFuncionarioNovoRequest();
        EnderecoNovoRequest enderecoNovoRequest = EnderecoCreator.criaEnderecoNovoRequest();
        //Quando - When
        when(funcionarioRepository.salva(any())).thenReturn(new Funcionario(funcionarioNovoRequest));
        when(enderecoRepository.salva(any())).thenReturn(new Endereco(enderecoNovoRequest, funcionario.getIdEndereco()));
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
        EnderecoDetalhadoResponse enderecoDetalhadoResponse = funcionarioApplicationService
                .buscaEnderecoPorIdDoFuncionario(idFuncionario);
        //Então - Then
        verify(funcionarioRepository, times(1)).funcionarioPorId(idFuncionario);
        verify(enderecoRepository, times(1)).enderecoPorId(funcionarioCriado.getIdEndereco());
        assertEquals(EnderecoDetalhadoResponse.class, enderecoDetalhadoResponse.getClass());
        assertNotNull(enderecoDetalhadoResponse);
    }

    @Test
    void deveAlterarFuncionario() {
        //Dado - Given
        AlteraFuncionarioRequest alteraFuncionarioRequest = FuncionarioCreator.alteraFuncionarioRequest();
        Funcionario funcionario = FuncionarioCreator.criaFuncionario();
        UUID idFuncionario = funcionario.getIdFuncionario();
        //Quando - When
        when(funcionarioRepository.funcionarioPorId(idFuncionario)).thenReturn(funcionario);
        when(funcionarioRepository.salva(any())).thenReturn(funcionario);
        funcionarioApplicationService.alteraFuncionario(alteraFuncionarioRequest, idFuncionario);
        //Então - Then
        verify(funcionarioRepository, times(1)).funcionarioPorId(idFuncionario);
        verify(funcionarioRepository, times(1)).salva(funcionario);
    }

    @Test
    void deveAlterarEnderecoPorIdDoFuncionario() {
        //Dado - Given
        Funcionario funcionario = FuncionarioCreator.criaFuncionario();
        UUID idFuncionario = funcionario.getIdFuncionario();
        EnderecoNovoRequest alteraEnderecoRequest = EnderecoCreator.alteraEnderecoPorIdDoFuncionario();
        Endereco endereco = EnderecoCreator.criaEndereco();
        UUID IdEndereco = funcionario.getIdEndereco();
        //Quando - When
        when(funcionarioRepository.funcionarioPorId(idFuncionario)).thenReturn(funcionario);
        when(enderecoRepository.enderecoPorId(IdEndereco)).thenReturn(endereco);
        when(enderecoRepository.salva(any())).thenReturn(endereco);
        funcionarioApplicationService.alteraEnderecoPorIdDoFuncionario(alteraEnderecoRequest, idFuncionario);
        //Então - Then
        verify(funcionarioRepository, times(1)).funcionarioPorId(idFuncionario);
        verify(enderecoRepository, times(1)).enderecoPorId(funcionario.getIdEndereco());
        verify(enderecoRepository, times(1)).salva(endereco);
    }
}