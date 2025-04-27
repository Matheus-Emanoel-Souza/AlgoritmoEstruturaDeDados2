package PT2;
import ClassPrimaria.Aluno;
import ClassPrimaria.Curso;
import ClassPrimaria.Disciplina;
import ClassPrimaria.listaEncadeada;
import ClassPrimaria.no;

public class ExibirPT2 {
	public void exibirAluno() {
	}
	public void exibirNomeAlunosDeLista(listaEncadeada<Aluno> listadealunos) {
		no<Aluno> aux = listadealunos.getPrimeiro();
		for(int i = 0; i<listadealunos.getContador();i++) {
			System.out.println(aux.getDado().getNome());
			aux = aux.getProx();
		}
	}
	public void exibirNomeDisciplinaDaLista(listaEncadeada<Disciplina> listadedisciplinas) {
		no<Disciplina> aux = listadedisciplinas.getPrimeiro();
		for(int i = 0; i<listadedisciplinas.getContador();i++) {
			System.out.println(aux.getDado().getNomeDisciplina());
			aux = aux.getProx();
		}
	}
	public void exibirMediaDoCurso(listaEncadeada<Curso> listadecursos) {
		no<Curso> aux = listadecursos.getPrimeiro();
		for(int i = 0; i<listadecursos.getContador() ; i++) {
			System.out.println(aux.getDado().calculaMedia());
		}
	}
}
