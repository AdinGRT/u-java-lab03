package datos;

import domain.Usuario;
import java.sql.*;
import java.util.*;

/**
 *
 * @author adingrt
 */
public class UsuarioDAO {
    private static final String SQL_SELECT = "SELECT id_usuario, usuario, password FROM usuario";
    private static final String SQL_INSERT = "INSERT INTO usuario (usuario, password) VALUES (?, ?)";
    private static final String SQL_UPDATE = "UPDATE usuario SET usuario = ?, password = ? WHERE id_usuario = ?";
    private static final String SQL_DELETE = "DELETE FROM usuario WHERE id_usuario = ?";
    
    public List<Usuario> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usuario = null;
        List<Usuario> usuarios = new ArrayList<>();
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_usuario = rs.getInt("id_usuario");
                String username = rs.getString("usuario");
                String password = rs.getString("password");
                usuario = new Usuario(id_usuario, username, password);
                usuarios.add(usuario);
            }   
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(conn);
                Conexion.close(stmt);
                Conexion.close(rs);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        
        return usuarios;
    }
    
    public int insertar(Usuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, usuario.getUsuario());
            stmt.setString(2, usuario.getPassword());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(conn);
                Conexion.close(stmt);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        
        return registros;
    }
    
}
