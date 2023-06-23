package com.Liniamientos.api.liniamiento.controller;

import com.Liniamientos.api.liniamiento.controller.dto.PersonaDTO;
import com.Liniamientos.api.liniamiento.model.Persona;
import com.Liniamientos.api.liniamiento.repository.PersonaRepository;
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
@RequestMapping("api/persona")

public class PersonaController {
@Autowired
    private PersonaRepository personaRepository;
    @GetMapping
    Page<Persona> index(@PageableDefault(sort = "id", size = 5) Pageable pageable){
        return personaRepository.findAll(pageable);
    }
    @GetMapping("/{id}")
    Persona obtener(@PathVariable Integer id){
        return personaRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    Persona crear(@RequestBody @Validated PersonaDTO personaDTO){
        Persona persona = new ModelMapper().map(personaDTO, Persona.class);
        return personaRepository.save(persona);
    }
    @PutMapping("/{id}")
    Persona actualizar(@PathVariable Integer id, @RequestBody PersonaDTO personaDTO){
        Persona persona = personaRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        new ModelMapper().map(personaDTO, persona);
        return personaRepository.save(new Persona());
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void eliminar(@PathVariable Integer id){
        Persona persona = personaRepository.findById(id).orElseThrow(EntityNotFoundException::new);

}
}
