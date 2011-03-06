package utilitarios;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 * @author usuario
 */
public class Licence {
    private String cryptText = null;

    public void Verify() {
        ReadCryptText();
        String hdSerial = HdSerial.getHDSerial("C:");
        if (hdSerial.compareTo(this.getHDSerial()) != 0) {
            String s = JOptionPane.showInputDialog(null, "O sistema expirou.\nInforme o código de validação.", "Sistema expirado." + hdSerial, 2);
            if (s != null) {
                cryptText = s;
                WriteCryptText();
                JOptionPane.showMessageDialog(null, "O sistema será fechado para validar as informações.", "Mensagem", 1);
            }
            System.exit(0);
        }
        if (isExpire()) {
            String s = JOptionPane.showInputDialog(null, "O sistema expirou.\nInforme o código de validação.", "Sistema expirado.", 2);
            if (s != null) {
                cryptText = s;
                WriteCryptText();
                JOptionPane.showMessageDialog(null, "O sistema será fechado para validar as informações.", "Mensagem", 1);
            }
            System.exit(0);
        } else {
            if (countLastOpen() < 0) {
                String s = JOptionPane.showInputDialog(null, "O sistema expirou.\nInforme o código de validação.", "Sistema expirado.", 2);
                if (s != null) {
                    cryptText = s;
                    WriteCryptText();
                    JOptionPane.showMessageDialog(null, "O sistema será fechado para validar as informações.", "Mensagem", 1);
                }
                System.exit(0);
            } else {
                actualizeLastOpen();
            }
        }
    }

    private void ReadCryptText() {
        cryptText = Criptografia.DecriptaBase64(ReadWritePropertiesFile.ReadProperty("licence.properties", "Licence"));
    }

    private void WriteCryptText() {
        ReadWritePropertiesFile.WriteProperty("licence.properties", "Licence", cryptText);
    }

    private Date getExpireDate() {
        ReadCryptText();
        String s = cryptText.substring(28, 36);
        s = s.substring(0, 2) + "/" + s.substring(2, 4) + "/" + s.substring(4, 8);
        return Utilities.getFormatedDate(s);
    }

    private Date getLastUseDate() {
        ReadCryptText();
        String s = cryptText.substring(10, 18);
        s = s.substring(0, 2) + "/" + s.substring(2, 4) + "/" + s.substring(4, 8);
        //System.out.println(s);
        return Utilities.getFormatedDate(s);
    }

    private String getLastUseDateString() {
        ReadCryptText();
        return cryptText.substring(10, 18);
    }

    private String getHDSerial() {
        ReadCryptText();
        String s = cryptText.substring(47, cryptText.length());
        return s;
    }

    private boolean isExpire() {
        Date today = new Date();
        int i = -1;
        try {
            i = CalendarOperations.countDays(today, getExpireDate());
        } catch (Exception e) {
            i = -1;
        }
        if (i < 0)
            return true;
        return false;
    }

    private int countLastOpen() {
        Date today = new Date();
        return CalendarOperations.countDays(getLastUseDate(), today);
    }

    private boolean actualizeLastOpen() {
        if (countLastOpen() >= 0) {
            SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
            cryptText = Criptografia.CriptaBase64(cryptText.replace(getLastUseDateString(), sdf.format(new Date())));
            WriteCryptText();
            return true;
        } else {
            return false;
        }
    }
}
