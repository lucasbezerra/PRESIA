package frames;

import apsia.Criptografia;
import model.Unidade;
import banco.Conexao;
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Locale;
import javax.swing.JOptionPane;
import model.Bpa;
import model.Competencia;
import utilitarios.FileUtil;
import utilitarios.ReadWritePropertiesFile;

public class GerarBpaFrame extends javax.swing.JDialog {

  public static String os = System.getProperty("os.name");
  public static String localBPA = null;
  public static String localLOG = null;
  public static String codCNES = null;
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
      loc_bpa = configuracao.get(0) + "/PA" + Unidade.getCnes().substring(0, 6) + geraExtensao();
    } else {
      loc_bpa = configuracao.get(0) + "\\PA" + Unidade.getCnes().substring(0, 6) + geraExtensao();
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

  public static String agora() {
    Locale locale = new Locale("pt", "BR");
    GregorianCalendar calendar = new GregorianCalendar();
    SimpleDateFormat data = new SimpleDateFormat("dd' de 'MMMMM' de 'yyyy' - 'HH:mm:ss", locale);
    return data.format(calendar.getTime());
  }

  public static String padRight(String s, int n) {
    return String.format("%1$-" + n + "s", s);
  }

  public void gravaLog(String texto, String local) {
    String conteudo = texto;
    try {
      FileWriter x = new FileWriter(local, true);
      x.write(conteudo);
      x.close();
    } catch (Exception erro) {
      JOptionPane.showMessageDialog(null, "Erro na Gravação do Log " + erro);
    }
  }

  public void gravaTXT(String texto, String local) {
    String conteudo = texto;
    try {
      FileWriter x = new FileWriter(local, true);
      x.write(conteudo);
      x.close();
    } catch (Exception erro) {
      JOptionPane.showMessageDialog(null, "Erro: " + erro);
    }
  }

  public void zeraTXT(String txt) {
    File arq_txt = new File(txt);
    if (arq_txt.exists()) {
      arq_txt.delete();
    }
  }

  public static String geraExtensao() {
    int mes = Integer.parseInt(Competencia.getMes());
    String extensao = null;
    switch (mes) {
      case 1:
        extensao = ".JAN";
        break;
      case 2:
        extensao = ".FEV";
        break;
      case 3:
        extensao = ".MAR";
        break;
      case 4:
        extensao = ".ABR";
        break;
      case 5:
        extensao = ".MAI";
        break;
      case 6:
        extensao = ".JUN";
        break;
      case 7:
        extensao = ".JUL";
        break;
      case 8:
        extensao = ".AGO";
        break;
      case 9:
        extensao = ".SET";
        break;
      case 10:
        extensao = ".OUT";
        break;
      case 11:
        extensao = ".NOV";
        break;
      case 12:
        extensao = ".DEZ";
        break;
    }
    return extensao;
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

    btSelecionaUnidade.setFont(new java.awt.Font("Andale Mono", 0, 14)); // NOI18N
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

    lblUnidade.setText(" ");
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
          btSelecionaUnidade.doClick();
        }

        String arq_bpa = ConfiguraLocalBpa();
        String arq_log = ConfiguraLocalLog();
        zeraTXT(arq_bpa);
        zeraTXT(arq_log);
        lblStatus.setText("BPA Gravado.");
        gravaLog(agora() + " Checando se existem boletos confirmados ...\n", arq_log);
        lblStatus.setText("Checando se existem boletos confirmados ...");
        try {
          boolean retorno = Bpa.PossuiDados();
          if (retorno) {
            lblStatus.setText("Inicializando Variaveis ...");
            gravaLog(agora() + " Inicializando Variaveis ...\n", arq_log);
            String ano = Competencia.getAno();
            int mes = Integer.parseInt(Competencia.getMes());
            String str_mes = String.format("%02d", mes);
            String ups = Unidade.getCnes();
            String nome_ups = padRight(Unidade.getNome(), 30);
            String sigla_ups = padRight(ups.substring(0, 6), 6);
            String cnpj = Unidade.getCnpj();
            String org_destino = padRight("SECRETARIA MUNICIPAL DE SAUDE", 40);
            String in_org_destino = "M";
            String versao = padRight("VER1.0", 10);
            String cabecalho = null;
            ResultSet result = null;
            int nRec = 0;
            String sql_sem_idade = "select usp.cod_cnes AS CNES,c.ano_ref AS ANO, lpad(cast(c.mes_ref as varchar), 2, '0') AS MES, "
                    + "cbo.cod_cbo_ocupacao AS CBO, p.cod_proced as COD_PRC, lpad(cast(sum(d.qtde_proced) as varchar), 6, '0') as quantidade "
                    + "from cab_aut_cmr c "
                    + "inner join det_aut_cmr d on c.id_cab_aut_cmr=d.id_cab_aut_cmr "
                    + "inner join unidade_saude usp on c.id_usp=usp.id_unidade_saude "
                    + "inner join procedimento p on d.id_proced=p.id_proced "
                    + "inner join cbo_ocupacao cbo on c.id_cbo_ocupacao=cbo.id_cbo_ocupacao "
                    + "inner join proced_registro pr on c.ano_ref=pr.ano_ref and c.mes_ref=pr.mes_ref and p.id_proced=pr.id_proced "
                    + "inner join status_cmr_aut a on c.id_status_cmr_aut=a.id_status_cmr_aut "
                    + "left join proced_detalhe pd on c.ano_ref=pd.ano_ref and c.mes_ref=pd.mes_ref and p.id_proced=pd.id_proced "
                    + "left join detalhe de on pd.id_detalhe=de.id_detalhe "
                    + "where c.ano_ref=" + ano + " and c.mes_ref=" + mes + " and usp.cod_cnes='" + ups + "' and pr.id_registro=1 and ((pd.id_detalhe is null) or (pd.id_detalhe<>11)) and d.id_status_cmr_aut=1 "
                    + "group by cnes,ano,mes,cbo,COD_PRC "
                    + "order by CNES, ANO,MES,COD_PRC,CBO ";
            String sql_com_idade = "select usp.cod_cnes as CNES, c.ano_ref as ANO, lpad(cast(c.mes_ref as varchar), 2, '0') as MES, cbo.cod_cbo_ocupacao as CBO, "
                    + "p.cod_proced as cod_prc, lpad(cast(date_part('YEAR', age(current_date, pe.dta_nasc)) as varchar), 3, '0') as IDADE, "
                    + "lpad(cast(sum(d.qtde_proced) as varchar), 6, '0') as quantidade "
                    + "from cab_aut_cmr c "
                    + "inner join det_aut_cmr d on c.id_cab_aut_cmr=d.id_cab_aut_cmr "
                    + "inner join unidade_saude usp on c.id_usp = usp.id_unidade_saude "
                    + "inner join pessoa pe on c.id_pessoa = pe.id_pessoa "
                    + "inner join procedimento p on d.id_proced = p.id_proced "
                    + "inner join cbo_ocupacao cbo on c.id_cbo_ocupacao = cbo.id_cbo_ocupacao "
                    + "inner join proced_registro pr on c.ano_ref = pr.ano_ref and c.mes_ref = pr.mes_ref and p.id_proced = pr.id_proced "
                    + "inner join status_cmr_aut a on c.id_status_cmr_aut = a.id_status_cmr_aut "
                    + "left join proced_detalhe pd on c.ano_ref = pd.ano_ref and c.mes_ref = pd.mes_ref and p.id_proced = pd.id_proced "
                    + "left join detalhe de on pd.id_detalhe = de.id_detalhe "
                    + "where c.ano_ref=" + ano + " and c.mes_ref=" + mes + " and pr.id_registro = 1 and pd.id_detalhe = 11 and usp.cod_cnes = '" + ups + "' and d.id_status_cmr_aut = 1 "
                    + "group by CNES, ANO, MES, CBO, cod_prc, IDADE "
                    + "order by cnes, ano, mes, cbo, cod_prc, idade";
            String sql_individual = "select usp.cod_cnes as CNES,c.ano_ref||lpad(cast(c.mes_ref as varchar), 2, '0') as ano_mes, prof.cod_cns as CNS_PROF, cbo.cod_cbo_ocupacao as CBO,"
                    + " cast(extract(year from d.dta_marcada) as varchar)||lpad(cast(extract(month from d.dta_marcada) as varchar), 2, '0')||lpad(cast(extract(day from d.dta_marcada) as varchar), 2, '0') as DATA_ATEND,"
                    + " p.cod_proced as COD_PRC, pe.cod_cartao_sus as CNS_PAC, pe.sexo as SEXO_PAC, substring(MNC.COD_IBGE from 1 for 6) as IBGE, cid.cod_cid AS CID10,"
                    + " lpad(cast(date_part('YEAR', age(current_date, pe.dta_nasc)) as varchar), 3, '0') as idade, lpad(cast(sum(d.qtde_proced) as varchar), 6, '0') as quantidade,"
                    + " c.cod_cab_aut_cmr as AUTORIZACAO, pe.nome as nome_paciente,"
                    + " cast(extract(year from pe.dta_nasc) as varchar)||lpad(cast(extract(month from pe.dta_nasc) as varchar), 2, '0')||lpad(cast(extract(day from pe.dta_nasc) as varchar), 2, '0') as DATA_NASC,"
                    + " rc.cod_ibge_raca_cor as raca_cor"
                    + " from cab_aut_cmr c"
                    + " inner join det_aut_cmr d on c.id_cab_aut_cmr=d.id_cab_aut_cmr"
                    + " inner join unidade_saude usp on c.id_usp=usp.id_unidade_saude"
                    + " inner join profissional_v prof on c.id_prof_usp=prof.id_pessoa"
                    + " inner join pessoa pe on c.id_pessoa=pe.id_pessoa"
                    + " inner join procedimento p on d.id_proced=p.id_proced"
                    + " inner join cbo_ocupacao cbo on c.id_cbo_ocupacao=cbo.id_cbo_ocupacao"
                    + " inner join proced_registro pr on c.ano_ref=pr.ano_ref and c.mes_ref=pr.mes_ref and p.id_proced=pr.id_proced"
                    + " inner join status_cmr_aut a on c.id_status_cmr_aut=a.id_status_cmr_aut"
                    + " left join municipio mnc on PE.id_municipio_res=mnc.id_municipio"
                    + " left join cid cid on d.id_cid=cid.id_cid"
                    + " left join raca_cor rc on pe.id_raca_cor = rc.id_raca_cor"
                    + " where c.ano_ref=" + ano + " and c.mes_ref=" + mes + " and pr.id_registro=2 and usp.cod_cnes='" + ups + "' and d.id_status_cmr_aut=1"
                    + " group by cnes, ano_mes, cns_prof, cid10, cbo, data_atend, cod_prc, cns_pac, sexo_pac, ibge, idade, autorizacao, nome_paciente, data_nasc, raca_cor"
                    + " order by cns_prof, autorizacao";
            long somaProcedimentos = 0;
            long somaQuantidades = 0;
            long controle = 0;
            int numLinhas = 0;
            int numFolhas = 0;
            int nFolha = 0;
            int nLinha = 0;
            String prd_folha = null;
            String prd_linha = null;
            String linha = null;
            String prd_cnes = null;
            String prd_cmp = null;
            String prd_cnsmed = null;
            String prd_cbo = null;
            String prd_dtaten = null;
            String prd_pa = null;
            String prd_cnspac = null;
            String prd_sexo = null;
            String prd_ibge = null;
            String prd_cid = null;
            String prd_idade = null;
            String prd_qtd = null;
            String prd_caten = null;
            String prd_naut = null;
            String prd_nmpac = null;
            String prd_dtnasc = null;
            String prd_raca = null;
            String cns_prf_1 = null;
            String cns_prf_2 = null;
            lblStatus.setText("Conectando ao Banco de Dados ...");
            gravaLog(agora() + " Conectando ao Banco de Dados...\n", arq_log);
            Connection conexao = Conexao.getConexao();
            Statement stmt = null;
            try {
              stmt = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            } catch (SQLException erro) {
              JOptionPane.showMessageDialog(null, "Erro na Conexão: " + erro);
            }

            lblStatus.setText("Gerando Campo de Controle ...");
            gravaLog(agora() + " Gerando Campo de Controle ...\n", arq_log);
            result = stmt.executeQuery(sql_sem_idade);
            result.last();
            numLinhas = numLinhas + result.getRow();
            result.beforeFirst();
            while (result.next()) {
              somaProcedimentos = somaProcedimentos + result.getLong("cod_prc");
              somaQuantidades = somaQuantidades + result.getInt("quantidade");
            }
            result = stmt.executeQuery(sql_com_idade);
            result.last();
            numLinhas = numLinhas + result.getRow();
            result.beforeFirst();
            while (result.next()) {
              somaProcedimentos = somaProcedimentos + result.getLong("cod_prc");
              somaQuantidades = somaQuantidades + result.getInt("quantidade");
            }

            result = stmt.executeQuery(sql_individual);
            result.last();
            numLinhas = numLinhas + result.getRow();
            result.beforeFirst();
            while (result.next()) {
              somaProcedimentos = somaProcedimentos + result.getLong("cod_prc");
              somaQuantidades = somaQuantidades + result.getInt("quantidade");
            }
            controle = ((somaProcedimentos + somaQuantidades) % 1111);
            controle = controle + 1111;
            numFolhas = (int) ((numLinhas % 20 == 0) ? (numLinhas / 20) : (Math.ceil(numLinhas / 20)));
            gravaLog(agora() + " Gravando o Cabeçalho do Arquivo ...\n", arq_log);
            String linhas = String.format("%06d", numLinhas);
            String folhas = String.format("%06d", numFolhas);
            nFolha = 1;
            nLinha = 1;
            cabecalho = "#BPA#" + ano + str_mes + linhas + folhas + controle + nome_ups + sigla_ups + cnpj + org_destino + in_org_destino + versao + "\n";
            lblStatus.setText("Gravando Procedimentos SEM Idade...");
            gravaLog(agora() + " Gravando Procedimentos SEM Idade ...\n", arq_log);
            gravaTXT(cabecalho, arq_bpa);
            result = Bpa.gerarBPASemIdade(sql_sem_idade);
            result.last();
            nRec = result.getRow();
            result.beforeFirst();
            if (nRec > 0) {
              while (result.next()) {
                prd_folha = String.format("%03d", nFolha);
                prd_linha = String.format("%02d", nLinha);
                prd_cnes = result.getString("cnes");
                prd_cmp = result.getString("ano") + result.getString("mes");
                prd_cnsmed = padRight(" ", 15);
                prd_cbo = result.getString("cbo");
                prd_dtaten = padRight(" ", 8);
                prd_pa = result.getString("cod_prc");
                prd_cnspac = padRight(" ", 15);
                prd_sexo = " ";
                prd_ibge = padRight(" ", 6);
                prd_cid = padRight(" ", 4);
                prd_idade = padRight(" ", 3);
                prd_qtd = result.getString("quantidade");
                prd_caten = padRight(" ", 2);
                prd_naut = padRight(" ", 13);
                prd_nmpac = padRight(" ", 13);
                prd_dtnasc = padRight(" ", 8);
                linha = prd_cnes + prd_cmp + prd_cnsmed + prd_cbo + prd_dtaten + prd_folha + prd_linha + prd_pa + padRight(" ", 26) + prd_idade + prd_qtd + prd_caten + prd_naut + "BPA" + padRight(" ", 38) + "C" + "\n";
                gravaTXT(linha, arq_bpa);
                if (nLinha == 20) {
                  nLinha = 1;
                  nFolha += 1;
                } else {
                  nLinha += 1;
                }
              }
            }
            lblStatus.setText(" Gravando Procedimentos COM Idade ...");
            gravaLog(agora() + " Gravando Procedimentos COM Idade ...\n", arq_log);
            result = Bpa.gerarBPAComIdade(sql_com_idade);
            result.last();
            nRec = result.getRow();
            result.beforeFirst();
            if (nRec > 0) {
              while (result.next()) {
                prd_folha = String.format("%03d", nFolha);
                prd_linha = String.format("%02d", nLinha);
                prd_cnes = result.getString("cnes");
                prd_cmp = result.getString("ano") + result.getString("mes");
                prd_cnsmed = padRight(" ", 15);
                prd_cbo = result.getString("cbo");
                prd_dtaten = padRight(" ", 8);
                prd_pa = result.getString("cod_prc");
                prd_cnspac = padRight(" ", 15);
                prd_sexo = " ";
                prd_ibge = padRight(" ", 6);
                prd_cid = padRight(" ", 4);
                prd_idade = result.getString("idade");
                prd_qtd = result.getString("quantidade");
                prd_caten = padRight(" ", 2);
                prd_naut = padRight(" ", 13);
                prd_nmpac = padRight(" ", 13);
                prd_dtnasc = padRight(" ", 8);
                linha = prd_cnes + prd_cmp + prd_cnsmed + prd_cbo + prd_dtaten + prd_folha + prd_linha + prd_pa + padRight(" ", 26) + prd_idade + prd_qtd + prd_caten + prd_naut + "BPA" + padRight(" ", 38) + "C" + "\n";
                gravaTXT(linha, arq_bpa);
                if (nLinha == 20) {
                  nLinha = 1;
                  nFolha += 1;
                } else {
                  nLinha += 1;
                }
              }
            }
            lblStatus.setText("Gravando Procedimentos Individualizados ...");
            gravaLog(agora() + " Gravando Procedimentos Individualizados ...\n", arq_log);
            result = Bpa.gerarBPAIndividualizado(sql_individual);
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
                prd_cnspac = result.getString("cns_pac") == null ? padRight(" ", 15) : result.getString("cns_pac");
                prd_sexo = result.getString("sexo_pac");
                prd_ibge = result.getString("ibge");
                prd_cid = result.getString("cid10") == null ? padRight(" ", 4) : padRight(result.getString("cid10"), 4);
                prd_idade = result.getString("idade");
                prd_qtd = result.getString("quantidade");
                prd_caten = padRight(" ", 2);
                prd_naut = result.getString("autorizacao");
                prd_nmpac = (result.getString("nome_paciente").length() <= 30) ? padRight(result.getString("nome_paciente"), 30) : result.getString("nome_paciente").substring(0, 30);
                prd_dtnasc = result.getString("data_nasc");
                prd_raca = result.getString("raca_cor");

                linha = prd_cnes + prd_cmp + prd_cnsmed + prd_cbo + prd_dtaten + prd_folha + prd_linha + prd_pa + prd_cnspac + prd_sexo + prd_ibge + prd_cid + prd_idade + prd_qtd + prd_caten + prd_naut + "BPA" + prd_nmpac + prd_dtnasc + "I" + prd_raca + "\n";
                gravaTXT(linha, arq_bpa);
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
            lblStatus.setText("BPA Gravado.");
            gravaLog(agora() + " Gravação Finalizada: " + arq_bpa, arq_log);
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
