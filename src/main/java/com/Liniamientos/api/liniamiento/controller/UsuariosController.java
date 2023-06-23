package com.Liniamientos.api.liniamiento.controller;


import com.Liniamientos.api.liniamiento.controller.dto.UsuariosDTO;

import com.Liniamientos.api.liniamiento.model.Usuarios;

import com.Liniamientos.api.liniamiento.repository.UsuariosRepository;
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
@RequestMapping("api/usuarios")
public class UsuariosController {
    @Autowired
    private UsuariosRepository usuariosRepository;
    @GetMapping
    Page<Usuarios> index(@PageableDefault(sort = "id", size=5)Pageable pageable){
        return usuariosRepository.findAll(pageable);
    }
    @GetMapping("/{id}")
    Usuarios obtener(@PathVariable Integer id){
        return usuariosRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    Usuarios crear(@RequestBody @Validated UsuariosDTO usuariosDTO){
        Usuarios usuarios= new ModelMapper().map(usuariosDTO, Usuarios.class);
        return usuariosRepository.save(usuarios);
    }
    @PutMapping("/{id}")
    Usuarios actualizar(@PathVariable Integer id, @RequestBody UsuariosDTO usuariosDTO){
        Usuarios usuarios= usuariosRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        new ModelMapper().map(usuariosDTO, usuarios);
        return usuariosRepository.save(usuarios);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void eliminar(@PathVariable Integer id){
        Usuarios usuarios= usuariosRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        usuariosRepository.delete(usuarios);
    }

}




