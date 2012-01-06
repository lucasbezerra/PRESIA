package model;

/**
 * @author Luciano
 */
import banco.Conexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import utilitarios.Funcoes;

public class Bpa {

  static Connection conexao = null;
  static Statement stmt = null;
  static ResultSet result = null;

  public static void Bpa() {
  }

  public static boolean PossuiDados(int mes, int ano, String ups) throws SQLException {
    conexao = Conexao.getConexao();
    stmt = conexao.createStatement();
    String sql = "select count(*) as retorno "
            + "from cab_aut_cmr cabecalho "
            + "inner join det_aut_cmr detalhe on cabecalho.id_cab_aut_cmr = detalhe.id_cab_aut_cmr "
            + "inner join unidade_saude usp on cabecalho.id_usp = usp.id_unidade_saude "
            + "where cabecalho.ano_ref=" + ano + " and mes_ref=" + mes + " and usp.cod_cnes='" + ups + "' and detalhe.id_status_cmr_aut=1";
    result = stmt.executeQuery(sql);
    result.next();
    int retorno = Integer.parseInt(result.getString("retorno"));
    if (retorno > 0) {
      return true;
    } else {
      return false;
    }
  }

  public static ResultSet gerarBPASemIdade(int mes, int ano, String ups) throws SQLException {
    conexao = Conexao.getConexao();
    stmt = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    String sql = "select usp.cod_cnes AS CNES,c.ano_ref AS ANO, lpad(cast(c.mes_ref as varchar), 2, '0') AS MES, "
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
    ResultSet dados = stmt.executeQuery(sql);
    Funcoes.gravaLog(sql + "\n", "sql.txt");
    return dados;
  }

  public static ResultSet gerarBPAComIdade(int mes, int ano, String ups) throws SQLException {
    conexao = Conexao.getConexao();
    stmt = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    String sql = "select usp.cod_cnes as CNES, c.ano_ref as ANO, lpad(cast(c.mes_ref as varchar), 2, '0') as MES, cbo.cod_cbo_ocupacao as CBO, "
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
    ResultSet dados = stmt.executeQuery(sql);
    Funcoes.gravaLog(sql + "\n", "sql.txt");
    return dados;
  }

  public static ResultSet gerarBPAIndividualizado(int mes, int ano, String ups) throws SQLException {
    conexao = Conexao.getConexao();
    stmt = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    String sql = "select usp.cod_cnes as CNES,c.ano_ref||lpad(cast(c.mes_ref as varchar), 2, '0') as ano_mes, prof.cod_cns as CNS_PROF, cbo.cod_cbo_ocupacao as CBO,"
            + " cast(extract(year from d.dta_marcada) as varchar)||lpad(cast(extract(month from d.dta_marcada) as varchar), 2, '0')||lpad(cast(extract(day from d.dta_marcada) as varchar), 2, '0') as DATA_ATEND,"
            + " p.cod_proced as COD_PRC, pe.cod_cartao_sus as CNS_PAC, pe.sexo as SEXO_PAC, substring(MNC.COD_IBGE from 1 for 6) as IBGE, cid.cod_cid AS CID10,"
            + " lpad(cast(date_part('YEAR', age(current_date, pe.dta_nasc)) as varchar), 3, '0') as idade, lpad(cast(sum(d.qtde_proced) as varchar), 6, '0') as quantidade,"
            + " c.cod_cab_aut_cmr as AUTORIZACAO, pe.nome as nome_paciente,"
            + " cast(extract(year from pe.dta_nasc) as varchar)||lpad(cast(extract(month from pe.dta_nasc) as varchar), 2, '0')||lpad(cast(extract(day from pe.dta_nasc) as varchar), 2, '0') as DATA_NASC,"
            + " rc.cod_ibge_raca_cor as raca_cor, coalesce(pais.cod_pais, '010') prd_nac"
            + " from cab_aut_cmr c"
            + " inner join det_aut_cmr d on c.id_cab_aut_cmr=d.id_cab_aut_cmr"
            + " inner join unidade_saude usp on c.id_usp=usp.id_unidade_saude"
            + " inner join profissional_v prof on c.id_prof_usp=prof.id_pessoa"
            + " inner join pessoa pe on c.id_pessoa=pe.id_pessoa"
            + " inner join procedimento p on d.id_proced=p.id_proced"
            + " inner join cbo_ocupacao cbo on c.id_cbo_ocupacao=cbo.id_cbo_ocupacao"
            + " inner join proced_registro pr on c.ano_ref=pr.ano_ref and c.mes_ref=pr.mes_ref and p.id_proced=pr.id_proced"
            + " inner join status_cmr_aut a on c.id_status_cmr_aut=a.id_status_cmr_aut"
            + " left join pais pais on pe.id_pais=pais.id_pais"
            + " left join municipio mnc on PE.id_municipio_res=mnc.id_municipio"
            + " left join cid cid on d.id_cid=cid.id_cid"
            + " left join raca_cor rc on pe.id_raca_cor = rc.id_raca_cor"
            + " where EXTRACT(YEAR FROM d.dta_marcada)=" + ano + " and EXTRACT(month FROM d.dta_marcada)=" + mes + " and pr.id_registro=2 and usp.cod_cnes='" + ups + "' and d.id_status_cmr_aut=1"
            + " group by cnes, ano_mes, cns_prof, cid10, cbo, data_atend, cod_prc, cns_pac, sexo_pac, ibge, idade, autorizacao, nome_paciente, data_nasc, raca_cor, prd_nac"
            + " order by cns_prof, autorizacao";
    System.out.println(sql);
    ResultSet dados = stmt.executeQuery(sql);
    Funcoes.gravaLog(sql + "\n", "sql.txt");
    return dados;
  }

