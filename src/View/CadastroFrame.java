
package View;

import Controller.CadastroController;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class CadastroFrame extends javax.swing.JFrame {

    public CadastroFrame() {
        initComponents();
        setTitle("Cadastro - Spotifei");
        setLocationRelativeTo(null); // Centralizar a janela
    }

    public JButton getBt_cadastro() {
        return bt_cadastro;
    }

    public void setBt_cadastro(JButton bt_cadastro) {
        this.bt_cadastro = bt_cadastro;
    }

    public JLabel getLb_senha_cadastro() {
        return lb_senha_cadastro;
    }

    public void setLb_senha_cadastro(JLabel lb_senha_cadastro) {
        this.lb_senha_cadastro = lb_senha_cadastro;
    }

    public JLabel getLb_usuario_cadastro() {
        return lb_usuario_cadastro;
    }

    public void setLb_usuario_cadastro(JLabel lb_usuario_cadastro) {
        this.lb_usuario_cadastro = lb_usuario_cadastro;
    }

    public JTextField getTxt_senha_cadastro() {
        return txt_senha_cadastro;
    }

    public void setTxt_senha_cadastro(JTextField txt_senha_cadastro) {
        this.txt_senha_cadastro = txt_senha_cadastro;
    }

    public JTextField getTxt_usuario_cadastro() {
        return txt_usuario_cadastro;
    }

    public void setTxt_usuario_cadastro(JTextField txt_usuario_cadastro) {
        this.txt_usuario_cadastro = txt_usuario_cadastro;
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb_usuario_cadastro = new javax.swing.JLabel();
        txt_usuario_cadastro = new javax.swing.JTextField();
        lb_senha_cadastro = new javax.swing.JLabel();
        txt_senha_cadastro = new javax.swing.JTextField();
        bt_cadastro = new javax.swing.JButton();
        bt_logar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Spotfei");

        lb_usuario_cadastro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_usuario_cadastro.setText("Usuário:");

        lb_senha_cadastro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_senha_cadastro.setText("Senha:");

        bt_cadastro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_cadastro.setText("CADASTRAR");
        bt_cadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cadastroActionPerformed(evt);
            }
        });

        bt_logar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_logar.setText("LOGAR");
        bt_logar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_logarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_usuario_cadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_senha_cadastro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_senha_cadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_usuario_cadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(bt_logar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_cadastro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(108, 108, 108))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_usuario_cadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_usuario_cadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_senha_cadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_senha_cadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(bt_cadastro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_logar)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_cadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cadastroActionPerformed
        CadastroController controller = new CadastroController(this);
        controller.cadastrarUsuario();
    }//GEN-LAST:event_bt_cadastroActionPerformed

    private void bt_logarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_logarActionPerformed
        View.LoginFrame login = new View.LoginFrame();
        login.setVisible(true);
        this.dispose(); // Isso fechara a tela atual
    }//GEN-LAST:event_bt_logarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_cadastro;
    private javax.swing.JButton bt_logar;
    private javax.swing.JLabel lb_senha_cadastro;
    private javax.swing.JLabel lb_usuario_cadastro;
    private javax.swing.JTextField txt_senha_cadastro;
    private javax.swing.JTextField txt_usuario_cadastro;
    // End of variables declaration//GEN-END:variables
}
