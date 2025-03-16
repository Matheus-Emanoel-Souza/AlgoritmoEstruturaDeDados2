
public class Curso {
	
	private int MatricCurso;
	private int CodCurso;
	private float Nota1;
	private float Nota2;
	
	public Curso() { 
	}
	
	public int getMatricCurso() {
		return MatricCurso;
	}
	public void setMatricCurso(int matricCurso) {
		MatricCurso = matricCurso;
	}
	public int getCodDisciplina() {
		return CodCurso;
	}
	public void setCodDisciplina(int codDisciplina) {
		CodCurso = codDisciplina;
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
	
	Curso(int matriCurso, int coddisciplina, float nota1, float nota2) {
		setMatricCurso(matriCurso);
		setCodDisciplina(coddisciplina);
		setNota1(nota1);
		setNota2(nota2);
	}
	}

