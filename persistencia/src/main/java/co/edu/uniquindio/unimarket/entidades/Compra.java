package co.edu.uniquindio.unimarket.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@ToString

public class Compra implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer codigo;


    @Column(nullable = false)
    private LocalDate fechaCreacion;

    @Column(nullable = false, scale = 2)
    private double valorTotal;


    @Column(nullable = false, length = 50)
    private String medioPago;

    public Compra(LocalDate fechaCreacion, double valorTotal, String medioPago) {
        this.fechaCreacion = fechaCreacion;
        this.valorTotal = valorTotal;
        this.medioPago = medioPago;
    }
}
