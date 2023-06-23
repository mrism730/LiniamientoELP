package com.Liniamientos.api.liniamiento.repository;

import com.Liniamientos.api.liniamiento.model.RespuestaEncuesta;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RespuestaEncuestaRepository extends JpaRepository <RespuestaEncuesta, Integer> {
}
