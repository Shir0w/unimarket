package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.unimarket.entidades.Producto;
import co.edu.uniquindio.unimarket.entidades.Usuario;
import co.edu.uniquindio.unimarket.repositorios.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {

    private final UsuarioRepo usuarioRepo;

    public UsuarioServicioImpl(UsuarioRepo usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }

    @Override
    public Usuario registarUsuario(Usuario u) throws Exception {
        Optional<Usuario> buscando = usuarioRepo.findById(u.getCodigo());

        if(buscando.isPresent()){
            throw new Exception("el codigo de este usuario ya existe");
        }

      buscando = usuarioRepo.findByEmail(u.getEmail());

        if(buscando.isPresent()){
            throw new Exception("el email de este usuario ya existe");
        }

        buscando = usuarioRepo.findByNombre(u.getNombre());

        if(buscando.isPresent()){
            throw new Exception("el nombre  ya existe");
        }
        return usuarioRepo.save(u);


    }
    @Override
    public Usuario actualizarUsuario(Usuario u) throws Exception {
        Optional<Usuario> buscando = usuarioRepo.findById(u.getCodigo());
        if(buscando.isPresent()){
            throw new Exception("El usuario no existe");
        }

        return usuarioRepo.save(u);
    }
    @Override
    public void eleminarUsuario(String codigo) throws Exception {
        Optional<Usuario> buscando = usuarioRepo.findById(codigo);

        if(buscando.isEmpty()){
            throw new Exception("el codigo de este usuario no existe");
        }
         usuarioRepo.deleteById(codigo);
    }

    @Override
    public Usuario obtenerUsuario(String codigo) throws Exception {
        Optional<Usuario> buscando = usuarioRepo.findById(codigo);

        if(buscando.isEmpty()){
            throw new Exception("el usuario no existe");

        }
        return buscando.get();
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepo.findAll();
    }

    @Override
    public List<Producto> listaFavoritos(Usuario u) throws Exception {
        return null;
    }

    @Override
    public List<Producto> listaFavoritos(String email) throws Exception {

        Optional<Usuario> buscado ;
        if(buscado.isEmpty()){
            throw new Exception("El CORREO No existe");
        }
        return null;
       // return usuarioRepo.ObtenerProductoFavorito(email);
    }

    @Override
    public Usuario iniciarSesion(String email, String password) throws Exception {
        return usuarioRepo.findByEmailAndPassword(email, password).orElseThrow( () -> new Exception("Los datos de autenticacion son incorrectos") );

    }


}
