
public class Disciplina extends Curso{
	
public Disciplina(int matriCurso, int coddisciplina, float nota1, float nota2) {
		super(matriCurso, coddisciplina, nota1, nota2);
		// TODO Auto-generated constructor stub
	}
private int CodDisciplina;
private String NomeDisciplina;
private float NotaMinima;

public int getCodDisciplina() {
	return CodDisciplina;
}
public void setCodDisciplina(int codDisciplina) {
	CodDisciplina = codDisciplina;
}
public String getNomeDisciplina() {
	return NomeDisciplina;
}
public void setNomeDisciplina(String nomeDisciplina) {
	NomeDisciplina = nomeDisciplina;
}
public float getNotaMinima() {
	return NotaMinima;
}
public void setNotaMinima(float notaMinima) {
	NotaMinima = notaMinima;
}
}
