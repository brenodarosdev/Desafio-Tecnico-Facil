package br.com.f1rst.gestaodefuncionarios.funcionario.application.service;

import br.com.f1rst.gestaodefuncionarios.endereco.application.repositrory.EnderecoRepository;
import br.com.f1rst.gestaodefuncionarios.funcionario.application.repository.FuncionarioRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class FuncionarioApplicationServiceTest {
    @InjectMocks
    private FuncionarioApplicationService funcionarioApplicationService;
    @Mock
    private FuncionarioRepository funcionarioRepositoryr;
    private EnderecoRepository enderecoRepository;

    @Test
    public void deveCriarNovoFuncionario() {
        //Dado - Given

        //Quando - When

        //Então - Then
    }
}