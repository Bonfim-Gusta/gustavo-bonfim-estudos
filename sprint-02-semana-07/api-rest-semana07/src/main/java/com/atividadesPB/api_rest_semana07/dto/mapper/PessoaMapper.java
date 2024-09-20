package com.atividadesPB.api_rest_semana07.dto.mapper;

import com.atividadesPB.api_rest_semana07.dto.PessoaDto;
import com.atividadesPB.api_rest_semana07.dto.PessoaResponseDto;
import org.modelmapper.ModelMapper;

public class PessoaMapper {

    public static PessoaResponseDto toResponseDto (PessoaDto dto){
        return new ModelMapper().map(dto, PessoaResponseDto.class);
    }
}
