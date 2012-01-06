package frames;

import apsia.Criptografia;
import java.awt.Cursor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import utilitarios.ReadWritePropertiesFile;

/**
 *
 * @author Luciano
 */
public class Configuracao extends javax.swing.JDialog {

  ArrayList<String> configuracao = new ArrayList<String>();

  public void gravaConfiguracao() {
    int resposta = JOptionPane.showConfirmDialog(this, "Atenção:\n Confirma a alteração da configuração do Sistema?", "Confirmação", 2);
    if (resposta == 0) {
      ReadWritePropertiesFile.WriteProperty("database.properties", "Protocolo", Criptografia.CriptaBase64("jdbc:postgresql://"));
      ReadWritePropertiesFile.WriteProperty("database.properties", "Host", Criptografia.CriptaBase64(editServidor.getText()));
      ReadWritePropertiesFile.WriteProperty("database.properties", "Banco", Criptografia.CriptaBase64(editBanco.getText()));
      ReadWritePropertiesFile.WriteProperty("database.properties", "Usuario", Criptografia.CriptaBase64(editUsuario.getText()));
      ReadWritePropertiesFile.WriteProperty("database.properties", "Senha", Criptografia.CriptaBase64(new String(editSenha.getPassword())));
      ReadWritePropertiesFile.WriteProperty("config.properties", "PastaBpa", Criptografia.CriptaBase64(editPastaBpa.getText()));
      ReadWritePropertiesFile.WriteProperty("config.properties", "PastaLog", Criptografia.CriptaBase64(editPastaLog.getText()));
      //ReadWritePropertiesFile.WriteProperty("config.properties", "SerialHd", Criptografia.CriptaBase64(labelSerialHd.getText()));
      JOptionPane.showMessageDialog(this, "O Sistema será reiniciado para efetivar a alteração", "Atenção", JOptionPane.INFORMATION_MESSAGE);
      System.exit(0);
    }
  }

  private void preencheForm() {
    lerConfiguracao();
    editServidor.setText(configuracao.get(1));
    editBanco.setText(configuracao.get(2));
    editUsuario.setText(configuracao.get(3));
    editSenha.setText(configuracao.get(4));
    editPastaBpa.setText(configuracao.get(5));
    editPastaLog.setText(configuracao.get(6));
    //labelSerialHd.setText(HdSerial.getHDSerial("C:"));
  }

  private void lerConfiguracao() {
    configuracao.clear();
    configuracao.add(Criptografia.DecriptaBase64(ReadWritePropertiesFile.ReadProperty("database.properties", "Protocolo")));
    configuracao.add(Criptografia.DecriptaBase64(ReadWritePropertiesFile.ReadProperty("database.properties", "Host")));
    configuracao.add(Criptografia.DecriptaBase64(ReadWritePropertiesFile.ReadProperty("database.properties", "Banco")));
    configuracao.add(Criptografia.DecriptaBase64(ReadWritePropertiesFile.ReadProperty("database.properties", "Usuario")));
    configuracao.add(Criptografia.DecriptaBase64(ReadWritePropertiesFile.ReadProperty("database.properties", "Senha")));
    configuracao.add(Criptografia.DecriptaBase64(ReadWritePropertiesFile.ReadProperty("config.properties", "PastaBpa")));
    configuracao.add(Criptografia.DecriptaBase64(ReadWritePropertiesFile.ReadProperty("config.properties", "PastaLog")));
    //configuracao.add(Criptografia.DecriptaBase64(ReadWritePropertiesFile.ReadProperty("config.properties", "SerialHd")));
  }

  public Configuracao(java.awt.Frame parent, boolean modal) {
    super(parent, modal);
    initComponents();
    preencheForm();
    editServidor.requestFocus();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    editServidor = new javax.swing.JTextField();
    jLabel1 = new javax.swing.JLabel();
    editBanco = new javax.swing.JTextField();
    editUsuario = new javax.swing.JTextField();
    jLabel4 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    editSenha = new javax.swing.JPasswordField();
    btCancelar = new javax.swing.JButton();
    btGravar = new javax.swing.JButton();
    btTestar = new javax.swing.JButton();
    jLabel6 = new javax.swing.JLabel();
    jLabel7 = new javax.swing.JLabel();
    editPastaBpa = new javax.swing.JTextField();
    editPastaLog = new javax.swing.JTextField();
    jButton1 = new javax.swing.JButton();
    jButton2 = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    editServidor.setFont(new java.awt.Font("Tahoma", 0, 12));
    editServidor.setName("editServidor"); // NOI18N
    getContentPane().add(editServidor, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 32, 115, 30));

