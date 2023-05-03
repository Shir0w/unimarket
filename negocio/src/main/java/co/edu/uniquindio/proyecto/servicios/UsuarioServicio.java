package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.unimarket.entidades.Producto;
import co.edu.uniquindio.unimarket.entidades.Usuario;

import java.util.List;

public interface UsuarioServicio {

    Usuario registarUsuario (Usuario u) throws Exception;
    Usuario actualizarUsuario (Usuario u) throws Exception;

    void eleminarUsuario (String codigo) throws Exception;

    Usuario obtenerUsuario (String codigo) throws  Exception;

    List<Usuario> listarUsuarios();

    List<Producto> listaFavoritos(Usuario u)throws  Exception ;

    Usuario iniciarSesion(String email, String password)throws  Exception;





}
