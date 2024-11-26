package com.notas.registro.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "fecha_curso")
public class FechaCurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_FECHA_CURSO", nullable = false)
    private Integer id;

    @Column(name = "`AÑO`", nullable = false)
    private Integer año;

    @Column(name = "SEMESTRE", nullable = false)
    private Integer semestre;

}