
package View;

import Controller.MusicaController;
import DAO.CurtidaDAO;
import DAO.HistoricoDAO;
import Model.HistoricoMODEL;
import Model.MusicaMODEL;
import Model.UsuarioLogadoMODEL;
import java.util.EventObject;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class BuscarMusicaFrame extends javax.swing.JFrame {
    private DefaultTableModel tableModel;

    public BuscarMusicaFrame() {
        initComponents();
        setTitle("Buscar Musicas - Spotifei");
        setLocationRelativeTo(null); // Centralizar a janela
        
        configurarTabela();
        carregarTodasAsMusicas();
        carregarHistorico();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb_buscar_por = new javax.swing.JLabel();
        txt_busca = new javax.swing.JTextField();
        cd_tipo_busca = new javax.swing.JComboBox<>();
        bt_buscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_resultado = new javax.swing.JTable();
        bt_curtir = new javax.swing.JButton();
        bt_voltar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        ta_historico = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lb_buscar_por.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_buscar_por.setText("Buscar música por:");

        txt_busca.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        cd_tipo_busca.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cd_tipo_busca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nome", "Gênero", "Artista" }));
        cd_tipo_busca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cd_tipo_buscaActionPerformed(evt);
            }
        });

        bt_buscar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_buscar.setText("Buscar");
        bt_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_buscarActionPerformed(evt);
            }
        });

        tb_resultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tb_resultado);

        bt_curtir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_curtir.setText("Curtir");
        bt_curtir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_curtirActionPerformed(evt);
            }
        });

        bt_voltar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_voltar.setText("Voltar");
        bt_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_voltarActionPerformed(evt);
            }
        });

        ta_historico.setEditable(false);
        ta_historico.setColumns(20);
        ta_historico.setLineWrap(true);
        ta_historico.setRows(5);
        ta_historico.setWrapStyleWord(true);
        ta_historico.setFocusable(false);
        jScrollPane2.setViewportView(ta_historico);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_curtir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_voltar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(lb_buscar_por)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cd_tipo_busca, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txt_busca, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(bt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(53, 53, 53)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_buscar_por)
                    .addComponent(cd_tipo_busca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_busca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_buscar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_curtir)
                    .addComponent(bt_voltar))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void configurarTabela() {
        tableModel = new DefaultTableModel(new Object[]{"Música", "Artista", "Gênero"}, 0) {
            public boolean isCellEditable(int row, int column, EventObject e) {
                return false;
            }
        };
        tb_resultado.setModel(tableModel);
        
    }
    
    private void carregarTodasAsMusicas() {
        MusicaController controller = new MusicaController();
        List<MusicaMODEL> musicas = controller.buscarMusicas("nome", "");
        
        String[] colunas = {"ID", "Nome", "Gênero", "Artista"};
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);
        
        tableModel.setRowCount(0);
        
        for (MusicaMODEL musica : musicas) {
                Object[] linha = {
                    musica.getId_musica(),
                    musica.getNome(),
                    musica.getGenero(),
                    musica.getArtista().getNome()
            };
            modelo.addRow(linha);
        }
        tb_resultado.setModel(modelo);
    }
    
    private void carregarHistorico() {
        StringBuilder sb = new StringBuilder();
        sb.append("Histórico:\n");

        List<HistoricoMODEL> lista = new HistoricoDAO().buscarHistoricoPorUsuario(
            Model.UsuarioLogadoMODEL.getId_usuario()
        );

        int max = Math.min(10, lista.size());
        for (int i = 0; i < max; i++) {
            HistoricoMODEL h = lista.get(i);
            sb.append("Filtrou \"")
              .append(h.getTipo())
              .append("\" -> ")
              .append(h.getTermo())
              .append("\n");
        }

        ta_historico.setText(sb.toString());
    }


    private void bt_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_buscarActionPerformed
                String tipo = cd_tipo_busca.getSelectedItem().toString().trim();
        String termo = txt_busca.getText().trim();

        // Verificação
        if (tipo.isEmpty() || termo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Escolha um filtro e digite algo para buscar.");
            return;
        }

        // Limpa a tabela
        tableModel.setRowCount(0);
        
        MusicaController controller = new MusicaController();
        List<MusicaMODEL> musicas = controller.buscarMusicas(tipo, termo);

        for (MusicaMODEL musica : musicas) {
            tableModel.addRow(new Object[]{
                musica.getId_musica(),
                musica.getNome(),
                musica.getGenero(),
                musica.getArtista().getNome()
            });
        }

        // Registrar no histórico e atualizar histórico
        HistoricoMODEL h = new HistoricoMODEL(UsuarioLogadoMODEL.getId_usuario(), termo, tipo);
        new HistoricoDAO().registrarBusca(h);
        carregarHistorico();
    }//GEN-LAST:event_bt_buscarActionPerformed

    private void bt_curtirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_curtirActionPerformed
        int linhaSelecionada = tb_resultado.getSelectedRow();
        
        if (linhaSelecionada != -1) {
            int id_usuario = UsuarioLogadoMODEL.getId_usuario();
            int id_musica = (int) tb_resultado.getValueAt(linhaSelecionada, 0);
            
            CurtidaDAO curtidaDAO = new CurtidaDAO();
            boolean sucesso = curtidaDAO.curtirMusica(id_usuario, id_musica);
            
            if (sucesso){
                JOptionPane.showMessageDialog(this, "Música curtida com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this, "Essa música já foi curtida");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma música na tabela.");
        }
    }//GEN-LAST:event_bt_curtirActionPerformed

    private void bt_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_voltarActionPerformed
        View.MenuFrame menu = new MenuFrame();
        menu.setVisible(true);
        this.dispose(); // Isso fechara a tela atual
    }//GEN-LAST:event_bt_voltarActionPerformed

    private void cd_tipo_buscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cd_tipo_buscaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cd_tipo_buscaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_buscar;
    private javax.swing.JButton bt_curtir;
    private javax.swing.JButton bt_voltar;
    private javax.swing.JComboBox<String> cd_tipo_busca;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lb_buscar_por;
    private javax.swing.JTextArea ta_historico;
    private javax.swing.JTable tb_resultado;
    private javax.swing.JTextField txt_busca;
    // End of variables declaration//GEN-END:variables
}
