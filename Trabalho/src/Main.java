import java.io.IOException;
import ClassPrimaria.Aluno;
import ClassPrimaria.Curso;
import ClassPrimaria.Disciplina;
import ClassPrimaria.ListaDuplamenteEncadeada;

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
		
		//Funções de exibição
		Exibir exibicao = new Exibir();
		//exibicao.exibirNomeAlunosDeLista(ListaAlunos);
		//exibicao.exibirNomeDisciplinaDaLista(ListaDisciplinas);
		//exibicao.exibircurso(ListaCursos);
		
		//Função Montar Relatório

	}
}
