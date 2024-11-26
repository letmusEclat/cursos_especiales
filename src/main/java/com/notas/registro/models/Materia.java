package com.notas.registro.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "materia")
public class Materia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_MATERIA", nullable = false)
    private Integer id;

    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_ESCUELA", nullable = false)
    private  Escuela idEscuela;

    @OneToMany(mappedBy = "idMateria")
    private Set< Curso> cursos = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "materias_y_profesor",
            joinColumns = @JoinColumn(name = "ID_MATERIA"),
            inverseJoinColumns = @JoinColumn(name = "ID_PROFESOR"))
    private Set< Profesor> profesors = new LinkedHashSet<>();

}