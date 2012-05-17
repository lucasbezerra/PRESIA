package telas;

import apsia.Criptografia;
import java.util.ArrayList;
import utilitarios.ReadWritePropertiesFile;

/**
 * @author Luciano
 */
public class SobreFrame extends javax.swing.JFrame {

    ArrayList<String> configuracao = new ArrayList<String>();

    private static String[] lerDatas() {
        String licenca = Criptografia.DecriptaBase64(ReadWritePropertiesFile.ReadProperty("licence.properties", "Licence"));
        String[] array = new String[2];
        array[0] = licenca.substring(10, 12) + "/" + licenca.substring(12, 14) + "/" + licenca.substring(14, 18);
        array[1] = licenca.substring(28, 30) + "/" + licenca.substring(30, 32) + "/" + licenca.substring(32, 36);
        return array;
    }

    private void lerConfiguracao() {
        configuracao.clear();
        configuracao.add(Criptografia.DecriptaBase64(ReadWritePropertiesFile.ReadProperty("database.properties", "Protocolo")));
        configuracao.add(Criptografia.DecriptaBase64(ReadWritePropertiesFile.ReadProperty("database.properties", "Host")));
        configuracao.add(Criptografia.DecriptaBase64(ReadWritePropertiesFile.ReadProperty("database.properties", "Banco")));
        configuracao.add(Criptografia.DecriptaBase64(ReadWritePropertiesFile.ReadProperty("database.properties", "Usuario")));
        configuracao.add(Criptografia.DecriptaBase64(ReadWritePropertiesFile.ReadProperty("database.properties", "Senha")));
        String datas[] = lerDatas();
        configuracao.add(datas[0]);
        configuracao.add(datas[1]);
    }

    private void preencheDados() {
        lerConfiguracao();
        String prot = configuracao.get(0);
        String host = configuracao.get(1);
        String banc = configuracao.get(2);
        String user = configuracao.get(3);
        String pass = configuracao.get(4);
        String ulti = configuracao.get(5);
        String expi = configuracao.get(6);
        jLabel7.setText(prot);
        jLabel8.setText(host + "/" + banc);
        jLabel10.setText(user);
        jLabel11.setText(pass);
        jLabel12.setText(ulti);
        jLabel14.setText(expi);
    }

    public SobreFrame() {
        initComponents();
        preencheDados();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sobre o Sistema ...");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel1.setText("Protocolo.:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 12, 80, -1));

        jLabel2.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel2.setText("Host/Banco:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 10, 78, -1));

        jLabel4.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel4.setText("Usuário...:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 80, -1));

        jLabel5.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel5.setText("Senha....:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 50, 75, -1));

        jLabel6.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel6.setText("Utilizado.:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 96, 80, -1));

        jLabel7.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel7.setText("a");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 12, -1, -1));

        jLabel8.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel8.setText("a");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, -1, -1));

        jLabel10.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel10.setText("a");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 50, -1, -1));

        jLabel11.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel11.setText("a");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, -1, -1));

        jLabel12.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel12.setText("a");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 96, -1, -1));

        jLabel13.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel13.setText("Expira...:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 96, 75, -1));

        jLabel14.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel14.setText("a");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 96, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/remove-24x24.png"))); // NOI18N
        jButton1.setText("Fechar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 160, 120, 30));

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-519)/2, (screenSize.height-234)/2, 519, 234);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new SobreFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables
}
