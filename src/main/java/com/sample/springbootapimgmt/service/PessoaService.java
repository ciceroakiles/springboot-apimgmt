package com.sample.springbootapimgmt.service;

import com.sample.springbootapimgmt.dto.MessageResponseDTO;
import com.sample.springbootapimgmt.dto.request.PessoaDTO;
import com.sample.springbootapimgmt.entity.Pessoa;
import com.sample.springbootapimgmt.exception.PessoaException;
import com.sample.springbootapimgmt.mapper.PessoaMapper;
import com.sample.springbootapimgmt.repository.PessoaRepositorio;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
// Injeção de dependência (repositório) == construtor do serviço com pessoaRepositorio e @Autowired
// (erro no mapper)
//@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PessoaService {
    // Mapper
    private PessoaMapper pessoaMapper = PessoaMapper.INSTANCE;

    private PessoaRepositorio pessoaRepositorio;

    @Autowired
    public PessoaService(PessoaRepositorio pessoaRepositorio) {
        this.pessoaRepositorio = pessoaRepositorio;
    }

    // Inserção de pessoa (usa o método criaMessageResponse)
    public MessageResponseDTO criaPessoa(PessoaDTO pessoaDTO) throws PessoaException {
        // Conversão de objetos
        Pessoa beforeSave = pessoaMapper.toModel(pessoaDTO);
        Pessoa salva = pessoaRepositorio.save(beforeSave);
        return criaMessageResponse("Objeto <Pessoa> criado (ID " + salva.getId() + ")");
    }

    // Converte cada objeto e retorna a lista DTO inteira
    public List<PessoaDTO> listAll() {
        List<Pessoa> todasPessoas = pessoaRepositorio.findAll();
        return todasPessoas
            .stream()
            .map(pessoaMapper::toDto)
            .collect(Collectors.toList());
    }

    // Busca (usa o método verificaPessoa)
    public PessoaDTO findById(Long id) throws PessoaException {
        return pessoaMapper.toDto(verificaPessoa(id));
    }

    // Deleção (usa o método verificaPessoa)
    public void deleteById(Long id) throws PessoaException {
        verificaPessoa(id);
        pessoaRepositorio.deleteById(id);
    }

    // Atualização (usa os métodos verificaPessoa e criaMessageResponse)
    public MessageResponseDTO updateById(Long id, PessoaDTO pessoaDTO) throws PessoaException {
        verificaPessoa(id);
        Pessoa updated = pessoaMapper.toModel(pessoaDTO);
        Pessoa salva = pessoaRepositorio.save(updated);
        return criaMessageResponse("Objeto <Pessoa> atualizado (ID " + salva.getId() + ")");
    }

    // Verifica se pessoa existe
    private Pessoa verificaPessoa(Long id) throws PessoaException {
        // Caso não encontre, lança a exceção (expressão lambda)
        Pessoa pessoaExiste = pessoaRepositorio.findById(id)
            .orElseThrow(() -> new PessoaException(id));
        return pessoaExiste;
    }

    // Mensagem de resposta dos métodos CREATE e UPDATE
    private MessageResponseDTO criaMessageResponse(String msg) throws PessoaException {
        return MessageResponseDTO.builder().message(msg).build();
    }
}
