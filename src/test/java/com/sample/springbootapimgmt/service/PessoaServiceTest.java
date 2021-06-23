package com.sample.springbootapimgmt.service;

import com.sample.springbootapimgmt.dto.MessageResponseDTO;
import com.sample.springbootapimgmt.dto.request.PessoaDTO;
import com.sample.springbootapimgmt.entity.Pessoa;
import com.sample.springbootapimgmt.exception.PessoaException;
import com.sample.springbootapimgmt.repository.PessoaRepositorio;
import com.sample.springbootapimgmt.utils.PessoaUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
// Mockito
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mock;
// Imports estáticos
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

// Classe de teste com framework Mockito
@ExtendWith(MockitoExtension.class)
public class PessoaServiceTest {
    
    @Mock
    private PessoaRepositorio pessoaRepositorio;

    @InjectMocks
    private PessoaService pessoaService;

    @Test
    void TestandoPessoaDTO() throws PessoaException {
        // Dados fake da classe Utils
        Pessoa fakeObj = PessoaUtils.criaFakeEnt();
        PessoaDTO testDTO = PessoaUtils.criaFakeDTO();
        // Retorna resultado para o Mockito após "salvar"
        // save(fakeObj): id=null - ERRO
        // save(any(Pessoa.class)): id salvo corretamente
        when(pessoaRepositorio.save(any(Pessoa.class))).thenReturn(fakeObj);
        // Mensagens
        MessageResponseDTO msgEsperada = respostaEsperada(fakeObj.getId());
        MessageResponseDTO msgSucesso = pessoaService.criaPessoa(testDTO);
        // Comparação das mensagens
        Assertions.assertEquals(msgEsperada, msgSucesso);
    }

    private MessageResponseDTO respostaEsperada(Long id) {
        return MessageResponseDTO
            .builder()
            .message("Objeto <Pessoa> criado (ID " + id + ")")
            .build();
    }
}
