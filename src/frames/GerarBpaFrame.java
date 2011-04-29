package frames;

import apsia.Criptografia;
import model.Unidade;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Bpa;
import model.Competencia;
import utilitarios.FileUtil;
import utilitarios.Funcoes;
import utilitarios.ReadWritePropertiesFile;
import utilitarios.Utilities;

public class GerarBpaFrame extends javax.swing.JDialog {

  public static String os = System.getProperty("os.name");
  public static String localBPA = null;
  public static String localLOG = null;
  public static String codCNES = null;
  String controle = null;
  String cabecalho = null;
  ResultSet result = null;
  int nRec = 0;
  int nFolha = 0;
  int nLinha = 0;
  String prd_folha = null;
  String prd_linha = null;
  String linha = null;
  String prd_cnes = null;
  String prd_cmp = null;
  String prd_cnsmed = Utilities.padRight(" ", 15);
  String prd_cbo = null;
  String prd_dtaten = Utilities.padRight(" ", 8);
  
  String prd_pa = null;
  String prd_cnspac = Utilities.padRight(" ", 15);
  String prd_sexo = " ";
  String prd_ibge = Utilities.padRight(" ", 6);
  String prd_cid = Utilities.padRight(" ", 4);
  String prd_idade = Utilities.padRight(" ", 3);
  String prd_qtd = null;
  String prd_caten = Utilities.padRight(" ", 2);
  String prd_naut = Utilities.padRight(" ", 13);
  String prd_nmpac = Utilities.padRight(" ", 13);
  String prd_dtnasc = Utilities.padRight(" ", 8);
  
  String prd_raca = null;
  String prd_etnia = Utilities.padRight(" ", 4);
  String prd_nac = null;
  String cns_prf_1 = null;
  String cns_prf_2 = null;
  
  public static ArrayList<String> configuracao = new ArrayList<String>();

  public static void lerVariaveis() {
    configuracao.clear();
    configuracao.add(Criptografia.DecriptaBase64(ReadWritePropertiesFile.ReadProperty("config.properties", "PastaBpa")));
    configuracao.add(Criptografia.DecriptaBase64(ReadWritePropertiesFile.ReadProperty("config.properties", "PastaLog")));
  }

  public static String ConfiguraLocalBpa() {
    String loc_bpa = null;
    lerVariaveis();
    if (os.equals("Linux")) {
      loc_bpa = configuracao.get(0) + "/PA" + Unidade.getCnes().substring(0, 6) + Funcoes.geraExtensao();
    } else {
      loc_bpa = configuracao.get(0) + "\\PA" + Unidade.getCnes().substring(0, 6) + Funcoes.geraExtensao();
    }
    return loc_bpa;
  }

  public static String ConfiguraLocalLog() {
    String loc_log = null;
    lerVariaveis();
    if (os.equals("Linux")) {
      loc_log = configuracao.get(1) + "/PA" + Unidade.getCnes().substring(0, 6) + ".LOG";
    } else {
      loc_log = configuracao.get(1) + "\\PA" + Unidade.getCnes().substring(0, 6) + ".LOG";
    }
    return loc_log;
  }

