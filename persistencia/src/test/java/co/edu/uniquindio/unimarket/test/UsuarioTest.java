package co.edu.uniquindio.unimarket.test;

import co.edu.uniquindio.unimarket.entidades.Usuario;
import co.edu.uniquindio.unimarket.repositorios.UsuarioRepo;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class UsuarioTest {
    @Autowired
    private UsuarioRepo usuarioRepo;

    @Test
    @Sql("classpath:datos.sql")
    public void registrarTest() {
        Usuario usuarioBuscado = usuarioRepo.findById("123").orElse(null);
        Assertions.assertNotNull(usuarioBuscado);
    }

    @Test
    @Sql("classpath:datos.sql")
    public void eliminarTest() {
        usuarioRepo.deleteById("123");
        Usuario usuarioBuscado = usuarioRepo.findById("123").orElse(null);
        Assertions.assertNull(usuarioBuscado);
    }

    @Test
    @Sql("classpath:datos.sql")
    public void actualizarTest() {

        Usuario buscado = usuarioRepo.findById("123").orElse(null);
        buscado.setNombre("juan3");
        Assertions.assertEquals("juan3", buscado.getNombre());

    }

    @Test
    @Sql("classpath:datos.sql")
    public void listarTest() {
        List<Usuario> lista = usuarioRepo.findAll();
        System.out.println(lista);

    }


}
