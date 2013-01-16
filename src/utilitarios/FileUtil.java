package utilitarios;

import java.io.*;

/**
 * @author Luciano
 */
public class FileUtil {

  public static void salvar(String arquivo, String conteudo, boolean adicionar) throws IOException {
    FileWriter fw = new FileWriter(arquivo, adicionar);
    fw.write(conteudo);
    fw.close();
  }

  public static String carregar(String arquivo) throws FileNotFoundException, IOException {
    File file = new File(arquivo);
    if (!file.exists()) {
      return null;
    }

    BufferedReader br = new BufferedReader(new FileReader(arquivo));
    StringBuilder bufSaida = new StringBuilder();

    String linha;
    while ((linha = br.readLine()) != null) {
      bufSaida.append(linha).append("\n");
    }
    br.close();
    return bufSaida.toString();
  }

  public void removeLineFromFile(String file, String lineToRemove) {
    try {
      File inFile = new File(file);
      if (!inFile.isFile()) {
        System.out.println("Parameter is not an existing file");
        return;
      }

      File tempFile = new File(inFile.getAbsolutePath() + ".tmp");
      BufferedReader br = new BufferedReader(new FileReader(file));
      PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
      String line = null;
      while ((line = br.readLine()) != null) {
        if (!line.trim().equals(lineToRemove)) {
          pw.println(line);
          pw.flush();
        }
      }
      pw.close();
      br.close();

      if (!inFile.delete()) {
        System.out.println("Could not delete file");
        return;
      }

      if (!tempFile.renameTo(inFile)) {
        System.out.println("Could not rename file");
      }

    } catch (FileNotFoundException ex) {
      System.out.println("Arquivo não encontrado!" + ex.getLocalizedMessage());
    } catch (IOException ex) {
      System.out.println("Erro ao manippular o arquivo!" + ex.getLocalizedMessage());
    }
  }
}
