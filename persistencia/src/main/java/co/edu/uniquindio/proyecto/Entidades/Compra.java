package co.edu.uniquindio.proyecto.Entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor

public class Compra implements Serializable {
@Id
@EqualsAndHashCode.Include

private String codigo;

private LocalDate fecha_cracion;

private int  valor_total;

private String medio_pago;

private String codigo_pago;



    public Compra(String codigo, LocalDate fecha_cracion, int valor_total, String medio_pago, String codigo_pago) {
        this.codigo = codigo;
        this.fecha_cracion = fecha_cracion;
        this.valor_total = valor_total;
        this.medio_pago = medio_pago;
        this.codigo_pago = codigo_pago;
    }
}
