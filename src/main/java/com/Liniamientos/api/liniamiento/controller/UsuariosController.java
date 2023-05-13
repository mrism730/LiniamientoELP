package com.Liniamientos.api.liniamiento.controller;


import com.Liniamientos.api.liniamiento.controller.dto.UsuariosDTO;

import com.Liniamientos.api.liniamiento.model.Usuarios;

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
    private UsuariosController UsuariosRepository;
    @GetMapping
    Page<Usuarios> index(@PageableDefault(sort = "id", size = 5) Pageable pageable){
        return UsuariosRepository.findAll(pageable);
    }
    @GetMapping("/{id}")
    Usuarios obtener(@PathVariable Integer id){
        return UsuariosRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    Usuarios store(@RequestBody @Validated UsuariosDTO usuariosDTO){
        Usuarios usuarios = new ModelMapper().map(usuariosDTO, Usuarios.class);
        return UsuariosRepository.save(usuarios);
    }



    @PutMapping("/{id}")
    Usuarios update(@PathVariable Integer id, @RequestBody UsuariosDTO usuariosDTO){
        Usuarios persona = UsuariosRepository.findById(id).orElseThrow(EntityNotFoundException::new );
        new ModelMapper().map(usuariosDTO, us);
        return UsuariosRepository.save(new Usuarios());
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void destroy(@PathVariable Integer id){
        Usuarios usuarios = UsuariosRepository.findById(id).orElseThrow(EntityNotFoundException::new);

    }
}




