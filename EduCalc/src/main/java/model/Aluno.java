package model;

import ClassPrimaria.ListaDuplamenteEncadeada;
import ClassPrimaria.No;
import util.Exibir;

public class Aluno {
    private int MatriculaAluno;
    private String Nome;
    private int Idade;

    public Aluno(int matricula, String nome, int idade) {
        this.MatriculaAluno = matricula;
        this.Nome = nome;
        this.Idade = idade;
    }
    public Aluno(int matricula) {
        this.MatriculaAluno = matricula;
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

    // Fun. para validar objeto na lista;        
    public int IndiceAluno(Aluno aluno, ListaDuplamenteEncadeada<Aluno> listaDeAlunos) {
    	int indice =0;
    	No<Aluno> percorre = listaDeAlunos.getHead();
    	
    	while(percorre != null && aluno.getMatriculaAluno() != percorre.getConteudo().getMatriculaAluno()) {
    		indice ++;
    		percorre = percorre.getProximo();
    	}
    	if (percorre == null) {
            return -1;
        }else {
        	return indice;
        }

    }
    //Função para buscar o nome do aluno pela matricula, Não lembro pra que criei isso
	
	  public String nomeAluno(int matricula,ListaDuplamenteEncadeada<Aluno>
	  listaDeAlunos) { String nomeAluno=null; No<Aluno> per =
	  listaDeAlunos.getHead(); while(per != null) {
	  if(per.getConteudo().getMatriculaAluno() == matricula) { nomeAluno =
	  per.getConteudo().getNome(); } per = per.getProximo(); } return nomeAluno; }   

    //Aluno apenas com matricula vai passar a ser aluno com todos os dados que está na lista!!!
    public void constroi_aluno_indice(Aluno aluno, ListaDuplamenteEncadeada<Aluno> listaDeAlunos) {
    	int a = IndiceAluno(aluno,listaDeAlunos);
    	
    	if(a != -1){
    		No<Aluno> no = listaDeAlunos.getHead();
    		for(int i = 0; i<a; i++) {
    			no = no.getProximo();
    		}
    		System.out.println("Indice na função interna é:"+a);
    		
    		aluno = no.getConteudo();
    		//Teste para ver se é o mesmo aluno!
    		Exibir.exibirAluno(aluno);
    	}
    		
    }
    
    //Constroi a string de cursos do aluno.
    public String constroi_cursos_aluno(Aluno aluno,ListaDuplamenteEncadeada<Curso> ListaCursos,
    		ListaDuplamenteEncadeada<Disciplina> ListaDisciplinas) {
    	StringBuilder cursos = new StringBuilder();
    	No<Curso> no = ListaCursos.getHead();
    	Disciplina disc = new Disciplina();
    	//andar a lista toda, independente do no
    	while(no !=null) {
    		
    		if(no.getConteudo().getMatricCurso() == aluno.getMatriculaAluno()) {
    			cursos.append("Código: ").append(no.getConteudo().getCodDisciplina()).append(" | ");
    			cursos.append("Nome:"+disc.nomeDisciplina(no.getConteudo().getCodDisciplina(), ListaDisciplinas));
                cursos.append("Nota 1: ").append(no.getConteudo().getNota1()).append(" | ");
                cursos.append("Nota 2: ").append(no.getConteudo().getNota2()).append(" | ");
                cursos.append("Média: ").append(no.getConteudo().calculaMedia()).append("\n");
                cursos.append("---------------------------------------------------------------------------------\n");
               
    		
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
    
    public void RemoverAluno(int matricula, ListaDuplamenteEncadeada<Aluno> listaDeAlunos) {
        No<Aluno> no = listaDeAlunos.getHead();

        while (no != null) {
            if (no.getConteudo().getMatriculaAluno() == matricula) {
                
                if (no == listaDeAlunos.getHead()) {
                    listaDeAlunos.setHead(no.getProximo());
                    if (listaDeAlunos.getHead() != null) {
                        listaDeAlunos.getHead().setAnterior(null);
                    } else {
                        
                        listaDeAlunos.setTail(null);
                    }
                }
                
                else if (no == listaDeAlunos.getTail()) {
                    listaDeAlunos.setTail(no.getAnterior());
                    if (listaDeAlunos.getTail() != null) {
                        listaDeAlunos.getTail().setProximo(null);
                    }
                }
                
                else {
                    no.getAnterior().setProximo(no.getProximo());
                    no.getProximo().setAnterior(no.getAnterior());
                }

                listaDeAlunos.setTamanho(listaDeAlunos.getTamanho()-1);
                return;
            }

            no = no.getProximo();
        }
    }


}



