package com.sample.springbootapimgmt.dto.request;

import com.sample.springbootapimgmt.enums.TipoTel;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// Validation API
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

// Anotações Lombok
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TelefoneDTO {
    
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoTel tipo;

    @NotEmpty
    @Size(min = 12, max = 14)
    private String numero;
}
