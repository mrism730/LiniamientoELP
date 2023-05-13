package com.Liniamientos.api.liniamiento.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table ( name = "respuestaencuesta" )
public class RespuestaEncuesta {

  @Id
   @GeneratedValue ( strategy = GenerationType.IDENTITY )
   @Column ( name = "Id")
   private Integer id;

  @ManyToOne
   @JoinColumn ( name = "idusuario" , referencedColumnName = "idusuario" , nullable = false)
   private Usuarios usuarios;

  @OneToOne
   @JoinColumn ( name = "idpreguntasencuesta" , referencedColumnName = "idpreguntasencuesta" , nullable = false)
   private PreguntasEncuesta preguntasEncuesta ;

  private String Respuesta;



}




