package co.edu.uniquindio.unimarket.repositorios;

import co.edu.uniquindio.unimarket.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario, String> {
}
