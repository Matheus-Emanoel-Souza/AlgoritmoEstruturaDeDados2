package PT2;
import ClassPrimaria.Aluno;
import ClassPrimaria.lista;
import ClassPrimaria.no;

public class ExibirPT2 {
	public void exibirAluno() {
	}
	public void exibirNomeAlunosDeLista(lista<Aluno> listadealunos) {
		no<Aluno> aux = listadealunos.getPrimeiro();
		for(int i = 0; i<listadealunos.getContador();i++) {
			System.out.println(aux.getDado().getNome());
			aux = aux.getProx();
		}
	}
}
