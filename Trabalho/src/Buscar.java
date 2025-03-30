import java.util.Scanner;

public class Buscar {
	 static void buscarAluno(Scanner scanner,Aluno[] arrayAluno,Curso[] arrayCurso) {
	    System.out.println("Digite o nome ou a matrícula do aluno:");
	    String busca = scanner.nextLine();
	    String conteudo = "";

	    // Percorrer o array de alunos para encontrar o aluno
	    for (Aluno aluno : arrayAluno) {
	        if (busca.equalsIgnoreCase(aluno.getNome()) || busca.equals(String.valueOf(aluno.getMatriculaAluno()))) {
	            // Exibir informações do aluno
	            Exibir.exibirInformacoesAluno(aluno);
	            conteudo += "Aluno encontrado:\nNome: " + aluno.getNome() + "\nMatrícula: " + aluno.getMatriculaAluno() + "\n";
	            
	            // Buscar e exibir todos os cursos do aluno
	            boolean encontrouCursos = false;
	            for (Curso curso : arrayCurso) {
	                if (curso.getMatricCurso() == aluno.getMatriculaAluno()) {
	                    Exibir.exibirInformacoesCurso(curso);
	                    conteudo += "Curso encontrado:\nMatrícula do Curso: " + curso.getMatricCurso() + 
	                                "\nCódigo da Disciplina: " + curso.getCodDisciplina() + 
	                                "\nNota 1: " + curso.getNota1() + "\nNota 2: " + curso.getNota2() + "\n";
	                    encontrouCursos = true;
	                }
	            }
	            if (!encontrouCursos) {
	                conteudo += "Nenhum curso encontrado para este aluno.\n";
	                System.out.println("Nenhum curso encontrado para este aluno.\n");
	            }
	            // Se não encontrou cursos, não adiciona nada no conteúdo

	            // Salvar as informações no arquivo com a matrícula do aluno
	            Util.salvarEmArquivo(conteudo, "resultado_busca_" + aluno.getMatriculaAluno() + ".txt");
	            return;
	        }
	    }

	    System.out.println("Aluno não encontrado.");
	}


	 public static void buscarDisciplina(Scanner scanner, Disciplina[] arrayDisciplina, Aluno[] arrayAluno,Curso[] arrayCurso) {
		    System.out.println("Digite o código ou o nome da disciplina:");
		    String busca = scanner.nextLine();
		    String conteudo = "";

		    for (Disciplina disciplina : arrayDisciplina) {
		        if (busca.equalsIgnoreCase(disciplina.getNomeDisciplina()) || busca.equals(String.valueOf(disciplina.getCodDisciplina()))) {
		            Exibir.exibirInformacoesDisciplina(disciplina);  // Classe Exibir para exibir os detalhes
		            conteudo = "Disciplina encontrada:\nCódigo: " + disciplina.getCodDisciplina() + 
		                       "\nNome: " + disciplina.getNomeDisciplina() + 
		                       "\nNota Mínima: " + disciplina.getNotaMinima() + "\n";

		            // Percorrer o array de cursos e buscar os alunos matriculados na disciplina
		            for (Curso curso : arrayCurso) {
		                if (curso.getCodDisciplina() == disciplina.getCodDisciplina()) {
		                    // Aqui, você deve procurar o aluno pelo código do curso
		                    for (Aluno aluno : arrayAluno) {
		                        if (aluno.getMatriculaAluno() == curso.getMatricCurso()) {
		                            // Exibir o aluno e as notas associadas a ele
		                            conteudo += "Aluno: " + aluno.getNome() + 
		                                        "\nMatrícula: " + aluno.getMatriculaAluno() + 
		                                        "\nNota 1: " + curso.getNota1() + 
		                                        "\nNota 2: " + curso.getNota2() + "\n";
		                        }
		                    }
		                }
		            }

		            // Salvar as informações no arquivo de resultados
		            Util.salvarEmArquivo(conteudo, "resultado_busca_disciplina.txt");
		            return;
		        }
		    }
		    System.out.println("Disciplina não encontrada.");
		}

}
