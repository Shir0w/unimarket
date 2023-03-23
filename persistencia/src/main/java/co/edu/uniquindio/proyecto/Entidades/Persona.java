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
   @Id
   @EqualsAndHashCode.Include
    private String NombreCompleto;
   private String email;
   private String cedula;
    @ElementCollection
    private Map<String, String> telefono;
    private String direccion;
    private String password;

    public Persona(String nombreCompleto, String email, String cedula, String direccion, String password) {
        NombreCompleto = nombreCompleto;
        this.email = email;
        this.cedula = cedula;
        this.direccion = direccion;
        this.password = password;
    }
}
