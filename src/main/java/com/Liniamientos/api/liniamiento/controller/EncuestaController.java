package com.Liniamientos.api.liniamiento.controller;

import com.Liniamientos.api.liniamiento.controller.dto.EncuestaDTO;
import com.Liniamientos.api.liniamiento.model.Encuesta;
import com.Liniamientos.api.liniamiento.repository.EncuestaRepository;
import jakarta.persistence.EntityExistsException;
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
@RequestMapping("api/encuesta")
public class EncuestaController {
    @Autowired
    private EncuestaRepository encuestaRepository;
    @GetMapping
    Page<Encuesta> index(@PageableDefault(sort = "id", size=5)Pageable pageable){
        return encuestaRepository.findAll(pageable);
    }
    @GetMapping("/{id}")
    Encuesta obtener(@PathVariable Integer id){
        return encuestaRepository.findById(id).orElseThrow(EntityExistsException::new);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    Encuesta crear(@RequestBody @Validated EncuestaDTO encuestaDTO){
        Encuesta encuesta= new ModelMapper().map(encuestaDTO, Encuesta.class);
        return encuestaRepository.save(encuesta);
    }
    @PutMapping("/{id}")
    Encuesta actualizar(@PathVariable Integer id, @RequestBody EncuestaDTO encuestaDTO){
        Encuesta encuesta= encuestaRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        new ModelMapper().map(encuestaDTO,encuesta);
        return encuestaRepository.save(encuesta);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void eliminar(@PathVariable Integer id){
        Encuesta encuesta= encuestaRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        encuestaRepository.delete(encuesta);
    }
}
