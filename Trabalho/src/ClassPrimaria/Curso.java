package ClassPrimaria;

public class Curso {

    private int MatricCurso;
    private int CodCurso;
    private float Nota1;
    private float Nota2;

    public float calculaMedia() {
        return (Nota1 + Nota2) / 2;
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

    public Curso(int matriCurso, int coddisciplina, float nota1, float nota2) {
        setMatricCurso(matriCurso);
        setCodDisciplina(coddisciplina);
        setNota1(nota1);
        setNota2(nota2);
    }

    //validação de objeto para lista.
    public boolean validaCursoNaLista(Curso curso, ListaDuplamenteEncadeada<Curso> listaDeCursos) {
        No<Curso> atual = listaDeCursos.getHead();

        while (atual != null) {
            Curso cursoAtual = atual.getConteudo();
            if (cursoAtual.getMatricCurso() == curso.getMatricCurso() &&
                cursoAtual.getCodDisciplina() == curso.getCodDisciplina()) {
                return true;
            }
            atual = atual.getProximo();
        }

        return false;
    }
}
