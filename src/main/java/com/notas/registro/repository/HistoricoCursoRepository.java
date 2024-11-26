package com.notas.registro.repository;

import com.notas.registro.models.HistoricoCurso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoricoCursoRepository extends JpaRepository<HistoricoCurso, Integer> {
    List<HistoricoCurso> findByIdEstudiante(Integer idEstudiante);
}