package com.Liniamientos.api.liniamiento.repository;

import com.Liniamientos.api.liniamiento.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EncuestaRepository extends JpaRepository<Usuarios, Integer> {
}
