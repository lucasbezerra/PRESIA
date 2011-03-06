package model;

/**
 * @author Luciano
 */
import banco.Conexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Bpa {

    public static void Bpa() {
    }

    public static boolean PossuiDados() throws SQLException {
        String mes = Competencia.getMes();
        String ano = Competencia.getAno();
        String ups = Unidade.getCnes();
        Connection conexao = Conexao.getConexao();
        Statement stmt = conexao.createStatement();
        String sql = "select count(*) as retorno "
                + "from cab_aut_cmr cabecalho "
                + "inner join det_aut_cmr detalhe on cabecalho.id_cab_aut_cmr = detalhe.id_cab_aut_cmr "
                + "inner join unidade_saude usp on cabecalho.id_usp = usp.id_unidade_saude "
                + "where cabecalho.ano_ref=" + ano + " and mes_ref=" + mes + " and usp.cod_cnes='" + ups + "' and detalhe.id_status_cmr_aut=1";
        ResultSet result = stmt.executeQuery(sql);
        result.next();
        int retorno = Integer.parseInt(result.getString("retorno"));
        if (retorno > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static ResultSet gerarBPASemIdade(String sql) throws SQLException {
        Connection conexao = Conexao.getConexao();
        Statement stmt = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet dados = stmt.executeQuery(sql);
        return dados;
    }

    public static ResultSet gerarBPAComIdade(String sql) throws SQLException {
        Connection conexao = Conexao.getConexao();
        Statement stmt = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet dados = stmt.executeQuery(sql);
        return dados;
    }

    public static ResultSet gerarBPAIndividualizado(String sql) throws SQLException {
        Connection conexao = Conexao.getConexao();
        Statement stmt = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet dados = stmt.executeQuery(sql);
        return dados;
    }
}
