package com.Liniamientos.api.liniamiento.controller;

import com.Liniamientos.api.liniamiento.controller.dto.PreguntasEncuestasDTO;
import com.Liniamientos.api.liniamiento.controller.dto.RespuestaEncuestaDTO;
import com.Liniamientos.api.liniamiento.model.PreguntasEncuesta;
import com.Liniamientos.api.liniamiento.repository.PreguntasEncuestaRepository;
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
@RequestMapping("api/preguntasEncuesta")
public class PreguntasEncuestaController {

    @Autowired
    private PreguntasEncuestaRepository preguntasEncuestaRepository;
    @GetMapping
    Page<PreguntasEncuesta> index(@PageableDefault(sort = "id", size=5)Pageable pageable){
        return preguntasEncuestaRepository.findAll(pageable);
    }
    @GetMapping("/{id}")
    PreguntasEncuesta obtener(@PathVariable Integer id){
        return preguntasEncuestaRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    PreguntasEncuesta crear(@RequestBody @Validated PreguntasEncuestasDTO preguntasEncuestasDTO){
        PreguntasEncuesta preguntasEncuesta= new ModelMapper().map(preguntasEncuestasDTO, PreguntasEncuesta.class);
        return preguntasEncuestaRepository.save(preguntasEncuesta);
    }
    @PutMapping("/{id}")
    PreguntasEncuesta actualizar(@PathVariable Integer id, @RequestBody PreguntasEncuestasDTO preguntasEncuestasDTO){
        PreguntasEncuesta preguntasEncuesta = preguntasEncuestaRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        new ModelMapper().map(preguntasEncuestasDTO, preguntasEncuesta);
        return preguntasEncuestaRepository.save(preguntasEncuesta);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void eliminar(@PathVariable Integer id){
        PreguntasEncuesta preguntasEncuesta= preguntasEncuestaRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        preguntasEncuestaRepository.delete(preguntasEncuesta);
    }


}
