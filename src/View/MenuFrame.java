
package View;

import javax.swing.JOptionPane;
import javax.swing.text.View;


public class MenuFrame extends javax.swing.JFrame {

    public MenuFrame() {
        initComponents();
        setTitle("Menu - Spotifei");
        setLocationRelativeTo(null); // Centralizar a janela
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bt_buscar = new javax.swing.JButton();
        bt_curtidas = new javax.swing.JButton();
        bt_playlists = new javax.swing.JButton();
        bt_historico = new javax.swing.JButton();
        bt_sair = new javax.swing.JButton();
        bt_musicaDescutidas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bt_buscar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_buscar.setText("Buscar músicas");
        bt_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_buscarActionPerformed(evt);
            }
        });

        bt_curtidas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_curtidas.setText("Minhas curtidas");
        bt_curtidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_curtidasActionPerformed(evt);
            }
        });

        bt_playlists.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_playlists.setText("Playlist");
        bt_playlists.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_playlistsActionPerformed(evt);
            }
        });

        bt_historico.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_historico.setText("Histórico");
        bt_historico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_historicoActionPerformed(evt);
            }
        });

        bt_sair.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_sair.setText("Sair");
        bt_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sairActionPerformed(evt);
            }
        });

        bt_musicaDescutidas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_musicaDescutidas.setText("Musicas Descurtidas");
        bt_musicaDescutidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_musicaDescutidasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bt_musicaDescutidas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_playlists, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_historico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_sair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_curtidas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_buscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(bt_buscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bt_curtidas)
                .addGap(12, 12, 12)
                .addComponent(bt_musicaDescutidas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bt_playlists)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bt_historico)
                .addGap(12, 12, 12)
                .addComponent(bt_sair)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_buscarActionPerformed
        var buscar = new BuscarMusicaFrame();
        buscar.setVisible(true);
        this.dispose(); // Isso fechara a tela atual
    }//GEN-LAST:event_bt_buscarActionPerformed

    private void bt_curtidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_curtidasActionPerformed
        var musicasCurtidas = new MusicasCurtidasFrame();
        musicasCurtidas.setVisible(true);
        this.dispose(); // Isso fechara a tela atual
    }//GEN-LAST:event_bt_curtidasActionPerformed

    private void bt_playlistsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_playlistsActionPerformed
        var playlist = new PlaylistFrame();
        playlist.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bt_playlistsActionPerformed

    private void bt_historicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_historicoActionPerformed

    }//GEN-LAST:event_bt_historicoActionPerformed

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        var loginFrame = new LoginFrame();
        loginFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void bt_musicaDescutidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_musicaDescutidasActionPerformed
        var musicasDescurtidasFrame = new MusicasDescurtidasFrame();
        musicasDescurtidasFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bt_musicaDescutidasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_buscar;
    private javax.swing.JButton bt_curtidas;
    private javax.swing.JButton bt_historico;
    private javax.swing.JButton bt_musicaDescutidas;
    private javax.swing.JButton bt_playlists;
    private javax.swing.JButton bt_sair;
    // End of variables declaration//GEN-END:variables
}
