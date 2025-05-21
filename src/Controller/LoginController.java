
package Controller;

import DAO.Conexao;
import DAO.UsuarioDAO;
import Model.UsuarioMODEL;
import Model.UsuarioLogadoMODEL;
import View.LoginFrame;
import java.sql.Connection;
import javax.swing.JOptionPane;


public class LoginController {
    private LoginFrame view;

    public LoginController(LoginFrame view) {
        this.view = view;
    }
    
    public void loginUsuario() {
        String nome = view.getTxt_usuario_login().getText();
        String senha = view.getTxt_senha_login().getText();
        UsuarioMODEL usuario = new UsuarioMODEL(nome, senha);

        try {
            Connection conn = new Conexao().getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);

            UsuarioMODEL usuarioAutenticado = dao.autenticarUsuario(usuario.getNome(), usuario.getSenha());

            if (usuarioAutenticado != null) {
                UsuarioLogadoMODEL.setId_usuario(usuarioAutenticado.getId_usuario());
                System.out.println("Id: " + usuarioAutenticado.getId_usuario());

                JOptionPane.showMessageDialog(view, "Login realizado com sucesso!");
                new View.MenuFrame().setVisible(true);
                view.dispose();
            } else {
                JOptionPane.showMessageDialog(view, "Usuário ou senha inválidos.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Erro ao conectar com o banco.");
            e.printStackTrace(); // ajuda no debug
        }
    }
}
