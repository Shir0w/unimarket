package co.edu.uniquindio.unimarket.test;

import co.edu.uniquindio.unimarket.entidades.Usuario;
import co.edu.uniquindio.unimarket.repositorios.UsuarioRepo;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    @Test
    @Sql("classpath:datos.sql")
    public void filtrarNombreTest() {
        List<Usuario> usuario = usuarioRepo.findAllByNombre("pepe");
        usuario.forEach(System.out::println);
    }
    @Test
    @Sql("classpath:datos.sql")
    public void filtrarEmailTest(){
        Optional<Usuario> usuario = usuarioRepo.findByEmail("JFKJSASF");
        if(usuario.isPresent()){
            System.out.println(usuario.get());
        }else{
            System.out.println("No existe ese email");
        }
   }
    @Test
    @Sql("classpath:datos.sql")
   public void paginarListaTest(){

        Pageable paginador = PageRequest.of(1,2);
       Page<Usuario> lista = usuarioRepo.findAll(paginador);

       System.out.println(lista.stream().collect(Collectors.toList()));
    }
    @Test
    @Sql("classpath:datos.sql")
    public void OrdenarListaTest(){


       List<Usuario> lista = usuarioRepo.findAll(Sort.by("nombre"));

        System.out.println(lista);
    }

}
