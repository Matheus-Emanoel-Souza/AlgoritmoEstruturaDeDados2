package metodosAuxiliares;
import ClassPrimaria.Aluno;
import ClassPrimaria.Curso;
import ClassPrimaria.Disciplina;
import ClassPrimaria.ListaDuplamenteEncadeada;
import ClassPrimaria.No;

public class busca {
//filtrar por disciplina e por aluno;
public ListaDuplamenteEncadeada<Aluno> AlunosPorDiciplina(int cod,
			ListaDuplamenteEncadeada<Disciplina> ListaDisciplinas,
			ListaDuplamenteEncadeada<Curso> ListaDeCursos,
			ListaDuplamenteEncadeada<Aluno> ListaDeAlunosGerais) {
	
	ListaDuplamenteEncadeada<Aluno> AlunosPorDiciplina = new ListaDuplamenteEncadeada<Aluno>();
	
	//verificar se Disciplina existe.
	No<Disciplina> auxDisciplina = ListaDisciplinas.getHead();
	
	if((auxDisciplina.getConteudo().getIndice(cod, ListaDisciplinas)!=0)) {

		No<Curso> auxCurso = ListaDeCursos.getHead();
		
		while(auxCurso.getProximo() != null) {
			if(auxCurso.getConteudo().getCodDisciplina() == cod) {
				//preencher a lista de alunos;
				No<Aluno> auxAluno = ListaDeAlunosGerais.getHead();
				while(auxAluno.getProximo()!=null) {
					
				}
			}
			auxCurso = auxCurso.getProximo();
		}
		//percorrer lista de Cursos buscando por 304;
		
		
	}
	return AlunosPorDiciplina;
}
}
