package com.Liniamientos.api.liniamiento.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="usuarios")

public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    private String usuarios;
    private String passwoord;

     @ManyToOne
    @JoinColumn(name = "idRol")
    private Rol idRol;

    @ManyToOne
    @JoinColumn(name = "idPersona")
    private Persona idPersona;




}
