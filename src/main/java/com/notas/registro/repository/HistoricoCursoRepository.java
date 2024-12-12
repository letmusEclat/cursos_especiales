package com.notas.registro.repository;

import com.notas.registro.models.CursosByPorfe;
import com.notas.registro.models.HistoricoCurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HistoricoCursoRepository extends JpaRepository<HistoricoCurso, Integer> {
    List<HistoricoCurso> findByIdEstudiante(Integer idEstudiante);


    @Query(value="select C.ID_CURSO, " +
            "       CONCAT(m.NOMBRE, '-', c.NOMBRE) as CURSO " +
            "from materia m " +
            "join curso c on c.ID_MATERIA = m.ID_MATERIA " +
            "join profesor p on c.ID_PROFESOR = p.ID_PROFESOR " +
            "where p.ID_PROFESOR = :idProfesor", nativeQuery = true)
    List<Object[]> findByIdProfesor(Integer idProfesor);
}