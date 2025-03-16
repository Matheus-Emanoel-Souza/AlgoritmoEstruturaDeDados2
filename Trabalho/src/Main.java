import java.io.*;
import java.util.Scanner;

public class Main {
    private static final String CAMINHO_ALUNOS = "C:\\Users\\mathe\\Desktop\\AlgoritmoEstruturaDeDados2\\Alunos.txt";
    private static final String CAMINHO_CURSOS = "C:\\Users\\mathe\\Desktop\\AlgoritmoEstruturaDeDados2\\Curso.txt";
    private static final String CAMINHO_DISCIPLINAS = "C:\\Users\\mathe\\Desktop\\AlgoritmoEstruturaDeDados2\\Disciplina.txt";

    private static Curso[] arrayCurso;
    private static Aluno[] arrayAluno;
    private static Disciplina[] arrayDisciplina;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        carregarDados();

        while (true) {
            System.out.println("\nBem-vindo!");
            System.out.println("1 - Buscar Aluno");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida. Tente novamente.");
                scanner.next(); // Limpa entrada inválida
                continue;
            }

            int escolha = scanner.nextInt();
            scanner.nextLine(); // Consome quebra de linha

            switch (escolha) {
                case 1:
                	Opcoes(scanner);
                    buscarAluno(scanner);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
    }

    private static void carregarDados() throws IOException {
        arrayCurso = lerCursos(CAMINHO_CURSOS);
        arrayAluno = lerAlunos(CAMINHO_ALUNOS);
        arrayDisciplina = lerDisciplinas(CAMINHO_DISCIPLINAS);
    }
    private static void Opcoes(Scanner scanner) {	
    System.out.println("Como deseja buscar ?");
    System.out.println("1 - Por Aluno.");
    System.out.println("2 - Por Disciplina.");
    String Resposta = scanner.nextLine();
    if(Integer.parseInt(Resposta)== 1) {
    	System.out.println("Buscando Pelo Aluno!");
    	buscarAluno(scanner);
    }
    if(Integer.parseInt(Resposta)==2) {
    	System.out.println("Buscando por disciplina!");
    	buscarDisciplina(scanner);
    }
    }
    private static Curso[] lerCursos(String caminho) throws IOException {
        String[] linhas = lerArquivo(caminho);
        Curso[] cursos = new Curso[linhas.length];

        for (int i = 0; i < linhas.length; i++) {
            String[] partes = linhas[i].split(";");
            int matricula = Integer.parseInt(partes[0]);
            int codDisciplina = Integer.parseInt(partes[1]);
            float nota1 = Float.parseFloat(partes[2]);
            float nota2 = Float.parseFloat(partes[3]);

            cursos[i] = new Curso(matricula, codDisciplina, nota1, nota2);
        }
        return cursos;
    }

    private static Aluno[] lerAlunos(String caminho) throws IOException {
        String[] linhas = lerArquivo(caminho);
        Aluno[] alunos = new Aluno[linhas.length];

        for (int i = 0; i < linhas.length; i++) {
            String[] partes = linhas[i].split(";");
            int matricula = Integer.parseInt(partes[0]);
            String nome = partes[1];
            int idade = Integer.parseInt(partes[2]);

            alunos[i] = new Aluno(matricula, nome, idade);
        }
        return alunos;
    }

    private static Disciplina[] lerDisciplinas(String caminho) throws IOException {
        String[] linhas = lerArquivo(caminho);
        Disciplina[] disciplinas = new Disciplina[linhas.length];

        for (int i = 0; i < linhas.length; i++) {
            String[] partes = linhas[i].split(";");
            int codigo = Integer.parseInt(partes[0]);
            String nome = partes[1];
            float notaMinima = Float.parseFloat(partes[2]);

            disciplinas[i] = new Disciplina(codigo, nome, notaMinima);
        }
        return disciplinas;
    }

    private static String[] lerArquivo(String caminho) throws IOException {
        File arquivo = new File(caminho);
        if (!arquivo.exists()) {
            System.out.println("Arquivo não encontrado: " + caminho);
            return new String[0];
        }

        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            return br.lines().toArray(String[]::new);
        }
    }

    private static void buscarAluno(Scanner scanner) {

        System.out.println("Digite o nome ou a matrícula do aluno:");
        String busca = scanner.nextLine();

        for (Aluno aluno : arrayAluno) {
            if (busca.equalsIgnoreCase(aluno.getNome()) || busca.equals(String.valueOf(aluno.getMatriculaAluno()))) {
                System.out.println("Aluno encontrado:");
                System.out.println("Nome: " + aluno.getNome());
                System.out.println("Matrícula: " + aluno.getMatriculaAluno());
                System.out.println("Pressione Enter para voltar ao menu...");
                scanner.nextLine();
                return;
            }
        }

        System.out.println("Aluno não encontrado.");
    }
    private static void buscarDisciplina(Scanner scanner) {
    	System.out.println("Digite o código da disciplina ou o nome dela!");
    	String busca = scanner.nextLine();
    	
    	for(Disciplina disciplina : arrayDisciplina) {
    		if(busca.equalsIgnoreCase(disciplina.getNomeDisciplina())||busca.equals(String.valueOf(disciplina.getCodDisciplina()))) {
    			System.out.println("Disciplina encontrada:");
    			System.out.println("Código: " + disciplina.getCodDisciplina());
    			System.out.println("Nome: " + disciplina.getNomeDisciplina());
    			System.out.println("Nota Mínima: " + disciplina.getNotaMinima());
    		}
    	}
    }
}
