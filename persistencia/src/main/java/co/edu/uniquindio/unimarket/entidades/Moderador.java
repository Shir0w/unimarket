package co.edu.uniquindio.unimarket.entidades;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@ToString

public class Moderador extends Persona implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    private String codigo;

    public Moderador(String codigo) {
        this.codigo = codigo;
    }
}
