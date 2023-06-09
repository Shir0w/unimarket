package co.edu.uniquindio.unimarket.repositorios;


import co.edu.uniquindio.unimarket.entidades.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface ProductoRepo extends JpaRepository<Producto, Integer> {


    Optional<Producto> findByNombre (String nombre);

    Page<Producto> findAll(Pageable paginador);

    //@Query("select p.vendedor.nombre from Producto p where p.codigo = :id")
    //String obtenerNombreVendedor(Integer id);

}
