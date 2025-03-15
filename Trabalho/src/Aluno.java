
public class Aluno {
	
	private int Matricula;
	private String Nome;
	private String Disciplina;
	private String Curso;
	
	public String getDisciplina() {
		return Disciplina;
	}

	public void setDisciplina(String disciplina) {
		Disciplina = disciplina;
	}

	public String getCurso() {
		return Curso;
	}

	public void setCurso(String curso) {
		Curso = curso;
	}

	public float getNota1() {
		return Nota1;
	}

	public void setNota1(float nota1) {
		Nota1 = nota1;
	}

	public float getNota2() {
		return Nota2;
	}

	public void setNota2(float nota2) {
		Nota2 = nota2;
	}

	private float Nota1;
	private float Nota2;
	
	
	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public int getMatricula() {
		return Matricula;
	}

	public void setMatricula(int matricula) {
		Matricula = matricula;
	}

	

}
