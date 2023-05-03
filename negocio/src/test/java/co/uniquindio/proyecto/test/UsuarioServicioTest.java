package co.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.NegocioApplication;
import co.edu.uniquindio.proyecto.servicios.UsuarioServicio;
import co.edu.uniquindio.unimarket.entidades.Usuario;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest (classes = NegocioApplication.class)
@Transactional

public class UsuarioServicioTest {

    @Autowired
        private UsuarioServicio usuarioServicio;



@Test

        private void registarTest(){

            Usuario u = new Usuario("123","edison","edisonpenelargo@gmail.com","feliz123","car19");

            try {
                Usuario respuesta = usuarioServicio.registarUsuario(u);
                Assertions.assertNotNull(respuesta);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }


        }
@Test
        public void eliminarTest (){

            try {
                usuarioServicio.eleminarUsuario("124");
                Assertions.assertTrue(true);
            } catch (Exception e) {
                e.printStackTrace();

                Assertions.assertTrue(false);
            }

        }
        @Test
       public void  listarTest () throws Exception {
        Usuario u = new Usuario("123","edison","edisonpenelargo@gmail.com","feliz123","car19");

        List<Usuario> lista =usuarioServicio.listarUsuarios();
        lista.forEach (System.out::println);

       }

       @Test
    public void actualizarTest(){
    try {
        Usuario u = usuarioServicio.obtenerUsuario("123");
        u.setPassword("&(/_2732");
        usuarioServicio.actualizarUsuario(u);

        Usuario modificado = usuarioServicio.obtenerUsuario("123");
        Assertions.assertEquals("&(/_2732", modificado.getPassword());
    }catch (Exception e){
        e.printStackTrace();
    }
       }

        @Test

    public void loginTest() {
            try {
                Usuario usuario = usuarioServicio.iniciarSesion("edisonpenelargo@gmail.com", "feliz123");
            } catch (Exception e){
        Assertions.assertTrue(false, e.getMessage());
    }
        }

}
