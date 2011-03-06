package ui;

import model.Unidade;
import banco.Conexao;
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import model.Bpa;
import model.Competencia;
import utilitarios.FileUtil;

public class GerarBpaFrame extends javax.swing.JDialog {

    public static String formataData(String data) {
        String str_data = data.substring(0, 3) + data.substring(5, 6) + data.substring(8, 9);
        return str_data;
    }

    public static String agora() {
        Locale locale = new Locale("pt", "BR");
        GregorianCalendar calendar = new GregorianCalendar();
        SimpleDateFormat data = new SimpleDateFormat("dd' de 'MMMMM' de 'yyyy' - 'HH':'mm'h'", locale);
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

    public String geraExtensao() {
        int mes = Integer.parseInt(Competencia.getMes());
        String extensao = null;
        switch (mes) {
            case 1: extensao = ".JAN"; break;
            case 2: extensao = ".FEV"; break;
            case 3: extensao = ".MAR"; break;
            case 4: extensao = ".ABR"; break;
            case 5: extensao = ".MAI"; break;
            case 6: extensao = ".JUN"; break;
            case 7: extensao = ".JUL"; break;
            case 8: extensao = ".AGO"; break;
            case 9: extensao = ".SET"; break;
            case 10: extensao = ".OUT"; break;
            case 11: extensao = ".NOV"; break;
            case 12: extensao = ".DEZ"; break;
        }
        return extensao;
    }

    public GerarBpaFrame(java.awt.Frame parent, boolean modal) throws SQLException {
        super(parent, modal);
        initComponents();
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
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        btSelecionaUnidade = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        btLocal = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btExportar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Exportar BPA");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Parâmetros"));

        jLabel1.setText("Código:");

        jLabel2.setText(" ");

        jLabel4.setText("Cnes:");

        jLabel5.setText(" ");

        jLabel6.setText("Estabelecimento:");

