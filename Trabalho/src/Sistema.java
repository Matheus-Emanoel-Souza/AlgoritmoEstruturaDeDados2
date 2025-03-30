import java.io.IOException;
import java.util.Scanner;

public class Sistema {
    private static final String CAMINHO_ALUNOS = "C:\\Users\\mathe\\Desktop\\AlgoritmoEstruturaDeDados2\\Alunos.txt";
    private static final String CAMINHO_CURSOS = "C:\\Users\\mathe\\Desktop\\AlgoritmoEstruturaDeDados2\\Curso.txt";
    private static final String CAMINHO_DISCIPLINAS = "C:\\Users\\mathe\\Desktop\\AlgoritmoEstruturaDeDados2\\Disciplina.txt";

    private Aluno[] arrayAluno;
    private Disciplina[] arrayDisciplina;
    private Curso[] arrayCurso;

    // Carrega os dados
    public void carregarDados() throws IOException {
        // Usa os métodos de leitura de arquivos para popular os arrays        
        arrayAluno = LeitorDeArquivos.lerAlunos(CAMINHO_ALUNOS);
        arrayDisciplina = LeitorDeArquivos.lerDisciplinas(CAMINHO_DISCIPLINAS);
        arrayCurso = LeitorDeArquivos.lerCursos(CAMINHO_CURSOS, arrayCurso, arrayDisciplina, arrayAluno);
    }

    // Método de busca
    public void buscar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Como deseja buscar ?");
        System.out.println("1 - Por Aluno.");
        System.out.println("2 - Por Disciplina.");
        String resposta = scanner.nextLine();

        if (Integer.parseInt(resposta) == 1) {
            System.out.println("Buscando Pelo Aluno!");
            Buscar.buscarAluno(scanner, arrayAluno, arrayCurso); // Usando a classe Buscar
        } else if (Integer.parseInt(resposta) == 2) {
            System.out.println("Buscando por Disciplina!");
            Buscar.buscarDisciplina(scanner, arrayDisciplina,arrayAluno,arrayCurso); // Usando a classe Buscar
        } else {
            System.out.println("Resposta Inválida!!!!!");
            buscar(); // Recurssão caso resposta inválida
        }
    }
}
