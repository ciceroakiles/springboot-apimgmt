package com.sample.springbootapimgmt.dto.request;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// Validation API
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

// Anotações Lombok
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDTO {
    
    private Long id;

    // Anotações de validação
    @NotEmpty
    @Size(min = 2, max = 100)
    private String primeiroNome;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String ultimoNome;

    @NotEmpty
    @CPF
    private String cpf;

    private String dataNasc;

    @Valid
    @NotEmpty
    private List<TelefoneDTO> telefones;
}
