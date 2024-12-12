package com.notas.registro.controllers;

import com.notas.registro.models.HistoricoCurso;
import com.notas.registro.repository.HistoricoCursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/notas")
public class NotasController {
    @Autowired
    private HistoricoCursoRepository historicoCursoRepository;

    @GetMapping("/byEstudiante/{idEstudiante}")
    public List<HistoricoCurso> getNotasByEstudiante(@PathVariable Integer idEstudiante) {
        return this.historicoCursoRepository.findByIdEstudiante(idEstudiante);
    }

}
