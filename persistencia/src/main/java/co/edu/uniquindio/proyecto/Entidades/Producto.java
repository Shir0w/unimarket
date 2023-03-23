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
    @Column (name = "descripcion", unique = false, nullable = true)
    private String descripcion;
    @Column (name = "precio", unique = false, nullable = false)
    private int precio ;
    @Column (name = "fechaLimite", unique = false, nullable = false)
    private LocalDate fechaLimite;

    @Column (name = "fechaInicio", unique = false, nullable = false)
    private LocalDateTime fechaInicio;

    @Column (name = "comentario", unique = false, nullable = false)
    private String comentario;

    @Column (name = "categoria", unique = false, nullable = false)
    private String categoria;

    @OneToMany(mappedBy = "producto")
    private List<Persona> personas;

    public Producto(String codigo, String descripcion, int precio, String comentario, String categoria) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.comentario = comentario;
        this.categoria = categoria;
    }
}