    jLabel1.setFont(new java.awt.Font("Andale Mono", 0, 18));
    jLabel1.setText("Host:");
    getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 100, -1));

    editBanco.setFont(new java.awt.Font("Tahoma", 0, 12));
    editBanco.setName("editBanco"); // NOI18N
    getContentPane().add(editBanco, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 32, 186, 30));

    editUsuario.setFont(new java.awt.Font("Tahoma", 0, 12));
    getContentPane().add(editUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 82, 115, 30));

    jLabel4.setFont(new java.awt.Font("Andale Mono", 0, 18));
    jLabel4.setText("Senha:");
    getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, -1, -1));

    jLabel2.setFont(new java.awt.Font("Andale Mono", 0, 18));
    jLabel2.setText("Banco:");
    getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, -1, -1));

    jLabel3.setFont(new java.awt.Font("Andale Mono", 0, 18));
    jLabel3.setText("Usuário:");
    getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 90, -1));

    editSenha.setFont(new java.awt.Font("Tahoma", 0, 12));
    editSenha.setMaximumSize(new java.awt.Dimension(50, 21));
    editSenha.setMinimumSize(new java.awt.Dimension(50, 21));
    editSenha.setPreferredSize(new java.awt.Dimension(50, 21));
    getContentPane().add(editSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 82, 187, 30));

    btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/remove-24x24.png"))); // NOI18N
    btCancelar.setText("Cancelar");
    btCancelar.setMaximumSize(new java.awt.Dimension(124, 30));
    btCancelar.setMinimumSize(new java.awt.Dimension(80, 30));
    btCancelar.setPreferredSize(new java.awt.Dimension(80, 30));
    btCancelar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btCancelarActionPerformed(evt);
      }
    });
    getContentPane().add(btCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 230, 124, -1));

    btGravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconOK.gif"))); // NOI18N
    btGravar.setText("Gravar");
    btGravar.setMaximumSize(new java.awt.Dimension(123, 30));
    btGravar.setMinimumSize(new java.awt.Dimension(80, 30));
    btGravar.setPreferredSize(new java.awt.Dimension(80, 30));
    btGravar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btGravarActionPerformed(evt);
      }
    });
    getContentPane().add(btGravar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 135, -1));

    btTestar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/testarConexao.PNG"))); // NOI18N
    btTestar.setText("Testar");
    btTestar.setAlignmentX(0.5F);
    btTestar.setMaximumSize(new java.awt.Dimension(125, 30));
    btTestar.setMinimumSize(new java.awt.Dimension(80, 30));
    btTestar.setPreferredSize(new java.awt.Dimension(80, 30));
    btTestar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btTestarActionPerformed(evt);
      }
    });
    getContentPane().add(btTestar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 125, -1));

    jLabel6.setFont(new java.awt.Font("Andale Mono", 0, 18));
    jLabel6.setText("Pasta BPA:");
    getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

    jLabel7.setFont(new java.awt.Font("Andale Mono", 0, 18));
    jLabel7.setText("Pasta Log:");
    getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));
    getContentPane().add(editPastaBpa, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 132, 289, 30));
    getContentPane().add(editPastaLog, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 182, 291, 30));

    jButton1.setText("...");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });
    getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, 34, 30));

    jButton2.setText("...");
    jButton2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton2ActionPerformed(evt);
      }
    });
    getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 180, 34, 30));

    java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    setBounds((screenSize.width-556)/2, (screenSize.height-325)/2, 556, 325);
  }// </editor-fold>//GEN-END:initComponents

    private void btTestarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTestarActionPerformed
      this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      Connection conexao = null;
      String url = "jdbc:postgresql://" + editServidor.getText() + "/" + editBanco.getText();
      String nomeUsuario = editUsuario.getText();
      String passUsuario = new String(editSenha.getPassword());
      try {
        Class.forName("org.postgresql.Driver");
        try {
          conexao = DriverManager.getConnection(url, nomeUsuario, passUsuario);
        } catch (SQLException erro) {
          JOptionPane.showMessageDialog(this, "Erro: " + erro);
        }
        if (conexao != null) {
          JOptionPane.showMessageDialog(null, "Conexão realizada com sucesso!");
        } else {
          JOptionPane.showMessageDialog(this, "Conexão NÃO realizada!");
        }
      } catch (ClassNotFoundException erro) {
        JOptionPane.showMessageDialog(this, "Erro: " + erro);
      }
      this.setCursor(null);

    }//GEN-LAST:event_btTestarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
      this.dispose();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGravarActionPerformed
      gravaConfiguracao();
    }//GEN-LAST:event_btGravarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      JFileChooser local = new JFileChooser();
      local.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
      local.setMultiSelectionEnabled(false);
      if (local.showSaveDialog(this) == javax.swing.JFileChooser.APPROVE_OPTION) {
        String pasta = local.getSelectedFile().getPath();
        editPastaBpa.setText(pasta);
      }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      JFileChooser local = new JFileChooser();
      local.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
      local.setMultiSelectionEnabled(false);
      if (local.showSaveDialog(this) == javax.swing.JFileChooser.APPROVE_OPTION) {
        String pasta = local.getSelectedFile().getPath();
        editPastaLog.setText(pasta);
      }
    }//GEN-LAST:event_jButton2ActionPerformed
  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {

      public void run() {
        Configuracao dialog = new Configuracao(new javax.swing.JFrame(), true);
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
  private javax.swing.JButton btCancelar;
  private javax.swing.JButton btGravar;
  private javax.swing.JButton btTestar;
  private javax.swing.JTextField editBanco;
  private javax.swing.JTextField editPastaBpa;
  private javax.swing.JTextField editPastaLog;
  private javax.swing.JPasswordField editSenha;
  private javax.swing.JTextField editServidor;
  private javax.swing.JTextField editUsuario;
  private javax.swing.JButton jButton1;
  private javax.swing.JButton jButton2;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  // End of variables declaration//GEN-END:variables
}
