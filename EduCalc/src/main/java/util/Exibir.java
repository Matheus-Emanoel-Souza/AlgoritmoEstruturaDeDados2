package util;


import ClassPrimaria.ListaDuplamenteEncadeada;
import ClassPrimaria.No;
import model.Aluno;
import model.Curso;
import model.Disciplina;
public class Exibir {
//impedir instanciamento sem querer.
	private Exibir() {}
	
    public static void exibirAluno(Aluno aluno) {
        System.out.println(aluno.getNome());
    }

    public static void exibirNomeAlunosDeLista(ListaDuplamenteEncadeada<Aluno> listaDeAlunos) {
        No<Aluno> aux = listaDeAlunos.getHead();
        while (aux != null) {
            exibirAluno(aux.getConteudo()); // chamada de método estático
            aux = aux.getProximo();
        }
    }

    public static void exibirDisciplina(Disciplina disciplina) {
        System.out.println(disciplina.getNomeDisciplina());
    }

    public static void exibirNomeDisciplinaDaLista(ListaDuplamenteEncadeada<Disciplina> listaDeDisciplinas) {
        No<Disciplina> aux = listaDeDisciplinas.getHead();
        while (aux != null) {
            exibirDisciplina(aux.getConteudo());
            aux = aux.getProximo();
        }
    }

    public static void exibirCurso(Curso curso) {
        System.out.println(
            "Matrícula: " + curso.getMatricCurso() +
            " | Cod. Disciplina: " + curso.getCodDisciplina() +
            " | Média: " + curso.calculaMedia()
        );
    }

    public static void exibirCursos(ListaDuplamenteEncadeada<Curso> listaDeCursos) {
        No<Curso> aux = listaDeCursos.getHead();
        if(listaDeCursos.getTamanho() == 0) {
        	System.out.println("Lista Vazia!!");
        }
        while (aux != null) {
            exibirCurso(aux.getConteudo());
            aux = aux.getProximo();
        }
    }
}