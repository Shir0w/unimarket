package co.edu.uniquindio.proyecto.Entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class Detalle_Compra implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String codigo;
    private int unidades;
    private double precio_producto;



    public Detalle_Compra(String codigo, int unidades, double precio_producto ) {

        this.codigo = codigo;
        this.unidades = unidades;
        this.precio_producto = precio_producto;

    }
}
