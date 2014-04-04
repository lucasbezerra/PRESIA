package utilitarios;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Utilities {

  public static String preencheCom(String linha_a_preencher, String letra, int tamanho, int direcao) {
    if (linha_a_preencher == null || "".equals(linha_a_preencher.trim())) {
      linha_a_preencher = "";
    }

    while (linha_a_preencher.contains(" ")) {
      linha_a_preencher = linha_a_preencher.replaceAll(" ", " ").trim();
    }

    linha_a_preencher = linha_a_preencher.replaceAll("[./-/,]", "");

    StringBuilder sb = new StringBuilder(linha_a_preencher);

    if (direcao == 1) { //a Esquerda
      for (int i = sb.length(); i < tamanho; i++) {
        sb.insert(0, letra);
      }
    } else if (direcao == 2) {//a Direita
      for (int i = sb.length(); i < tamanho; i++) {
        sb.append(letra);
      }
    }
    return sb.toString();
  }

  public static String getFormatedDate() {
    Date date = new Date();
    SimpleDateFormat formated = new SimpleDateFormat("dd/MM/yyyy");
    String format = formated.format(date);
    return format;
  }

  public static Date getFormatedDate(String stringDate) {
    SimpleDateFormat formated = new SimpleDateFormat("dd/MM/yyyy");
    Date newDate = null;
    try {
      newDate = formated.parse(stringDate);
    } catch (ParseException ex) {
      newDate = null;
    }
    return newDate;
  }

  public static String getMysqlDateFormat(String sDate) {
    return sDate.substring(6, 9) + "-" + sDate.substring(3, 5) + "-" + sDate.substring(0, 2);
  }

  public static String getMysqlDateFormat(Date date) {
    String sDate = Utilities.dateToString(date);
    return sDate.substring(6, 9) + "-" + sDate.substring(3, 5) + "-" + sDate.substring(0, 2);
  }

  public static String dateToString(Date d) {
    SimpleDateFormat formated = new SimpleDateFormat("dd/MM/yyyy");
    return formated.format(d);
  }

  public static String timeToString(Date d) {
    SimpleDateFormat formated = new SimpleDateFormat("hh:mm:ss");
    return formated.format(d);
  }

  public static String dataCompleta() {
    Locale locale = new Locale("pt", "BR");
    GregorianCalendar calendar = new GregorianCalendar();
    SimpleDateFormat data = new SimpleDateFormat("dd' de 'MMMMM' de 'yyyy' - 'HH:mm:ss", locale);
    return data.format(calendar.getTime());
  }

  public static String padRight(String s, int n) {
    return String.format("%1$-" + n + "s", s);
  }

  public static Double monetaryToDouble(String monetary) {
    monetary = monetary.substring(3, monetary.length());
    Number n = null;
    try {
      n = NumberFormat.getNumberInstance(Locale.getDefault()).parse(monetary);
    } catch (ParseException ex) {
      Funcoes.erro("Erro: " + ex.getLocalizedMessage());
    }
    return n.doubleValue();
  }

  public static String doubleToMonetary(Double d) {
    String s = NumberFormat.getCurrencyInstance(Locale.getDefault()).format(d);
    return s;
  }

  public String getMonetaryDoubleCaseNegative(String Monetary) {
    //converter monetário para double
    return Monetary.substring(2);
  }

  public static Boolean verifyCNPJ(String cpf) {
    if (Validate.validaCPF(cpf)) {
      return true;
    } else {
      return false;
    }
  }

  public static String passwordToString(char[] c) {
    StringBuffer sb1 = new StringBuffer();
    for (int i = 0; i < c.length; i++) {
      sb1.append(c[i]);
    }
    return sb1.toString();
  }

  public static Boolean isDateValid(String d) {
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    df.setLenient(false); // aqui o pulo do gato
    try {
      df.parse(d);
      // data válida
    } catch (ParseException ex) {
      // data inválida
      return false;
    }
    return true;
  }
}