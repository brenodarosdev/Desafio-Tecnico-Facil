package br.com.f1rst.gestaodefuncionarios.funcionario.application.service;

import br.com.f1rst.gestaodefuncionarios.endereco.application.api.EnderecoNovoRequest;
import br.com.f1rst.gestaodefuncionarios.endereco.application.repositrory.EnderecoRepository;
import br.com.f1rst.gestaodefuncionarios.endereco.domain.Endereco;
import br.com.f1rst.gestaodefuncionarios.funcionario.application.api.FuncionarioCriadoResponse;
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
        assertEquals(UUID.class, funcionarioCriadoResponse.getIdFuncionario().getClass());
    }
}