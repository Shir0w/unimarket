package co.edu.uniquindio.proyecto.Entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class Producto implements Serializable{
    @Id
    @EqualsAndHashCode.Include
    @Column (name = "codigo", unique = true, nullable = false)
    private String codigo;
    @Column(name = "nombre", unique = false, nullable = false)
    private String nombre;

    @Column(name= "unidades", unique = false, nullable = false)
    private int unidades;
    @Column (name = "descripcion", unique = false, nullable = true)
    private String descripcion;
    @Column (name = "precio", unique = false, nullable = false)
    private int precio ;
    @Column (name = "fechaLimite", unique = false, nullable = false)
    private LocalDate fecha_limite;

    @Column (name = "fechaCreado", unique = false, nullable = false)
    private LocalDateTime fecha_creado;

    private String codigo_vendedor;



    public Producto(String codigo, String descripcion, int precio, String comentario, String categoria) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.comentario = comentario;
        this.categoria = categoria;
    }

}
