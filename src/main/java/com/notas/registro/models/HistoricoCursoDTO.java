package com.notas.registro.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HistoricoCursoDTO {

    private Integer idHistorico;
    private Integer idCurso;
    private String nombreCurso;
    private String nombreMateria;
    private Double nota;
    private String acta;
    private String estado;
    private String periodo;
}

