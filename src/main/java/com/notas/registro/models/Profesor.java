package com.notas.registro.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "profesor")
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PROFESOR", nullable = false)
    private Integer id;

    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;

    @Column(name = "APELLIDO", nullable = false, length = 100)
    private String apellido;

    @OneToMany(mappedBy = "idProfesor")
    private Set< Curso> cursos = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "materias_y_profesor",
            joinColumns = @JoinColumn(name = "ID_PROFESOR"),
            inverseJoinColumns = @JoinColumn(name = "ID_MATERIA"))
    private Set< Materia> materias = new LinkedHashSet<>();

}