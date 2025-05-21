
package View;

import DAO.PlaylistDAO;
import Model.MusicaMODEL;
import Model.PlaylistMODEL;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AdicionarMusicaFrame extends javax.swing.JFrame {

    private final PlaylistMODEL playlist;
    private DefaultTableModel tableModel;
    private List<MusicaMODEL> listaMusicas;

    public AdicionarMusicaFrame(PlaylistMODEL playlist) {
        this.playlist = playlist;
        initComponents();
        setTitle("Adicionar Música à Playlist - Spotfei");
        setLocationRelativeTo(null);
        lb_playlistNome.setText("Playlist: " + playlist.getNome());
        
        configurarTabela();
        carregarMusicasDisponiveis();
    }
    
    private void configurarTabela() {
        tableModel = new DefaultTableModel(new Object[]{"Nome", "Artista", "Gênero"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        tb_musicasDisponiveis.setModel(tableModel);
    }
    
    private void carregarMusicasDisponiveis() {
        try {
            listaMusicas = new PlaylistDAO().buscarMusicasForaDaPlaylist(playlist.getId_playlist());

            tableModel.setRowCount(0);
            for (MusicaMODEL m : listaMusicas) {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tb_musicasDisponiveis = new javax.swing.JTable();
        bt_adicionarMusica = new javax.swing.JButton();
        bt_voltar = new javax.swing.JButton();
        lb_playlistNome = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tb_musicasDisponiveis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tb_musicasDisponiveis);

        bt_adicionarMusica.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_adicionarMusica.setText("Adicionar Musica");
        bt_adicionarMusica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_adicionarMusicaActionPerformed(evt);
            }
        });

        bt_voltar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_voltar.setText("Voltar");
        bt_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_voltarActionPerformed(evt);
            }
        });

        lb_playlistNome.setText("Playlist:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_adicionarMusica)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_voltar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lb_playlistNome)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_playlistNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_adicionarMusica)
                    .addComponent(bt_voltar))
                .addGap(0, 13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_adicionarMusicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_adicionarMusicaActionPerformed
        int linha = tb_musicasDisponiveis.getSelectedRow();
        
        if(linha == -1) {
            JOptionPane.showMessageDialog(this, "Selecione uma música!");
            return;
        }
        
        MusicaMODEL musica = listaMusicas.get(linha);
        boolean sucesso = new PlaylistDAO().adicionarMusicaNaPlaylist(playlist.getId_playlist(), musica.getId_musica());
        
        if (sucesso) {
            JOptionPane.showMessageDialog(this, "Música adicionada com sucesso!");
            carregarMusicasDisponiveis(); // Para atualizar a tabela
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao adicionar música");
        }
    }//GEN-LAST:event_bt_adicionarMusicaActionPerformed

    private void bt_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_voltarActionPerformed
        View.MusicasDaPlaylistFrame musicasDaPlaylistFrame = new MusicasDaPlaylistFrame(playlist);
        musicasDaPlaylistFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bt_voltarActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_adicionarMusica;
    private javax.swing.JButton bt_voltar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_playlistNome;
    private javax.swing.JTable tb_musicasDisponiveis;
    // End of variables declaration//GEN-END:variables
}
