package co.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.NegocioApplication;
import co.edu.uniquindio.proyecto.servicios.UsuarioServicio;
import co.edu.uniquindio.unimarket.entidades.Usuario;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

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

        public void eliminar (){

            try {
                usuarioServicio.eleminarUsuario("123");
                Assertions.assertTrue(true);
            } catch (Exception e) {
                e.printStackTrace();

                Assertions.assertTrue(false);
            }

        }
}
