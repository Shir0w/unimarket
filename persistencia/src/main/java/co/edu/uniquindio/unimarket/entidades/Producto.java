package co.edu.uniquindio.unimarket.entidades;

import lombok.*;
import org.springframework.context.annotation.EnableMBeanExport;

import javax.persistence.*;
import javax.persistence.metamodel.IdentifiableType;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

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

    @Column(unique = false, nullable = false, length = 100)
    private String nombre;

    @PositiveOrZero
    @Column(unique = false, nullable = false)
    private Integer unidades;

    @Lob
    @NotBlank
    @Column (unique = false, nullable = true)
    private String descripcion;
    
    @Positive
    @Column (unique = false, nullable = false, scale = 2)
    private double precio ;

    @Column(unique = false, nullable = false)
    private boolean activo;

    @Column (unique = false, nullable = false, columnDefinition= "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fechaCreado;

    @Column (unique = false, nullable = false)
    @Future
    private LocalDate fechaLimite;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "codigo_vendedor", nullable = false)
    private Usuario usuario;

    @OneToMany(mappedBy = "producto")
    @ToString.Exclude
    private List<Imagen> listaImagenes;

    @ManyToMany
    @JoinTable(name = "Favorito")
    private List<Usuario> usuarioFavorito;

    @OneToMany(mappedBy = "producto")
    @ToString.Exclude
    private List<DetalleCompra> listaDetalleCompra;

    @OneToMany(mappedBy = "producto")
    @ToString.Exclude
    private List<Comentario> listaComentarios;

    @OneToMany(mappedBy = "producto")
    @ToString.Exclude
    private List<ProductoModerador> listaProductoModerador;


    public Producto(String nombre, Integer unidades, String descripcion, double precio, boolean activo, LocalDateTime fechaCreado, LocalDate fechaLimite, Usuario usuario) {
        this.nombre = nombre;
        this.unidades = unidades;
        this.descripcion = descripcion;
        this.precio = precio;
        this.activo = activo;
        this.fechaCreado = fechaCreado;
        this.fechaLimite = fechaLimite;
        this.usuario = usuario;
    }
}
