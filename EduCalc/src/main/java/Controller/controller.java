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
@WebServlet({ "/controller", "/main","/aluno","/curso","/disciplina","/relatorio","/cria_aluno",
	"/excluir_aluno", "/aluno/buscar_aluno"})
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
		}
		if(action.equals("/aluno/buscar_aluno")){
			Visualiza_aluno(request, response);
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String action = request.getServletPath();
	    System.out.println("POST action: " + action);

	    if (action.equals("/cria_aluno")) {
	        cria_aluno(request, response);
	    }
	    if(action.equals("/excluir_aluno")) {
	    	exclui_aluno(request, response);
	    }
	}


	// Rodar o main
	@SuppressWarnings({ "static-access" })
	protected void inicio(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		//Carregar as listas.
		if(ListaAlunos.getTamanho() == 0 && ListaDisciplinas.getTamanho() ==0 && ListaCursos.getTamanho() == 0) {
			PreencheLista.MontaListaAluno(ListaAlunos, CaminhoAlunos);
			PreencheLista.MontaListaDisciplina(ListaDisciplinas, CaminhoDisciplinas);
			PreencheLista.MontaListaCurso(ListaDisciplinas, ListaAlunos, ListaCursos, CaminhoCursos);
		}else {
			System.out.println("Listas não foram carregadas!!");
		}
		//Teste para ver se as listas estão duplicando
		//exibicao.exibirNomeAlunosDeLista(ListaAlunos);
		//Exibir.exibirNomeDisciplinaDaLista(ListaDisciplinas);
		//Exibir.exibirNomeAlunosDeLista(ListaAlunos);
		//Exibir.exibirCursos(ListaCursos);
		//exibicao.exibirCursos(ListaCursos);
		response.sendRedirect("Inicio.jsp");
	}
	
	//ABAS PADRÕES(ALUNO,DISCIPLINA,CURSO,RELATORIO)
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
	//ABAS DE CRUD
	protected void cria_aluno(HttpServletRequest request, HttpServletResponse response) throws ServletException,
	IOException {
		//PRINT TESTE PARA VER SE REALMENTE ESTÁ FUNCIONANDO
		//System.out.println(request.getParameter("nome"));
		//System.out.println(request.getParameter("matricula"));
		//System.out.println(request.getParameter("idade"));
		
		String nome = request.getParameter("nome");
		int mat = Integer.parseInt(request.getParameter("matricula"));
		int idade = Integer.parseInt(request.getParameter("idade"));

		Aluno novoAluno = new Aluno(mat,nome,idade);
		
		//PRINT PARA TESTAR O QUE ESTÁ SENDO IMPRESSO
		//System.out.println(novoAluno.IndiceAluno(novoAluno, ListaAlunos));
		
		//SE RETORNAR -1 É PQ NÃO EXISTE NA LISTA E PODE SER CADASTRADO COM ESSA MATRICULA
		if(novoAluno.IndiceAluno(novoAluno, ListaAlunos) == -1) {
			ListaAlunos.add(novoAluno);
			System.out.println("Aluno cadastrado com sucesso!");
			request.setAttribute("mensagem", "Aluno cadastrado com sucesso!");
			response.sendRedirect("aluno/cad_aluno.jsp?sucesso=1");
			
		} else {			
			System.out.println("Erro! Matricula já cadastrada!");
			request.setAttribute("erro", "Matrícula já cadastrada!");
			response.sendRedirect("aluno/cad_aluno.jsp?erro=1");
		}
	}
	protected void exclui_aluno(HttpServletRequest request, HttpServletResponse response) throws ServletException,
	IOException {
		int mat = Integer.parseInt(request.getParameter("matricula"));
		Aluno excluido = new Aluno(mat);
		
		//testar impressao do indice
		//System.out.println(excluido.IndiceAluno(excluido, ListaAlunos));
		
		if(excluido.IndiceAluno(excluido, ListaAlunos) != -1) {
			ListaAlunos.remove(excluido);
			System.out.println("Aluno Removido com sucesso!");
			request.setAttribute("mensagem", "Aluno Removido com sucesso!");
			response.sendRedirect("aluno/exc_aluno.jsp?sucesso=1");
			
		} else {			
			System.out.println("Erro! Matricula Não cadastrada!");
			request.setAttribute("erro", "Matrícula Não cadastrada!");
			response.sendRedirect("aluno/exc_aluno.jsp?erro=1");
		}
		
	}
	
	protected void Visualiza_aluno(HttpServletRequest request, HttpServletResponse response) throws ServletException,
	IOException {

		//teste da função visualiza aluno
		System.out.println("Teste da função:Visualiza_aluno");
		
		int mat = Integer.parseInt(request.getParameter("matricula"));
		Aluno Achado = new Aluno(mat);
		//Colocar aqui para parar de fazer checagens;
		int a =Achado.IndiceAluno(Achado, ListaAlunos);
		String cursosdoaluno = Achado.constroi_cursos_aluno(Achado, ListaCursos, ListaDisciplinas);
		//testar impressao do indice
		//System.out.println(excluido.IndiceAluno(excluido, ListaAlunos));
		
		//Faço uma validação dentro e fora da função por a validação de aluno poderá ser usada para outra coisa.
		if(a != -1) {
			
			//System.out.println("Valor do indice na função externa é:"+a);
			
			
			
			  //MontaString de cursos do aluno.
			  Achado.constroi_aluno_indice(Achado,ListaAlunos);
			  
			 
			
			//antes aluno(so matricula) agora aluno passa ser o aluno da lista de alunos.
			Achado = Achado.constroi_alunoCompleto(mat, ListaAlunos);
			System.out.println("Visualização disponível!");
			
			
			request.setAttribute("Aluno", Achado);
			request.setAttribute("listaCursos", ListaCursos);
			request.setAttribute("cursosAluno", cursosdoaluno);
			request.setAttribute("ListaAlunos", ListaAlunos);
			request.setAttribute("mensagem", "Visualização!");
			request.getRequestDispatcher("visu_aluno.jsp").forward(request, response);

			
		} else {			
			System.out.println("Erro! Matricula Não cadastrada!");
			request.setAttribute("erro", "Matrícula Não cadastrada!");
			response.sendRedirect("visu_aluno.jsp?erro=1");
		}
		
	}

}
