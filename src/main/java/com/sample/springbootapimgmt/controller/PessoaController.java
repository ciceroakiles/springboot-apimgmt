package com.sample.springbootapimgmt.controller;

import com.sample.springbootapimgmt.dto.MessageResponseDTO;
import com.sample.springbootapimgmt.dto.request.PessoaDTO;
import com.sample.springbootapimgmt.exception.PessoaException;
import com.sample.springbootapimgmt.service.PessoaService;
import java.util.List;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pessoas")
// Injeção de dependência (serviço)
// Essa linha equivale a um construtor do controller com pessoaService e @Autowired 
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PessoaController {

    private PessoaService pessoaService;

    // Método POST
    // ResponseStatus: código de status de resposta HTTP 201
    // RequestBody: objeto está vindo de uma requisição externa
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO criaPessoa(@RequestBody @Valid PessoaDTO pessoaDTO) throws PessoaException {
        return pessoaService.criaPessoa(pessoaDTO);
    }

    // Listagem completa
    @GetMapping
    public List<PessoaDTO> listAll() {
        return pessoaService.listAll();
    }

    // Busca pessoa por id
    // PathVariable: id na URL
    @GetMapping("/{id}")
    public PessoaDTO findById(@PathVariable Long id) throws PessoaException {
        return pessoaService.findById(id);
    }

    // Deleta pessoa por id
    // ResponseStatus: código de status de resposta HTTP 204
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws PessoaException {
        pessoaService.deleteById(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid PessoaDTO pessoaDTO) throws PessoaException {
        return pessoaService.updateById(id, pessoaDTO);
    }
}

// Teste
@RestController
@RequestMapping("/")
class Root {
    @GetMapping
    public String msg() {
        return "Whoops! Aqui é a raiz. Tente outro caminho.";
    }
}
