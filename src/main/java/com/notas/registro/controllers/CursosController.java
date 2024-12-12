package com.notas.registro.controllers;

import com.notas.registro.models.*;
import com.notas.registro.repository.CursoRepository;
import com.notas.registro.repository.HistoricoCursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cursos")
public class CursosController {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private HistoricoCursoRepository historicoCursoRepository;

    /**
     * Todos los cursos disponibles para que el estudiante se matricule
     */
    @GetMapping("/todos")
    public List<Curso> getAllCursos() {
        return this.cursoRepository.findAll();
    }

    @GetMapping("/matiriculados")
    public List<HistoricoCurso> getMatriculados() {
        return this.historicoCursoRepository.findAll();
    }


    @GetMapping("/byProfesor/{idProfesor}")
    public List<CursosByPorfe> getCursosByProfesor(@PathVariable Integer idProfesor) {
        var results = this.historicoCursoRepository.findByIdProfesor(idProfesor);
        return results.stream()
                .map(result -> new CursosByPorfe(
                        (Integer) result[0],  // id
                        (String) result[1]    // nombre
                ))
                .collect(Collectors.toList());
    }

    @GetMapping("/byCurso/{idCurso}")
    public List<CursoEstudiantes> getEstudiantesByCurso(@PathVariable Integer idCurso) {
        var results = this.historicoCursoRepository.findByIdCurso(idCurso);
        return results.stream()
                .map(result -> new CursoEstudiantes(
                        (Integer) result[0],  // id
                        (String) result[1]    // nombre
                ))
                .collect(Collectors.toList());
    }

    @GetMapping("/byidHistorico/{id}")
    public List<HistoricoCursoDTO> getHistoricoCursos(@PathVariable Integer id) {
        var results = historicoCursoRepository.findHistoricoCursos(id);
        return results.stream().map(row -> new HistoricoCursoDTO(
                ((Number) row[0]).intValue(),          // idHistorico
                ((Number) row[1]).intValue(),          // idCurso
                (String) row[2],                       // nombreCurso
                (String) row[3],                       // nombreMateria
                ((Number) row[4]).doubleValue(),       // nota
                (String) row[5],                       // acta
                (String) row[6],                       // estado
                (String) row[7]                        // periodo
        )).toList();
    }
    //---------------------------------------------             ADMINISTRADOR               -------------------------------   //

    /**
     * Recibe al estudiante y el curso que se desea matricular.
     */
    @PostMapping("/matricular")
    public ResponseEntity<Boolean> matricular(
            @RequestBody HistoricoCurso historicoCurso
    ) {
        this.historicoCursoRepository.save(historicoCurso);
        return ResponseEntity.ok(Boolean.TRUE);
    }

}
