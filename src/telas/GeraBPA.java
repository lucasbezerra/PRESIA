package telas;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Bpa;
import model.Competencia;
import model.Unidade;
import utilitarios.FileUtil;
import utilitarios.Funcoes;
import utilitarios.Utilities;

public class GeraBPA extends javax.swing.JFrame {

  public static String os = System.getProperty("os.name");
  public static String codCNES = null;
  String arq_bpa = null;
  String arq_log = null;
  String arq_erro = null;
  String localBPA = null;
  String localLog = null;
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
  String prd_cnsmed = "";
  String cns_prof_1 = "";
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
  String prd_srv = null;
  String prd_clf = null;
  String prd_seq_eqp = Utilities.padRight(" ", 8);
  String prd_cod_are = Utilities.padRight(" ", 4);
  String prd_cnpj_opm = Utilities.padRight(" ", 14);
  String prd_cep_pct = null;
  String prd_cod_log_pct = null;
  String prd_end_log_pct = null;
  String prd_compl_log_pct = Utilities.padRight(" ", 10);
  String prd_num_log_pct = null;
  String prd_bai_log_pct = null;
  String prd_tel_pct = null;
  String prd_email_pct = Utilities.padRight(" ", 40);

  public static String ConfiguraLocalBpa() throws IOException {
    String loc_bpa;
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

  public GeraBPA() throws SQLException, IOException {
    initComponents();
    localBPA = ConfiguraLocalBpa();
    localLog = ConfiguraLocalLog();
    lblLocalBPA.setText(localBPA);
    lblLocalLOG.setText(localLog);
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPanel1 = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    lblCodigo = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    lblCnes = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    lblDescricao = new javax.swing.JLabel();
    btSelecionaUnidade = new javax.swing.JButton();
    jPanel2 = new javax.swing.JPanel();
    jLabel4 = new javax.swing.JLabel();
    lblLocalBPA = new javax.swing.JLabel();
    jLabel6 = new javax.swing.JLabel();
    lblArquivoBPA = new javax.swing.JLabel();
    jLabel8 = new javax.swing.JLabel();
    lblLocalLOG = new javax.swing.JLabel();
    jButton1 = new javax.swing.JButton();
    jButton2 = new javax.swing.JButton();
    btVerificaCNS = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setMaximumSize(new java.awt.Dimension(678, 362));
    setMinimumSize(new java.awt.Dimension(678, 362));
    setPreferredSize(new java.awt.Dimension(678, 362));
    setResizable(false);
    getContentPane().setLayout(null);

    jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("   Parâmetros   "));
    jPanel1.setMaximumSize(new java.awt.Dimension(640, 90));
    jPanel1.setPreferredSize(new java.awt.Dimension(640, 90));

    jLabel1.setText("Cod:");

    lblCodigo.setText(" ");

    jLabel2.setText("Cnes:");

    lblCnes.setText(" ");

    jLabel3.setText("Nome:");

    lblDescricao.setText(" ");

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
        .addContainerGap()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(jLabel1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(lblCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jLabel2)
            .addGap(18, 18, 18)
            .addComponent(lblCnes, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btSelecionaUnidade))
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(jLabel3)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(lblDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 268, Short.MAX_VALUE)))
        .addContainerGap())
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel1)
              .addComponent(lblCodigo)
              .addComponent(jLabel2)
              .addComponent(lblCnes)))
          .addComponent(btSelecionaUnidade))
        .addGap(18, 18, 18)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel3)
          .addComponent(lblDescricao))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    getContentPane().add(jPanel1);
    jPanel1.setBounds(10, 11, 640, 90);

    jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Destino do Arquivo")), "   Destino do Arquivo   "));
    jPanel2.setMaximumSize(new java.awt.Dimension(640, 90));
    jPanel2.setMinimumSize(new java.awt.Dimension(640, 90));
    jPanel2.setPreferredSize(new java.awt.Dimension(640, 90));

    jLabel4.setText("Local do BPA:");

    lblLocalBPA.setText(" ");

    jLabel6.setText("Arquivo BPA:");

    lblArquivoBPA.setText(" ");

    jLabel8.setText("Local do LOG:");

    lblLocalLOG.setText(" ");

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addComponent(jLabel4)
            .addGap(18, 18, 18)
            .addComponent(lblLocalBPA))
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addComponent(jLabel6)
            .addGap(18, 18, 18)
            .addComponent(lblArquivoBPA))
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addComponent(jLabel8)
            .addGap(18, 18, 18)
            .addComponent(lblLocalLOG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        .addContainerGap(527, Short.MAX_VALUE))
    );
    jPanel2Layout.setVerticalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel4)
          .addComponent(lblLocalBPA))
        .addGap(18, 18, 18)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel6)
          .addComponent(lblArquivoBPA))
        .addGap(18, 18, 18)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel8)
          .addComponent(lblLocalLOG))
        .addContainerGap(14, Short.MAX_VALUE))
    );

    getContentPane().add(jPanel2);
    jPanel2.setBounds(10, 120, 640, 130);

    jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Exportar.PNG"))); // NOI18N
    jButton1.setText("Exportar");
    jButton1.setMaximumSize(new java.awt.Dimension(80, 25));
    jButton1.setMinimumSize(new java.awt.Dimension(80, 25));
    jButton1.setPreferredSize(new java.awt.Dimension(80, 25));
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });
    getContentPane().add(jButton1);
    jButton1.setBounds(370, 260, 125, 30);

    jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cancelar.PNG"))); // NOI18N
    jButton2.setText("Cancelar");
    jButton2.setPreferredSize(new java.awt.Dimension(80, 25));
    jButton2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton2ActionPerformed(evt);
      }
    });
    getContentPane().add(jButton2);
    jButton2.setBounds(500, 260, 125, 30);

    btVerificaCNS.setText("Verifica CNS");
    btVerificaCNS.setMaximumSize(new java.awt.Dimension(80, 25));
    btVerificaCNS.setMinimumSize(new java.awt.Dimension(80, 25));
    btVerificaCNS.setPreferredSize(new java.awt.Dimension(80, 25));
    btVerificaCNS.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btVerificaCNSActionPerformed(evt);
      }
    });
    getContentPane().add(btVerificaCNS);
    btVerificaCNS.setBounds(20, 260, 125, 30);

    java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    setBounds((screenSize.width-678)/2, (screenSize.height-342)/2, 678, 342);
  }// </editor-fold>//GEN-END:initComponents

  private void btSelecionaUnidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSelecionaUnidadeActionPerformed
    try {
      UnidadeFrame unidade = new UnidadeFrame(null, true);
      unidade.setTitle("Selecionar Estabelecimento");
      unidade.setVisible(true);
      String nome_unidade = Unidade.getNome().length() <= 40 ? Unidade.getNome() : Unidade.getNome().substring(0, 40);
      lblCodigo.setText(Unidade.getCodigo());
      lblCnes.setText(Unidade.getCnes());
      lblDescricao.setText(nome_unidade);

      arq_bpa = ConfiguraLocalBpa() + "PA" + Unidade.getCnes().substring(0, 6) + Funcoes.geraExtensao();
      arq_log = ConfiguraLocalLog() + "PA" + Unidade.getCnes().substring(0, 6) + ".LOG";

      lblArquivoBPA.setText("PA" + Unidade.getCnes().substring(0, 6) + Funcoes.geraExtensao());
    } catch (IOException ex) {
      System.out.println(ex.getLocalizedMessage());
    }
  }//GEN-LAST:event_btSelecionaUnidadeActionPerformed

  private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    this.dispose();
  }//GEN-LAST:event_jButton2ActionPerformed

  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
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
      String versao = Utilities.padRight("VER1.1.1", 10);
      Funcoes.zeraTXT(arq_bpa);
      Funcoes.zeraTXT(arq_log);
      Funcoes.gravaLog(Utilities.dataCompleta() + " Checando se existem boletos confirmados ...\n", arq_log);
      try {
        Bpa bpa = new Bpa();
        boolean retorno = bpa.getPossuiDados(mes, ano, ups);
        if (retorno) {
          Funcoes.gravaLog(Utilities.dataCompleta() + " Gerando campo de Controle ...\n", arq_log);
          controle = bpa.getCampoControle(mes, ano, ups);
          Funcoes.gravaLog(Utilities.dataCompleta() + " Gerando campo de Controle ...\n", arq_log);
          nFolha = 1;
          nLinha = 1;
          cabecalho = "01#BPA#" + str_ano + str_mes + controle + nome_ups + sigla_ups + cnpj + org_destino + in_org_destino + versao + "\n";
          Funcoes.gravaLog(Utilities.dataCompleta() + " Gravando Procedimentos SEM Idade ...\n", arq_log);
          Funcoes.gravaTXT(cabecalho, arq_bpa);
          result = bpa.getSemIdade(mes, ano, ups);
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
              linha = prd_ident + prd_cnes + prd_cmp + prd_cbo + prd_folha + prd_linha + prd_pa + prd_idade + prd_qtd + "BPA" + "\n";
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
          result = bpa.getComIdade(mes, ano, ups);
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
              linha = prd_ident + prd_cnes + prd_cmp + prd_cbo + prd_folha + prd_linha + prd_pa + prd_idade + prd_qtd + "BPA" + "\n";
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
          result = bpa.getIndividualizado(mes, ano, ups);
          nFolha = 1;
          nLinha = 1;
          result.last();
          nRec = result.getRow();
          result.beforeFirst();
          if (nRec > 0) {
            nLinha = 1;
            nFolha += 1;
            while (result.next()) {
              prd_cnsmed = result.getString("cns_prof");

              if (prd_cnsmed.compareTo(cns_prof_1) > 0) {
                nFolha = 1;
                nLinha = 1;
              }
              cns_prof_1 = result.getString("cns_prof");
              prd_ident = result.getString("ident");
              prd_cnes = result.getString("cnes");
              prd_cmp = result.getString("ano_mes");
              prd_cbo = result.getString("cbo");
              prd_dtaten = result.getString("data_atend");
              prd_folha = String.format("%03d", nFolha);
              prd_linha = String.format("%02d", nLinha);
              prd_pa = result.getString("cod_prc");
              prd_cnspac = result.getString("cns_pac") == null ? Utilities.padRight(" ", 15) : (result.getString("cns_pac").length() <= 15 ? Utilities.padRight(result.getString("cns_pac"), 15) : result.getString("cns_pac").substring(0, 15));
              prd_sexo = result.getString("sexo_pac");
              prd_ibge = result.getString("ibge");
              prd_cid = result.getString("cid10") == null ? Utilities.padRight(" ", 4) : Utilities.padRight(result.getString("cid10"), 4);
              prd_idade = result.getString("idade");
              prd_qtd = result.getString("quantidade");
              prd_caten = result.getString("caten");
              prd_naut = result.getString("autorizacao");
              prd_nmpac = (result.getString("nome_paciente").length() <= 30) ? Utilities.padRight(result.getString("nome_paciente"), 30) : result.getString("nome_paciente").substring(0, 30);
              prd_dtnasc = result.getString("data_nasc");
              prd_raca = "99"; //result.getString("raca_cor");
              prd_etnia = prd_raca.equals("05") ? "0001" : Utilities.padRight(" ", 4);
              prd_nac = result.getString("prd_nac");
              prd_srv = result.getString("prd_srv");
              prd_clf = result.getString("prd_clf");
              prd_seq_eqp = result.getString("prd_seq_eqp");
              prd_cod_are = result.getString("prd_cod_are");
              prd_cnpj_opm = result.getString("prd_cnpj_opm");
              prd_cep_pct = (result.getString("prd_cep_pct").length() > 0) ? result.getString("prd_cep_pct") : Utilities.padRight(" ", 8);
              prd_cod_log_pct = result.getString("prd_cod_log_pct");
              prd_end_log_pct = result.getString("prd_end_log_pct");
              if (prd_end_log_pct == null) {
                prd_end_log_pct = Utilities.padRight(" ", 10);
              } else if (prd_end_log_pct.length() < 30) {
                prd_end_log_pct = Utilities.padRight(result.getString("prd_end_log_pct"), 30);
              } else if (prd_end_log_pct.length() > 30) {
                prd_end_log_pct = result.getString("prd_end_log_pct").substring(0, 29);
              }

              prd_compl_log_pct = result.getString("prd_compl_log_pct");
              if (prd_compl_log_pct == null) {
                prd_compl_log_pct = Utilities.padRight(" ", 10);
              } else if (prd_compl_log_pct.length() < 10) {
                prd_compl_log_pct = Utilities.padRight(result.getString("prd_compl_log_pct"), 10);
              } else if (prd_compl_log_pct.length() > 10) {
                prd_compl_log_pct = result.getString("prd_compl_log_pct").substring(0, 9);
              }

              prd_num_log_pct = Utilities.preencheCom(result.getString("prd_num_log_pct"), "0", 5, 1);
              prd_bai_log_pct = result.getString("prd_bai_log_pct");

              if (prd_bai_log_pct == null) {
                prd_bai_log_pct = Utilities.padRight(result.getString("prd_bai_log_pct"), 30);
              } else if (prd_bai_log_pct.length() < 30) {
                prd_bai_log_pct = Utilities.padRight(result.getString("prd_bai_log_pct"), 30);
              } else if (prd_bai_log_pct.length() > 30) {
                prd_bai_log_pct = result.getString("prd_bai_log_pct").substring(0, 29);
              }

              prd_tel_pct = (result.getString("prd_tel_pct") == null) ? Utilities.padRight(" ", 11) : result.getString("prd_tel_pct");
              prd_email_pct = result.getString("prd_email_pct");

              linha = prd_ident + prd_cnes + prd_cmp + prd_cnsmed + prd_cbo + prd_dtaten + prd_folha + prd_linha + prd_pa + prd_cnspac + prd_sexo + prd_ibge + prd_cid + prd_idade + prd_qtd + prd_caten + prd_naut + "BPA" + prd_nmpac + prd_dtnasc + prd_raca + prd_etnia + prd_nac + prd_srv + prd_clf + prd_seq_eqp + prd_cod_are + prd_cnpj_opm + prd_cep_pct + prd_cod_log_pct + prd_end_log_pct + prd_compl_log_pct + prd_num_log_pct + prd_bai_log_pct + prd_tel_pct + prd_email_pct + "\n";
              Funcoes.gravaTXT(linha, arq_bpa);
              if (nLinha == 20) {
                nLinha = 1;
                nFolha += 1;
              } else {
                nLinha += 1;
              }
            }
          }
          String xcontrole = controle.substring(12);
          FileUtil util = new FileUtil();
          util.removeLineFromFile(arq_bpa, "\n");
          JOptionPane.showMessageDialog(null, "Rotina de Geração do BPA Concluída\n\nCampo de Controle: " + xcontrole);
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

  }//GEN-LAST:event_jButton1ActionPerformed

  private void btVerificaCNSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVerificaCNSActionPerformed
    int ano = Integer.parseInt(Competencia.getAno());
    int mes = Integer.parseInt(Competencia.getMes());
    String ups = Unidade.getCnes();
    arq_erro = "invalidos.txt";
    if (ups == null) {
      JOptionPane.showMessageDialog(rootPane, "Unidade não definida", "Atenção", JOptionPane.INFORMATION_MESSAGE);
    } else {
      try {
        Bpa bpa = new Bpa();
        result = bpa.getInvalidos(mes, ano, ups);
        result.last();
        nRec = result.getRow();
        result.beforeFirst();
        if (nRec > 0) {
          Funcoes.zeraTXT(arq_erro);
          Funcoes.gravaErros("AUTORIZAÇÃO     PROCEDIMENTO     NOME_PACIENTE ENDERECO BAIRRO\n", arq_erro);
          Funcoes.gravaErros("=================================================================\n", arq_erro);
          while (result.next()) {
            String autorizacao = result.getString("autorizacao");
            String codigo      = result.getString("cod_prc");
            String nome        = result.getString("nome_paciente");
            String endereco    = result.getString("endereco");
            String bairro      = result.getString("bairro");
            linha = autorizacao + "  " + codigo + "  " + nome + "  " + endereco + "  " + bairro + "\n";
            Funcoes.gravaErros(linha, arq_erro);
          }
          JOptionPane.showMessageDialog(rootPane, "Relatorio Gerado!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
        } else {
          JOptionPane.showMessageDialog(rootPane, "Unidade sem dados inválidos", "Atenção", JOptionPane.INFORMATION_MESSAGE);
        }
      } catch (SQLException erro) {
        System.out.println(erro.getLocalizedMessage());
      }
    }
  }//GEN-LAST:event_btVerificaCNSActionPerformed

  public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
     * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(GeraBPA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(GeraBPA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(GeraBPA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(GeraBPA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        try {
          new GeraBPA().setVisible(true);
        } catch (SQLException | IOException ex) {
          System.out.println(ex.getLocalizedMessage());
        }
      }
    });
  }
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btSelecionaUnidade;
  private javax.swing.JButton btVerificaCNS;
  private javax.swing.JButton jButton1;
  private javax.swing.JButton jButton2;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel8;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JLabel lblArquivoBPA;
  private javax.swing.JLabel lblCnes;
  private javax.swing.JLabel lblCodigo;
  private javax.swing.JLabel lblDescricao;
  private javax.swing.JLabel lblLocalBPA;
  private javax.swing.JLabel lblLocalLOG;
  // End of variables declaration//GEN-END:variables
}
