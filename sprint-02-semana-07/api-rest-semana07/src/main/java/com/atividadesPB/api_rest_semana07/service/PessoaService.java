package com.atividadesPB.api_rest_semana07.service;

import com.atividadesPB.api_rest_semana07.dto.PessoaDto;
import com.atividadesPB.api_rest_semana07.dto.PessoaResponseDto;
import com.atividadesPB.api_rest_semana07.dto.mapper.PessoaMapper;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    public PessoaResponseDto responderTentativaEntrada(PessoaDto pessoaDto){
        boolean isMaiorIdade = verificarMaiorIdade(pessoaDto.getIdade());
        String mensagem = mensagem(isMaiorIdade);
        PessoaResponseDto pessoaResponseDto = PessoaMapper.toResponseDto(pessoaDto);
        pessoaResponseDto.setResposta(mensagem);

        return pessoaResponseDto;
    }

    private String mensagem(boolean isMaiorIdade){
        if (isMaiorIdade){
            return "Entry Allowed";
        }
        else {
            return "Entry Denied";
        }
    }

    private boolean verificarMaiorIdade(Integer idade){
        return idade >= 18;
    }
}
