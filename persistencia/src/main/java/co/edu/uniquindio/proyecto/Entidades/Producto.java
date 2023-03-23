package co.edu.uniquindio.proyecto.Entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Map;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class Producto implements Serializable{
    @Id
    @EqualsAndHashCode.Include
    private String codigo;
    private String descripcion;
    private int precio ;
    private String fechaLimite;
    private String comentario;
    private String categoria;

    public Producto(String codigo, String descripcion, int precio, String comentario, String categoria) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.comentario = comentario;
        this.categoria = categoria;
    }
}
