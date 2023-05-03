package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.unimarket.entidades.Categoria;
import co.edu.uniquindio.unimarket.entidades.Compra;
import co.edu.uniquindio.unimarket.entidades.Producto;
import co.edu.uniquindio.unimarket.entidades.Usuario;

import java.util.List;

public interface ProductoServicio {

    Producto publicarProducto (Producto p) throws Exception;
    void actualizarProducto (Producto p )throws Exception;
    void eliminarProducto (Integer codigo)throws Exception;
    Producto obtenerProducto (Integer codigo)throws Exception;

    List<Producto> listarProdcutos (Categoria categoria);

    void comentarProducto (String mensaje, Integer calificacion, Usuario usuario, Producto producto ) throws Exception;

    void guardarProductoEnFavorito(Producto producto, Usuario usuario )throws Exception ;
    void eliminarProductoEnFavorito(Producto producto, Usuario usuario )throws Exception ;

    void ComprarProducto(Compra compra)throws Exception ;

    List<Producto> buscarProductos(String nombreProducto, String[] filtro);
    List<Producto> listarProductos(String codigoUsuario) throws  Exception;
}
