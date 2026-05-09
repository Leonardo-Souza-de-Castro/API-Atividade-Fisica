package com.itau.api.atividade_fisica.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
@Table(name = "atividades")
@Getter
@Setter
public class Atividade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAtividade;

    @Column(length = 9, nullable = false)
    private String funcional;

    @Column(length = 150, nullable = false)
    private String codigoAtividade;

    @Column(length = 300)
    private String descricaoAtividade;

    private LocalDateTime dataCriacao = LocalDateTime.now();
}
