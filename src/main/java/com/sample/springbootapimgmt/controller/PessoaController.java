package com.sample.springbootapimgmt.controller;

import javax.validation.Valid;

import com.sample.springbootapimgmt.dto.MessageResponseDTO;
import com.sample.springbootapimgmt.dto.request.PessoaDTO;
import com.sample.springbootapimgmt.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pessoas")
public class PessoaController {
    
    private PessoaService pessoaService;

    // Injeção de dependência: serviço
    @Autowired
    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }
    
    // Método POST
    // ResponseStatus: código de status de resposta HTTP 201
    // RequestBody: objeto está vindo de uma requisição externa
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO criaPessoa(@RequestBody @Valid PessoaDTO pessoaDTO) {
        return pessoaService.criaPessoa(pessoaDTO);
    }

    // Testes
    @GetMapping
    public String msg() {
        return "API Test";
    }
}

// Mais testes
@RestController
@RequestMapping("/")
class Root {
    @GetMapping
    public String msgMain() {
        return "Whoops! Aqui é a raiz. Tente outro caminho.";
    }
}