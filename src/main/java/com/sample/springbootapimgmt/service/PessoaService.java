package com.sample.springbootapimgmt.service;

import com.sample.springbootapimgmt.dto.MessageResponseDTO;
import com.sample.springbootapimgmt.dto.request.PessoaDTO;
import com.sample.springbootapimgmt.entity.Pessoa;
import com.sample.springbootapimgmt.mapper.PessoaMapper;
import com.sample.springbootapimgmt.repository.PessoaRepositorio;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {
    
    private PessoaRepositorio pessoaRepositorio;

    // Mapper
    private PessoaMapper pessoaMapper = PessoaMapper.INSTANCE;

    // Injeção de dependência: repositório
    @Autowired
    public PessoaService(PessoaRepositorio pessoaRepositorio) {
        this.pessoaRepositorio = pessoaRepositorio;
    }

    // Inserção de pessoa
    public MessageResponseDTO criaPessoa(PessoaDTO pessoaDTO) {
        // Conversão de objetos
        Pessoa pessoaParaSalvar = pessoaMapper.toModel(pessoaDTO);

        Pessoa pessoaSave = pessoaRepositorio.save(pessoaParaSalvar);
        return MessageResponseDTO
            .builder()
            .message("Objeto <Pessoa> criado com ID " + pessoaSave.getId())
            .build();
    }

    // Converte cada objeto e retorna a lista DTO inteira
    public List<PessoaDTO> listAll() {
        List<Pessoa> todasPessoas = pessoaRepositorio.findAll();
        return todasPessoas
            .stream()
            .map(pessoaMapper::toDto)
            .collect(Collectors.toList());
    }
}