        jLabel7.setText(" ");

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
                        .addComponent(jLabel2)
                        .addGap(92, 92, 92)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)))
                .addContainerGap(383, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 580, 90));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Seletores"));

        jLabel3.setText("Unidade:");

        btSelecionaUnidade.setText("...");
        btSelecionaUnidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSelecionaUnidadeActionPerformed(evt);
            }
        });

        jLabel8.setText("Arquivo:");

        jTextField2.setText("C:\\SMS\\PRESIA\\BPA");
        jTextField2.setEnabled(false);

        btLocal.setText("...");
        btLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLocalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btLocal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btSelecionaUnidade, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSelecionaUnidade))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btLocal))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 580, 120));

        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel3.setPreferredSize(new java.awt.Dimension(580, 30));

        btExportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/images/Exportar.PNG"))); // NOI18N
        btExportar.setText("Exportar");
        btExportar.setMaximumSize(new java.awt.Dimension(80, 25));
        btExportar.setMinimumSize(new java.awt.Dimension(80, 25));
        btExportar.setPreferredSize(new java.awt.Dimension(80, 25));
        btExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExportarActionPerformed(evt);
            }
        });

        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/images/Cancelar.PNG"))); // NOI18N
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(302, Short.MAX_VALUE)
                .addComponent(btExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 570, 40));

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-598)/2, (screenSize.height-295)/2, 598, 295);
    }// </editor-fold>//GEN-END:initComponents

    private void btExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExportarActionPerformed
        if ((jTextField1.getText() == null) || ("".equals(jTextField1.getText()))) {
            JOptionPane.showMessageDialog(null, "Selecione um Estabelecimento!", "Erro", JOptionPane.ERROR_MESSAGE);
            jTextField1.requestFocus();
        } else {

            String arq_bpa = jTextField2.getText() + "\\PA" + Unidade.getCnes().substring(0, 6) + geraExtensao();
            String arq_log = jTextField2.getText() + "\\PA" + Unidade.getCnes().substring(0, 6) + ".LOG";
            zeraTXT(arq_bpa);
            zeraTXT(arq_log);
            try {
                boolean retorno = Bpa.PossuiDados();
                if (retorno) {
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
                    String sql_individual = "select usp.cod_cnes as CNES,c.ano_ref as ANO, lpad(cast(c.mes_ref as varchar), 2, '0') as MES, prof.cod_cns as CNS_PROF, cid.cod_cid AS CID10, "
                            + "cbo.cod_cbo_ocupacao as CBO, d.dta_marcada as DATA_ATEND, p.cod_proced as COD_PRC, pe.cod_cartao_sus as CNS_PAC, pe.sexo as SEXO_PAC, "
                            + "MNC.COD_IBGE as IBGE, lpad(cast(date_part('YEAR', age(current_date, pe.dta_nasc)) as varchar), 3, '0') as idade, rc.cod_ibge_raca_cor as raca_cor, "
                            + "c.cod_cab_aut_cmr as AUTORIZACAO, pe.nome as nome_paciente, pe.dta_nasc as DATA_NASC, lpad(cast(sum(d.qtde_proced) as varchar), 6, '0') as quantidade "
                            + "from cab_aut_cmr c "
                            + "inner join det_aut_cmr d on c.id_cab_aut_cmr=d.id_cab_aut_cmr "
                            + "inner join unidade_saude usp on c.id_usp=usp.id_unidade_saude "
                            + "inner join profissional_v prof on c.id_prof_usp=prof.id_pessoa "
                            + "inner join pessoa pe on c.id_pessoa=pe.id_pessoa "
                            + "inner join procedimento p on d.id_proced=p.id_proced "
                            + "inner join cbo_ocupacao cbo on c.id_cbo_ocupacao=cbo.id_cbo_ocupacao "
                            + "inner join proced_registro pr on c.ano_ref=pr.ano_ref and c.mes_ref=pr.mes_ref and p.id_proced=pr.id_proced "
                            + "inner join status_cmr_aut a on c.id_status_cmr_aut=a.id_status_cmr_aut "
                            + "left join municipio mnc on PE.id_municipio_res=mnc.id_municipio "
                            + "left join cid cid on d.id_cid=cid.id_cid "
                            + "left join raca_cor rc on pe.id_raca_cor = rc.id_raca_cor "
                            + "where c.ano_ref=" + ano + " and c.mes_ref=" + mes + " and pr.id_registro=2 and usp.cod_cnes='" + ups + "' and d.id_status_cmr_aut=1 "
                            + "group by cnes, ano, mes, cns_prof, cid10, cbo, data_atend, cod_prc, cns_pac, sexo_pac, ibge, idade, autorizacao, nome_paciente, data_nasc, raca_cor "
                            + "order by cns_prof, autorizacao ";
                    long somaProcedimentos = 0;
                    long somaQuantidades = 0;
                    long controle = 0;
                    int numLinhas = 0;
                    int numFolhas = 0;
                    int nFolha = 0;
                    int nLinha = 0;
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
                    Connection conexao = Conexao.getConexao();
                    gravaLog(agora() + " Abrindo a conexão com o Banco ...\n", arq_log);
                    Statement stmt = null;
                    try {
                        stmt = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                    } catch (SQLException erro) {
                        JOptionPane.showMessageDialog(null, "Erro na Conexão: " + erro);
                    }

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
                    gravaLog(agora() + " Construindo header do BPA ...\n", arq_log);
                    String linhas = String.format("%06d", numLinhas);
                    String folhas = String.format("%06d", numFolhas);
                    nFolha = 1;
                    nLinha = 1;
                    cabecalho = "#BPA" + ano + str_mes + linhas + folhas + controle + nome_ups + sigla_ups + cnpj + org_destino + in_org_destino + versao + "\n";
                    gravaLog(agora() + " Iniciando a gravação no arquivo ...\n", arq_log);
                    gravaTXT(cabecalho, arq_bpa);
                    result = Bpa.gerarBPASemIdade(sql_sem_idade);
                    result.last();
                    nRec = result.getRow();
                    result.beforeFirst();
                    if (nRec > 0) {
                        while (result.next()) {
                            String prd_folha = String.format("%03d", nFolha);
                            String prd_linha = String.format("%02d", nLinha);
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
                    result = Bpa.gerarBPAComIdade(sql_com_idade);
                    result.last();
                    nRec = result.getRow();
                    result.beforeFirst();
                    if (nRec > 0) {
                        while (result.next()) {
                            String prd_folha = String.format("%03d", nFolha);
                            String prd_linha = String.format("%02d", nLinha);
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
                            String prd_folha = String.format("%03d", nFolha);
                            String prd_linha = String.format("%02d", nLinha);
                            cns_prf_1 = result.getString("cns_prof");
                            prd_cnspac = result.getString("cns_pac") == null ? padRight(" ", 15) : result.getString("cns_pac");
                            prd_cid = result.getString("cid10") == null ? padRight(" ", 4) : padRight(result.getString("cid10"), 4);
                            prd_cnes = result.getString("cnes");
                            prd_cmp = result.getString("ano") + result.getString("mes");
                            prd_cnsmed = result.getString("cns_prof");
                            prd_cbo = result.getString("cbo");
                            prd_dtaten = formataData(result.getString("data_atend"));
                            prd_pa = result.getString("cod_prc");
                            prd_sexo = result.getString("sexo_pac");
                            prd_ibge = result.getString("ibge").substring(0, 6);
                            prd_idade = result.getString("idade");
                            prd_qtd = result.getString("quantidade");
                            prd_caten = padRight(" ", 2);
                            prd_naut = result.getString("autorizacao");
                            prd_nmpac = padRight(result.getString("nome_paciente"), 30);
                            prd_dtnasc = formataData(result.getString("data_nasc"));
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
                    System.out.println("Arquivo " + arq_bpa + " gravado ....");

                } else {
                    JOptionPane.showMessageDialog(null, "Sem dados para geração do BPA.");
                }
            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "Erro no Método: " + erro);
            }
        }
    }//GEN-LAST:event_btExportarActionPerformed

    private void btSelecionaUnidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSelecionaUnidadeActionPerformed
        UnidadeFrame unidade = new UnidadeFrame(null, true);
        unidade.setVisible(true);
        jLabel2.setText(Unidade.getCodigo());
        jLabel4.setText(Unidade.getCnes());
        jLabel7.setText(Unidade.getNome());
        jTextField1.setText(Unidade.getNome());
    }//GEN-LAST:event_btSelecionaUnidadeActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btLocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLocalActionPerformed
        JFileChooser local = new JFileChooser();
        local.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        local.setMultiSelectionEnabled(false);
        if (local.showSaveDialog(this) == javax.swing.JFileChooser.APPROVE_OPTION) {
            String pasta = local.getSelectedFile().getPath();
            jTextField2.setText(pasta);
        }
    }//GEN-LAST:event_btLocalActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                GerarBpaFrame dialog = null;
                try {
                    dialog = new GerarBpaFrame(new javax.swing.JFrame(), true);
                } catch (SQLException ex) {
                    Logger.getLogger(GerarBpaFrame.class.getName()).log(Level.SEVERE, null, ex);
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
    private javax.swing.JButton btLocal;
    private javax.swing.JButton btSelecionaUnidade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
