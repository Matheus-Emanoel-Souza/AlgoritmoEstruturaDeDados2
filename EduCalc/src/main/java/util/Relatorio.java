package util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.imageio.IIOException;


public class Relatorio {

    // Caminho base do arquivo
    private final String caminhoBase = System.getProperty("user.dir");
    private final File arquivo = new File(caminhoBase, "RelatórioTXT");

    // Data e hora atuais formatadas
    private final LocalDateTime agora = LocalDateTime.now();
    private final DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private final String dataFormatada = agora.format(formato);

    // StringBuilder para montar o conteúdo do relatório
    @SuppressWarnings("unused")
	private final StringBuilder conteudo = new StringBuilder();

    // Verifica se o arquivo já existe
    public boolean checarRelatorio() {
        return arquivo.exists() && arquivo.isFile();
    }

    // Cria o arquivo de relatório
    public void criar() throws IOException {
        if (!checarRelatorio()) {
            try {
                FileWriter writer = new FileWriter(arquivo);
                writer.write("Relatório Criado em: " + dataFormatada);
                writer.close();
            } catch (IIOException e) {
                System.out.println("Erro ao criar arquivo!!!");
            }
        }
    }

    // Limpa o conteúdo do relatório
    public void limpaRelatorio() throws IOException {
        try {
            FileWriter limpa = new FileWriter(arquivo, false);
            limpa.write("");
            limpa.close();
            System.out.println("Arquivo limpo com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao limpar: " + e.getMessage());
        }
    }
    

	/*
	 * // Adiciona informações de um aluno ao relatório public void adcAluno(
	 * ListaDuplamenteEncadeada<Aluno> listaAlunos,
	 * ListaDuplamenteEncadeada<Disciplina> listaDisciplinas,
	 * ListaDuplamenteEncadeada<Curso> listaCursos, int matriculaAluno ) throws
	 * IOException { Aluno alunoProcurado = new Aluno(matriculaAluno);
	 * 
	 * if (alunoProcurado.IndiceAluno(alunoProcurado, listaAlunos) != 0) {
	 * conteudo.append("Nome do Aluno: ")
	 * .append(alunoProcurado.nomeAluno(matriculaAluno, listaAlunos)) .append("\n");
	 * 
	 * // Percorre os cursos do aluno No<Curso> aux = listaCursos.getHead();
	 * No<Disciplina> nome = listaDisciplinas.getHead();
	 * 
	 * while (aux != null) { if (aux.getConteudo().getMatricCurso() ==
	 * alunoProcurado.getMatriculaAluno()) { conteudo.append("Disciplina: ")
	 * .append(nome.getConteudo().nomeDisciplina(aux.getConteudo().getCodDisciplina(
	 * ), listaDisciplinas))
	 * .append(" - Cod: ").append(aux.getConteudo().getCodDisciplina()).append("\n")
	 * .append("Nota1: ").append(aux.getConteudo().getNota1()).append("\n")
	 * .append("Nota2: ").append(aux.getConteudo().getNota2()).append("\n")
	 * .append("Média: ").append(aux.getConteudo().calculaMedia()).append("\n")
	 * .append("----------------------------------\n"); } aux = aux.getProximo(); }
	 * 
	 * FileWriter escritor = new FileWriter(arquivo, true);
	 * escritor.write(conteudo.toString()); escritor.close();
	 * System.out.println("Relatório salvo com sucesso!!"); } else {
	 * System.out.println("Aluno não registrado!!!"); } }
	 * 
	 * // Adiciona informações de uma disciplina ao relatório public void
	 * adcDisciplina( ListaDuplamenteEncadeada<Aluno> listaAlunos,
	 * ListaDuplamenteEncadeada<Disciplina> listaDisciplinas,
	 * ListaDuplamenteEncadeada<Curso> listaCursos, int codDisciplina ) throws
	 * IOException { No<Disciplina> disc = listaDisciplinas.getHead();
	 * System.out.println(disc.getConteudo().getIndice(codDisciplina,
	 * listaDisciplinas));
	 * 
	 * if (disc.getConteudo().getIndice(codDisciplina, listaDisciplinas) != 0) {
	 * conteudo.append("Disciplina: ")
	 * .append(disc.getConteudo().nomeDisciplina(codDisciplina, listaDisciplinas))
	 * .append(" - Cod: ").append(disc.getConteudo().getCodDisciplina()).append("\n"
	 * );
	 * 
	 * No<Curso> noCursoAux = listaCursos.getHead(); No<Aluno> noAlunoAux =
	 * listaAlunos.getHead();
	 * 
	 * while (noCursoAux != null) { if (noCursoAux.getConteudo().getCodDisciplina()
	 * == codDisciplina) { conteudo.append("Aluno: ")
	 * .append(noAlunoAux.getConteudo().nomeAluno(noCursoAux.getConteudo().
	 * getMatricCurso(), listaAlunos)) .append("\n"); } noCursoAux =
	 * noCursoAux.getProximo(); }
	 * 
	 * FileWriter escritor = new FileWriter(arquivo, true);
	 * escritor.write(conteudo.toString()); escritor.close(); } else {
	 * System.out.println("Disciplina não registrada!!"); } }
	 */

    
    // Futuro método de remover disciplina do relatório (ainda não implementado)
    public void remDisciplina() {}
}
