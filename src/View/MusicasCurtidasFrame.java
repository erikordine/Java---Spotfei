
package View;

import DAO.CurtidaDAO;
import DAO.MusicaDAO;
import Model.MusicaMODEL;
import Model.MusicasCurtidasMODEL;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class MusicasCurtidasFrame extends javax.swing.JFrame {
    private final CurtidaDAO curtidaDAO;
    private final MusicaDAO musicaDAO;
    private DefaultTableModel tableModel;

    public MusicasCurtidasFrame() {
        // DAOs no construtor
        this.curtidaDAO = new CurtidaDAO();
        this.musicaDAO = new MusicaDAO();
        
        initComponents();
        setTitle("Musícas Curtidas - Spotifei");
        setLocationRelativeTo(null); // Centralizar a janela
        
        configurarTabela();
        carregarMusicasCurtidas();
    }
    
    private void configurarTabela() {
        // Cria o modelo com 3 colunas
        tableModel = new DefaultTableModel(
            new Object[]{"Música", "Artista", "Gênero"}, 
            0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Tabela não-editável
            }
        };
        
        tabelaMusicas.setModel(tableModel);
        tabelaMusicas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    
    private void carregarMusicasCurtidas() {
        tableModel.setRowCount(0);
        
        List<MusicasCurtidasMODEL> musicasCurtidas = curtidaDAO.getMusicasCurtidasCompletas();
        
        for (MusicasCurtidasMODEL mc : musicasCurtidas) {
            MusicaMODEL musica = musicaDAO.buscarPorId(mc.getId_musica());
            
            if (musica != null) {
                tableModel.addRow(new Object[]{
                    musica.getNome(),
                    musica.getArtista().getNome(),
                    musica.getGenero()
                });
            }
        }
        
        if (tableModel.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this,
                    "Nenhuma música curtida encontrada.",
                    "Aviso",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }
    
    private void descurtirMusicaSelecionada() {
        int linhaSelecionada = tabelaMusicas.getSelectedRow();
        
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, 
                    "Selecione uma música para descurtir",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }
        
        try {
            List<MusicasCurtidasMODEL> musicasCurtidas = curtidaDAO.getMusicasCurtidasCompletas();
            int idMusica = musicasCurtidas.get(linhaSelecionada).getId_musica();
            
            // COnfirmação
            int confirmacao = JOptionPane.showConfirmDialog(this,
                    "Tem certeza que deseja descurtir está música?",
                    "Confirmar Descurtida",
                    JOptionPane.YES_NO_OPTION
            );
            
            if (confirmacao == JOptionPane.YES_NO_OPTION) {
                if (curtidaDAO.removerCurtida(idMusica)) {
                    JOptionPane.showMessageDialog(this, 
                            "Música descurtida com sucesso!",
                            "Sucesso", 
                            JOptionPane.INFORMATION_MESSAGE
                    );
                    carregarMusicasCurtidas(); // Atualiza a tabela
                } else {
                    JOptionPane.showMessageDialog(this, 
                            "Erro ao descurtir:",
                            "Erro",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, 
                    "Erro ao descurtir: " + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaMusicas = new javax.swing.JTable();
        bt_descurtir = new javax.swing.JButton();
        bt_voltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabelaMusicas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Musica", "Artista", "Gênero"
            }
        ));
        tabelaMusicas.setColumnSelectionAllowed(true);
        tabelaMusicas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(tabelaMusicas);
        tabelaMusicas.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tabelaMusicas.getAccessibleContext().setAccessibleDescription("");
        tabelaMusicas.getAccessibleContext().setAccessibleParent(tabelaMusicas);

        bt_descurtir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_descurtir.setText("Descurtir");
        bt_descurtir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_descurtirActionPerformed(evt);
            }
        });

        bt_voltar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_voltar.setText("Voltar");
        bt_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_voltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(bt_descurtir)
                .addGap(62, 62, 62)
                .addComponent(bt_voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(137, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 51, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 51, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(332, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_voltar)
                    .addComponent(bt_descurtir))
                .addGap(17, 17, 17))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 51, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 51, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_descurtirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_descurtirActionPerformed
        descurtirMusicaSelecionada();
    }//GEN-LAST:event_bt_descurtirActionPerformed

    private void bt_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_voltarActionPerformed
        View.MenuFrame menu = new MenuFrame();
        menu.setVisible(true);
        this.dispose(); // Isso fechara a tela atual
    }//GEN-LAST:event_bt_voltarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_descurtir;
    private javax.swing.JButton bt_voltar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaMusicas;
    // End of variables declaration//GEN-END:variables
}
