package com.Liniamientos.api.liniamiento.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "encuesta")
public class Encuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    private String nombreEncuesta;
    private String codigoEncuesta;
    private String fecha;

    @OneToOne
    @JoinColumn(name="idUsuarios")
    private Usuarios idUsuarios;


}
