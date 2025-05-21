
package DAO;

import Model.ArtistaMODEL;
import Model.MusicaMODEL;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MusicaDAO {
    
    public MusicaDAO() {}
    
    
    public List<MusicaMODEL> buscarMusicas(String tipo, String termo) {
        List<MusicaMODEL> musicas = new ArrayList<>();
        
        String sql = """
                        SELECT M.id_musica, M.nome AS nome_musica, M.genero,
                        A.id_artista, A.nome AS nome_artista
                        FROM musica M JOIN artista A ON M.id_artista = A.id_artista
                        WHERE 
                     """;
        
        switch (tipo.toLowerCase()) {
            case "nome":
                sql += "LOWER(M.nome) LIKE ?";
                break;
            case "artista":
                sql += "LOWER(A.nome) LIKE ?";
                break;
            case "gênero":
            case "genero":
                sql += "LOWER(M.genero) LIKE ?";
                break;
            default:
                sql += "1=0";
        }
        
        
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, "%" + termo.toLowerCase() + "%");
        
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    ArtistaMODEL artista = new ArtistaMODEL(
                        rs.getInt("id_artista"),
                        rs.getString("nome_artista")
                    );

                    MusicaMODEL musica = new MusicaMODEL(
                        rs.getInt("id_musica"),
                        rs.getString("nome_musica"),
                        artista,
                        rs.getString("genero")
                    );

                    musicas.add(musica);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar músicas: " + e.getMessage());
            // Adicione tratamento de erro mais robusto se necessário
        }

        return musicas;
    }
    
    // Buscar por ID
     public MusicaMODEL buscarPorId(int idMusica) {
        String sql = """
                     SELECT M.nome, M.genero, A.id_artista, A.nome as nome_artista
                     FROM musica M
                     JOIN artista A ON M.id_artista = A.id_artista
                     WHERE M.id_musica = ?
                     """;
        
        // Usa try-with-resources para garantir que a conexão será fechada
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, idMusica);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                ArtistaMODEL artista = new ArtistaMODEL(
                    rs.getInt("id_artista"),
                    rs.getString("nome_artista")
                );
                
                return new MusicaMODEL(
                    idMusica,
                    rs.getString("nome"),
                    artista,
                    rs.getString("genero")
                );
            }
        } catch (SQLException e) {
            Logger.getLogger(MusicaDAO.class.getName()).log(Level.SEVERE, "Erro ao buscar música por ID", e);
            JOptionPane.showMessageDialog(null, 
                "Erro ao buscar música: " + e.getMessage(),
                "Erro no Banco de Dados",
                JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
}
