package com.notas.registro.repository;

import com.notas.registro.models.HistoricoCurso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoricoCursoRepository extends JpaRepository<HistoricoCurso, Integer> {
    HistoricoCurso findByIdEstudiante(Integer idEstudiante);
}