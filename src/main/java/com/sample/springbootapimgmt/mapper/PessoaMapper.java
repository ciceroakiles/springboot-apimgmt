package com.sample.springbootapimgmt.mapper;

import com.sample.springbootapimgmt.dto.request.PessoaDTO;
import com.sample.springbootapimgmt.entity.Pessoa;

// MapStruct
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PessoaMapper {
    /*
    // IMPORTANTE:
    // Caso haja incompatibilidade entre o Lombok e o MapStruct,
    // será disparada uma exceção do tipo ClassNotFoundException,
    // e a linha seguinte fará com que o projeto não rode
    */
    PessoaMapper INSTANCE = Mappers.getMapper(PessoaMapper.class);

    // Mapeia data de nascimento
    @Mapping(target = "dataNasc", source = "dataNasc", dateFormat = "dd-MM-yyyy")
    Pessoa toModel(PessoaDTO pessoaDTO);

    PessoaDTO toDto(Pessoa pessoa);
}
