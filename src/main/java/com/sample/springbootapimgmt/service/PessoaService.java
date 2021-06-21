package com.sample.springbootapimgmt.service;

import com.sample.springbootapimgmt.dto.MessageResponseDTO;
import com.sample.springbootapimgmt.entity.Pessoa;
import com.sample.springbootapimgmt.repository.PessoaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {
    
    private PessoaRepositorio pessoaRepositorio;

    // Injeção de dependência: repositório
    @Autowired
    public PessoaService(PessoaRepositorio pessoaRepositorio) {
        this.pessoaRepositorio = pessoaRepositorio;
    }

    public MessageResponseDTO criaPessoa(Pessoa pessoa) {
        Pessoa pessoaSave = pessoaRepositorio.save(pessoa);
        return MessageResponseDTO
            .builder()
            .message("Objeto <Pessoa> criado com ID " + pessoaSave.getId())
            .build();
    }
}
