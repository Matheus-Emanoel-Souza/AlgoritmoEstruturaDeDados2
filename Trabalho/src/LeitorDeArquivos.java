import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import ClassPrimaria.Aluno;
import ClassPrimaria.Curso;
import ClassPrimaria.Disciplina;

public class LeitorDeArquivos {

    public static Curso[] lerCursos(String caminho, Curso[] cursos, Disciplina[] arrayDisciplina, Aluno[] arrayAluno) throws IOException {
        String[] linhas = lerArquivo(caminho);
        cursos = new Curso[linhas.length];

        for (int i = 0; i < linhas.length; i++) {
            String[] partes = linhas[i].split(";");
            String matricula = partes[0];
            String codDisciplina = partes[1];
            float nota1 = Float.parseFloat(partes[2]);
            float nota2 = Float.parseFloat(partes[3]);

            boolean matriculaEncontrada = false;
            for (Aluno aluno : arrayAluno) {
                if (Integer.toString(aluno.getMatriculaAluno()).equals(matricula)) {
                    matriculaEncontrada = true;
                    break;
                }
            }

            boolean disciplinaEncontrada = false;
            for (Disciplina disciplina : arrayDisciplina) {
                if (Integer.toString(disciplina.getCodDisciplina()).equals(codDisciplina)) {
                    disciplinaEncontrada = true;
                    break;
                }
            }

            if (matriculaEncontrada && disciplinaEncontrada) {
                cursos[i] = new Curso(Integer.parseInt(matricula), Integer.parseInt(codDisciplina), nota1, nota2);
            }
        }
        return cursos;
    }

    public static Aluno[] lerAlunos(String caminho) throws IOException {
        String[] linhas = lerArquivo(caminho);
        Aluno[] alunos = new Aluno[linhas.length];

        for (int i = 0; i < linhas.length; i++) {
            String[] partes = linhas[i].split(";");
            int matricula = Integer.parseInt(partes[0]);
            String nome = partes[1];
            int idade = Integer.parseInt(partes[2]);

            alunos[i] = new Aluno(matricula, nome, idade);
        }
        return alunos;
    }

    public static Disciplina[] lerDisciplinas(String caminho) throws IOException {
        String[] linhas = lerArquivo(caminho);
        Disciplina[] disciplinas = new Disciplina[linhas.length];

        for (int i = 0; i < linhas.length; i++) {
            String[] partes = linhas[i].split(";");
            int codigo = Integer.parseInt(partes[0]);
            String nome = partes[1];
            float notaMinima = Float.parseFloat(partes[2]);

            disciplinas[i] = new Disciplina(codigo, nome, notaMinima);
        }
        return disciplinas;
    }

    public static String[] lerArquivo(String caminho) throws IOException {
        File arquivo = new File(caminho);
        if (!arquivo.exists()) {
            System.out.println("Arquivo não encontrado: " + caminho);
            return new String[0];
        }

        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            return br.lines().toArray(String[]::new);
        }
    }
}
