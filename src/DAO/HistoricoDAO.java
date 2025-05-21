
package DAO;

import Model.HistoricoMODEL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HistoricoDAO {
    
    public boolean registrarBusca(HistoricoMODEL h) {
        // Vai inserir na tabela historico_busca
        String sqlINSERT = "INSERT INTO historico_busca (id_usuario, termo, tipo) VALUES (?, ?, ?)";
        String sqlCOUNT = "SELECT COUNT(*) FROM historico_busca WHERE id_usuario = ?";
        String sqlDELETE = "DELETE FROM historico_busca WHERE id_usuario = ?";
        
        // Conexao com o Banco
        try (Connection conn = Conexao.getConnection()) {
            
            //1. Verificar quantos registros o usuário tem
            try (PreparedStatement countStmt = conn.prepareStatement(sqlCOUNT)) {
                countStmt.setInt(1, h.getId_usuario());
                ResultSet rs = countStmt.executeQuery();
                
                if (rs.next() && rs.getInt(1) >= 10) {
                    // 2. Se tiver 5 ou mais, apagar todos
                    try (PreparedStatement deleteStmt = conn.prepareStatement(sqlDELETE)) {
                        deleteStmt.setInt(1, h.getId_usuario());
                        deleteStmt.executeUpdate();
                    }
                }
            }
            
            // 3. Inserir o novo registro
            try (PreparedStatement insertStmt = conn.prepareStatement(sqlINSERT)) {
                insertStmt.setInt(1, h.getId_usuario());
                insertStmt.setString(2, h.getTermo());
                insertStmt.setString(3, h.getTipo());
                insertStmt.executeUpdate();
            }
            
            return true;
            
        } catch (SQLException e) {
            System.out.println("Erro ao registrar busca: " + e.getMessage());
            return false;
        }
    }
    
    public List<HistoricoMODEL> buscarHistoricoPorUsuario(int idUsuario) {
        List<HistoricoMODEL> lista = new ArrayList<>();
        String sql = """
                     SELECT * FROM historico_busca WHERE id_usuario = ?
                     """;
        
        try (Connection conn = Conexao.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, idUsuario);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                HistoricoMODEL h = new HistoricoMODEL();
                h.setId_usuario(rs.getInt("id_usuario"));
                h.setTermo(rs.getString("termo"));
                h.setTipo(rs.getString("tipo"));
                lista.add(h);
            }
            
        } catch (SQLException e) {
            System.out.println("Erro ao buscar hístorico: " + e.getMessage());
        }
        
        return lista;
    }
}
