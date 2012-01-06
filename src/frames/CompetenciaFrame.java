package frames;

import model.Competencia;
import banco.Conexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import utilitarios.ReadWritePropertiesFile;

public class CompetenciaFrame extends javax.swing.JDialog {

  ArrayList<String> configuracao = new ArrayList<String>();

  public CompetenciaFrame(java.awt.Frame parent, boolean modal) {
    super(parent, modal);
    initComponents();
  }

  public void gravaCompetencia() {
    int mes = jComboBox1.getSelectedIndex() +1;
    int ano = Integer.parseInt(jComboBox2.getSelectedItem().toString());
    
    String str_mes = Integer.toString(mes);
    String str_ano = Integer.toString(ano);
    
    ReadWritePropertiesFile.WriteProperty("config.properties", "str_mes", str_mes);
    ReadWritePropertiesFile.WriteProperty("config.properties", "str_ano", str_ano);
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    jComboBox1 = new javax.swing.JComboBox();
    jComboBox2 = new javax.swing.JComboBox();
    btDefinir = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("Definir Competência");
    setModal(true);
    setName("formCompetencia"); // NOI18N

    jLabel1.setLabelFor(jComboBox1);
    jLabel1.setText("Mês:");

    jLabel2.setLabelFor(jComboBox2);
    jLabel2.setText("Ano:");

    jComboBox1.setMaximumRowCount(12);
    jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" }));
    jComboBox1.setName("comboMes"); // NOI18N

    jComboBox2.setMaximumRowCount(3);
    jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2010", "2011", "2012" }));
    jComboBox2.setName("comboAno"); // NOI18N

    btDefinir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconOK.gif"))); // NOI18N
    btDefinir.setText("Definir");
    btDefinir.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btDefinirActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGap(27, 27, 27)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabel1)
              .addComponent(jLabel2))
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
          .addGroup(layout.createSequentialGroup()
            .addGap(131, 131, 131)
            .addComponent(btDefinir, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap(162, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(34, 34, 34)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel1)
          .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel2)
          .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(32, 32, 32)
        .addComponent(btDefinir, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(39, Short.MAX_VALUE))
    );

    java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    setBounds((screenSize.width-411)/2, (screenSize.height-236)/2, 411, 236);
  }// </editor-fold>//GEN-END:initComponents
  private void btDefinirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDefinirActionPerformed
    Competencia cmpt = new Competencia();
    int mes = jComboBox1.getSelectedIndex() + 1;
    int ano = Integer.parseInt(jComboBox2.getSelectedItem().toString());
    String str_mes = Integer.toString(mes);
    String str_ano = Integer.toString(ano);
    Competencia.setMes(str_mes);
    Competencia.setAno(str_ano);
    try {
      Connection conexao = Conexao.getConexao();
      Statement st = null;
      try {
        st = (Statement) conexao.createStatement();
      } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Erro: " + ex.getLocalizedMessage());
      }
      String sql = "select count(*) as qtde from ano_mes where ano=" + ano + " and mes=" + mes;
      ResultSet result = st.executeQuery(sql);
      result.next();
      int qtde = result.getInt("qtde");
      if (qtde <= 0) {
        JOptionPane.showMessageDialog(null, "Competência Não Cadastrada!");
      } else {
        gravaCompetencia();
        this.dispose();
      }
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, "Erro: " + ex.getLocalizedMessage());
    }
  }//GEN-LAST:event_btDefinirActionPerformed

  public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {

      public void run() {
        CompetenciaFrame dialog = new CompetenciaFrame(new javax.swing.JFrame(), true);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {

          @Override
          public void windowClosing(java.awt.event.WindowEvent e) {
            System.exit(0);
          }
        });
        dialog.setVisible(true);
      }
    });
  }
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btDefinir;
  private javax.swing.JComboBox jComboBox1;
  private javax.swing.JComboBox jComboBox2;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  // End of variables declaration//GEN-END:variables
}
