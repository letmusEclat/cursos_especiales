package com.notas.registro.repository;

import com.notas.registro.models.Escuela;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EscuelaRepository extends JpaRepository<Escuela, Integer> {
}