  public static String GeraCampoControle(int mes, int ano, String ups) throws SQLException {
    String nControle = null;
    long somaProcedimentos = 0;
    long somaQuantidades = 0;
    long controle = 0;
    double numLinhas = 0;
    double numFolhas = 0;

    conexao = Conexao.getConexao();
    stmt = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    String sql = "select usp.cod_cnes AS CNES,c.ano_ref AS ANO, lpad(cast(c.mes_ref as varchar), 2, '0') AS MES, "
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
    result = stmt.executeQuery(sql);
    result.last();
    numLinhas = numLinhas + result.getRow();
    result.beforeFirst();
    while (result.next()) {
      somaProcedimentos = somaProcedimentos + result.getLong("cod_prc");
      somaQuantidades = somaQuantidades + result.getInt("quantidade");
    }
    sql = "select usp.cod_cnes as CNES, c.ano_ref as ANO, lpad(cast(c.mes_ref as varchar), 2, '0') as MES, cbo.cod_cbo_ocupacao as CBO, "
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
    result = stmt.executeQuery(sql);
    result.last();
    numLinhas = numLinhas + result.getRow();
    result.beforeFirst();
    while (result.next()) {
      somaProcedimentos = somaProcedimentos + result.getLong("cod_prc");
      somaQuantidades = somaQuantidades + result.getInt("quantidade");
    }

    sql = "select usp.cod_cnes as CNES,c.ano_ref||lpad(cast(c.mes_ref as varchar), 2, '0') as ano_mes, prof.cod_cns as CNS_PROF, cbo.cod_cbo_ocupacao as CBO,"
            + " cast(extract(year from d.dta_marcada) as varchar)||lpad(cast(extract(month from d.dta_marcada) as varchar), 2, '0')||lpad(cast(extract(day from d.dta_marcada) as varchar), 2, '0') as DATA_ATEND,"
            + " p.cod_proced as COD_PRC, pe.cod_cartao_sus as CNS_PAC, pe.sexo as SEXO_PAC, substring(MNC.COD_IBGE from 1 for 6) as IBGE, cid.cod_cid AS CID10,"
            + " lpad(cast(date_part('YEAR', age(current_date, pe.dta_nasc)) as varchar), 3, '0') as idade, lpad(cast(sum(d.qtde_proced) as varchar), 6, '0') as quantidade,"
            + " c.cod_cab_aut_cmr as AUTORIZACAO, pe.nome as nome_paciente,"
            + " cast(extract(year from pe.dta_nasc) as varchar)||lpad(cast(extract(month from pe.dta_nasc) as varchar), 2, '0')||lpad(cast(extract(day from pe.dta_nasc) as varchar), 2, '0') as DATA_NASC,"
            + " rc.cod_ibge_raca_cor as raca_cor, coalesce(pais.cod_pais, '010') prd_nac"
            + " from cab_aut_cmr c"
            + " inner join det_aut_cmr d on c.id_cab_aut_cmr=d.id_cab_aut_cmr"
            + " inner join unidade_saude usp on c.id_usp=usp.id_unidade_saude"
            + " inner join profissional_v prof on c.id_prof_usp=prof.id_pessoa"
            + " inner join pessoa pe on c.id_pessoa=pe.id_pessoa"
            + " inner join procedimento p on d.id_proced=p.id_proced"
            + " inner join cbo_ocupacao cbo on c.id_cbo_ocupacao=cbo.id_cbo_ocupacao"
            + " inner join proced_registro pr on c.ano_ref=pr.ano_ref and c.mes_ref=pr.mes_ref and p.id_proced=pr.id_proced"
            + " inner join status_cmr_aut a on c.id_status_cmr_aut=a.id_status_cmr_aut"
            + " left join pais pais on pe.id_pais=pais.id_pais"
            + " left join municipio mnc on PE.id_municipio_res=mnc.id_municipio"
            + " left join cid cid on d.id_cid=cid.id_cid"
            + " left join raca_cor rc on pe.id_raca_cor = rc.id_raca_cor"
            + " where c.ano_ref=" + ano + " and c.mes_ref=" + mes + " and pr.id_registro=2 and usp.cod_cnes='" + ups + "' and d.id_status_cmr_aut=1"
            + " group by cnes, ano_mes, cns_prof, cid10, cbo, data_atend, cod_prc, cns_pac, sexo_pac, ibge, idade, autorizacao, nome_paciente, data_nasc, raca_cor, prd_nac"
            + " order by cns_prof, autorizacao";
    result = stmt.executeQuery(sql);
    result.last();
    numLinhas = numLinhas + result.getRow();
    result.beforeFirst();
    while (result.next()) {
      somaProcedimentos = somaProcedimentos + result.getLong("cod_prc");
      somaQuantidades = somaQuantidades + result.getInt("quantidade");
    }
    controle = ((somaProcedimentos + somaQuantidades) % 1111);
    controle = controle + 1111;
    numFolhas = ((numLinhas % 20 == 0) ? (numLinhas / 20) : (Math.ceil(numLinhas / 20)));

    String linhas = String.format("%06d", (int) numLinhas);
    String folhas = String.format("%06d", (int) numFolhas);

    nControle = linhas + folhas + Long.toString(controle);
    return nControle;
  }
}
