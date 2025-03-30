public class Exibir {
    public static void exibirInformacoesAluno(Aluno aluno) {
        System.out.println("==== Detalhes do Aluno ====");
        System.out.println("Nome: " + aluno.getNome());
        System.out.println("Matrícula: " + aluno.getMatriculaAluno());
        System.out.println("Idade: " + aluno.getIdade());
        System.out.println("===========================");
    }

    public static void exibirInformacoesDisciplina(Disciplina disciplina) {
        System.out.println("==== Detalhes da Disciplina ====");
        System.out.println("Código: " + disciplina.getCodDisciplina());
        System.out.println("Nome: " + disciplina.getNomeDisciplina());
        System.out.println("Nota Mínima: " + disciplina.getNotaMinima());
        System.out.println("===============================");
    }
    public static void exibirInformacoesCurso(Curso curso) {
        System.out.println("==== Detalhes do Curso ====");
        System.out.println("Matrícula do Curso: " + curso.getMatricCurso());
        System.out.println("Código da Disciplina: " + curso.getCodDisciplina());
        System.out.println("Nota 1: " + curso.getNota1());
        System.out.println("Nota 2: " + curso.getNota2());
        System.out.println("=============================");
    }
}
