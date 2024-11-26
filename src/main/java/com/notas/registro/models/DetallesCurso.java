package com.notas.registro.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "detalles_curso")
public class DetallesCurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DETALLE", nullable = false)
    private Integer id;

    @Column(name = "EDIFICIO", nullable = false, length = 100)
    private String edificio;

    @Column(name = "SALON", nullable = false, length = 100)
    private String salon;

    @Column(name = "GRUPO", nullable = false, length = 100)
    private String grupo;

    @Column(name = "HORA", nullable = false)
    private Integer hora;

    @OneToMany(mappedBy = "idDetalle")
    private Set<Curso> cursos = new LinkedHashSet<>();

}