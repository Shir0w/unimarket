package co.edu.uniquindio.proyecto.Entidades;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Map;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class   Persona implements Serializable {

   @Id
   private String codigo;

   @Column (name = "nombreCompleto", unique = false, nullable = false)
   private String nombre;

   @Column (name = "email", unique = true, nullable = false)
   private String email;

   @Column (name = "password", unique = false, nullable = false)
   private String password;



}
