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
    @JoinColumn(name = "idEncuesta")
    private Encuesta encuesta;

    @ManyToOne
    @JoinColumn(name = "idUsuarios")
    private Usuarios usuarios;


    private String preguntas;




}
