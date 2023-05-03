package co.edu.uniquindio.unimarket.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)



public class Usuario extends Persona implements Serializable {

    @Column(nullable = false, length = 150, unique = false)
    private String direccion;

    @Column(nullable = false, unique = false)
    private Integer telefono;

    @OneToMany(mappedBy = "usuario")
    @ToString.Exclude
    private List<Producto> listaProductos;

    @OneToMany(mappedBy = "usuario")
    @ToString.Exclude
    private List<Compra> listaCompras;

    @ManyToMany(mappedBy = "usuarioFavorito")
    private List<Producto> productoFavorito;

    @OneToMany(mappedBy = "usuario")
    @ToString.Exclude
    private List<Comentario> listaComentarios;

    public Usuario(String codigo, String nombre, String email, String password, String direccion, Integer telefono) {
        super(codigo, nombre, email, password);
        this.direccion = direccion;
        this.telefono = telefono;
    }


}
