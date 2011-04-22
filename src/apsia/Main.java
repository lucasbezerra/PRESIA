package apsia;

import java.sql.SQLException;
import frames.MenuFrame;
import utilitarios.Licence;

/**
 * @author luciano
 */
public class Main {

  public static void main(String[] args) throws SQLException {
    Licence licenca = new Licence();
    licenca.Verify();
    MenuFrame menu = new MenuFrame();
    menu.setVisible(true);
    menu.setLocationRelativeTo(null);
  }
}
