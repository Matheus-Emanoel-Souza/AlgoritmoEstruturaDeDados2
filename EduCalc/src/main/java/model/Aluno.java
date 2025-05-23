package model;

import ClassPrimaria.ListaDuplamenteEncadeada;
import ClassPrimaria.No;

public class Aluno {
    private int MatriculaAluno;
    private String Nome;
    private int Idade;

    public Aluno(int matricula, String nome, int idade) {
        this.MatriculaAluno = matricula;
        this.Nome = nome;
        this.Idade = idade;
    }

    public Aluno() {
		// TODO Auto-generated constructor stub
	}

	public int getMatriculaAluno() {
        return MatriculaAluno;
    }

    public void setMatriculaAluno(int matriculaAluno) {
        MatriculaAluno = matriculaAluno;
    }

    public int getIdade() {
        return Idade;
    }

    public void setIdade(int idade) {
        Idade = idade;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    } 
    
    
    
    //Constroi a string de cursos do aluno. Essa função não consigo construir 
    public String constroi_cursos_aluno(Aluno aluno,ListaDuplamenteEncadeada<Curso> ListaCursos,
    									ListaDuplamenteEncadeada<Disciplina> ListaDisciplinas) {
    	
    	
    	StringBuilder cursos = new StringBuilder();
    	No<Curso> no = ListaCursos.getHead();
    	
    	
    	//andar a lista toda, independente do no
    	while(no !=null) {	
    		
    		if(no.getConteudo().getMatricCurso() == aluno.getMatriculaAluno()) {
    			cursos.append(" Código: ").append(no.getConteudo().getCodDisciplina()).append(" | ");
    			No<Disciplina> noaux = ListaDisciplinas.getHead();
    			
    			while(noaux != null) {
    				if(noaux.getConteudo().getCodDisciplina( )== no.getConteudo().getCodDisciplina()) {
    					
    					cursos.append(" Nome:"+noaux.getConteudo().getNomeDisciplina()).append(" | ");
    					cursos.append(" Média Necessária:"+noaux.getConteudo().getNotaMinima()).append(" | ");
    					if(no.getConteudo().calculaMedia() >= noaux.getConteudo().getNotaMinima()) {
    	                	cursos.append(" Status: APROVADO!!").append(" | ");
    	                }
    	                else {
    	                	cursos.append(" Status: Reprovado!!").append(" | ");
    	                }
    				}
    				noaux = noaux.getProximo();
    			}			
                cursos.append(" Nota 1: ").append(no.getConteudo().getNota1()).append(" | ");
                cursos.append(" Nota 2: ").append(no.getConteudo().getNota2()).append(" | ");
                cursos.append(" Média: ").append(no.getConteudo().calculaMedia()).append("\n");
                cursos.append("-------------------------------------------------------------------------------------------------\n");   		
    		}
    		no = no.getProximo();
    	}
    	
		return cursos.toString();   	
    }
    
    //Funcao parar aluno(apenas matricula) -> aluno(completo);
    public Aluno constroi_alunoCompleto(int matricula, ListaDuplamenteEncadeada<Aluno> listaDeAlunos) {
        No<Aluno> no = listaDeAlunos.getHead();
        while (no != null) {
            if (no.getConteudo().getMatriculaAluno() == matricula) {
                return no.getConteudo();  
            }
            no = no.getProximo();
        }
        //caso nao achar.
        System.out.println("Aluno+constroi_alunoCompleto: Erro!");
        return null; 
    }
    
}



