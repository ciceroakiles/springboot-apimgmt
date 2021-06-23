package com.sample.springbootapimgmt.utils;

import com.sample.springbootapimgmt.dto.request.PessoaDTO;
import com.sample.springbootapimgmt.entity.Pessoa;
import java.time.LocalDate;
import java.util.Collections;

// Classe para mockar dados
public class PessoaUtils {
    private static final Long ID = 1L;
    private static final String PRIMEIRO_NOME = "João";
    private static final String ULTIMO_NOME = "Silva";
    private static final String CPF = "194.211.120-75";
    private static final LocalDate DATA_NASC = LocalDate.of(1990, 12, 12);

    public static PessoaDTO criaFakeDTO() {
        return PessoaDTO.builder()
            .primeiroNome(PRIMEIRO_NOME)
            .ultimoNome(ULTIMO_NOME)
            .cpf(CPF)
            .dataNasc("12-12-1990")
            .telefones(Collections.singletonList(TelefoneUtils.criaFakeDTO()))
            .build();
    }

    public static Pessoa criaFakeEnt() {
        return Pessoa.builder()
            .id(ID)
            .primeiroNome(PRIMEIRO_NOME)
            .ultimoNome(ULTIMO_NOME)
            .cpf(CPF)
            .dataNasc(DATA_NASC)
            .telefones(Collections.singletonList(TelefoneUtils.criaFakeEnt()))
            .build();
    }
}
