
package Controller;

import DAO.Conexao;
import DAO.UsuarioDAO;
import Model.UsuarioMODEL;
import View.CadastroFrame;
import java.sql.Connection;
import javax.swing.JOptionPane;

public class CadastroController {
    private CadastroFrame view;

    public CadastroController(CadastroFrame view) {
        this.view = view;
    }
    
    public void cadastrarUsuario() {
        String nome = view.getTxt_usuario_cadastro().getText();
        String senha = view.getTxt_senha_cadastro().getText();
        
        UsuarioMODEL usuario = new UsuarioMODEL(nome, senha);
        
        try {
            Connection conn = new Conexao().getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            
            boolean sucesso = dao.cadastrarUsuario(usuario);
            
            if (sucesso) {
                JOptionPane.showMessageDialog(view, "Usuário cadastrado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(view, "Erro ao cadastrar usuário.");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Erro de conexão com o banco: " + e.getMessage());
        }
    }
}
