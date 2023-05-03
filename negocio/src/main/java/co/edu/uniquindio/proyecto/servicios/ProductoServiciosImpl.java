package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.unimarket.entidades.Categoria;
import co.edu.uniquindio.unimarket.entidades.Compra;
import co.edu.uniquindio.unimarket.entidades.Producto;
import co.edu.uniquindio.unimarket.entidades.Usuario;
import co.edu.uniquindio.unimarket.repositorios.ProductoRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiciosImpl implements ProductoServicio {
    private final ProductoRepo productoRepo;

    public ProductoServiciosImpl(ProductoRepo productoRepo) {
        this.productoRepo = productoRepo;
    }

    @Override
    public Producto publicarProducto(Producto p) throws Exception {
        try {

            return productoRepo.save(p);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }


    }

    @Override
    public void actualizarProducto(Producto p) throws Exception {

    }

    @Override
    public void eliminarProducto(Integer codigo) throws Exception {

        Optional<Producto> producto = productoRepo.findById(codigo);

        if(producto.isEmpty()){
            throw new Exception("El codigo del producto no existe");
        }
        productoRepo.deleteById(codigo);
    }

    @Override
    public Producto obtenerProducto(Integer codigo) throws Exception {

        return productoRepo.findById(codigo).orElseThrow( () -> new Exception("el codigo el prodcuto no es valido"));
    }

    @Override
    public List<Producto> listarProdcutos(Categoria categoria) {
        return null;
    }

    @Override
    public void comentarProducto(String mensaje, Integer calificacion, Usuario usuario, Producto producto) throws Exception {

    }

    @Override
    public void guardarProductoEnFavorito(Producto producto, Usuario usuario) throws Exception {

    }

    @Override
    public void eliminarProductoEnFavorito(Producto producto, Usuario usuario) throws Exception {

    }

    @Override
    public void ComprarProducto(Compra compra) throws Exception {

    }

    @Override
    public List<Producto> buscarProductos(String nombreProducto, String[] filtro) {
        return null;
    }

    @Override
    public List<Producto> listarProductos(String codigoUsuario) throws Exception {
        return null;
    }
}
