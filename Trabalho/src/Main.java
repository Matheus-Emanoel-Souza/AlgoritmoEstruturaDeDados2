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
            System.out.println("\n====Bem-vindo!====");
            System.out.println("1 - Buscar Resultados");
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
                    Opcoes();
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
        arrayCurso = lerCursos(CAMINHO_CURSOS,arrayCurso);
        arrayAluno = lerAlunos(CAMINHO_ALUNOS);
        arrayDisciplina = lerDisciplinas(CAMINHO_DISCIPLINAS);
    }
    
    private static void Opcoes() {
        try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Como deseja buscar ?");
			System.out.println("1 - Por Aluno.");
			System.out.println("2 - Por Disciplina.");
			String Resposta = scanner.nextLine();
			
			if(Integer.parseInt(Resposta) == 1) {
			    System.out.println("Buscando Pelo Aluno!");
			    buscarAluno();
			} else if(Integer.parseInt(Resposta) == 2) {
			    System.out.println("Buscando por disciplina!");
			    buscarDisciplina();
			} else {
			    System.out.println("Resposta Inválida!!!!!");
			    Opcoes();
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    private static Curso[] lerCursos(String caminho, Curso[] cursos) throws IOException { 
        String[] linhas = lerArquivo(caminho);
        cursos = new Curso[linhas.length];

        for (int i = 0; i < linhas.length; i++) {
            String[] partes = linhas[i].split(";");
            String matricula = partes[0];  // Usando String para a matrícula
            String codDisciplina = partes[1];  // Usando String para o código da disciplina
            float nota1 = Float.parseFloat(partes[2]);
            float nota2 = Float.parseFloat(partes[3]);

            // Verificando se a matrícula existe no array de alunos
            boolean matriculaEncontrada = false;
            for (Aluno aluno : arrayAluno) {
                if (Integer.toString(aluno.getMatriculaAluno()).equals(matricula)) {
                    matriculaEncontrada = true;
                    break;
                }
            }

            // Verificando se a disciplina existe no array de disciplinas
            boolean disciplinaEncontrada = false;
            for (Disciplina disciplina : arrayDisciplina) {
                if (Integer.toString(disciplina.getCodDisciplina()).equals(codDisciplina)) {
                    disciplinaEncontrada = true;
                    break;
                }
            }

            // Se ambas as condições forem verdadeiras, cria o curso
            if (matriculaEncontrada && disciplinaEncontrada) {
                cursos[i] = new Curso(Integer.parseInt(matricula), Integer.parseInt(codDisciplina), nota1, nota2);
            }
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

    private static void buscarAluno() {
        try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Digite o nome ou a matrícula do aluno:");
			String busca = scanner.nextLine();

			for (Aluno aluno : arrayAluno) {
			    if (busca.equalsIgnoreCase(aluno.getNome()) || busca.equals(String.valueOf(aluno.getMatriculaAluno()))) {
			        System.out.println("Aluno encontrado:");
			        System.out.println("Nome: " + aluno.getNome());
			        System.out.println("Matrícula: " + aluno.getMatriculaAluno());
			        System.out.println("Pressione Enter para voltar ao menu...");
			        scanner.nextLine();
			        return; // Interrompe a execução da função após encontrar o aluno
			    }
			}
		}
        System.out.println("Aluno não encontrado.");
    }


    private static void buscarDisciplina() {
        try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Digite o código da disciplina ou o nome dela!");
			String busca = scanner.nextLine();
			
			for(Disciplina disciplina : arrayDisciplina) {
			    if(busca.equalsIgnoreCase(disciplina.getNomeDisciplina()) || busca.equals(String.valueOf(disciplina.getCodDisciplina()))) {
			        System.out.println("Código: " + disciplina.getCodDisciplina());
			        System.out.println("Nome: " + disciplina.getNomeDisciplina());
			        System.out.println("Nota Mínima: " + disciplina.getNotaMinima());
			    } else {
			        System.out.println("Disciplina não encontrada!");
			    }
			}
		}
    }
}
