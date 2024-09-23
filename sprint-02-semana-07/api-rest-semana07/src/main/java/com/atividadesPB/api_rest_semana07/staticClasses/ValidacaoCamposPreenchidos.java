package com.atividadesPB.api_rest_semana07.staticClasses;

import com.atividadesPB.api_rest_semana07.exceptions.CamposNaoPreenchidosException;
import com.atividadesPB.api_rest_semana07.service.dto.PessoaDto;

public class ValidacaoCamposPreenchidos {
    public static void verificarCampos(PessoaDto dto){
        if ((dto.getNome() == null) || (dto.getNome().isEmpty()) || (dto.getIdade() == null) || (dto.getIdade() <= -1)){
            throw new CamposNaoPreenchidosException("Algum campo está vazio ou não foi preenchido corretamente");
        }
    }
}
