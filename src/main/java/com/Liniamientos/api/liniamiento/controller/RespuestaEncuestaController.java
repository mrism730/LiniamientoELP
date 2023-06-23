package com.Liniamientos.api.liniamiento.controller;

import com.Liniamientos.api.liniamiento.controller.dto.RespuestaEncuestaDTO;
import com.Liniamientos.api.liniamiento.model.RespuestaEncuesta;
import com.Liniamientos.api.liniamiento.repository.RespuestaEncuestaRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Id;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/respuestaEncuesta")
public class RespuestaEncuestaController {

    @Autowired
    private RespuestaEncuestaRepository respuestaEncuestaRepository;

    @GetMapping
    Page<RespuestaEncuesta> index(@PageableDefault(sort = "id", size=5)Pageable pageable){
        return respuestaEncuestaRepository.findAll(pageable);
    }
    @GetMapping("/{id}")
    RespuestaEncuesta obtener(@PathVariable Integer id){
        return respuestaEncuestaRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    RespuestaEncuesta crear(@RequestBody @Validated RespuestaEncuestaDTO respuestaEncuestaDTO){
        RespuestaEncuesta respuestaEncuesta= new ModelMapper().map(respuestaEncuestaDTO, RespuestaEncuesta.class);
        return respuestaEncuestaRepository.save(respuestaEncuesta);
    }
    @PutMapping("/{id}")
    RespuestaEncuesta actualizar(@PathVariable Integer id, @RequestBody RespuestaEncuestaDTO respuestaEncuestaDTO){
        RespuestaEncuesta respuestaEncuesta= respuestaEncuestaRepository.findById(id).orElseThrow(EntityExistsException::new);
        new ModelMapper().map(respuestaEncuestaDTO, respuestaEncuesta);
        return respuestaEncuestaRepository.save(respuestaEncuesta);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void eliminar(@PathVariable Integer id){
        RespuestaEncuesta respuestaEncuesta= respuestaEncuestaRepository.findById(id).orElseThrow(EntityExistsException::new);
        respuestaEncuestaRepository.delete(respuestaEncuesta);
    }



}
