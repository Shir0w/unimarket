package co.edu.uniquindio.unimarket.entidades;

import lombok.*;

import javax.persistence.*;
import javax.persistence.metamodel.IdentifiableType;
import javax.validation.constraints.Future;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@ToString

public class Producto implements Serializable{
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    @Column(unique = false, nullable = false)
    private String nombre;

    @Column(unique = false, nullable = false)
    private int unidades;
    @Column (unique = false, nullable = true)
    private String descripcion;
    @Column (unique = false, nullable = false)
    private int precio ;

    @Column(unique = false, nullable = false)
    private boolean activo;

    @Column (unique = false, nullable = false, columnDefinition= "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fechaCreado;
    @Column (unique = false, nullable = false)
    @Future
    private LocalDate fechaLimite;

    public Producto(String nombre, int unidades, String descripcion, int precio, boolean activo, LocalDateTime fechaCreado, LocalDate fechaLimite) {
        this.nombre = nombre;
        this.unidades = unidades;
        this.descripcion = descripcion;
        this.precio = precio;
        this.activo = activo;
        this.fechaCreado = fechaCreado;
        this.fechaLimite = fechaLimite;
    }
}
