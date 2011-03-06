package utilitarios;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


/**
 *
 * @author Gilderlan
 */
public class Utilities {
    
    public static String getFormatedDate(){
        Date date = new Date();
        SimpleDateFormat formated = new SimpleDateFormat("dd/MM/yyyy");
        String format = formated.format(date);
        return format;
    }

    public static Date getFormatedDate(String stringDate){
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

    public static Double monetaryToDouble(String monetary){
        monetary = monetary.substring(3, monetary.length());
        Number n = null;
        try {
            n = NumberFormat.getNumberInstance(Locale.getDefault()).parse(monetary);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return n.doubleValue();
    }

    public static String doubleToMonetary(Double d) {
        String s = NumberFormat.getCurrencyInstance(Locale.getDefault()).format(d);
        return s;
    }

    public String getMonetaryDoubleCaseNegative(String Monetary){
        //converter monetário para double
        return Monetary.substring(2);
    }

    public static Boolean verifyCNPJ(String cpf) {
        if(Validate.validaCPF(cpf))
            return true;
        else
            return false;
    }

    public static String passwordToString(char[] c) {
        StringBuffer sb1 = new StringBuffer();
        for (int i=0; i < c.length; i++) {
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