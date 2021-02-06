package test;

import datos.*;
import domain.UsuarioDTO;
import java.sql.*;
import java.util.List;

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
            
            UsuarioDAOInterface usuarioDao = new UsuarioDAOJDBC(conexion);
            
            List<UsuarioDTO> usuarios = usuarioDao.listar();
            usuarios.forEach(usuario -> {
                System.out.println("Usuario = " + usuario);
            });
            
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
