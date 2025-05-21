package View;

import DAO.CurtidaDAO;
import Model.MusicaMODEL;
import Model.UsuarioLogadoMODEL;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class MusicasDescurtidasFrame extends javax.swing.JFrame {
    private DefaultTableModel tableModel;
    private List<MusicaMODEL> listaMusicasDescurtidas;

    
    public MusicasDescurtidasFrame() {
        
        initComponents();
        setTitle("Musícas Descurtidas - Spotifei");
        setLocationRelativeTo(null); // Centralizar a janela
        
        configurarTabela();
        carregarMusicasDescurtidas();
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
        
        tb_descurtidas.setModel(tableModel);
        tb_descurtidas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    
    private void carregarMusicasDescurtidas(){
        
        try {
            tableModel.setRowCount(0);

            CurtidaDAO dao = new CurtidaDAO();
            listaMusicasDescurtidas = dao.buscarMusicasDescurtidas(UsuarioLogadoMODEL.getId_usuario());

            for (MusicaMODEL m : listaMusicasDescurtidas) {
                tableModel.addRow(new Object[]{
                    m.getNome(),
                    m.getArtista().getNome(),
                    m.getGenero()
                });
            }

            if (listaMusicasDescurtidas.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                    "Nenhuma música disponível para curtir.",
                    "Info",
                    JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                "Erro ao carregar músicas descurtidas: " + e.getMessage(),
                "Erro",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tb_descurtidas = new javax.swing.JTable();
        bt_curtir = new javax.swing.JButton();
        bt_voltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tb_descurtidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Musica", "Artista", "Gênero"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tb_descurtidas);

        bt_curtir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_curtir.setText("Curtir novamente");
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(bt_curtir)
                .addGap(54, 54, 54)
                .addComponent(bt_voltar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_curtir)
                    .addComponent(bt_voltar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_curtirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_curtirActionPerformed
        try {
            int linha = tb_descurtidas.getSelectedRow();

            if (linha == -1) {
                JOptionPane.showMessageDialog(this, "Selecione uma música!");
                return;
            }

            int idUsuario = UsuarioLogadoMODEL.getId_usuario();
            int idMusica = listaMusicasDescurtidas.get(linha).getId_musica();

            boolean sucesso = new CurtidaDAO().curtirMusica(idUsuario, idMusica);

            if (sucesso) {
                JOptionPane.showMessageDialog(this, "Música curtida novamente!");
                carregarMusicasDescurtidas(); // atualiza a tabela
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao curtir música.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                "Erro ao carregar música descurtidas: " + e.getMessage(),
                "Erro",
                JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_bt_curtirActionPerformed

    private void bt_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_voltarActionPerformed
        View.MenuFrame menu = new MenuFrame();
        menu.setVisible(true);
        this.dispose(); // Isso fechara a tela atual
    }//GEN-LAST:event_bt_voltarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_curtir;
    private javax.swing.JButton bt_voltar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_descurtidas;
    // End of variables declaration//GEN-END:variables
}
