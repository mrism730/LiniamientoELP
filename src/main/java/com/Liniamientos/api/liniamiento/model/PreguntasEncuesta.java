package com.Liniamientos.api.liniamiento.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="preguntasEncuesta")
public class PreguntasEncuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name ="Id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idencuesta",referencedColumnName ="idencuesta",nullable = false )
    private Encuesta encuesta;

    @ManyToOne
    @JoinColumn(name = "idusuario",referencedColumnName ="idusuario",nullable = false )
    private Usuarios usuario;


    private String preguntas;




}
