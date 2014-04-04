package telas;



import apsia.Criptografia;
import utilitarios.Funcoes;
import utilitarios.ReadWritePropertiesFile;

public class FrameLiberacao extends javax.swing.JDialog {

  public FrameLiberacao(java.awt.Frame parent, boolean modal) {
    super(parent, modal);
    initComponents();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLabel2 = new javax.swing.JLabel();
    jLabel1 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    jTextField1 = new javax.swing.JTextField();
    jButton1 = new javax.swing.JButton();
    jLabel4 = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("Validar Sistema...");
    setModal(true);
    setResizable(false);
    addWindowListener(new java.awt.event.WindowAdapter() {
      public void windowClosing(java.awt.event.WindowEvent evt) {
        formWindowClosing(evt);
      }
    });
    getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
    getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

    jLabel1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel1.setText("<html>\nSolicite a Chave de Liberação do Sistema<br/>e informe abaixo:\n</html>");
    getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 82, 340, -1));

    jLabel3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
    jLabel3.setForeground(new java.awt.Color(255, 0, 51));
    jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel3.setText("Atenção: Sistema Expirado!");
    getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 340, -1));
    getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 146, 360, -1));

    jButton1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
    jButton1.setText("Validar");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });
    getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 206, 100, 30));

    jLabel4.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
    jLabel4.setForeground(new java.awt.Color(204, 0, 15));
    jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel4.setText("<html>Para obter chave de liberação, faça contato com o sr Márcio Nogueira no email marcio@itarget.com.br.</html>");
    getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 176, 360, 40));

    java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    setBounds((screenSize.width-413)/2, (screenSize.height-268)/2, 413, 268);
  }// </editor-fold>//GEN-END:initComponents

  private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
    Funcoes.informacao("Sistema será encerrado sem validação!");
    System.exit(0);
  }//GEN-LAST:event_formWindowClosing

  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    if ("".equalsIgnoreCase(jTextField1.getText())) {
      Funcoes.erro("Chave de Liberação não Informada.\nO Sistema não será validado!");
    } else {
      String chave = Criptografia.DecriptaBase64(jTextField1.getText());
      if (chave.substring(0, 4).equalsIgnoreCase("189x")) {
          ReadWritePropertiesFile.WriteProperty("licence.properties", "Licence", jTextField1.getText());
          Funcoes.informacao("Chave de Liberação gravada.\nPreciso reiniciar o sistema para validar essa chave.");
      } else {
        Funcoes.erro("A chave informada não é válida\npara esse Sistema!");
      }
    }
    System.exit(0);
  }//GEN-LAST:event_jButton1ActionPerformed

  public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {

      public void run() {
        FrameLiberacao dialog = new FrameLiberacao(new javax.swing.JFrame(), true);
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
  private javax.swing.JButton jButton1;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JTextField jTextField1;
  // End of variables declaration//GEN-END:variables
}
