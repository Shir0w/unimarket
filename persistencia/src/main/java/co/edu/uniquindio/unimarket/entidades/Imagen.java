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

public class Imagen implements Serializable {

    @ManyToOne
    @JoinColumn(nullable = false)
    private Producto producto;

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idImagen;

    @Column(nullable = false)
    private String ruta;

    public Imagen(Producto producto, String ruta) {
        this.producto = producto;
        this.ruta = ruta;
    }
}
