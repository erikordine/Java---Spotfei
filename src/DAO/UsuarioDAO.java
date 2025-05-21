
package DAO;

//Exception
import java.sql.SQLException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Model.UsuarioMODEL;

public class UsuarioDAO {
    private Connection connection;

    public UsuarioDAO(Connection connection) {
        this.connection = connection;
    }
    
    public UsuarioMODEL autenticarUsuario(String nome, String senha) throws SQLException {
        String sql = """
                     SELECT * FROM usuario WHERE nome = ? AND senha = ?
                     """;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                UsuarioMODEL usuario = new UsuarioMODEL(nome, senha);
                usuario.setId_usuario(rs.getInt("id_usuario"));
                usuario.setNome(rs.getString("nome"));
                usuario.setSenha(rs.getString("senha"));
                return usuario;
            } else {
                return null;
            }
        }
    }
    
    public boolean cadastrarUsuario(UsuarioMODEL usuario){
        String sql = """
                     INSERT INTO usuario (nome, senha) VALUES (?, ?)
                     """;
        
        try {
            Connection con = Conexao.getConnection();
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getSenha());
            
            stmt.executeUpdate();
            stmt.close();
            return true;
            
        } catch (Exception e) {
            System.out.print("Erro ao cadastrar: " + e.getMessage());
            return false;
        }
    }
}
