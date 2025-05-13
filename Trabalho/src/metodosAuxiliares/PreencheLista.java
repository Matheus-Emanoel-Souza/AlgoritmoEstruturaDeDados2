package metodosAuxiliares;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import ClassPrimaria.Aluno;
import ClassPrimaria.Curso;
import ClassPrimaria.Disciplina;
import ClassPrimaria.ListaDuplamenteEncadeada;
import ClassPrimaria.No;

public class PreencheLista {
	// Ler txt e montar a lista aluno.
	public void MontaListaAluno(ListaDuplamenteEncadeada<Aluno> listAlunos, String caminho) throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
			// 1a verifico se a linha está preenchida
			String linha;
			while ((linha = br.readLine()) != null) {
				// 2a Crio um vetor para separar e organizar meus dados
				// meus dados vira um vetor splitado por ";"
				String[] dados = linha.split(";");
				// Verifico se a linha foi montada corretamente;
				if (dados.length == 3) {
					int cod = Integer.parseInt(dados[0]);// Viável validação
					String nome = dados[1];
					int idade = Integer.parseInt(dados[2]);

					Aluno aluno1 = new Aluno(cod, nome, idade);
					listAlunos.addFirst(aluno1);
				}
			}
		}
		System.out.println("Arquivo carregado com sucesso!!!");
	}

	public void MontaListaDisciplina(ListaDuplamenteEncadeada<Disciplina> listDisciplina, String caminho)
			throws FileNotFoundException, IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
			String linha;
			while ((linha = br.readLine()) != null) {
				String[] dados = linha.split(";");
				if (dados.length == 3) {
					int codDisciplina = Integer.parseInt(dados[0]);
					String nomeDisciplina = dados[1];
					float NotaCorte = Float.parseFloat(dados[2]);

					Disciplina disci1 = new Disciplina(codDisciplina, nomeDisciplina, NotaCorte);
					listDisciplina.addFirst(disci1);
				}
			}
		}
		System.out.println("Arquivo carregado com sucesso!!!");
	}

	public void MontaListaCurso(
	        ListaDuplamenteEncadeada<Disciplina> listDisciplina,
	        ListaDuplamenteEncadeada<Aluno> listAlunos,
	        ListaDuplamenteEncadeada<Curso> listCursos,
	        String Caminho
	) throws FileNotFoundException, IOException {

	    try (BufferedReader br = new BufferedReader(new FileReader(Caminho))) {
	        String linha;

	        while ((linha = br.readLine()) != null) {
	            String[] dados = linha.split(";");

	            if (dados.length == 4) {
	                int matricula = Integer.parseInt(dados[0]);
	                int codDisciplina = Integer.parseInt(dados[1]);
	                float nota1 = Float.parseFloat(dados[2]);
	                float nota2 = Float.parseFloat(dados[3]);

	                // 1. Verifica se o aluno existe
	                No<Aluno> alunoAtual = listAlunos.getHead();
	                boolean alunoExiste = false;

	                while (alunoAtual != null) {
	                    if (alunoAtual.getConteudo().getMatriculaAluno() == matricula) {
	                        alunoExiste = true;
	                        break;
	                    }
	                    alunoAtual = alunoAtual.getProximo();
	                }

	                // Se o aluno não existir, pula essa linha
	                if (!alunoExiste) continue;

	                // 2. Verifica se a disciplina existe
	                No<Disciplina> disciplinaAtual = listDisciplina.getHead();
	                boolean disciplinaExiste = false;

	                while (disciplinaAtual != null) {
	                    if (disciplinaAtual.getConteudo().getCodDisciplina() == codDisciplina) {
	                        disciplinaExiste = true;
	                        break;
	                    }
	                    disciplinaAtual = disciplinaAtual.getProximo();
	                }

	                // 3. Se ambos existirem, adiciona curso
	                if (disciplinaExiste) {
	                    Curso novoCurso = new Curso(matricula, codDisciplina, nota1, nota2);
	                    listCursos.addFirst(novoCurso);
	                }
	            }
	        }
	    }
	}


}