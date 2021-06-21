package com.sample.springbootapimgmt.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

// Anotações Lombok
@Getter
@AllArgsConstructor
public enum TipoTel {
    
    RESIDENCIAL("Residencial"),
    MOVEL("Movel"),
    COMERCIAL("Comercial");

    private final String descricao;
}
