package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.unimarket.entidades.Usuario;
import co.edu.uniquindio.unimarket.repositorios.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {

    private final UsuarioRepo UsuarioRepo;

    public UsuarioServicioImpl(UsuarioRepo UsuarioRepo) {
        this.UsuarioRepo = UsuarioRepo;
    }

    @Override
    public Usuario registarUsuario(Usuario u) throws Exception {
        Optional<Usuario> buscando = UsuarioRepo.findById(u.getCodigo());

        if(buscando.isPresent()){
            throw new Exception("el codigo de este usuario ya existe");
        }

      buscando = UsuarioRepo.findByEmail(u.getEmail());

        if(buscando.isPresent()){
            throw new Exception("el email de este usuario ya existe");
        }

        buscando = UsuarioRepo.findByNombre(u.getNombre());

        if(buscando.isPresent()){
            throw new Exception("el nombre  ya existe");
        }
        return UsuarioRepo.save(u);


    }
    @Override
    public Usuario actualizarUsuario(Usuario u) throws Exception {


        return UsuarioRepo.save(u);
    }
    @Override
    public void eleminarUsuario(String codigo) throws Exception {
        Optional<Usuario> buscando = UsuarioRepo.findById(codigo);

        if(buscando.isEmpty()){
            throw new Exception("el codigo de este usuario no existe");
        }
         UsuarioRepo.deleteById(codigo);
    }

    @Override
    public Usuario obtenerUsuario(String codigo) throws Exception {
        Optional<Usuario> buscando = UsuarioRepo.findById(codigo);

        if(buscando.isEmpty()){
            throw new Exception("el usuario no existe");

        }
        return buscando.get();
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return null;
    }


}
