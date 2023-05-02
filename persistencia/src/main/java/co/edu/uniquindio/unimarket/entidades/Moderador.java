package co.edu.uniquindio.unimarket.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)

public class Moderador extends Persona implements Serializable {

    @OneToMany(mappedBy = "moderador")
    @ToString.Exclude
    private List<ProductoModerador> listaProductoModerador;

}
