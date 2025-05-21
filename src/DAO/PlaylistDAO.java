
package DAO;

import Model.ArtistaMODEL;
import Model.MusicaMODEL;
import Model.PlaylistMODEL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

public class PlaylistDAO {
    
    // Criar Playlist
    public boolean criarPlaylist(PlaylistMODEL playlist) {
        String sql = "INSERT INTO playlist (nome, id_usuario) VALUES (?, ?)";
        
        // Conecta com o banco
        try (Connection conn = Conexao.getConnection();
              PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            // Define os valores do ? na query, 1 e 2 - posição do ? na query (?,?)
            stmt.setString(1, playlist.getNome());
            stmt.setInt(2, playlist.getUsuario().getId_usuario());
            // Executa o INSERT
            stmt.executeUpdate();
            // Se tudo der certo, retorna true
            return true;
            
        } catch (SQLException e) {
            System.out.println("Erro ao criar playlist: " + e.getMessage());
            return false;
        }
    }
    
    // Busca as Playlist que o Usuario tem
    public List<PlaylistMODEL> buscarPlaylistsPorUsuario(int idUsuario) {
        // Lista de cada item do tipo Playlist
        List<PlaylistMODEL> lista = new ArrayList<>();
        
        // Busca as colunas id_playlist e nome da tabela playlist mas quero so do usuario com esse ID 
        String sql = "SELECT id_playlist, nome FROM playlist WHERE id_usuario = ?";
        
        try (Connection conn = Conexao.getConnection();
              PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, idUsuario);
            // Mostra todas as playlists do usuario
            ResultSet rs = stmt.executeQuery();
            
            // rs.next() le linha por linha dessa tabela
            while (rs.next()) {
                PlaylistMODEL playlist = new PlaylistMODEL(); // <- Cria um novo objeto para a linha atual;
                playlist.setId_playlist(rs.getInt("id_playlist"));  // pega o id da linha
                playlist.setNome(rs.getString("nome")); // pega o nome da linha
                
                lista.add(playlist); // adiciona esse obejto na lista final
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar playlists: " + e.getMessage());
        }
        
        return lista;
    }
    
    // Musicas que estão dentro da Playlist
    public List<MusicaMODEL> buscarMusicasDaPlaylist(int idPlaylist) {
        List<MusicaMODEL> lista = new ArrayList<>();
        
        String sql = """
                     SELECT M.id_musica, M.nome, M.genero, A.id_artista, A.nome AS nome_artista
                     FROM playlist_musica PM
                     JOIN musica M ON PM.id_musica = M.id_musica
                     JOIN artista A ON M.id_artista = A.id_artista
                     WHERE PM.id_playlist = ?
                     ORDER BY M.nome
                     """;
        
        try (Connection conn = Conexao.getConnection();
              PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, idPlaylist);
            // Mostra todas as playlists do usuario
            ResultSet rs = stmt.executeQuery();
            
            // rs.next() le linha por linha dessa tabela
            while (rs.next()) {
                ArtistaMODEL artista = new ArtistaMODEL(); // <- Cria um novo objeto para a linha atual;
                artista.setId_artista(rs.getInt("id_artista")); // pega o id da linha
                artista.setNome(rs.getString("nome_artista")); // pega o nome da linha
                
                MusicaMODEL musica = new MusicaMODEL();
                musica.setId_musica(rs.getInt("id_musica"));
                musica.setNome(rs.getString("nome"));
                musica.setGenero(rs.getString("genero"));
                musica.setArtista(artista);
                
                lista.add(musica);
            }
            
        } catch (Exception e) {
            System.out.println("Erro ao buscar músicas da playlist: " + e.getMessage());
        }
        
        return lista;
    }
    
    // Coloca todas as musicas que tem, dentro da tabela de AdicionarMusicas
    public List<MusicaMODEL> buscarMusicasForaDaPlaylist (int idPlaylist) {
        List<MusicaMODEL> lista = new ArrayList<>();
        
        String sql = """
                     SELECT M.id_musica, M.nome, M.genero, A.id_artista, A.nome AS nome_artista
                     FROM musica M
                     JOIN artista A ON M.id_artista = A.id_artista
                     WHERE NOT EXISTS (
                        SELECT 1 FROM playlist_musica PM
                        WHERE PM.id_musica = M.id_musica AND PM.id_playlist = ?
                     )
                     ORDER BY M.nome
                     """;
        
        try (Connection conn = Conexao.getConnection();
              PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, idPlaylist);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                ArtistaMODEL artista = new ArtistaMODEL();
                artista.setId_artista(rs.getInt("id_artista"));
                artista.setNome(rs.getString("nome_artista"));
                
                MusicaMODEL musica = new MusicaMODEL();
                musica.setId_musica(rs.getInt("id_musica"));
                musica.setNome(rs.getString("nome"));
                musica.setGenero(rs.getString("genero"));
                musica.setArtista(artista);
                
                lista.add(musica);
            }
            
        } catch (SQLException e) {
            System.out.println("Erro ao buscar músicas fora da playlist: " + e.getMessage());
        }
        
        return lista;
    }
    
    public boolean adicionarMusicaNaPlaylist(int idPlaylist, int idMusica) {
        String sql = """
                     INSERT INTO playlist_musica (id_playlist, id_musica) VALUES (?,?);
                     """;
        
        try (Connection conn = Conexao.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)){
            
            stmt.setInt(1, idPlaylist);
            stmt.setInt(2, idMusica);
            stmt.executeUpdate();
            return true;
            
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar música na playlist: " + e.getMessage());
            return false;
        }
    }
    
    public boolean deletarMusicaPlaylist(int idPlaylist) {
        String sql = "DELETE FROM playlist WHERE id_playlist = ?";
        
        try (Connection conn = Conexao.getConnection();
              PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, idPlaylist);
            stmt.executeUpdate();
            return true;
           
        } catch (SQLException e) {
            System.out.println("Erro ao deletar playlist: " + e.getMessage());
            return false;
        }
    }
    
    public boolean removerMusicaDaPlaylist(int idPlaylist, int idMusica) {
        String sql = "DELETE FROM playlist_musica WHERE id_playlist = ? AND id_musica = ?";
        
        try (Connection conn = Conexao.getConnection();
              PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, idPlaylist);
            stmt.setInt(2, idMusica);
            stmt.executeUpdate();
            return true;
           
        } catch (SQLException e) {
            System.out.println("Erro ao remover música da playlist: " + e.getMessage());
            return false;
        }
    }
}
