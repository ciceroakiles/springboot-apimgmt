package com.sample.springbootapimgmt.controller;

import com.sample.springbootapimgmt.dto.MessageResponseDTO;
import com.sample.springbootapimgmt.entity.Pessoa;
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
    public MessageResponseDTO criaPessoa(@RequestBody Pessoa pessoa) {
        return pessoaService.criaPessoa(pessoa);
    }

    // Teste
    @GetMapping
    public String msg() {
        return "API Test";
    }
}
