package banco;

import apsia.Criptografia;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import utilitarios.ReadWritePropertiesFile;

public class Conexao {

    public static String status = "Não conectou...";

    public Conexao() {
    }

    public static Connection getConexao() {
        String nomeProtocolo = Criptografia.DecriptaBase64(ReadWritePropertiesFile.ReadProperty("database.properties", "Protocolo"));
        String nomeServidor  = Criptografia.DecriptaBase64(ReadWritePropertiesFile.ReadProperty("database.properties", "Host"));
        String nomeBanco     = Criptografia.DecriptaBase64(ReadWritePropertiesFile.ReadProperty("database.properties", "Banco"));
        String nomeUsuario   = Criptografia.DecriptaBase64(ReadWritePropertiesFile.ReadProperty("database.properties", "Usuario"));
        String senhaUsuario  = Criptografia.DecriptaBase64(ReadWritePropertiesFile.ReadProperty("database.properties", "Senha"));
        String nomeUrl       = nomeProtocolo + nomeServidor + "/" + nomeBanco;

        Connection connection = null;
        try {
            String driverName = "org.postgresql.Driver";
            Class.forName(driverName);
            connection = DriverManager.getConnection(nomeUrl, nomeUsuario, senhaUsuario);
            if (connection != null) {
                status = ("STATUS--->Conectado com sucesso!");
            } else {
                status = ("STATUS--->Não foi possivel realizar conexão");
            }
            return connection;
        } catch (ClassNotFoundException e) {  //Driver não encontrado
            System.out.println("O driver expecificado nao foi encontrado.");
            return null;
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "Nao foi possivel conectar ao Banco de Dados.");
            return null;
        }
    }

    public static String statusConection() {
        return status;
    }

    public static boolean FecharConexao() {
        try {
            Conexao.getConexao().close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public static java.sql.Connection ReiniciarConexao() {
        FecharConexao();
        return Conexao.getConexao();
    }
}