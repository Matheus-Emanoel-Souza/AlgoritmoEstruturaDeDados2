package ClassPrimaria;

public class Aluno {
    private int MatriculaAluno;
    private String Nome;
    private int Idade;

    public Aluno(int matricula, String nome, int idade) {
        this.MatriculaAluno = matricula;
        this.Nome = nome;
        this.Idade = idade;
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
    	while(aluno.getMatriculaAluno() != percorre.getConteudo().getMatriculaAluno()) {
    		indice ++;
    		percorre = percorre.getProximo();
    	}
    	return indice;
    }
}



