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
    
    
    @Query(value = "select" +
            "    hc.ID_HISTORICO," +
            "    e.NOMBRE" +
            "    from historico_curso hc " +
            "join estudiante e on hc.ID_ESTUDIANTE = e.ID " +
            "where hc.ID_CURSO = :idCurso;", nativeQuery = true)
    List<Object[]> findByIdCurso(Integer idCurso);

    @Query(value = """
            SELECT
                hc.ID_HISTORICO,
                hc.ID_CURSO,
                c.NOMBRE AS NOMBRE_CURSO,
                m.NOMBRE AS NOMBRE_MATERIA,
                hc.NOTA,
                hc.ACTA,
                CASE
                    WHEN hc.NOTA >= 3.2 THEN 'Aprobado'
                    ELSE 'Desaprobado'
                END AS ESTADO,
                CONCAT(fc.AÑO, '-', fc.SEMESTRE) AS PERIODO
            FROM historico_curso hc
            JOIN curso c ON c.ID_CURSO = hc.ID_CURSO
            JOIN materia m ON m.ID_MATERIA = c.ID_MATERIA
            JOIN fecha_curso fc ON c.ID_FECHA_CURSO = fc.ID_FECHA_CURSO
            where hc.ID_HISTORICO = :idHistorico
        """, nativeQuery = true)
    List<Object[]>  findHistoricoCursos(Integer idHistorico);
}