
package View;

import DAO.PlaylistDAO;
import Model.MusicaMODEL;
import Model.PlaylistMODEL;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MusicasDaPlaylistFrame extends javax.swing.JFrame {

    private final PlaylistMODEL playlist;
    private DefaultTableModel tableModel;
    
    public MusicasDaPlaylistFrame(PlaylistMODEL playlist) {
        this.playlist = playlist;
        initComponents();
        setTitle("Músicas da Playlist - Spotifei");
        setLocationRelativeTo(null);

        lb_nomePlaylist.setText("Playlist: " + playlist.getNome());
        configurarTabela();
        carregarMusicas();
    }

    
    private void configurarTabela() {
        tableModel = new DefaultTableModel(new Object[]{"Música", "Artista", "Gênero"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tb_musicas.setModel(tableModel);
    }
    
    private void carregarMusicas() {
        try {
            List<MusicaMODEL> musicas = new PlaylistDAO().buscarMusicasDaPlaylist(playlist.getId_playlist());
            tableModel.setRowCount(0);
            
            for (MusicaMODEL m : musicas) {
                tableModel.addRow(new Object[]{
                    m.getNome(),
                    m.getArtista().getNome(),
                    m.getGenero()
                });
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar músicas: " + e.getMessage());
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb_nomePlaylist = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_musicas = new javax.swing.JTable();
        bt_voltar = new javax.swing.JButton();
        bt_adicionarMusica = new javax.swing.JButton();
        bt_removerMusica = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lb_nomePlaylist.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_nomePlaylist.setText("Nome da Playlist:");

        tb_musicas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tb_musicas);

        bt_voltar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_voltar.setText("Voltar");
        bt_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_voltarActionPerformed(evt);
            }
        });

        bt_adicionarMusica.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_adicionarMusica.setText("Adicionar Musica");
        bt_adicionarMusica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_adicionarMusicaActionPerformed(evt);
            }
        });

        bt_removerMusica.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_removerMusica.setText("Remover Musica");
        bt_removerMusica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_removerMusicaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lb_nomePlaylist))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bt_adicionarMusica)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bt_removerMusica)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bt_voltar))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_nomePlaylist)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_voltar)
                    .addComponent(bt_adicionarMusica)
                    .addComponent(bt_removerMusica))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_voltarActionPerformed
        View.PlaylistFrame playlist = new PlaylistFrame();
        playlist.setVisible(true);
        this.dispose(); // Isso fechara a tela atual
    }//GEN-LAST:event_bt_voltarActionPerformed

    private void bt_adicionarMusicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_adicionarMusicaActionPerformed
        View.AdicionarMusicaFrame adicionarMusicaFrame = new AdicionarMusicaFrame(this.playlist);
        adicionarMusicaFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bt_adicionarMusicaActionPerformed

    private void bt_removerMusicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_removerMusicaActionPerformed
        int linha = tb_musicas.getSelectedRow();
        
        if (linha == -1) {
            JOptionPane.showMessageDialog(this, "Selecione uma música");
            return;
        }
        
        int confirmacao = JOptionPane.showConfirmDialog(this, 
                "Deseja realmente remover está música da playlist?",
                "Confirmação", JOptionPane.YES_NO_OPTION);
        
        if (confirmacao == JOptionPane.YES_OPTION) {
            try {
                
                List<MusicaMODEL> musicas = new PlaylistDAO().buscarMusicasDaPlaylist(playlist.getId_playlist());
                MusicaMODEL musicaSelecionada = musicas.get(linha);
                
                boolean sucesso = new PlaylistDAO().removerMusicaDaPlaylist(
                        playlist.getId_playlist(), 
                        musicaSelecionada.getId_musica()
                );
                
                if (sucesso) {
                    JOptionPane.showMessageDialog(this, "Música removida com sucesso!");
                    carregarMusicas();
                } else {
                    JOptionPane.showMessageDialog(this, "Erro ao remover música");
                }
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erro ao buscar/remover música: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_bt_removerMusicaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_adicionarMusica;
    private javax.swing.JButton bt_removerMusica;
    private javax.swing.JButton bt_voltar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_nomePlaylist;
    private javax.swing.JTable tb_musicas;
    // End of variables declaration//GEN-END:variables
}
