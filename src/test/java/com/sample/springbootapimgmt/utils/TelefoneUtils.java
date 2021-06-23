package com.sample.springbootapimgmt.utils;

import com.sample.springbootapimgmt.dto.request.TelefoneDTO;
import com.sample.springbootapimgmt.entity.Telefone;
import com.sample.springbootapimgmt.enums.TipoTel;

public class TelefoneUtils {
    private static final Long ID = 1L;
    private static final TipoTel TEL_TIPO = TipoTel.MOVEL;
    private static final String TEL_NUMERO = "(11) 9999-9999";

    public static TelefoneDTO criaFakeDTO() {        
        return TelefoneDTO.builder()
            .tipo(TEL_TIPO)
            .numero(TEL_NUMERO)
            .build();
    }

    public static Telefone criaFakeEnt() {
        return Telefone.builder()
            .id(ID)
            .tipo(TEL_TIPO)
            .numero(TEL_NUMERO)
            .build();
    }
}
