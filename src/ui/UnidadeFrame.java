package ui;

import model.Unidade;
import banco.Conexao;
import java.awt.event.KeyEvent;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class UnidadeFrame extends javax.swing.JDialog {

    public UnidadeFrame(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        editPesquisa = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btConfirmar = new javax.swing.JButton();
        btFiltrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Selecione o Prestador de Serviços");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jScrollPane1.setNextFocusableComponent(jTable1);

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Cnes", "Nome", "Cnpj"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.setColumnSelectionAllowed(true);
        jTable1.setNextFocusableComponent(btFiltrar);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.getColumnModel().getColumn(0).setResizable(false);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTable1.getColumnModel().getColumn(1).setResizable(false);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(62);
        jTable1.getColumnModel().getColumn(2).setResizable(false);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(475);
        jTable1.getColumnModel().getColumn(3).setResizable(false);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(120);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 240));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Opções de Filtro"));
        jPanel1.setNextFocusableComponent(btFiltrar);
        jPanel1.setPreferredSize(new java.awt.Dimension(625, 57));

        editPesquisa.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        editPesquisa.setNextFocusableComponent(btFiltrar);
        editPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                editPesquisaKeyPressed(evt);
            }
        });

        jLabel1.setText("Nome ou parte:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(editPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 625, 60));

        btConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/images/iconOK.gif"))); // NOI18N
        btConfirmar.setText("Confirmar");
        btConfirmar.setMaximumSize(new java.awt.Dimension(120, 30));
        btConfirmar.setMinimumSize(new java.awt.Dimension(120, 30));
        btConfirmar.setPreferredSize(new java.awt.Dimension(120, 30));
        btConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConfirmarActionPerformed(evt);
            }
        });
        getContentPane().add(btConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 320, 120, 30));

        btFiltrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/images/filter.gif"))); // NOI18N
        btFiltrar.setText("Filtrar");
        btFiltrar.setMaximumSize(new java.awt.Dimension(120, 30));
        btFiltrar.setMinimumSize(new java.awt.Dimension(120, 30));
        btFiltrar.setPreferredSize(new java.awt.Dimension(120, 30));
        btFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFiltrarActionPerformed(evt);
            }
        });
        getContentPane().add(btFiltrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 320, -1, 30));

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-633)/2, (screenSize.height-391)/2, 633, 391);
    }// </editor-fold>//GEN-END:initComponents

    public boolean removeLinha(DefaultTableModel model) {
        int linha = model.getRowCount();
        for (int i = linha - 1; i >= 0; --i) {
            model.removeRow(i);
        }
        return false;
    }

    private void btFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFiltrarActionPerformed
            Connection conexao = Conexao.getConexao();
            Statement stmt = null;
        try {
            stmt = (Statement) conexao.createStatement();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro: "+erro);
        }
        try {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            removeLinha(model);
            String texto = editPesquisa.getText().toUpperCase();
            String sql = "select id_unidade_saude as id, cod_cnes as cnes, nome_fantasia as nome, cnpj_unidade_saude as cnpj "
                    + "from unidade_saude "
                    + "where tipo_unidade_saude in ('P', 'A') and ativo='S' and nome_fantasia like '%" + texto + "%' "
                    + "order by cnes";
            ResultSet result = stmt.executeQuery(sql);
            while (result.next()) {
                model.addRow(new Object[]{result.getInt("id"), result.getString("cnes"), result.getString("nome"), result.getString("cnpj")});
            }
            jTable1.setModel(model);
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro: "+erro);
        }
    }//GEN-LAST:event_btFiltrarActionPerformed

    private void editPesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editPesquisaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btFiltrar.doClick();
        }
    }//GEN-LAST:event_editPesquisaKeyPressed

    private void btConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfirmarActionPerformed
        int linha = -1;
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        linha = jTable1.getSelectedRow();
        String codi = model.getValueAt(linha, 0).toString();
        String cnes = model.getValueAt(linha, 1).toString();
        String nome = model.getValueAt(linha, 2).toString();
        String cnpj = model.getValueAt(linha, 3).toString();
        if (linha == -1) {
            System.out.println("Erro");
        } else {
            int resposta = JOptionPane.showConfirmDialog(this, "Confirma " + nome + "?", "Atenção", 0);
            if (resposta == 0) {
                Unidade.setNome(nome);
                Unidade.setCodigo(codi);
                Unidade.setCnes(cnes);
                Unidade.setCnpj(cnpj);
                this.dispose();
            }
    }//GEN-LAST:event_btConfirmarActionPerformed
    }

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int linha = jTable1.getSelectedRow();
        String nome = model.getValueAt(linha, 2).toString();
        editPesquisa.setText(nome);
        if(evt.getClickCount() == 2){
            btConfirmar.doClick();
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        editPesquisa.requestFocus();
    }//GEN-LAST:event_formWindowActivated

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                UnidadeFrame dialog = new UnidadeFrame(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btConfirmar;
    private javax.swing.JButton btFiltrar;
    private javax.swing.JTextField editPesquisa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
