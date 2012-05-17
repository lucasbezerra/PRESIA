package telas;

import java.io.FileNotFoundException;
import java.io.IOException;
import utilitarios.FileUtil;
import utilitarios.Funcoes;

/**
 * @author luciano
 */
public class FrameLeiame extends javax.swing.JFrame {

  public FrameLeiame() {
    initComponents();
  }

  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        memoLeiame = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Leia-me");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        memoLeiame.setColumns(50);
        memoLeiame.setEditable(false);
        memoLeiame.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        memoLeiame.setRows(15);
        memoLeiame.setWrapStyleWord(true);
        jScrollPane1.setViewportView(memoLeiame);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 695, 320));

        jButton1.setText("Retornar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 330, 120, 30));

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-710)/2, (screenSize.height-398)/2, 710, 398);
    }// </editor-fold>//GEN-END:initComponents

  private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
    String texto = null;
    try {
      texto = FileUtil.carregar("leiame.txt");
      memoLeiame.append(texto);
    } catch (FileNotFoundException ex) {
      Funcoes.erro(ex.getLocalizedMessage());
    } catch (IOException ex) {
      Funcoes.erro(ex.getLocalizedMessage());
    }
  }//GEN-LAST:event_formWindowActivated

  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    this.dispose();
  }//GEN-LAST:event_jButton1ActionPerformed

  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {

      public void run() {
        new FrameLeiame().setVisible(true);
      }
    });
  }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea memoLeiame;
    // End of variables declaration//GEN-END:variables
}
