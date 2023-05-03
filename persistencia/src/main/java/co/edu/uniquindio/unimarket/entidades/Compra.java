package co.edu.uniquindio.unimarket.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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


    @Column(nullable = false, columnDefinition= "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fechaCreacion;

    @Column(nullable = false, scale = 2)
    private double valorTotal;

    @Column(nullable = false, length = 50)
    private String medioPago;

    @ManyToOne
    @JoinColumn(name = "codigo_usuario", nullable = false)
    private Usuario usuario;

    @OneToMany(mappedBy = "compra")
    @ToString.Exclude
    private List<DetalleCompra> listaDetalleCompra;

    public Compra(LocalDateTime fechaCreacion, double valorTotal, String medioPago, Usuario usuario) {
        this.fechaCreacion = fechaCreacion;
        this.valorTotal = valorTotal;
        this.medioPago = medioPago;
        this.usuario = usuario;
    }
}
