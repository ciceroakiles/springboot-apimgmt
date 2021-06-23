package com.sample.springbootapimgmt.entity;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
public class Pessoa {

    // ID e estratégia de geração
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Valor não nulo (campo obrigatório)
    @Column(nullable = false)
    private String primeiroNome;

    @Column(nullable = false)
    private String ultimoNome;

    // Campo único para cada registro
    @Column(nullable = false, unique = true)
    private String cpf;

    private LocalDate dataNasc;

    // Relação de um para muitos
    // Mantém integridade no SQL de acordo com CASCADE
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Telefone> telefones;
}
