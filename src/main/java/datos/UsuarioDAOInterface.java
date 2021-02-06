package datos;

import domain.UsuarioDTO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author adingrt
 */
public interface UsuarioDAOInterface {
    public List<UsuarioDTO> listar() throws SQLException;
    public int insertar(UsuarioDTO usuario) throws SQLException;
    public int actualizar(UsuarioDTO usuario) throws SQLException;
    public int eliminar(UsuarioDTO usuario) throws SQLException;
}
