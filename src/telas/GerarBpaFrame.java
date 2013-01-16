package telas;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Bpa;
import model.Competencia;
import model.Unidade;
import utilitarios.FileUtil;
import utilitarios.Funcoes;
import utilitarios.Utilities;

public class GerarBpaFrame extends javax.swing.JDialog {

  public static String os = System.getProperty("os.name");
  public static String codCNES = null;
  String arq_bpa = null;
  String arq_log = null;
  String localBPA = null;
  String localLog = null;
  String msg_gerado = null;
  String controle = null;
  String cabecalho = null;
  ResultSet result = null;
  int nRec = 0;
  int nFolha = 0;
  int nLinha = 0;
  String prd_folha = null;
  String prd_linha = null;
  String linha = null;
  String prd_ident = null;
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
  String prd_caten = null;
  String prd_naut = Utilities.padRight(" ", 13);
  String prd_nmpac = Utilities.padRight(" ", 13);
  String prd_dtnasc = Utilities.padRight(" ", 8);
  String prd_raca = null;
  String prd_etnia = null;
  String prd_nac = null;
  String cns_prf_1 = null;
  String cns_prf_2 = null;

  public static String ConfiguraLocalBpa() throws IOException {
    String loc_bpa = "";
    String loc_base = new File(".").getCanonicalPath();
    if (os.equals("Linux")) {
      loc_bpa = loc_base + "/bpa/";
    } else {
      loc_bpa = loc_base + "\\bpa\\";
    }
    return loc_bpa;
  }

  public static String ConfiguraLocalLog() throws IOException {
    String loc_log = "";
    String loc_base = new File(".").getCanonicalPath();
    if (os.equals("Linux")) {
      loc_log = loc_base + "/log/";
    } else {
      loc_log = loc_base + "\\log\\";
    }
    return loc_log;
  }

