package com.Liniamientos.api.liniamiento.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="preguntaEncuesta")
public class PreguntasEncuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name ="Id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idencuesta",referencedColumnName ="iencuesta",nullable = false )
    private Encuesta encuesta;

    @ManyToOne
    @JoinColumn(name = "idusuario",referencedColumnName ="idusuario",nullable = false )
    private Usuario usuario;


    private String pregunta;




}
