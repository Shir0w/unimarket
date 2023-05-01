package co.edu.uniquindio.unimarket.entidades;

import java.io.Serializable;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@ToString

public class Persona implements Serializable {

   @Id
   @EqualsAndHashCode.Include
   private String codigo;

   @Column (unique = false, nullable = false)
   private String nombre;

   @Column (unique = true, nullable = false)
   private String email;

   @Column (unique = false, nullable = false)
   private String password;

   public Persona(String codigo, String nombre, String email, String password) {
      this.codigo = codigo;
      this.nombre = nombre;
      this.email = email;
      this.password = password;
   }
}
