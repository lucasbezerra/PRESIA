package model;

/**
 *
 * @author luciano
 */
public class Unidade {
private static String codigo;
private static String cnes;
private static String nome;
private static String cnpj;

  public static String getNome() {
    return nome;
  }

  public static void setNome(String aNome) {
    nome = aNome;
  }

  public static String getCodigo() {
    return codigo;
  }

  public static void setCodigo(String aCodigo) {
    codigo = aCodigo;
  }

  public static String getCnes() {
    return cnes;
  }

  public static void setCnes(String aCnes) {
    cnes = aCnes;
  }

    public static String getCnpj() {
        return cnpj;
    }

    public static void setCnpj(String aCnpj) {
        cnpj = aCnpj;
    }

}
