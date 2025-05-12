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
    public boolean validaAlunoNaLista(Aluno aluno, ListaDuplamenteEncadeada<Aluno> listaDeAlunos) {
        No<Aluno> atual = listaDeAlunos.getHead();

        while (atual != null) {
            if (atual.getConteudo().getMatriculaAluno() == aluno.getMatriculaAluno()) {
                return true;
            }
            atual = atual.getProximo();
        }

        return false; 
    }
}



