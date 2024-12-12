package com.notas.registro.controllers;

import com.notas.registro.models.Curso;
import com.notas.registro.models.CursosByPorfe;
import com.notas.registro.models.HistoricoCurso;
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
