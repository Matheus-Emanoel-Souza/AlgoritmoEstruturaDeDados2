package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Aluno;
import model.Curso;
import model.Disciplina;
import util.Exibir;
import util.PreencheLista;

import java.io.IOException;

import ClassPrimaria.ListaDuplamenteEncadeada;



@SuppressWarnings("unused")
@WebServlet({ "/controller", "/main","/aluno","/curso","/disciplina","/relatorio","/cria_aluno" })
public class controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public controller() {
		super();
	}
	
	private static ListaDuplamenteEncadeada<Aluno> ListaAlunos = new ListaDuplamenteEncadeada<Aluno>();
	private static ListaDuplamenteEncadeada<Disciplina> ListaDisciplinas = new ListaDuplamenteEncadeada<Disciplina>();
	private static ListaDuplamenteEncadeada<Curso> ListaCursos = new ListaDuplamenteEncadeada<Curso>();
	
	String caminhoBase = "C:\\Temp\\WS-JavaWeb\\EduCalc\\src\\main\\java\\TXT\\";
	String CaminhoAlunos = caminhoBase + "Alunos.txt";
	String CaminhoDisciplinas = caminhoBase + "Disciplinas.txt";
	String CaminhoCursos = caminhoBase + "Cursos.txt";
	String CaminhoRelatorio = caminhoBase + "Relatorio.txt";
	PreencheLista iniciodocodigo = new PreencheLista();


	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) {
			inicio(request, response);
		}
		if(action.equals("/aluno")){
			aba_aluno(request, response);
		}
		if(action.equals("/disciplina")){
			aba_disciplina(request, response);
		}
		if(action.equals("/curso")){
			aba_curso(request, response);
		}
		if(action.equals("/relatorio")){
			aba_relatorio(request, response);
		}if(action.equals("/cria_aluno")){
			cria_aluno(request,response);
		}
	}

	// Rodar o main
	@SuppressWarnings({ "static-access" })
	protected void inicio(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("Inicio.jsp");
		//Carregar as listas.
		if(ListaAlunos.getTamanho() == 0 && ListaDisciplinas.getTamanho() ==0 && ListaCursos.getTamanho() == 0) {
			PreencheLista.MontaListaAluno(ListaAlunos, CaminhoAlunos);
			PreencheLista.MontaListaDisciplina(ListaDisciplinas, CaminhoDisciplinas);
			PreencheLista.MontaListaCurso(ListaDisciplinas, ListaAlunos, ListaCursos, CaminhoCursos);
		}
		//Teste para ver se as listas estão duplicando
		//exibicao.exibirNomeAlunosDeLista(ListaAlunos);
		//Exibir.exibirNomeDisciplinaDaLista(ListaDisciplinas);
		//Exibir.exibirNomeAlunosDeLista(ListaAlunos);
		//Exibir.exibirCursos(ListaCursos);
		//exibicao.exibirCursos(ListaCursos);
	}
	//abas
	protected void aba_aluno(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendRedirect("aluno/aluno.jsp");
	}
	protected void aba_disciplina(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendRedirect("disciplina.jsp");
	}
	protected void aba_curso(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendRedirect("curso.jsp");
	}
	protected void aba_relatorio(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendRedirect("relatorio.jsp");
	}
	protected void cria_aluno(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		int mat = Integer.parseInt(request.getParameter("matricula"));
		int idade = Integer.parseInt(request.getParameter("Idade"));

		Aluno novoAluno = new Aluno(mat,nome,idade);

		if(novoAluno.IndiceAluno(novoAluno, ListaAlunos) != 0) {
			System.out.println("Erro! Matricula já cadastrada!");
			request.setAttribute("erro", "Matrícula já cadastrada!");
			response.sendRedirect("cad_aluno.html?erro=1");
		} else {
			ListaAlunos.add(novoAluno);
			System.out.println("Aluno cadastrado com sucesso!");
			request.setAttribute("mensagem", "Aluno cadastrado com sucesso!");
			response.sendRedirect("cad_aluno.html?sucesso=1");
		}
	}

}
