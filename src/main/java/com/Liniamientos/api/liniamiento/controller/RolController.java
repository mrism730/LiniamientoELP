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

      @GetMapping("/{id}")
      Rol obtener(@PathVariable Integer id){
          return personaRepository.findById(id).orElseThrow(EntityNotFoundException::new);
      }
      @ResponseStatus (HttpStatus.CREATED)
      @PostMapping

      Rol store (@RequestBody @Validated RolDTO rolDTO){
          Rol rol = new ModelMapper().map(rolDTO, Persona.class);
          return rolRepository.save(rol);
      }
      @PutMapping("/{id}")
      Rol update (@PathVariable  Integer id , @RequestBody RolDTO rolDTO){
          Rol rol = rolRepository.findById(id).orElseThrow(EntityNotFoundException::new);
          new ModelMapper().map(rolDTO, rol);
          return rolRepository.save(new Rol());
      }

      @ResponseStatus(HttpStatus.NO_CONTENT)
      @DeleteMapping("/{id}")
      void destroy (@PathVariable Integer id){
          Rol rol = rolRepository.findById(id).orElseThrow();
      }
  }  }