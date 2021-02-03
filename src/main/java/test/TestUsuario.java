package test;

import datos.*;
import domain.Usuario;
import java.sql.*;

/**
 *
 * @author adingrt
 */
public class TestUsuario {
    public static void main(String[] args) {
        Connection conexion = null;
        
        try {
            conexion = Conexion.getConnection();
            conexion.setAutoCommit(false);
            
            var usuarioDao = new UsuarioDAO(conexion);
            
            var usuarioModificar = new Usuario(1, "gtrejo", "abc123");
            usuarioDao.actualizar(usuarioModificar);
            
            var usuarioNuevo = new Usuario("arubioaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "333bbb");
            usuarioDao.insertar(usuarioNuevo);
            
            conexion.commit();
            System.out.println("Se realizo commit");
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            
            try {
                conexion.rollback();
                System.out.println("Se realizo rollback");
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        } finally {
            try {
                Conexion.close(conexion);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        
        
    }
}
