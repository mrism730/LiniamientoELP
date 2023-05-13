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

     @ManyToOne
    @JoinColumn(name = "idrol",referencedColumnName ="idrol",nullable = false )
    private Rol rol;

    @ManyToOne
    @JoinColumn(name = "idpersona",referencedColumnName ="idpersona",nullable = false )
    private Persona persona;


     private String usuario;
     private String passwoord;

}