  public GerarBpaFrame(java.awt.Frame parent, boolean modal) throws SQLException {
    super(parent, modal);
    initComponents();
    lerVariaveis();
    localBPA = configuracao.get(0);
    lblBpa.setText(localBPA);
    localLOG = configuracao.get(1);
    lblLog.setText(localLOG);
  }

  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btSelecionaUnidade = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblBpa = new javax.swing.JLabel();
        lblLog = new javax.swing.JLabel();
        lblUnidade = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btExportar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        lblStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Exportar BPA");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Parâmetros"));
        jPanel1.setFont(new java.awt.Font("Andale Mono", 0, 14));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Andale Mono", 0, 14));
        jLabel1.setText("Código:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 21, -1, -1));

        jLabel2.setFont(new java.awt.Font("Andale Mono", 0, 14));
        jLabel2.setText(" ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 21, -1, -1));

        jLabel4.setFont(new java.awt.Font("Andale Mono", 0, 14));
        jLabel4.setText("Cnes:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 21, -1, -1));

        jLabel5.setFont(new java.awt.Font("Andale Mono", 0, 14));
        jLabel5.setText(" ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 21, -1, -1));

        jLabel6.setFont(new java.awt.Font("Andale Mono", 0, 14));
        jLabel6.setText("Estabelecimento:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 49, -1, -1));

        jLabel7.setFont(new java.awt.Font("Andale Mono", 0, 14));
        jLabel7.setText(" ");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 49, -1, -1));

        btSelecionaUnidade.setFont(new java.awt.Font("Andale Mono", 0, 14));
        btSelecionaUnidade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/filter.gif"))); // NOI18N
        btSelecionaUnidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSelecionaUnidadeActionPerformed(evt);
            }
        });
        jPanel1.add(btSelecionaUnidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, 52, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 580, 80));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Seletores"));
        jPanel2.setFont(new java.awt.Font("Andale Mono", 0, 14));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Andale Mono", 0, 14));
        jLabel3.setText("Unidade:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 27, -1, -1));

        jLabel8.setFont(new java.awt.Font("Andale Mono", 0, 14));
        jLabel8.setText("Bpa:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 75, -1, -1));

        jLabel9.setFont(new java.awt.Font("Andale Mono", 0, 14));
        jLabel9.setText("Log:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 123, -1, -1));

        lblBpa.setText(" ");
        jPanel2.add(lblBpa, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 75, -1, -1));

        lblLog.setText(" ");
        jPanel2.add(lblLog, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 123, -1, -1));
        jPanel2.add(lblUnidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 27, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 580, 160));

        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel3.setFont(new java.awt.Font("Andale Mono", 0, 14));
        jPanel3.setPreferredSize(new java.awt.Dimension(580, 30));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btExportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Exportar.PNG"))); // NOI18N
        btExportar.setText("Exportar");
        btExportar.setMaximumSize(new java.awt.Dimension(80, 25));
        btExportar.setMinimumSize(new java.awt.Dimension(80, 25));
        btExportar.setPreferredSize(new java.awt.Dimension(80, 25));
        btExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExportarActionPerformed(evt);
            }
        });
        jPanel3.add(btExportar, new org.netbeans.lib.awtextra.AbsoluteConstraints(301, 1, 125, 30));

        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cancelar.PNG"))); // NOI18N
        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });
        jPanel3.add(btCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(432, 1, 125, 30));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 570, 35));

        lblStatus.setText(" ");
        getContentPane().add(lblStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-598)/2, (screenSize.height-390)/2, 598, 390);
    }// </editor-fold>//GEN-END:initComponents

    private void btExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExportarActionPerformed
      if (Competencia.getAno() != null) {
        if ((lblUnidade.getText() == null) || ("".equals(lblUnidade.getText()))) {
          Funcoes.erro("Nenhum Estabelecimento Selecionado!");
          return;
        }

        String ano = Competencia.getAno();
        int mes = Integer.parseInt(Competencia.getMes());
        String str_mes = String.format("%02d", mes);
        String ups = Unidade.getCnes();
        String nome_ups = Funcoes.ajustaNome(Unidade.getNome());
        String sigla_ups = Utilities.padRight(ups.substring(0, 6), 6);
        String cnpj = Unidade.getCnpj();
        String org_destino = Utilities.padRight("SECRETARIA MUNICIPAL DE SAUDE", 40);
        String in_org_destino = "M";
        String versao = Utilities.padRight("VER1.0.5", 10);
        String arq_bpa = ConfiguraLocalBpa();
        String arq_log = ConfiguraLocalLog();
        Funcoes.zeraTXT(arq_bpa);
        Funcoes.zeraTXT(arq_log);
        Funcoes.gravaLog(Utilities.dataCompleta() + " Checando se existem boletos confirmados ...\n", arq_log);
        try {
          boolean retorno = Bpa.PossuiDados();
          if (retorno) {
            Funcoes.gravaLog(Utilities.dataCompleta() + " Gerando campo de Controle ...\n", arq_log);
            controle = Bpa.GeraCampoControle();
            Funcoes.gravaLog(Utilities.dataCompleta() + " Gravando o Cabeçalho do Arquivo ...\n", arq_log);
            nFolha = 1;
            nLinha = 1;
            cabecalho = "#BPA#" + ano + str_mes + controle + nome_ups + sigla_ups + cnpj + org_destino + in_org_destino + versao + "\n";
            Funcoes.gravaLog(Utilities.dataCompleta() + " Gravando Procedimentos SEM Idade ...\n", arq_log);
            Funcoes.gravaTXT(cabecalho, arq_bpa);
            result = Bpa.gerarBPASemIdade();
            result.last();
            nRec = result.getRow();
            result.beforeFirst();
            if (nRec > 0) {
              while (result.next()) {
                prd_folha = String.format("%03d", nFolha);
                prd_linha = String.format("%02d", nLinha);
                prd_cnes = result.getString("cnes");
                prd_cmp = result.getString("ano") + result.getString("mes");
                prd_cbo = result.getString("cbo");
                prd_pa = result.getString("cod_prc");
                prd_qtd = result.getString("quantidade");
                linha = prd_cnes + prd_cmp + prd_cnsmed + prd_cbo + prd_dtaten + prd_folha + prd_linha + prd_pa + Utilities.padRight(" ", 26) + prd_idade + prd_qtd + prd_caten + prd_naut + "BPA" + Utilities.padRight(" ", 38) + "C" + "\n";
                Funcoes.gravaTXT(linha, arq_bpa);
                if (nLinha == 20) {
                  nLinha = 1;
                  nFolha += 1;
                } else {
                  nLinha += 1;
                }
              }
            }
            Funcoes.gravaLog(Utilities.dataCompleta() + " Gravando Procedimentos COM Idade ...\n", arq_log);
            result = Bpa.gerarBPAComIdade();
            result.last();
            nRec = result.getRow();
            result.beforeFirst();
            if (nRec > 0) {
              while (result.next()) {
                prd_folha = String.format("%03d", nFolha);
                prd_linha = String.format("%02d", nLinha);
                prd_cnes = result.getString("cnes");
                prd_cmp = result.getString("ano") + result.getString("mes");
                prd_cbo = result.getString("cbo");
                prd_pa = result.getString("cod_prc");
                prd_idade = result.getString("idade");
                prd_qtd = result.getString("quantidade");
                linha = prd_cnes + prd_cmp + prd_cnsmed + prd_cbo + prd_dtaten + prd_folha + prd_linha + prd_pa + Utilities.padRight(" ", 26) + prd_idade + prd_qtd + prd_caten + prd_naut + "BPA" + Utilities.padRight(" ", 38) + "C" + "\n";
                Funcoes.gravaTXT(linha, arq_bpa);
                if (nLinha == 20) {
                  nLinha = 1;
                  nFolha += 1;
                } else {
                  nLinha += 1;
                }
              }
            }
            Funcoes.gravaLog(Utilities.dataCompleta() + " Gravando Procedimentos Individualizados ...\n", arq_log);
            result = Bpa.gerarBPAIndividualizado();
            nFolha = 1;
            nLinha = 1;
            result.last();
            nRec = result.getRow();
            result.beforeFirst();
            if (nRec > 0) {
              while (result.next()) {
                if ((cns_prf_1 != null && cns_prf_2 != null) && cns_prf_1.compareTo(cns_prf_2) > 0) {
                  nLinha = 1;
                  nFolha += 1;
                }
                prd_cnes = result.getString("cnes");
                prd_cmp = result.getString("ano_mes");
                prd_cnsmed = result.getString("cns_prof");
                cns_prf_1 = result.getString("cns_prof");
                prd_cbo = result.getString("cbo");
                prd_dtaten = result.getString("data_atend");
                prd_folha = String.format("%03d", nFolha);
                prd_linha = String.format("%02d", nLinha);
                prd_pa = result.getString("cod_prc");
                prd_cnspac = result.getString("cns_pac") == null ? Utilities.padRight(" ", 15) : result.getString("cns_pac");
                prd_sexo = result.getString("sexo_pac");
                prd_ibge = result.getString("ibge");
                prd_cid = result.getString("cid10") == null ? Utilities.padRight(" ", 4) : Utilities.padRight(result.getString("cid10"), 4);
                prd_idade = result.getString("idade");
                prd_qtd = result.getString("quantidade");
                prd_naut = result.getString("autorizacao");
                prd_nmpac = (result.getString("nome_paciente").length() <= 30) ? Utilities.padRight(result.getString("nome_paciente"), 30) : result.getString("nome_paciente").substring(0, 30);
                prd_dtnasc = result.getString("data_nasc");
                prd_raca = result.getString("raca_cor");
                prd_nac = result.getString("prd_nac");

                linha = prd_cnes + prd_cmp + prd_cnsmed + prd_cbo + prd_dtaten + prd_folha + prd_linha + prd_pa + prd_cnspac + prd_sexo + prd_ibge + prd_cid + prd_idade + prd_qtd + prd_caten + prd_naut + "BPA" + prd_nmpac + prd_dtnasc + "I" + prd_raca + prd_etnia + prd_nac + "\n";
                Funcoes.gravaTXT(linha, arq_bpa);
                if (nLinha == 20) {
                  nLinha = 1;
                  nFolha += 1;
                } else {
                  nLinha += 1;
                }
                cns_prf_2 = result.getString("cns_prof");
              }
            }
            FileUtil util = new FileUtil();
            util.removeLineFromFile(arq_bpa, "\n");
            JOptionPane.showMessageDialog(null, "Rotina de Geração do BPA Concluída");
            Funcoes.gravaLog(Utilities.dataCompleta() + " Gravação Finalizada: " + arq_bpa, arq_log);
          } else {
            JOptionPane.showMessageDialog(null, "Sem dados para geração do BPA.");
          }
        } catch (SQLException erro) {
          JOptionPane.showMessageDialog(null, "Erro no Método: " + erro);
        }
      } else {
        JOptionPane.showMessageDialog(this, "Nenhuma Competência Definida!");
        this.dispose();
      }
    }//GEN-LAST:event_btExportarActionPerformed

    private void btSelecionaUnidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSelecionaUnidadeActionPerformed
      UnidadeFrame unidade = new UnidadeFrame(null, true);
      unidade.setTitle("Selecionar Estabelecimento");
      unidade.setVisible(true);
      String nome_unidade = Unidade.getNome();
      jLabel2.setText(Unidade.getCodigo());
      jLabel5.setText(Unidade.getCnes());
      if (nome_unidade.length() <= 40) {
        lblUnidade.setText(Unidade.getNome());
        jLabel7.setText(Unidade.getNome());
      } else {
        lblUnidade.setText(Unidade.getNome().substring(0, 40));
        jLabel7.setText(Unidade.getNome().substring(0, 40));
      }
    }//GEN-LAST:event_btSelecionaUnidadeActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
      this.dispose();
    }//GEN-LAST:event_btCancelarActionPerformed

  public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {

      public void run() {
        GerarBpaFrame dialog = null;
        try {
          dialog = new GerarBpaFrame(new javax.swing.JFrame(), true);
        } catch (SQLException ex) {
          System.out.println("Erro: " + ex.getMessage());
        }
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
    private javax.swing.JButton btExportar;
    private javax.swing.JButton btSelecionaUnidade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblBpa;
    private javax.swing.JLabel lblLog;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblUnidade;
    // End of variables declaration//GEN-END:variables
}
