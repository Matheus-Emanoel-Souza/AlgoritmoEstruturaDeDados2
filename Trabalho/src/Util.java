import java.io.*;

public class Util {
    public static void salvarEmArquivo(String conteudo) {
    	String caminhoArquivo = "C:\\Users\\mathe\\Desktop";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo, true))) {
            writer.write(conteudo);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao salvar no arquivo: " + e.getMessage());
        }
    }
}
