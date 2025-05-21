
package View;

import DAO.PlaylistDAO;
import Model.PlaylistMODEL;
import Model.UsuarioMODEL;
import Model.UsuarioLogadoMODEL;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class PlaylistFrame extends javax.swing.JFrame {

    private DefaultTableModel tableModel;
    private List<PlaylistMODEL> listaPlaylists;
    
    public PlaylistFrame() {
        initComponents();
        setTitle("Minhas Playlists - Spotifei"); // titulo
        setLocationRelativeTo(null);
        
        configurarTabela();
        carregarPlaylists();
    }

    // Define a estrutura da tabela
    private void configurarTabela() {
        tableModel = new DefaultTableModel(new Object[]{"Nome da Playlist"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tb_playlists.setModel(tableModel);
        tb_playlists.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    
    // Preenche os dados da tabela
    private void carregarPlaylists() {
        try {
            PlaylistDAO dao = new PlaylistDAO(); // <- classe responsavel por falar com o banco
            int idUsuario = UsuarioLogadoMODEL.getId_usuario(); // Pegamos o id do usuario
            listaPlaylists = dao.buscarPlaylistsPorUsuario(idUsuario); // Pegamos a lista e armazenamos na variavel
            
            tableModel.setRowCount(0); // limpamos a tabela antes de mostrar os dados novos, evitando duplicadas
            
            // Percorra cada playlist da lista
            for (PlaylistMODEL p : listaPlaylists) {
                // E pegue o id e nome e adicione na nova linha da tabela
                tableModel.addRow(new Object[]{p.getNome()});
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar playlist " + e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tb_playlists = new javax.swing.JTable();
        bt_novaPlaylist = new javax.swing.JButton();
        bt_verMusicas = new javax.swing.JButton();
        bt_voltar = new javax.swing.JButton();
        bt_deletarPlaylist = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tb_playlists.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tb_playlists);

        bt_novaPlaylist.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_novaPlaylist.setText("Nova Playlist");
        bt_novaPlaylist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_novaPlaylistActionPerformed(evt);
            }
        });

        bt_verMusicas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_verMusicas.setText("Ver Músicas");
        bt_verMusicas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_verMusicasActionPerformed(evt);
            }
        });

        bt_voltar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_voltar.setText("Voltar");
        bt_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_voltarActionPerformed(evt);
            }
        });

        bt_deletarPlaylist.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_deletarPlaylist.setText("Deletar Playlist");
        bt_deletarPlaylist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_deletarPlaylistActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_novaPlaylist)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_verMusicas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_deletarPlaylist)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_voltar)))
                .addGap(52, 52, 52))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_novaPlaylist)
                    .addComponent(bt_verMusicas)
                    .addComponent(bt_voltar)
                    .addComponent(bt_deletarPlaylist))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_novaPlaylistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_novaPlaylistActionPerformed
        String nome = JOptionPane.showInputDialog(this, "Nome da nova playlist:");

        // Se nome for diferente de nulo e se o nome informado não está vazio
        // trim -> Tira o espaçamento ficando "" e isEmpty verifica se nao está vazia
        // !nome -> Nao deixa criar
        if (nome != null && !nome.trim().isEmpty()) {
            PlaylistMODEL nova = new PlaylistMODEL(nome, new UsuarioMODEL(UsuarioLogadoMODEL.getId_usuario()));
            boolean sucesso = new PlaylistDAO().criarPlaylist(nova);

            if (sucesso) {
                JOptionPane.showMessageDialog(this, "Playlist criada!");
                carregarPlaylists();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao criar playlist.");
            }
        }
    }//GEN-LAST:event_bt_novaPlaylistActionPerformed

   
    private void bt_verMusicasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_verMusicasActionPerformed
        int linha = tb_playlists.getSelectedRow();

        if (linha != -1) {
            PlaylistMODEL selecionada = listaPlaylists.get(linha);
            MusicasDaPlaylistFrame tela = new MusicasDaPlaylistFrame(selecionada);
            tela.setVisible(true);
            this.dispose(); // fecha o PlaylistFrame atual
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma playlist!");
        }
    }//GEN-LAST:event_bt_verMusicasActionPerformed

    private void bt_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_voltarActionPerformed
        View.MenuFrame menu = new MenuFrame();
        menu.setVisible(true);
        this.dispose(); // Isso fechara a tela atual
    }//GEN-LAST:event_bt_voltarActionPerformed

    private void bt_deletarPlaylistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_deletarPlaylistActionPerformed
        int linha = tb_playlists.getSelectedRow();
        
        if(linha == -1) {
            JOptionPane.showMessageDialog(this, "Selecione uma playlist!");
            return;
        }
        
        int confirmacao = JOptionPane.showConfirmDialog(this,
                "Deseja realmente excluir esta playlist?",
                "Confirmação", JOptionPane.YES_NO_OPTION);
        
        if (confirmacao == JOptionPane.YES_OPTION) {
            PlaylistMODEL selecionada = listaPlaylists.get(linha);
            boolean sucesso = new PlaylistDAO().deletarMusicaPlaylist(selecionada.getId_playlist());
            
            if (sucesso) {
                JOptionPane.showMessageDialog(this, "Playlist exclúida com sucesso");
                carregarPlaylists(); // Atualizar
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao excluir playlist.");
            }
        }
    }//GEN-LAST:event_bt_deletarPlaylistActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_deletarPlaylist;
    private javax.swing.JButton bt_novaPlaylist;
    private javax.swing.JButton bt_verMusicas;
    private javax.swing.JButton bt_voltar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_playlists;
    // End of variables declaration//GEN-END:variables
}
