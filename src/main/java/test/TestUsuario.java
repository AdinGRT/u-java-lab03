package test;

import datos.UsuarioDAO;
import domain.Usuario;
import java.util.*;

/**
 *
 * @author adingrt
 */
public class TestUsuario {
    public static void main(String[] args) {
        var usuarioDao = new UsuarioDAO();
        
        //var usuarioNuevo = new Usuario("atrejo", "555bbb");
        //usuarioDao.insertar(usuarioNuevo);
        
        //var usuarioMod = new Usuario(3, "gtrejo", "123ABC");
        //usuarioDao.actualizar(usuarioMod);
        
        var usuarioEliminar = new Usuario(3);
        usuarioDao.eliminar(usuarioEliminar);
        
        List<Usuario> usuarios = usuarioDao.listar();
        usuarios.forEach(usuario -> {
            System.out.println("usuario = " + usuario);
        });
        
    }
}
