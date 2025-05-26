package Controller;

import java.io.IOException;
import java.util.function.Predicate;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import ClassPrimaria.ListaDuplamenteEncadeada;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Aluno;
import model.Curso;
import model.Disciplina;


@WebServlet({
"/RelatorioController",
"/relatorio"
})
public class RelatorioController extends controller {
	private static final long serialVersionUID = 1L;

	
	private static ListaDuplamenteEncadeada<Aluno> ListaAlunos = new ListaDuplamenteEncadeada<Aluno>();
	private static ListaDuplamenteEncadeada<Disciplina> ListaDisciplinas = new ListaDuplamenteEncadeada<Disciplina>();
	private static ListaDuplamenteEncadeada<Curso> ListaCursos = new ListaDuplamenteEncadeada<Curso>();
	
    public RelatorioController() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
	    System.out.println("POST action: " + action);
	    if (action.equals("/relatorio")) {
	    	Carregar();
	    	Aba_relatorio(request, response);
	    }
	    if (action.equals("/RelatorioController")) {
	    	retornaRelatorio(request, response);
	    }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}
	
	protected void Aba_relatorio(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("entrou neste metodo!");
		response.sendRedirect("relatorio.jsp");
	}
	
	protected void retornaRelatorio(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("Class=relatorio container, metodo retornaRelatorio");

		// Pegando parâmetros
		String[] relatorios = request.getParameterValues("relatorio");
		String filtroIdade = request.getParameter("filtroIdade");
		String filtroMedia = request.getParameter("filtroMedia");
		String filtroQuantidade = request.getParameter("filtroQuantidade");
		String nomeMateria = request.getParameter("nomeMateria");
		String nomeAluno = request.getParameter("nomeAluno");

		try {
		    Document documento = new Document();
		    PdfWriter.getInstance(documento, response.getOutputStream());

		    documento.open();
		    documento.add(new Paragraph("Relatórios Acadêmicos", 
		        FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20, BaseColor.BLUE)));
		    documento.add(new Paragraph(" "));

		    if (relatorios != null) {
		        for (String r : relatorios) {
		            switch (r) {
		                case "listaAlunos":
		                    documento.add(new Paragraph("📜 Lista de Alunos"));

		                    documento.add(new Paragraph("Filtro Idade: " + (filtroIdade.isEmpty() ? "Nenhum" : filtroIdade)));
		                    documento.add(new Paragraph("Filtro Média: " + (filtroMedia.isEmpty() ? "Nenhum" : filtroMedia)));
		                    documento.add(new Paragraph("----------------------------"));

		                    // Montando filtros
		                    Predicate<Aluno> filtroFinal = Aluno -> true;

		                    if (filtroIdade != null && !filtroIdade.isEmpty()) {
		                        switch (filtroIdade) {
		                            case "menor18":
		                                filtroFinal = filtroFinal.and(a -> a.getIdade() < 18);
		                                break;
		                            case "18a25":
		                                filtroFinal = filtroFinal.and(a -> a.getIdade() >= 18 && a.getIdade() <= 25);
		                                break;
		                            case "maior25":
		                                filtroFinal = filtroFinal.and(a -> a.getIdade() > 25);
		                                break;
		                        }
		                    }

		                    
		                    if (filtroMedia != null && !filtroMedia.isEmpty()) {
		                        switch (filtroMedia) {
		                            case "menor6":
		                                filtroFinal = filtroFinal.and(a -> a.getMedia(ListaCursos) < 6);
		                                break;
		                            case "6a8":
		                                filtroFinal = filtroFinal.and(a -> a.getMedia(ListaCursos) >= 6 && a.getMedia(ListaCursos) <= 8);
		                                break;
		                            case "maior8":
		                                filtroFinal = filtroFinal.and(a -> a.getMedia(ListaCursos) > 8);
		                                break;
		                        }
		                    }

		                    // Gerar relatório usando SEU MÉTODO
		                    String relatorioAlunos = ListaAlunos.gerarRelatorio(
		                        filtroFinal,
		                        aluno -> "Aluno: " + aluno.getNome() +
		                                " | Idade: " + aluno.getIdade() +
		                                " | Média: " + aluno.getMedia(ListaCursos)
		                    );

		                    documento.add(new Paragraph(relatorioAlunos));
		                    break;

		                case "listaDisciplinas":
		                    documento.add(new Paragraph("📘 Lista de Disciplinas"));
		                    documento.add(new Paragraph("Filtro Quantidade de Alunos: " + 
		                        (filtroQuantidade.isEmpty() ? "Nenhum" : filtroQuantidade)));
		                    documento.add(new Paragraph("----------------------------"));

		                    // Filtro para disciplinas
		                    Predicate<Disciplina> filtroDisc = d -> true;
		                    if (filtroQuantidade != null && !filtroQuantidade.isEmpty()) {
		                        switch (filtroQuantidade) {
		                            case "menor10":
		                                filtroDisc = filtroDisc.and(d -> d.qtd_alunos(ListaCursos) < 10);
		                                break;
		                            case "10a30":
		                                filtroDisc = filtroDisc.and(d -> d.qtd_alunos(ListaCursos) >= 10 && d.qtd_alunos(ListaCursos) <= 30);
		                                break;
		                            case "maior30":
		                                filtroDisc = filtroDisc.and(d -> d.qtd_alunos(ListaCursos) > 30);
		                                break;
		                        }
		                    }

		                    String relatorioDisciplinas = ListaDisciplinas.gerarRelatorio(
		                        filtroDisc,
		                        d -> "Disciplina: " + d.getNomeDisciplina() + 
		                            " | Código: " + d.getCodDisciplina() + 
		                            " | Qtd Alunos: " + d.qtd_alunos(ListaCursos)
		                    );

		                    documento.add(new Paragraph(relatorioDisciplinas));
		                    break;

		                case "materiaEspecifica":
		                    documento.add(new Paragraph("🔍 Matéria Específica"));
		                    documento.add(new Paragraph("Código da Matéria: " + 
		                        (nomeMateria.isEmpty() ? "Não informado" : nomeMateria)));
		                    documento.add(new Paragraph("----------------------------"));

		                    // Buscar disciplina
		                    Predicate<Disciplina> filtroMateria = d -> d.getNomeDisciplina().equalsIgnoreCase(nomeMateria);
		                    String relatorioMateria = ListaDisciplinas.gerarRelatorio(
		                        filtroMateria,
		                        d -> "Disciplina: " + d.getNomeDisciplina() + " | Código: " + d.getCodDisciplina()
		                    );

		                    documento.add(new Paragraph(relatorioMateria.isEmpty() ? "Nenhuma disciplina encontrada." : relatorioMateria));
		                    break;

		                case "alunoEspecifico":
		                    documento.add(new Paragraph("👨‍🎓 Aluno Específico"));
		                    documento.add(new Paragraph("Matrícula do Aluno: " + 
		                        (nomeAluno.isEmpty() ? "Não informado" : nomeAluno)));
		                    documento.add(new Paragraph("----------------------------"));

		                    // Buscar aluno
		                    Predicate<Aluno> filtroAluno = a -> a.getNome().equalsIgnoreCase(nomeAluno);
		                    String relatorioAluno = ListaAlunos.gerarRelatorio(
		                        filtroAluno,
		                        a -> "Aluno: " + a.getNome() + 
		                            " | Matrícula: " + a.getMatriculaAluno() + 
		                            " | Idade: " + a.getIdade() + 
		                            " | Média: " + a.getMedia(ListaCursos)
		                    );

		                    documento.add(new Paragraph(relatorioAluno.isEmpty() ? "Aluno não encontrado." : relatorioAluno));
		                    break;

		                default:
		                    documento.add(new Paragraph("Relatório não identificado."));
		                    break;
		            }

		            documento.add(new Paragraph(" "));
		        }
		    } else {
		        documento.add(new Paragraph("Nenhuma opção de relatório foi selecionada."));
		    }

		    documento.close();

		} catch (DocumentException e) {
		    throw new IOException(e.getMessage());
		}
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment; filename=relatorio.pdf");
    }

}
