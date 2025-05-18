package ClassPrimaria;
import java.io.IOException;

import metodosAuxiliares.Exibir;
import metodosAuxiliares.PreencheLista;
import metodosAuxiliares.Relatorio;

public class Main {
	public static void main(String[] args) throws IOException {

		// ystem.out.println(new File("").getAbsolutePath());
		// 1a passo criar as listas
		ListaDuplamenteEncadeada<Aluno> ListaAlunos = new ListaDuplamenteEncadeada<Aluno>();
		ListaDuplamenteEncadeada<Disciplina> ListaDisciplinas = new ListaDuplamenteEncadeada<Disciplina>();
		ListaDuplamenteEncadeada<Curso> ListaCursos = new ListaDuplamenteEncadeada<Curso>();
		// 2a passo, preencher as listas com os dados do TXT
		String caminhoBase = System.getProperty("user.dir");
		String CaminhoAlunos = caminhoBase + "\\src\\TXT\\Alunos.txt";
		String CaminhoDisciplinas = caminhoBase + "\\src\\TXT\\Disciplinas.txt";
		String CaminhoCursos = caminhoBase + "\\src\\TXT\\Cursos.txt";
		PreencheLista iniciodocodigo = new PreencheLista();
		iniciodocodigo.MontaListaAluno(ListaAlunos, CaminhoAlunos);
		iniciodocodigo.MontaListaDisciplina(ListaDisciplinas, CaminhoDisciplinas);
		iniciodocodigo.MontaListaCurso(ListaDisciplinas, ListaAlunos, ListaCursos, CaminhoCursos);
		//Posso colocar tudo o que está em cima em uma classe.
		
		
		//Funções de exibição
		Exibir exibicao = new Exibir();
		//exibicao.exibirNomeAlunosDeLista(ListaAlunos);
		exibicao.exibirNomeDisciplinaDaLista(ListaDisciplinas);
		//exibicao.exibircurso(ListaCursos);
		//Exibir relatório.
		//Manipular o relatório.
		
		//Função Montar Relatório
		Relatorio relat = new Relatorio();
		//relat.Criar();
		//relat.LimpaRelatorio();
		relat.AdcDisciplina(ListaAlunos, ListaDisciplinas, ListaCursos, 601);
		//relat.AdcAluno(ListaAlunos, ListaDisciplinas, ListaCursos, 10001);
	}
}
