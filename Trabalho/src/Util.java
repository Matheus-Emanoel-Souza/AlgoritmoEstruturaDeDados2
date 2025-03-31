import java.io.*;

import ClassPrimaria.Aluno;
import ClassPrimaria.Curso;
import ClassPrimaria.Disciplina;

public class Util {

    public static void salvarEmArquivo(String conteudo) {
        String caminhoArquivo = "C:\\Users\\mathe\\Desktop\\AlgoritmoEstruturaDeDados2\\Trabalho\\Relatorio.txt";
        
        File arquivo = new File(caminhoArquivo);
        
        try {
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }
            
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo, true))) {
                writer.write(conteudo);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar no arquivo: " + e.getMessage());
        }
    }

    public static String calculaMedia(Aluno aluno, Curso curso, Disciplina disciplina) {
        float media = (curso.getNota1() + curso.getNota2()) / 2;
        String situacao = media >= disciplina.getNotaMinima() ? "Aprovado" : "Reprovado";

        return "Aluno encontrado: " + aluno.getNome() +
               " | Matrícula: " + aluno.getMatriculaAluno() +
               " | Média: " + media +
               " | Situação: " + situacao;
    }
}
