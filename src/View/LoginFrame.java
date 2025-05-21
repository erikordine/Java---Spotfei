
package View;

import Controller.LoginController;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class LoginFrame extends javax.swing.JFrame {

    public LoginFrame() {
        initComponents();
        setTitle("Login - Spotifei");
        setLocationRelativeTo(null); // Centralizar a janela
    }

    public JButton getBt_cadastro() {
        return bt_cadastro;
    }

    public void setBt_cadastro(JButton bt_cadastro) {
        this.bt_cadastro = bt_cadastro;
    }

    public JButton getBt_login() {
        return bt_login;
    }

    public void setBt_login(JButton bt_login) {
        this.bt_login = bt_login;
    }

    public JLabel getLb_senha_login() {
        return lb_senha_login;
    }

    public void setLb_senha_login(JLabel lb_senha_login) {
        this.lb_senha_login = lb_senha_login;
    }

    public JLabel getLb_usuario_login() {
        return lb_usuario_login;
    }

    public void setLb_usuario_login(JLabel lb_usuario_login) {
        this.lb_usuario_login = lb_usuario_login;
    }

    public JTextField getTxt_senha_login() {
        return txt_senha_login;
    }

    public void setTxt_senha_login(JTextField txt_senha_login) {
        this.txt_senha_login = txt_senha_login;
    }

    public JTextField getTxt_usuario_login() {
        return txt_usuario_login;
    }

    public void setTxt_usuario_login(JTextField txt_usuario_login) {
        this.txt_usuario_login = txt_usuario_login;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb_usuario_login = new javax.swing.JLabel();
        txt_usuario_login = new javax.swing.JTextField();
        lb_senha_login = new javax.swing.JLabel();
        txt_senha_login = new javax.swing.JTextField();
        bt_login = new javax.swing.JButton();
        bt_cadastro = new javax.swing.JButton();

        setTitle("Spotfei");

        lb_usuario_login.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_usuario_login.setText("Usuário:");

        lb_senha_login.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_senha_login.setText("Senha:");

        bt_login.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_login.setText("LOGIN");
        bt_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_loginActionPerformed(evt);
            }
        });

        bt_cadastro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_cadastro.setText("CADASTRO");
        bt_cadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cadastroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb_usuario_login, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                    .addComponent(lb_senha_login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bt_login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_cadastro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_usuario_login, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                    .addComponent(txt_senha_login))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_usuario_login, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_usuario_login, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_senha_login, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_senha_login, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(bt_login)
                .addGap(18, 18, 18)
                .addComponent(bt_cadastro)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_loginActionPerformed
        LoginController controller = new LoginController(this);
        controller.loginUsuario();
    }//GEN-LAST:event_bt_loginActionPerformed

    private void bt_cadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cadastroActionPerformed
        View.CadastroFrame cadastro = new View.CadastroFrame();
        cadastro.setVisible(true);
        this.dispose(); // Isso fechara a tela atual
    }//GEN-LAST:event_bt_cadastroActionPerformed


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_cadastro;
    private javax.swing.JButton bt_login;
    private javax.swing.JLabel lb_senha_login;
    private javax.swing.JLabel lb_usuario_login;
    private javax.swing.JTextField txt_senha_login;
    private javax.swing.JTextField txt_usuario_login;
    // End of variables declaration//GEN-END:variables
}
