package co.edu.uniquindio.unimarket.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString

public class Moderador extends Persona implements Serializable {

    @OneToMany(mappedBy = "moderador")
    private List<ProductoModerador> listaProductoModerador;

}
