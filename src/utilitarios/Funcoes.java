package utilitarios;

import java.io.File;
import java.io.FileWriter;
import javax.swing.JOptionPane;
import model.Competencia;

/**
 *
 * @author luciano
 */
public class Funcoes {

    public static void informacao(String msg) {
        JOptionPane.showMessageDialog(null, msg, "Atenção", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void erro(String msg) {
        JOptionPane.showMessageDialog(null, msg, "Atenção", JOptionPane.ERROR_MESSAGE);
    }

    public static void cuidado(String msg) {
        JOptionPane.showMessageDialog(null, msg, "Atenção", JOptionPane.WARNING_MESSAGE);
    }

    public static String ajustaNome(String nome) {
        String nome_ups = nome;
        if (nome_ups.length() > 30) {
            nome_ups = nome_ups.substring(0, 30);
        }
        if (nome_ups.length() < 30) {
            nome_ups = Utilities.padRight(nome_ups, 30);
        }
        return nome_ups;
    }

    public static void gravaTXT(String texto, String local) {
        String conteudo = texto;
        try {
            FileWriter x = new FileWriter(local, true);
            x.write(conteudo);
            x.close();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
    }

    public static void zeraTXT(String txt) {
        File arq_txt = new File(txt);
        if (arq_txt.exists()) {
            arq_txt.delete();
        }
    }

    public static void gravaLog(String texto, String local) {
        String conteudo = texto;
        try {
            FileWriter x = new FileWriter(local, true);
            x.write(conteudo);
            x.close();
        } catch (Exception erro) {
            erro("Erro na Gravação do Log " + erro);
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
}
