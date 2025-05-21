
package Controller;

import DAO.Conexao;
import DAO.MusicaDAO;
import Model.MusicaMODEL;
import java.sql.Connection;
import java.util.List;

public class MusicaController {
    
    public List<MusicaMODEL> buscarMusicas(String tipo, String termo) {
        List<MusicaMODEL> resultado = null;
        
        try {
            Connection conn = Conexao.getConnection();
            MusicaDAO dao = new MusicaDAO();
            resultado = dao.buscarMusicas(tipo, termo);
        } catch (Exception e) {
            System.out.println("Erro ao controller: " + e.getMessage());
        }
        
        return resultado;
    }
}
