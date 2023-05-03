package co.edu.uniquindio.unimarket.entidades;

import lombok.*;
import org.springframework.context.annotation.EnableMBeanExport;

import javax.persistence.*;
import javax.persistence.metamodel.IdentifiableType;
import javax.validation.constraints.Future;
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

    @Column(unique = false, nullable = false)
    private Integer unidades;
    @Column (unique = false, nullable = true)
    private String descripcion;
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


    public Producto(Integer codigo, String nombre, int unidades, double precio, boolean activo, LocalDateTime fechaCreado, LocalDate fechaLimite, Categoria categoria, Usuario usuario, List<Imagen> listaImagenes, List<Usuario> usuarioFavorito, List<DetalleCompra> listaDetalleCompra, List<Comentario> listaComentarios, List<ProductoModerador> listaProductoModerador) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.unidades = unidades;
        this.precio = precio;
        this.activo = activo;
        this.fechaCreado = fechaCreado;
        this.fechaLimite = fechaLimite;
        this.categoria = categoria;
        this.usuario = usuario;
        this.listaImagenes = listaImagenes;
        this.usuarioFavorito = usuarioFavorito;
        this.listaDetalleCompra = listaDetalleCompra;
        this.listaComentarios = listaComentarios;
        this.listaProductoModerador = listaProductoModerador;
    }
}
