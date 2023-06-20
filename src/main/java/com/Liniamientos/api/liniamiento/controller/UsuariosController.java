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

}




