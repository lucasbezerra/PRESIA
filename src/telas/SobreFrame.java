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

        jLabel1.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel1.setText("Protocolo.:");

        jLabel2.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel2.setText("Host/Banco:");

        jLabel4.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel4.setText("Usuário...:");

        jLabel5.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel5.setText("Senha....:");

        jLabel6.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel6.setText("Utilizado.:");

        jLabel7.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel7.setText("a");

        jLabel8.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel8.setText("a");

        jLabel10.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel10.setText("a");

        jLabel11.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel11.setText("a");

        jLabel12.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel12.setText("a");

        jLabel13.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel13.setText("Expira...:");

        jLabel14.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel14.setText("a");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/remove-24x24.png"))); // NOI18N
        jButton1.setText("Fechar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabel7)
                .addGap(130, 130, 130)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jLabel8))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabel10)
                .addGap(130, 130, 130)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel11))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabel12)
                .addGap(130, 130, 130)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel14))
            .addGroup(layout.createSequentialGroup()
                .addGap(370, 370, 370)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel8)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel7))))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel10)
                    .addComponent(jLabel5)
                    .addComponent(jLabel11))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addGap(50, 50, 50)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

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
