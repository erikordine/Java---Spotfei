package DAO;

import Model.ArtistaMODEL;
import Model.MusicaMODEL;
import Model.MusicasCurtidasMODEL;
import Model.UsuarioLogadoMODEL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CurtidaDAO {

    // Função de Curtir Musica
    public boolean curtirMusica(int id_usuario, int id_musica) {
        String verificaSql = """
                             SELECT 1 FROM curtida WHERE id_usuario = ? AND id_musica = ?
                             """;

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(verificaSql)) {

            stmt.setInt(1, id_usuario);
            stmt.setInt(2, id_musica);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return false; // já curtiu
            }

            String insertSql = """
                               INSERT INTO curtida (id_usuario, id_musica) VALUES (?, ?)
                               """;
            try (PreparedStatement inserir = conn.prepareStatement(insertSql)) {
                inserir.setInt(1, id_usuario);
                inserir.setInt(2, id_musica);
                inserir.executeUpdate();
                return true;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao curtir música: " + e.getMessage());
            return false;
        }
    }
    
    // Lista os IDs das músicas curtidas pelo usuario
    public List<MusicasCurtidasMODEL> getMusicasCurtidasCompletas() {
        List<MusicasCurtidasMODEL> curtidas = new ArrayList<>();
        int id_usuario = UsuarioLogadoMODEL.getId_usuario();
        String sql = """
                     SELECT id_curtida, id_musica FROM curtida WHERE id_usuario = ?
                     """;
        
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id_usuario);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                MusicasCurtidasMODEL mc = new MusicasCurtidasMODEL(
                    rs.getInt("id_curtida"),
                    id_usuario,
                    rs.getInt("id_musica")
                );
                curtidas.add(mc);
            }
            
        } catch (SQLException e) {
            System.out.println("Erro ao buscar músicas curtidas: " + e.getMessage());
        }
        
        return curtidas;
    }
    
    // Remover Curtida
    public boolean removerCurtida(int id_musica) {
        int id_usuario = UsuarioLogadoMODEL.getId_usuario();
        String sql = """
                     DELETE FROM curtida WHERE id_usuario = ? AND id_musica = ?
                     """;
        
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id_usuario);
            stmt.setInt(2, id_musica);
            
            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
            
        } catch (SQLException e) {
            System.out.println("Erro ao remover curtida: " + e.getMessage());
            return false;
        }
    }
    
    public List<MusicaMODEL> buscarMusicasDescurtidas(int idUsuario) throws SQLException {
        List<MusicaMODEL> musicas = new ArrayList<>();
        
        String sql = """
                        SELECT M.id_musica, M.nome, M.genero, A.id_artista, A.nome AS nome_artista
                        FROM musica M JOIN artista A
                        ON M.id_artista = A.id_artista
                        WHERE NOT EXISTS (
                            SELECT 1 FROM curtida C
                            WHERE C.id_usuario = ? AND C.id_musica = M.id_musica
                        )
                        ORDER BY M.nome
                     """;
        
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, idUsuario);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                ArtistaMODEL artista = new ArtistaMODEL(
                        rs.getInt("id_artista"),
                        rs.getString("nome_artista")
                );
                
                MusicaMODEL musica = new MusicaMODEL(
                        rs.getInt("id_musica"),
                        rs.getString("nome"),
                        artista,
                        rs.getString("genero")
                );
                
                musicas.add(musica);
            }
            
        } catch (SQLException e) {
            System.out.print("Erro ao buscar músicas não curtidas: " + e.getMessage());
        }
        
        return musicas;
    }
}
