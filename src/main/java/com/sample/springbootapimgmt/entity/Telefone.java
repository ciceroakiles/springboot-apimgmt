package com.sample.springbootapimgmt.entity;

import com.sample.springbootapimgmt.enums.TipoTel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// Anotações Lombok
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
//
@Entity
public class Telefone {
    
    // ID e estratégia de geração
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Enum: valores predefinidos
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoTel tipo;

    // Valor não nulo (campo obrigatório)
    @Column(nullable = false)
    private String numero;
}
