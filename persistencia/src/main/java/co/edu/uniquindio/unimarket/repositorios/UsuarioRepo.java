package co.edu.uniquindio.unimarket.repositorios;

import co.edu.uniquindio.unimarket.entidades.Producto;
import co.edu.uniquindio.unimarket.entidades.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario, String> {
    List<Usuario>findAllByNombreContains(String nombre);
    Optional<Usuario>  findByNombre (String nombre);

    @Query ("select  u from  Usuario u where u.codigo = ?1")

    Usuario obtenerUsuario(String codigo);

   Optional<Usuario> findByEmail(String email);

   Optional<Usuario> findByEmailAndPassword(String email, String clave);

        Page<Usuario> findAll(Pageable paginador);
        Optional<Usuario> findByUsarname(String username);
        @Query("select p from Usuario u, IN (U.productoFavorito) p where  u.email = :email")
        List<Producto>obtenerProductosFavoritos(String email);

       //  @Query("select new co.edu.uniquindio.proyecto.dto.UsuarioYProducto(u.email, u.nombre, p) from Usuario  u left join u.productosVenta p")
       //  List<UsuarioYProducto>listarUsuarioYProcuto();


}
