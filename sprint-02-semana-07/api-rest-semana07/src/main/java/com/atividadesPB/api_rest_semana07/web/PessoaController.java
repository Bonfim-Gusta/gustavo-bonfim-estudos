package com.atividadesPB.api_rest_semana07.web;

import com.atividadesPB.api_rest_semana07.dto.PessoaDto;
import com.atividadesPB.api_rest_semana07.dto.PessoaResponseDto;
import com.atividadesPB.api_rest_semana07.service.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/semana07/pessoas")
@RequiredArgsConstructor
public class PessoaController {

    private final PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<PessoaResponseDto> entrar(@RequestBody PessoaDto pessoaDto){
        return ResponseEntity.ok(pessoaService.responderTentativaEntrada(pessoaDto));
    }
}
