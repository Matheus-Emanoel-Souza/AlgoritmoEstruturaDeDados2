package ClassPrimaria;

public class Disciplina {
 
    private int CodDisciplina;
    private String NomeDisciplina;
    private float NotaMinima;

    public Disciplina(int CodDisciplina, String NomeDisciplina, float NotaMinima) {
        this.CodDisciplina = CodDisciplina;
        this.NomeDisciplina = NomeDisciplina;
        this.NotaMinima = NotaMinima;
    }

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