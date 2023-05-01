package co.edu.uniquindio.unimarket.entidades;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

    private LocalDate fechaCreacion;

    private double valorTotal;

    private String medioPago;

    public Compra(LocalDate fechaCreacion, double valorTotal, String medioPago) {
        this.fechaCreacion = fechaCreacion;
        this.valorTotal = valorTotal;
        this.medioPago = medioPago;
    }
}
