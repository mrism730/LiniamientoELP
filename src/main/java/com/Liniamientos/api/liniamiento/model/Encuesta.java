package com.Liniamientos.api.liniamiento.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "encuesta")
public class Encuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @OneToOne
    @JoinColumn(name="idUsuarios")
    private Usuarios idUsuarios;

    private String nombreEncuesta;
    private Integer codigoEncuesta;
    private Date fecha;




}
