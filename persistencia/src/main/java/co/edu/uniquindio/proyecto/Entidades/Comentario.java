package co.edu.uniquindio.proyecto.Entidades;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor

public class Comentario implements Serializable {
@Id
@EqualsAndHashCode.Include


private  String codigo;

private String nombre;

private int unidades;

private  String descripcion;

private double precio;

private String activo;

private  String  fecha_creado;

private  String  fecha_limite;

private String codigo_vendedor;


    public Comentario(String codigo, String nombre, int unidades, String descripcion, double precio, String activo, String fecha_creado, String fecha_limite, String codigo_vendedor) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.unidades = unidades;
        this.descripcion = descripcion;
        this.precio = precio;
        this.activo = activo;
        this.fecha_creado = fecha_creado;
        this.fecha_limite = fecha_limite;
        this.codigo_vendedor = codigo_vendedor;
    }
}
