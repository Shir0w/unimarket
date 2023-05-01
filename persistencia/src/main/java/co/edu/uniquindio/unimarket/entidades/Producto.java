package co.edu.uniquindio.unimarket.entidades;

import lombok.*;

import javax.persistence.*;
import javax.persistence.metamodel.IdentifiableType;
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
    @Column (name = "codigo", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    @Column(name = "nombre", unique = false, nullable = false)
    private String nombre;

    @Column(name= "unidades", unique = false, nullable = false)
    private int unidades;
    @Column (name = "descripcion", unique = false, nullable = true)
    private String descripcion;
    @Column (name = "precio", unique = false, nullable = false)
    private int precio ;

    @Column(name = "activo", unique = false, nullable = false)
    private boolean activo;

    @Column (name = "fechaCreado", unique = false, nullable = false)
    private LocalDateTime fechaCreado;
    @Column (name = "fechaLimite", unique = false, nullable = false)
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