  public GerarBpaFrame(java.awt.Frame parent, boolean modal) throws SQLException, IOException {
    super(parent, modal);
    initComponents();
    localBPA = ConfiguraLocalBpa();
    localLog = ConfiguraLocalLog();
    lblLocalBpa.setText(localBPA);
    lblLocalLog.setText(localLog);
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPanel1 = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    lblCnes = new javax.swing.JLabel();
    jLabel6 = new javax.swing.JLabel();
    jLabel7 = new javax.swing.JLabel();
    btSelecionaUnidade = new javax.swing.JButton();
    jPanel2 = new javax.swing.JPanel();
    jLabel8 = new javax.swing.JLabel();
    jLabel9 = new javax.swing.JLabel();
    lblLocalBpa = new javax.swing.JLabel();
    lblLocalLog = new javax.swing.JLabel();
    jLabel10 = new javax.swing.JLabel();
    lblArquivoBPA = new javax.swing.JLabel();
    jPanel3 = new javax.swing.JPanel();
    btExportar = new javax.swing.JButton();
    btCancelar = new javax.swing.JButton();
    lblStatus = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("Exportar BPA");

    jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Parâmetros", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
    jPanel1.setFont(new java.awt.Font("Andale Mono", 0, 14));

    jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14));
    jLabel1.setText("Código:");

    jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14));
    jLabel2.setText(" ");

    jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14));
    jLabel4.setText("Cnes:");

    lblCnes.setFont(new java.awt.Font("Tahoma", 0, 14));
    lblCnes.setText(" ");

    jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14));
    jLabel6.setText("Estabelecimento:");

    jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14));
    jLabel7.setText(" ");

    btSelecionaUnidade.setFont(new java.awt.Font("Andale Mono", 0, 14));
    btSelecionaUnidade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/filter.gif"))); // NOI18N
    btSelecionaUnidade.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btSelecionaUnidadeActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(12, 12, 12)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(jLabel1)
            .addGap(14, 14, 14)
            .addComponent(jLabel2)
            .addGap(68, 68, 68)
            .addComponent(jLabel4)
            .addGap(13, 13, 13)
            .addComponent(lblCnes)
            .addGap(306, 306, 306)
            .addComponent(btSelecionaUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(jLabel6)
            .addGap(30, 30, 30)
            .addComponent(jLabel7))))
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(btSelecionaUnidade)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(11, 11, 11)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabel1)
              .addComponent(jLabel2)
              .addComponent(jLabel4)
              .addComponent(lblCnes))))
        .addGap(9, 9, 9)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel6)
          .addComponent(jLabel7)))
    );

    jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Destino do Arquivo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
    jPanel2.setFont(new java.awt.Font("Tahoma", 0, 14));

    jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14));
    jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    jLabel8.setText("Local do Bpa:");
    jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

    jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14));
    jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    jLabel9.setText("Local do Log:");
    jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

    lblLocalBpa.setFont(new java.awt.Font("Tahoma", 0, 14));
    lblLocalBpa.setText("LOCAL BPA");
    lblLocalBpa.setName(""); // NOI18N

    lblLocalLog.setFont(new java.awt.Font("Tahoma", 0, 14));
    lblLocalLog.setText("LOCAL LOG");

    jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14));
    jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    jLabel10.setText("Arquivo BPA:");
    jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

    lblArquivoBPA.setFont(new java.awt.Font("Tahoma", 0, 14));
    lblArquivoBPA.setText("ARQUIVO BPA");

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addGap(4, 4, 4)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(15, 15, 15)
            .addComponent(lblLocalBpa))
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(15, 15, 15)
            .addComponent(lblArquivoBPA))
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(15, 15, 15)
            .addComponent(lblLocalLog)))
        .addContainerGap(359, Short.MAX_VALUE))
    );
    jPanel2Layout.setVerticalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addGap(7, 7, 7)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel8)
          .addComponent(lblLocalBpa))
        .addGap(23, 23, 23)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel10)
          .addComponent(lblArquivoBPA))
        .addGap(23, 23, 23)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel9)
          .addComponent(lblLocalLog)))
    );

    jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
    jPanel3.setFont(new java.awt.Font("Andale Mono", 0, 14));
    jPanel3.setPreferredSize(new java.awt.Dimension(580, 30));

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

    btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cancelar.PNG"))); // NOI18N
    btCancelar.setText("Cancelar");
    btCancelar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btCancelarActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel3Layout.createSequentialGroup()
        .addGap(309, 309, 309)
        .addComponent(btExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(5, 5, 5)
        .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
    );
    jPanel3Layout.setVerticalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(btExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
      .addComponent(btCancelar)
    );

    lblStatus.setText(" ");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(10, 10, 10)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGroup(layout.createSequentialGroup()
            .addGap(10, 10, 10)
            .addComponent(lblStatus))
          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)))
        .addContainerGap(14, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(10, 10, 10)
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(10, 10, 10)
        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(20, 20, 20)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(lblStatus)))
    );

    java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    setBounds((screenSize.width-614)/2, (screenSize.height-354)/2, 614, 354);
  }// </editor-fold>//GEN-END:initComponents

    private void btExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExportarActionPerformed
      if (Competencia.getAno() != null) {
        if ((lblCnes.getText() == null) || ("".equals(lblCnes.getText()))) {
          Funcoes.erro("Nenhum Estabelecimento Selecionado!");
          return;
        }
        int ano = Integer.parseInt(Competencia.getAno());
        int mes = Integer.parseInt(Competencia.getMes());
        String str_mes = String.format("%02d", mes);
        String str_ano = String.valueOf(ano);
        String ups = Unidade.getCnes();
        String nome_ups = Funcoes.ajustaNome(Unidade.getNome());
        String sigla_ups = Utilities.padRight(ups.substring(0, 6), 6);
        String cnpj = Unidade.getCnpj();
        String org_destino = Utilities.padRight("SECRETARIA MUNICIPAL DE SAUDE", 40);
        String in_org_destino = "M";
        String versao = Utilities.padRight("VER1.0.7", 10);
        Funcoes.zeraTXT(arq_bpa);
        Funcoes.zeraTXT(arq_log);
        Funcoes.gravaLog(Utilities.dataCompleta() + " Checando se existem boletos confirmados ...\n", arq_log);
        try {
          boolean retorno = Bpa.PossuiDados(mes, ano, ups);
          if (retorno) {
            Funcoes.gravaLog(Utilities.dataCompleta() + " Gerando campo de Controle ...\n", arq_log);
            controle = Bpa.GeraCampoControle(mes, ano, ups);
            Funcoes.gravaLog(Utilities.dataCompleta() + " Gerando campo de Controle ...\n", arq_log);
            nFolha = 1;
            nLinha = 1;
            cabecalho = "#BPA#" + str_ano + str_mes + controle + nome_ups + sigla_ups + cnpj + org_destino + in_org_destino + versao + "\n";
            Funcoes.gravaLog(Utilities.dataCompleta() + " Gravando Procedimentos SEM Idade ...\n", arq_log);
            Funcoes.gravaTXT(cabecalho, arq_bpa);
            result = Bpa.gerarBPASemIdade(mes, ano, ups);
            result.last();
            nRec = result.getRow();
            result.beforeFirst();
            if (nRec > 0) {
              while (result.next()) {
                prd_folha = String.format("%03d", nFolha);
                prd_linha = String.format("%02d", nLinha);
                prd_ident = result.getString("ident");
                prd_cnes = result.getString("cnes");
                prd_cmp = result.getString("ano") + result.getString("mes");
                prd_cbo = result.getString("cbo");
                prd_pa = result.getString("cod_prc");
                prd_qtd = result.getString("quantidade");
                linha = prd_ident + prd_cnes + prd_cmp + prd_cnsmed + prd_cbo + prd_dtaten + prd_folha + prd_linha + prd_pa + Utilities.padRight(" ", 26) + prd_idade + prd_qtd + Utilities.padRight(" ", 2) + prd_naut + "BPA" + Utilities.padRight(" ", 38) + "C" + "\n";
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
            result = Bpa.gerarBPAComIdade(mes, ano, ups);
            result.last();
            nRec = result.getRow();
            result.beforeFirst();
            if (nRec > 0) {
              while (result.next()) {
                prd_folha = String.format("%03d", nFolha);
                prd_linha = String.format("%02d", nLinha);
                prd_ident = result.getString("ident");
                prd_cnes = result.getString("cnes");
                prd_cmp = result.getString("ano") + result.getString("mes");
                prd_cbo = result.getString("cbo");
                prd_pa = result.getString("cod_prc");
                prd_idade = result.getString("idade");
                prd_qtd = result.getString("quantidade");
                linha = prd_ident + prd_cnes + prd_cmp + prd_cnsmed + prd_cbo + prd_dtaten + prd_folha + prd_linha + prd_pa + Utilities.padRight(" ", 26) + prd_idade + prd_qtd + Utilities.padRight(" ", 2) + prd_naut + "BPA" + Utilities.padRight(" ", 38) + "C" + "\n";
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
            result = Bpa.gerarBPAIndividualizado(mes, ano, ups);
            nFolha = 1;
            nLinha = 1;
            result.last();
            nRec = result.getRow();
            result.beforeFirst();
            if (nRec > 0) {
              while (result.next()) {
                if ("".equals(result.getString("cns_prof"))) {
                  msg_gerado = "Atenção: Encontrados Profissionais SEM CNS!\nSua produção PODERÁ ser rejeitada no SIA \n\nRotina de Geração do BPA Concluída";
                } else {
                  msg_gerado = "Rotina de Geração do BPA Concluída\n\nCampo de Controle: ";
                }
                if ((cns_prf_1 != null && cns_prf_2 != null) && cns_prf_1.compareTo(cns_prf_2) > 0) {
                  nLinha = 1;
                  nFolha += 1;
                }
                prd_ident = result.getString("ident");
                prd_cnes = result.getString("cnes");
                prd_cmp = result.getString("ano_mes");
                prd_cnsmed = "".equals(result.getString("cns_prof")) ? Utilities.padRight(" ", 15) : result.getString("cns_prof");
                cns_prf_1 = "".equals(result.getString("cns_prof")) ? Utilities.padRight(" ", 15) : result.getString("cns_prof");
                prd_cbo = result.getString("cbo");
                prd_dtaten = result.getString("data_atend");
                prd_folha = String.format("%03d", nFolha);
                prd_linha = String.format("%02d", nLinha);
                prd_pa = result.getString("cod_prc");
                prd_cnspac = result.getString("cns_pac") == null ? Utilities.padRight(" ", 15) :  (result.getString("cns_pac").length() <= 15 ? Utilities.padRight(result.getString("cns_pac"), 15) : result.getString("cns_pac").substring(0, 15));
                prd_sexo = result.getString("sexo_pac");
                prd_ibge = result.getString("ibge");
                prd_cid = result.getString("cid10") == null ? Utilities.padRight(" ", 4) : Utilities.padRight(result.getString("cid10"), 4);
                prd_idade = result.getString("idade");
                prd_qtd = result.getString("quantidade");
                prd_caten = result.getString("caten");
                prd_naut = result.getString("autorizacao");
                prd_nmpac = (result.getString("nome_paciente").length() <= 30) ? Utilities.padRight(result.getString("nome_paciente"), 30) : result.getString("nome_paciente").substring(0, 30);
                prd_dtnasc = result.getString("data_nasc");
                prd_raca = result.getString("raca_cor");
                prd_etnia = prd_raca.equals("05") ? "0001" : Utilities.padRight(" ", 4);
                prd_nac = result.getString("prd_nac");

                linha = prd_ident + prd_cnes + prd_cmp + prd_cnsmed + prd_cbo + prd_dtaten + prd_folha + prd_linha + prd_pa + prd_cnspac + prd_sexo + prd_ibge + prd_cid + prd_idade + prd_qtd + prd_caten + prd_naut + "BPA" + prd_nmpac + prd_dtnasc + "I" + prd_raca + prd_etnia + prd_nac + "\n";
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
            String xcontrole = controle.substring(12);
            FileUtil util = new FileUtil();
            util.removeLineFromFile(arq_bpa, "\n");
            JOptionPane.showMessageDialog(null, msg_gerado + "\n\nCampo de Controle: " + xcontrole);
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
      try {
        UnidadeFrame unidade = new UnidadeFrame(null, true);
        unidade.setTitle("Selecionar Estabelecimento");
        unidade.setVisible(true);
        String nome_unidade = Unidade.getNome().length() <= 40 ? Unidade.getNome() : Unidade.getNome().substring(0, 40);
        jLabel2.setText(Unidade.getCodigo());
        lblCnes.setText(Unidade.getCnes());
        jLabel7.setText(nome_unidade);

        arq_bpa = ConfiguraLocalBpa() + "PA" + Unidade.getCnes().substring(0, 6) + Funcoes.geraExtensao();
        arq_log = ConfiguraLocalLog() + "PA" + Unidade.getCnes().substring(0, 6) + ".LOG";

        lblArquivoBPA.setText("PA" + Unidade.getCnes().substring(0, 6) + Funcoes.geraExtensao());
      } catch (IOException ex) {
        Logger.getLogger(GerarBpaFrame.class.getName()).log(Level.SEVERE, null, ex);
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
          try {
            dialog = new GerarBpaFrame(new javax.swing.JFrame(), true);
          } catch (IOException ex) {
            Logger.getLogger(GerarBpaFrame.class.getName()).log(Level.SEVERE, null, ex);
          }
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
  private javax.swing.JLabel jLabel10;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JLabel jLabel8;
  private javax.swing.JLabel jLabel9;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JPanel jPanel3;
  private javax.swing.JLabel lblArquivoBPA;
  private javax.swing.JLabel lblCnes;
  private javax.swing.JLabel lblLocalBpa;
  private javax.swing.JLabel lblLocalLog;
  private javax.swing.JLabel lblStatus;
  // End of variables declaration//GEN-END:variables
}
