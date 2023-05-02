package co.edu.uniquindio.unimarket.entidades;

import java.io.Serializable;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass
@AllArgsConstructor
@ToString


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


}
