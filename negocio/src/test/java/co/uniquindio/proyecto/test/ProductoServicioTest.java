package co.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.NegocioApplication;
import co.edu.uniquindio.proyecto.servicios.ProductoServicio;
import co.edu.uniquindio.proyecto.servicios.UsuarioServicio;
import co.edu.uniquindio.unimarket.entidades.Producto;
import co.edu.uniquindio.unimarket.entidades.Usuario;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest(classes = NegocioApplication.class)
@Transactional
public class ProductoServicioTest {

    @Autowired
    private ProductoServicio produtoServicio;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Test
    public void obtenerProductoTest() {
        try {
            Usuario vendedor = usuarioServicio.obtenerUsuario("123");
            LocalDateTime ldt = LocalDateTime.of(2021, 11, 25, 20, 10);
            LocalDate ldp = LocalDate.of(2022, 03, 25);
            Producto producto = new Producto("Televisor Lg55", 5, "maravillsos televisor", 200000F, true, ldt, ldp, vendedor);
            Producto publicado = produtoServicio.publicarProducto(producto);
            Assertions.assertNotNull(publicado);
        } catch (Exception e) {
            Assertions.assertTrue(false,e.getMessage());
        }
    }
}
