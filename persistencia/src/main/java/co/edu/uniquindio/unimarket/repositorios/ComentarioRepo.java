package co.edu.uniquindio.unimarket.repositorios;

import co.edu.uniquindio.unimarket.entidades.Comentario;
import co.edu.uniquindio.unimarket.entidades.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComentarioRepo extends JpaRepository<Comentario, Integer> {
    @Query("select c from Comentario c where  c.calificacion between :calificacionMenor and :calificacionMayor")
    List<Comentario> listaComentariosRango(int calificacionMenor, int calificacionMayor);

    Page<Comentario> findAll(Pageable paginador);
}
