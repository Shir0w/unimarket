package co.edu.uniquindio.unimarket.test;

import co.edu.uniquindio.unimarket.entidades.Comentario;
import co.edu.uniquindio.unimarket.entidades.Imagen;
import co.edu.uniquindio.unimarket.entidades.Usuario;
import co.edu.uniquindio.unimarket.repositorios.ComentarioRepo;
import co.edu.uniquindio.unimarket.repositorios.ImagenRepo;
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
import java.util.stream.Collectors;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ImagenTest {

    @Autowired
    private ImagenRepo imagenRepo;

    @Test
    @Sql("classpath:datos.sql")
    public void paginarListaTest(){

        Pageable paginador = PageRequest.of(0,3);
        Page<Imagen> lista = imagenRepo.findAll(paginador);

        System.out.println(lista.stream().collect(Collectors.toList()));
    }

}
