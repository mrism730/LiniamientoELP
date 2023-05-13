package com.Liniamientos.api.liniamiento.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="persona")

public class Persona {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name="id")
    private Integer id;


    private String dni;
    private String nombreapellido;
    private String carrera;
    private String correo;
    private String ciclo;



}
