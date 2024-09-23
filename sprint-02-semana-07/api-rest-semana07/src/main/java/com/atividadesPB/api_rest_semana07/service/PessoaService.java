package com.atividadesPB.api_rest_semana07.service;

import com.atividadesPB.api_rest_semana07.service.dto.PessoaDto;
import com.atividadesPB.api_rest_semana07.service.dto.PessoaResponseDto;
import com.atividadesPB.api_rest_semana07.service.dto.mapper.PessoaMapper;
import com.atividadesPB.api_rest_semana07.staticClasses.ValidacaoCamposPreenchidos;
import com.atividadesPB.api_rest_semana07.staticClasses.ValidacaoPessoa;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    public PessoaResponseDto responderTentativaEntrada(PessoaDto pessoaDto){
        ValidacaoCamposPreenchidos.verificarCampos(pessoaDto);
        boolean isMaiorIdade = ValidacaoPessoa.verificarMaiorIdade(pessoaDto.getIdade());
        String mensagem = ValidacaoPessoa.mensagem(isMaiorIdade);

        PessoaResponseDto pessoaResponseDto = PessoaMapper.toResponseDto(pessoaDto);
        pessoaResponseDto.setResposta(mensagem);

        return pessoaResponseDto;
    }
}
