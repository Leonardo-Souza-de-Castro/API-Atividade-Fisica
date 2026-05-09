package com.itau.api.atividade_fisica.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class ListarDTO {
    private String funcional;
    private String codigoAtividade;
    private String descricaoAtividade;
    private LocalDateTime dataHora;
}
