package frames;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Competencia;
import utilitarios.Funcoes;

/**
 * @author luciano
 */
public class MenuFrame extends javax.swing.JFrame {

    /** Creates new form MenuFrame */
    public MenuFrame() {
        initComponents();
        this.setResizable(false);
    }

    @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPanel1 = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    jToolBar1 = new javax.swing.JToolBar();
    btCompetencia = new javax.swing.JButton();
    btConfigura = new javax.swing.JButton();
    btGerarBpa = new javax.swing.JButton();
    btSobre = new javax.swing.JButton();
    btLeiame = new javax.swing.JButton();
    btSair = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("PRE-SIA <--> SMS Juazeiro do Norte");
    setName("menuPrincipal"); // NOI18N

    jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

    jLabel1.setText(" ");

    jLabel2.setText("SMS JUAZEIRO DO NORTE / CE");

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel1)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 516, Short.MAX_VALUE)
        .addComponent(jLabel2)
        .addContainerGap())
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
        .addComponent(jLabel2))
    );

    jToolBar1.setRollover(true);

    btCompetencia.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
    btCompetencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cal1.gif"))); // NOI18N
    btCompetencia.setText("Competência");
    btCompetencia.setToolTipText("Definir Competência");
    btCompetencia.setBorder(null);
    btCompetencia.setFocusable(false);
    btCompetencia.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    btCompetencia.setMaximumSize(new java.awt.Dimension(100, 39));
    btCompetencia.setMinimumSize(new java.awt.Dimension(100, 39));
    btCompetencia.setPreferredSize(new java.awt.Dimension(100, 39));
    btCompetencia.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    btCompetencia.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btCompetenciaActionPerformed(evt);
      }
    });
    jToolBar1.add(btCompetencia);

    btConfigura.setFont(new java.awt.Font("Ubuntu", 0, 12));
    btConfigura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/engrenagem_01.png"))); // NOI18N
    btConfigura.setText("Configuração");
    btConfigura.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
    btConfigura.setFocusable(false);
    btConfigura.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    btConfigura.setMaximumSize(new java.awt.Dimension(100, 39));
    btConfigura.setMinimumSize(new java.awt.Dimension(100, 39));
    btConfigura.setPreferredSize(new java.awt.Dimension(100, 39));
    btConfigura.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    btConfigura.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btConfiguraActionPerformed(evt);
      }
    });
    jToolBar1.add(btConfigura);

    btGerarBpa.setFont(new java.awt.Font("Ubuntu", 0, 12));
    btGerarBpa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Exportar.PNG"))); // NOI18N
    btGerarBpa.setText("Gerar BPA");
    btGerarBpa.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
    btGerarBpa.setFocusable(false);
    btGerarBpa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    btGerarBpa.setMaximumSize(new java.awt.Dimension(100, 39));
    btGerarBpa.setMinimumSize(new java.awt.Dimension(100, 39));
    btGerarBpa.setPreferredSize(new java.awt.Dimension(100, 39));
    btGerarBpa.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    btGerarBpa.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btGerarBpaActionPerformed(evt);
      }
    });
    jToolBar1.add(btGerarBpa);

    btSobre.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
    btSobre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sobre.jpg"))); // NOI18N
    btSobre.setText("Sobre ...");
    btSobre.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
    btSobre.setFocusable(false);
    btSobre.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    btSobre.setMaximumSize(new java.awt.Dimension(100, 39));
    btSobre.setMinimumSize(new java.awt.Dimension(100, 39));
    btSobre.setPreferredSize(new java.awt.Dimension(100, 39));
    btSobre.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    btSobre.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btSobreActionPerformed(evt);
      }
    });
    jToolBar1.add(btSobre);

    btLeiame.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
    btLeiame.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/leiame.gif"))); // NOI18N
    btLeiame.setText("Leiame");
    btLeiame.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
    btLeiame.setFocusable(false);
    btLeiame.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    btLeiame.setPreferredSize(new java.awt.Dimension(100, 39));
    btLeiame.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    btLeiame.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btLeiameActionPerformed(evt);
      }
    });
    jToolBar1.add(btLeiame);

    btSair.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
    btSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/saida.png"))); // NOI18N
    btSair.setText("Sair do Sistema");
    btSair.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
    btSair.setFocusable(false);
    btSair.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    btSair.setMaximumSize(new java.awt.Dimension(100, 39));
    btSair.setMinimumSize(new java.awt.Dimension(100, 39));
    btSair.setPreferredSize(new java.awt.Dimension(100, 39));
    btSair.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    btSair.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btSairActionPerformed(evt);
      }
    });
    jToolBar1.add(btSair);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 744, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 324, Short.MAX_VALUE)
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
    );

    java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    setBounds((screenSize.width-746)/2, (screenSize.height-422)/2, 746, 422);
  }// </editor-fold>//GEN-END:initComponents

  private void btCompetenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCompetenciaActionPerformed
      Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
      CompetenciaFrame cmpt = new CompetenciaFrame(this, true);
      this.setLocation((tela.width - this.getSize().width) / 2, (tela.height - this.getSize().height) / 2);
      cmpt.setVisible(true);
      jLabel1.setText("   COMPETÊNCIA: " + String.format("%02d", Integer.parseInt(Competencia.getMes())) + "/" + String.format("%02d", Integer.parseInt(Competencia.getAno())));
  }//GEN-LAST:event_btCompetenciaActionPerformed

  private void btGerarBpaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGerarBpaActionPerformed
      if (Competencia.getAno() != null) {
          Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
          GerarBpaFrame bpa = null;
          try {
              bpa = new GerarBpaFrame(this, true);
          } catch (SQLException ex) {
              Funcoes.erro(ex.getLocalizedMessage());
          }
          this.setLocation((tela.width - this.getSize().width) / 2, (tela.height - this.getSize().height) / 2);
          bpa.setVisible(true);
      } else {
          JOptionPane.showMessageDialog(this, "Nenhuma Competência Definida!");
      }
  }//GEN-LAST:event_btGerarBpaActionPerformed

  private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
      System.exit(0);
  }//GEN-LAST:event_btSairActionPerformed

  private void btConfiguraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfiguraActionPerformed
      Configuracao configura = new Configuracao(this, true);
      configura.setVisible(true);
  }//GEN-LAST:event_btConfiguraActionPerformed

  private void btSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSobreActionPerformed
      SobreFrame about = new SobreFrame();
      about.setVisible(true);
  }//GEN-LAST:event_btSobreActionPerformed

  private void btLeiameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLeiameActionPerformed
    FrameLeiame leiame = new FrameLeiame();
    leiame.setVisible(true);
  }//GEN-LAST:event_btLeiameActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MenuFrame().setVisible(true);
            }
        });
    }
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btCompetencia;
  private javax.swing.JButton btConfigura;
  private javax.swing.JButton btGerarBpa;
  private javax.swing.JButton btLeiame;
  private javax.swing.JButton btSair;
  private javax.swing.JButton btSobre;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JToolBar jToolBar1;
  // End of variables declaration//GEN-END:variables
}
