package com.itau.api.atividade_fisica.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class CadastroDTO {
    @NotBlank(message = "Funcional é obrigatório")
    @Size(min = 9, max = 9, message = "Funcional deve ter 9 caracteres")
    private String funcional;

    @NotBlank(message = "O Código da atividade é obrigatório")
    @Size(max = 150, message = "Código da atividade deve ter no máximo 150 caracteres")
    private String codigoAtividade;

    @Size(max = 300, message = "A descrição da atividade deve ter no máximo 300 caracteres")
    private String descricaoAtividade;
    private LocalDateTime dataHora;
}
