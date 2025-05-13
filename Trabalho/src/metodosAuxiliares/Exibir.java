package metodosAuxiliares;


import ClassPrimaria.Aluno;
import ClassPrimaria.Curso;
import ClassPrimaria.Disciplina;
import ClassPrimaria.ListaDuplamenteEncadeada;
import ClassPrimaria.No;

public class Exibir {
	//Exibi aluno individualmente.
	public void exibirAluno(Aluno aluno) {
	    System.out.println(aluno.getNome());
	}
	//Exibi o conjuntto de alunos na lista;
	public void exibirNomeAlunosDeLista(ListaDuplamenteEncadeada<Aluno> listaDeAlunos) {
	    No<Aluno> aux = listaDeAlunos.getHead();
	    while (aux != null) {
	        exibirAluno(aux.getConteudo());
	        aux = aux.getProximo();
	    }
	}
	 //Exibi disciplina
	public void exibirDisciplina(Disciplina disciplina) {
	    System.out.println(disciplina.getNomeDisciplina());
	}

	public void exibirNomeDisciplinaDaLista(ListaDuplamenteEncadeada<Disciplina> listaDeDisciplinas) {
	    No<Disciplina> aux = listaDeDisciplinas.getHead();
	    while (aux != null) {
	        exibirDisciplina(aux.getConteudo());
	        aux = aux.getProximo();
	    }
	}

    
	public void exibirCurso(Curso curso) {
	    System.out.println(
	        "Matrícula: " + curso.getMatricCurso() +
	        " | Cod. Disciplina: " + curso.getCodDisciplina() +
	        " | Média: " + curso.calculaMedia()
	    );
	}

	public void exibirCursos(ListaDuplamenteEncadeada<Curso> listaDeCursos) {
	    No<Curso> aux = listaDeCursos.getHead();
	    while (aux != null) {
	        exibirCurso(aux.getConteudo());
	        aux = aux.getProximo();
	    }
	}

}

