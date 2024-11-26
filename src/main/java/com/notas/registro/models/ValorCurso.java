package com.notas.registro.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "valor_curso")
public class ValorCurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_VALOR_CURSO", nullable = false)
    private Integer id;

    @Column(name = "VALOR", nullable = false)
    private Integer valor;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_HISTORICO", nullable = false)
    private  HistoricoCurso idHistorico;

}