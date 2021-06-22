package com.sample.springbootapimgmt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PessoaException extends Exception {
    
    public PessoaException(Long id) {
        super("ID " + id + " não encontrado");
    }
}
