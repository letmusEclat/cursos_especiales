package com.notas.registro.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "curso")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CURSO", nullable = false)
    private Integer id;

    @Column(name = "NOMBRE", nullable = false, length = 30)
    private String nombre;

    @Column(name = "CUPO", nullable = false)
    private Integer cupo;

    @Column(name = "VALOR", nullable = false)
    private Double valor;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_PROFESOR", nullable = false)
    private Profesor idProfesor;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_FECHA_CURSO", nullable = false)
    private FechaCurso idFechaCurso;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_DETALLE", nullable = false)
    private DetallesCurso idDetalle;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_MATERIA", nullable = false)
    private Materia idMateria;

    @OneToMany(mappedBy = "idCurso")
    private Set<HistoricoCurso> historicoCursos = new LinkedHashSet<>();

}