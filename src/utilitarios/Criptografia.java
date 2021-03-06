package utilitarios;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author usuario
 */
public class Criptografia {

    private static String texto = null;
    private static MessageDigest md = null;

    static {
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
    }

    private static char[] hexCodes(byte[] text) {
        char[] hexOutput = new char[text.length * 2];
        String hexString;

        for (int i = 0; i < text.length; i++) {
            hexString = "00" + Integer.toHexString(text[i]);
            hexString.toUpperCase().getChars(hexString.length() - 2,
                    hexString.length(), hexOutput, i * 2);
        }
        return hexOutput;
    }

    public static String criptografar(String pwd) {
        if (md != null) {
            return new String(hexCodes(md.digest(pwd.getBytes())));
        }
        return null;
    }

    public static String decriptar(String texto) {
        texto = Criptografia.DecriptaBase64(texto);
        return texto;
    }

    protected static String CriptaBase64(String TextoIni) {
        String RetVal = "";
        try {
            String TextoCripto = new sun.misc.BASE64Encoder().encode(TextoIni.getBytes());
            String TextoDecript = new String(new sun.misc.BASE64Decoder().decodeBuffer(TextoCripto));
            RetVal = TextoCripto;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return RetVal;
    }

    //retorna o seu texto original descriptografando ele!
    protected static String DecriptaBase64(String TextoIni) {
        String RetVal = "";
        try {
            String TextoDecript = new String(new sun.misc.BASE64Decoder().decodeBuffer(TextoIni));
            RetVal = TextoDecript;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return RetVal;
    }
}
