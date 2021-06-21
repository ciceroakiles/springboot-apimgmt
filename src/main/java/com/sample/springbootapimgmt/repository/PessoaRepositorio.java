package com.sample.springbootapimgmt.repository;

import com.sample.springbootapimgmt.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepositorio extends JpaRepository<Pessoa, Long> {
    
}
