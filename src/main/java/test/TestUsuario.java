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
        
        List<Usuario> usuarios = usuarioDao.listar();
        usuarios.forEach(usuario -> {
            System.out.println("usuario = " + usuario);
        });
        
    }
}
