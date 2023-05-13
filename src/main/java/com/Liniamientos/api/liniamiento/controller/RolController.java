package com.Liniamientos.api.liniamiento.controller;

import com.Liniamientos.api.liniamiento.model.Persona;
import com.Liniamientos.api.liniamiento.model.Rol;
import com.Liniamientos.api.liniamiento.repository.PersonaRepository;
import com.Liniamientos.api.liniamiento.repository.RolRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/Rol")
public class RolController {

  @Autowired
  private RolRepository rolRepository;
  @GetMapping
  Page<Rol> index(@PageableDefault(sort = "id", size = 5) Pageable pageable) {
      return rolRepository.findAll(pageable);


  }  }