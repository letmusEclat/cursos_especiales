package com.notas.registro.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "historico_curso")
public class HistoricoCurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_HISTORICO", nullable = false)
    private Integer id;

    @Column(name = "ID_CURSO", nullable = false)
    private Integer idCurso;

    @Column(name = "ID_ESTUDIANTE", nullable = false)
    private Integer idEstudiante;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_ESTUDIANTE", insertable = false, updatable = false)
    private  Estudiante estudiante;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_CURSO", insertable = false, updatable = false)
    private  Curso curso;

    @OneToMany(mappedBy = "idHistorico")
    private Set<ValorCurso> valorCursos = new LinkedHashSet<>();

}