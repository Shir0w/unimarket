package co.edu.uniquindio.unimarket.test;


import co.edu.uniquindio.unimarket.entidades.Producto;
import co.edu.uniquindio.unimarket.entidades.Usuario;
import co.edu.uniquindio.unimarket.repositorios.ProductoRepo;
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
import java.util.stream.Collectors;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class ProductoTest {
    @Autowired
    private ProductoRepo productoRepo;

    @Test
    public void registrarTest(){

    }

    public void paginarListaTest(){

        Pageable paginador = PageRequest.of(0,3);
        Page<Producto> lista = productoRepo.findAll(paginador);

        System.out.println(lista.stream().collect(Collectors.toList()));
    }

    @Test
    @Sql("classpath:datos.sql")
    public void OrdenarListaTest(){


        List<Producto> lista = productoRepo.findAll(Sort.by("nombre"));

        System.out.println(lista);

    }


}
