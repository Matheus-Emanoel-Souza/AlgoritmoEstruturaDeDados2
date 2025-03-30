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
	            Util.salvarEmArquivo(conteudo);
	            return;
	        }
	    }

	    System.out.println("Aluno não encontrado.");
	}

	 public static void buscarDisciplina(Scanner scanner, Disciplina[] arrayDisciplina, Aluno[] arrayAluno, Curso[] arrayCurso) {
		    System.out.println("Digite o código ou o nome da disciplina:");
		    String busca = scanner.nextLine();

		    for (Disciplina disciplina : arrayDisciplina) {
		        if (busca.equalsIgnoreCase(disciplina.getNomeDisciplina()) || busca.equals(String.valueOf(disciplina.getCodDisciplina()))) {
		            Exibir.exibirInformacoesDisciplina(disciplina);
		            String conteudo1 = "Disciplina encontrada:\nCódigo: " + disciplina.getCodDisciplina() + 
		                               "\nNome: " + disciplina.getNomeDisciplina() + 
		                               "\nNota Mínima: " + disciplina.getNotaMinima() + "\n\n";

		            boolean encontrouAlunos = false;

		            for (Curso curso : arrayCurso) {
		                if (curso.getCodDisciplina() == disciplina.getCodDisciplina()) {
		                    System.out.println("Curso encontrado para a disciplina: " + disciplina.getNomeDisciplina());

		                    for (Aluno aluno : arrayAluno) {
		                        if (aluno.getMatriculaAluno() == curso.getMatricCurso()) {
		                            encontrouAlunos = true;
		                            conteudo1 += "Aluno: " + aluno.getNome() + 
		                                         "\nMatrícula: " + aluno.getMatriculaAluno() + 
		                                         "\nNota 1: " + curso.getNota1() + 
		                                         "\nNota 2: " + curso.getNota2() + "\n\n";
		                            
		                            System.out.println("Aluno encontrado: " + aluno.getNome() + " | Matrícula: " + aluno.getMatriculaAluno());
		                        }
		                    }
		                }
		            }

		            if (!encontrouAlunos) {
		                conteudo1 += "Nenhum aluno matriculado nesta disciplina.\n";
		                System.out.println("Nenhum aluno encontrado para esta disciplina.");
		            }

		            Util.salvarEmArquivo(conteudo1);
		            return;
		        }
		    }
		    System.out.println("Disciplina não encontrada.");
		}}
