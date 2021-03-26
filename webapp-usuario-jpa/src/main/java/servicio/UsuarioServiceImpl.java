package servicio;

import datos.UsuarioDao;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import  domain.Usuario;
import java.util.ArrayList;

@Stateless
public class UsuarioServiceImpl implements UsuarioServiceRemote, UsuarioService{

    @Inject
    private UsuarioDao usuarioDao;
    
    @Override
    public List<Usuario> listarUsuarios() {
        
       
      return usuarioDao.findAllUsuarios();
    }

    @Override
    public Usuario encontrarUsuarioPorId(Usuario usuario) {
        
        return usuarioDao.findUsuarioById(usuario);
    }

    @Override
    public void registrarUsuario(Usuario usuario) {
        usuarioDao.insertUsuario(usuario);
    }

    @Override
    public void modificarUsuario(Usuario usuario) {
        usuarioDao.updateUsuario(usuario);
    }

    @Override
    public void eliminarUsuario(Usuario usuario) {
       usuarioDao.deleteUsuario(usuario);
    }
    
}
