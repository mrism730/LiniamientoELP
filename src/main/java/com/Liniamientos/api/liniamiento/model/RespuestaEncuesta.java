package com.Liniamientos.api.liniamiento.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table ( name = "respuestaEncuesta" )
public class RespuestaEncuesta {

  @Id
   @GeneratedValue ( strategy = GenerationType.IDENTITY )
   @Column ( name = "id")
   private Integer id;

  private String Respuesta;

  @ManyToOne
   @JoinColumn ( name = "idUsuario")
   private Usuarios idUsuarios;

  @OneToOne
   @JoinColumn ( name = "idpreguntasEncuesta")
   private PreguntasEncuesta idpreguntasEncuesta ;

}




