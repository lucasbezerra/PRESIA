package utilitarios;

import java.text.SimpleDateFormat;
import java.util.Date;
import telas.FrameLiberacao;

public class Licence {

  private String cryptText = null;

  public void Verify() {
    ReadCryptText();
    if (isExpire()) {
      FrameLiberacao liberacao = new FrameLiberacao(null, true);
      liberacao.setVisible(true);
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
    String s = cryptText.substring(32, 40);
    s = s.substring(0, 2) + "/" + s.substring(2, 4) + "/" + s.substring(4, 8);
    return Utilities.getFormatedDate(s);
  }

  private Date getLastUseDate() {
    ReadCryptText();
    String s = cryptText.substring(14, 22);
    s = s.substring(0, 2) + "/" + s.substring(2, 4) + "/" + s.substring(4, 8);
    return Utilities.getFormatedDate(s);
  }

  private String getLastUseDateString() {
    ReadCryptText();
    return cryptText.substring(14, 22);
  }

  private boolean isExpire() {
    Date today = new Date();
    int i = -1;
    try {
      i = CalendarOperations.countDays(today, getExpireDate());
    } catch (Exception e) {
      i = -1;
    }
    if (i < 0) {
      return true;
    }
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
