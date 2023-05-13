package com.Liniamientos.api.liniamiento.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name ="Id")
    private Integer id;

    private String rol;

}
