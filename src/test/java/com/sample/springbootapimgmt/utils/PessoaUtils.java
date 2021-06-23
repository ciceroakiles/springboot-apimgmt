package com.sample.springbootapimgmt.utils;

import com.sample.springbootapimgmt.dto.request.PessoaDTO;
import java.util.Collections;

// Classe para mockar dados
public class PessoaUtils {
    private static final String PRIMEIRO_NOME = "João";
    private static final String ULTIMO_NOME = "Silva";
    private static final String CPF = "194.211.120-75";
    private static final String DATA_NASC = "12-12-1990";

    public static PessoaDTO criaFakeDTO() {
        return PessoaDTO.builder()
            .primeiroNome(PRIMEIRO_NOME)
            .ultimoNome(ULTIMO_NOME)
            .cpf(CPF)
            .dataNasc(DATA_NASC)
            .telefones(Collections.singletonList(TelefoneUtils.criaFakeDTO()))
            .build();
    }
}
