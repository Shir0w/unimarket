package co.edu.uniquindio.unimarket.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString


public class Usuario extends Persona implements Serializable {

    @Column(nullable = false, length = 150, unique = false)
    private String direccion;

    @Column(nullable = false, unique = false)
    private Integer telefono;

    @OneToMany(mappedBy = "usuario")
    private List<Producto> listaProductos;

    @OneToMany(mappedBy = "usuario")
    private List<Compra> listaCompras;

    @ManyToMany(mappedBy = "usuarioFavorito")
    private List<Producto> productoFavorito;

    @OneToMany(mappedBy = "usuario")
    private List<Comentario> listaComentarios;


}
