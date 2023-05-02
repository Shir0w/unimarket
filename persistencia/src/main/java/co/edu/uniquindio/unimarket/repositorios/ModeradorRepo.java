package co.edu.uniquindio.unimarket.repositorios;

import co.edu.uniquindio.unimarket.entidades.Moderador;
import co.edu.uniquindio.unimarket.entidades.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface ModeradorRepo extends JpaRepository<Moderador, String> {

    List<Moderador> findAllByNombre(String nombre);



    Page<Moderador> findAll(Pageable paginador);
}
