package com.itau.api.atividade_fisica.DTO;

import lombok.Getter;

import java.util.Date;

@Getter
public class CadastroDTO {
    private String funcional;
    private String codigoAtividade;
    private String descricaoAtividade;
    private Date dataHora;
}
