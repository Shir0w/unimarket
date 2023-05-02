package co.edu.uniquindio.unimarket.entidades;

import java.io.Serializable;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@ToString
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass

public class Persona implements Serializable {

   @Id
   @EqualsAndHashCode.Include
   private String codigo;

   @Column (unique = false, nullable = false, length = 150)
   private String nombre;

   @Column (unique = true, nullable = false, length = 100)
   private String email;

   @Column (unique = false, nullable = false, length = 100)
   private String password;

   public Persona(String codigo, String nombre, String email, String password) {
      this.codigo = codigo;
      this.nombre = nombre;
      this.email = email;
      this.password = password;
   }
}
