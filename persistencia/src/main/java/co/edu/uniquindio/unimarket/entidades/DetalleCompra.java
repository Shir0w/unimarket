package co.edu.uniquindio.unimarket.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@ToString

public class DetalleCompra implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @Column(nullable = false)
    private Integer unidades;


    @Column(nullable = false , scale = 2)
    private double precioProducto;

    @ManyToOne
    @JoinColumn(name = "codigo_producto", nullable = false)
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "codigo_compra", nullable = false)
    private Compra compra;

}
