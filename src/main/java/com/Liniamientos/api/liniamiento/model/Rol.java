package com.Liniamientos.api.liniamiento.model;

import jakarta.persistence.*;

@Entity
@Table(
        name = "rol"
)
public class Rol {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY)
    @Column(
            name = "id"
    )
    private Integer id;
    private String rol;
}
