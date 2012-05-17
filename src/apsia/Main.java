package apsia;

import java.io.IOException;
import java.sql.SQLException;
import telas.MenuFrame;
import utilitarios.Licence;

/**
 * @author luciano
 */
public class Main {

  public static void main(String[] args) throws SQLException, IOException {
    Licence licenca = new Licence();
    licenca.Verify();
    MenuFrame menu = new MenuFrame();
    menu.setVisible(true);
    menu.setLocationRelativeTo(null);
  }
}
