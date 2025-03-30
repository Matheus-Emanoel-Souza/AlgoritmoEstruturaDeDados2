import java.io.*;

public class Util {
    public static void salvarEmArquivo(String conteudo, String caminhoArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo, true))) {
            writer.write(conteudo);
            writer.newLine(); // Adiciona uma nova linha após o conteúdo
        } catch (IOException e) {
            System.out.println("Erro ao salvar no arquivo: " + e.getMessage());
        }
    }
}
