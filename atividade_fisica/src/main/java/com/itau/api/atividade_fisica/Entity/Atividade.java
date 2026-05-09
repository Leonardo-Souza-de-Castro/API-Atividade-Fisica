package com.itau.api.atividade_fisica.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
@Table(name = "atividades")
@Getter
@Setter
public class Atividade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdAtividade;

    @Column(length = 9, nullable = false, name = "funcional")
    private String Funcional;

    @Column(length = 150, nullable = false, name = "codigoAtividade")
    private String CodigoAtividade;

    @Column(length = 300, name = "descricaoAtividade")
    private String DescricaoAtividade;

    @Column(name = "dataCriacao")
    private Date dataCriacao;
}
