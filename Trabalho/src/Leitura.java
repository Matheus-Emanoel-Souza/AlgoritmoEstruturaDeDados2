import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Leitura { // Corrigido nome da classe para iniciar com maiúscula (boa prática)
    public static void main(String[] args) throws FileNotFoundException, IOException {
        int linhas = 0;
        String caminhoArquivo = "C:\\Users\\mathe\\Desktop\\Trabalho.txt";
        String linha;

        // Contar quantas linhas tem no arquivo
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            while ((linha = br.readLine()) != null) {
                linhas++;
            }
        }

        // Arrays para armazenar os dados dos alunos
        String[] nomesDosAlunos = new String[linhas];
        String[] curso = new String[linhas];
        String[] disciplina = new String[linhas];
        Float[] nota1 = new Float[linhas];
        Float[] nota2 = new Float[linhas];

        int contador = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");

                if (partes.length == 5) { // Verifica se há exatamente 5 elementos
                    try {
                        nomesDosAlunos[contador] = partes[0].trim();
                        curso[contador] = partes[1].trim();
                        disciplina[contador] = partes[2].trim();
                        nota1[contador] = Float.parseFloat(partes[3].trim());
                        nota2[contador] = Float.parseFloat(partes[4].trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Erro ao converter notas na linha " + (contador + 1) + ": " + linha);
                    }
                } else {
                    System.out.println("Linha " + (contador + 1) + " com formato incorreto: " + linha);
                }
                contador++;
            }
        } catch (NumberFormatException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        // Exemplo de impressão para testar os valores lidos
        System.out.println("Dados lidos do arquivo:");
        for (int i = 0; i < linhas; i++) {
            if (nomesDosAlunos[i] != null) { // Evita imprimir valores nulos
                System.out.println("Aluno: " + nomesDosAlunos[i] + ", Curso: " + curso[i] + 
                                   ", Disciplina: " + disciplina[i] + ", Nota 1: " + nota1[i] + 
                                   ", Nota 2: " + nota2[i]);
            }
        }
    }
}
