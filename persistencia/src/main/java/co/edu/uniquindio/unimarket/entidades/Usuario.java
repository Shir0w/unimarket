package co.edu.uniquindio.unimarket.entidades;

import lombok.*;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@ToString


public class Usuario extends Persona implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    private String codigo;
    private String direccion;
    private Integer telefono;

    public Usuario(String codigo, String direccion, Integer telefono) {
        this.codigo = codigo;
        this.direccion = direccion;
        this.telefono = telefono;
    }
}
