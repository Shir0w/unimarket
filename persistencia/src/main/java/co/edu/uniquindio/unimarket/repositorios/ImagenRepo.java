package co.edu.uniquindio.unimarket.repositorios;

import co.edu.uniquindio.unimarket.entidades.Imagen;
import co.edu.uniquindio.unimarket.entidades.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository

public interface ImagenRepo extends JpaRepository<Imagen,Integer> {

    Page<Imagen> findAll(Pageable paginador);

}
