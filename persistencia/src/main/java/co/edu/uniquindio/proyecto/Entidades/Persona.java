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
public class Persona implements Serializable {

   @Column (name = "nombreCompleto", unique = false, nullable = false)
   private String NombreCompleto;

   @Column (name = "email", unique = true, nullable = false)
   private String email;
   @Id
   @Column (name = "cedula", unique = true, nullable = false)
   @EqualsAndHashCode.Include
   private String cedula;
   @ElementCollection
   @Column (name = "telefono", unique = true, nullable = false)
   private Map<String, String> telefono;
   @Column (name = "direccion", unique = false, nullable = true)
   private String direccion;

   @Column (name = "password", unique = false, nullable = false)
   private String password;
@ManyToOne
   private Producto producto;

   @Enumerated(EnumType.STRING)
   @Column (name = "password", unique = false, nullable = false)
   private Disponibilidad disponibilidad;

   public Persona(String nombreCompleto, String email, String cedula, String direccion, String password) {
        NombreCompleto = nombreCompleto;
        this.email = email;
        this.cedula = cedula;
        this.direccion = direccion;
        this.password = password;
   }
}
