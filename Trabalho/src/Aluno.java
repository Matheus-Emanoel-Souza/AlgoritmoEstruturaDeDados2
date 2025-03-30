public class Aluno extends Curso{
	//Variáveis primárias
	private int MatriculaAluno;
	private String Nome;
	private int Idade;
	
	public Aluno(int matriCurso, int coddisciplina, float nota1, float nota2) {
		super(matriCurso, coddisciplina, nota1, nota2);
		// TODO Auto-generated constructor stub
	}


	public Aluno(int matricula, String nome2, int idade2) {
		MatriculaAluno=matricula;
		Nome=nome2;
		Idade=idade2;
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


	public void setIdade(int Idade) {
		this.Idade = Idade;
	}


	public String getNome() {
		return Nome;
	}

	public void setNome(String Nome) {
		this.Nome = Nome;
	}

	
}
