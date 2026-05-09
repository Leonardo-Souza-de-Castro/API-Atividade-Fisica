package com.itau.api.atividade_fisica.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class RespostaCadastroDTO {

    private Long idAtividade;
    private String funcional;
    private String codigoAtividade;
    private String descricaoAtividade;
    private LocalDateTime dataHora;
}
