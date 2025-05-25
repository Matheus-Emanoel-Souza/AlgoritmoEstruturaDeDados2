package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Aluno;
import model.Curso;
import model.Disciplina;
import util.Exibir;
import util.PreencheLista;

import java.io.IOException;

import ClassPrimaria.ListaDuplamenteEncadeada;



@SuppressWarnings("unused")
@WebServlet({ 
	//controladores
    "/controller", 
    "/main", 
    //camadas 1
    "/aluno",
    "/disciplina",
    "/curso", 
    "/relatorio",
    "/salvar",  
    //Camadas de criação
    "/cria_aluno",
    "/cria_disciplina",
    "/cria_curso",
    //camadas de exclusão
    "/excluir_aluno",
    "/excluir_disciplina",
    "/excluir_curso",
    //camadas de busca
    "/aluno/buscar_aluno",
    "/disciplina/buscar_disciplina",
    "/curso/buscar_curso"
})

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
		if(action.equals("/aluno/buscar_aluno")){
			Visualiza_aluno(request, response);
		}
		if(action.equals("/disciplina/buscar_disciplina")) {
			Visualiza_Disciplina(request, response);
		}
		if(action.equals("/curso/buscar_curso")) {
			Visualiza_curso(request, response);
		}
		if(action.equals("/salvar")) {
	    	salvar_listas(request,response);
	    }
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String action = request.getServletPath();
	    System.out.println("POST action: " + action);

	    //Criar
	    if (action.equals("/cria_aluno")) {
	        cria_aluno(request, response);
	    }
	    if (action.equals("/cria_disciplina")) {
	        cria_disciplina(request, response);
	    }
	    if(action.equals("/cria_curso")){
	    	cria_curso(request,response);
	    }
	    //Excluir
	    if(action.equals("/excluir_aluno")) {
	    	exclui_aluno(request, response);
	    }
	    if(action.equals("/excluir_disciplina")) {
	    	exclui_disciplina(request, response);
	    }
	    if(action.equals("/excluir_curso")) {
	    	exclui_curso(request, response);
	    }
	    
	}

	@SuppressWarnings({ "static-access" })
	protected void inicio(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		System.out.println("Entrou no metodo inicio!!");
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
		response.sendRedirect("disciplina/disciplina.jsp");
	}
	protected void aba_curso(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendRedirect("curso/curso.jsp");
	}
	//ABAS DE CRUD
	protected void cria_aluno(HttpServletRequest request, HttpServletResponse response) throws ServletException,
	IOException {
		
		System.out.println("Função:cria_aluno");
		String nome = request.getParameter("nome");
		int mat = Integer.parseInt(request.getParameter("matricula"));
		int idade = Integer.parseInt(request.getParameter("idade"));

		Aluno novoAluno = new Aluno(mat,nome,idade);
		
		//PRINT PARA TESTAR O QUE ESTÁ SENDO IMPRESSO
		System.out.println("Indice:"+ListaAlunos.getIndice( a -> a.getMatriculaAluno() == mat));
		//SE RETORNAR -1 É PQ NÃO EXISTE NA LISTA E PODE SER CADASTRADO COM ESSA MATRICULA
		
		if(ListaAlunos.getIndice(a -> a.getMatriculaAluno() == novoAluno.getMatriculaAluno()) == -1) {
			ListaAlunos.add(novoAluno);
			System.out.println(novoAluno.getNome()+" cadastrado com sucesso!");
			System.out.println("Matricula:"+novoAluno.getMatriculaAluno());
			request.setAttribute("mensagem", novoAluno.getNome()+"cadastrado com sucesso!");
			response.sendRedirect("aluno/cad_aluno.jsp?sucesso=1");
			
		} else {			
			System.out.println("Erro! Matricula:"+novoAluno.getMatriculaAluno()+" já está cadastrada!");
			request.setAttribute("erro","Erro! Matricula:"+novoAluno.getMatriculaAluno()+" já está cadastrada!");
			response.sendRedirect("aluno/cad_aluno.jsp?erro=1");
		}
	}
	protected void cria_disciplina(HttpServletRequest request, HttpServletResponse response) throws ServletException,
	IOException {
		
		String nome_disciplina = request.getParameter("nome");
		int cdo_disciplina = Integer.parseInt(request.getParameter("cod_disciplina"));
		float media_necessaria = Float.parseFloat(request.getParameter("media_necessaria"));

		Disciplina novadisciplina = new Disciplina(cdo_disciplina,nome_disciplina,media_necessaria);
		
		 
		

		System.out.println(ListaDisciplinas.getIndice( a -> a.getCodDisciplina() == novadisciplina.getCodDisciplina()));
		
		//novadisciplina.getIndice(novadisciplina, ListaDisciplinas) == -1
		if(ListaDisciplinas.getIndice(a -> a.getCodDisciplina() == novadisciplina.getCodDisciplina()) == -1 ) {
			ListaDisciplinas.add(novadisciplina);
			System.out.println("Disciplina:"+novadisciplina.getNomeDisciplina()+" Inserida com sucesso!!");
			request.setAttribute("mensagem", "Disciplina:"+novadisciplina.getNomeDisciplina()+" Inserida com sucesso!!");
			response.sendRedirect("disciplina/cad_disciplina.jsp?sucesso=1");
			
		}else {
			
			System.out.println("Erro!! Disciplina:"+novadisciplina.getNomeDisciplina()+" Já cadastrada!!");
			request.setAttribute("mensagem","Erro!! Codigo de Disciplina:"+novadisciplina.getCodDisciplina()+" Já cadastrada!!");
			response.sendRedirect("disciplina/cad_disciplina.jsp?erro=1");
		}
		
	}
	protected void cria_curso(HttpServletRequest request, HttpServletResponse response) throws ServletException,
	IOException {
		
		System.out.println("Entrou em cria_curso");
		
		//1a passo receber os parametros
		int matricula_aluno = Integer.parseInt(request.getParameter("mat_aluno"));
		int	codigo_disciplina = Integer.parseInt(request.getParameter("cod_disciplina"));
		float Nota1 = Float.parseFloat(request.getParameter("nota1"));
		float Nota2 = Float.parseFloat(request.getParameter("nota2"));
		
		System.out.println("Indice do Aluno:"+ListaAlunos.getIndice(a->a.getMatriculaAluno() == matricula_aluno));
		System.out.println("Indice da disciplina:"+ListaDisciplinas.getIndice(a->a.getCodDisciplina() == codigo_disciplina));
		System.out.println(ListaCursos.getIndice(a->a.getCodDisciplina()==codigo_disciplina && a.getMatricCurso()== matricula_aluno));
		//2a passo criar um objeto com as inormações que tenho.
		
		if((ListaAlunos.getIndice(a->a.getMatriculaAluno() == matricula_aluno) != -1) &&
			(ListaDisciplinas.getIndice(b->b.getCodDisciplina() == codigo_disciplina) != -1) && 
			(ListaCursos.getIndice(a->a.getCodDisciplina()==codigo_disciplina && a.getMatricCurso()== matricula_aluno)== -1)){
			
			Curso curso = new Curso(matricula_aluno,codigo_disciplina,Nota1,Nota2);
			ListaCursos.add(curso);
			System.out.println("Curso cadastrado com sucesso!!!");
			request.setAttribute("mensagem", "Curso Inserida com sucesso!!");
			response.sendRedirect("curso/cad_cursos.jsp?sucesso=1");
		
		}else
		{
			if(ListaAlunos.getIndice(a->a.getMatriculaAluno() == matricula_aluno)!= -1) {
				

				request.setAttribute("mensagem","Erro!! Aluno não cadastrados!!");
				response.sendRedirect("curso/cad_cursos.jsp?erro=1");
				
			}else if(ListaDisciplinas.getIndice(b->b.getCodDisciplina() == codigo_disciplina) != -1) {
				System.out.println("Disciplina não existe na lista de disciplinas");
				request.setAttribute("mensagem","Erro!! Disciplina não cadastrados!!");
				response.sendRedirect("curso/cad_cursos.jsp?erro=1");
			}else {
				
				HttpSession sessao = request.getSession();
				sessao.setAttribute("mensagem","Erro!! Aluno já cadastrado nesta disciplina!!");
				
				System.out.println("Aluno já cadastrado nesta disciplina");
				request.setAttribute("mensagem","Erro!! Aluno já cadastrado nesta disciplina!!");
				response.sendRedirect("curso/cad_cursos.jsp?erro=1");
			}
			
			
		}			
	}		
	protected void exclui_aluno(HttpServletRequest request, HttpServletResponse response) throws ServletException,
	IOException {
		Aluno excluido = new Aluno();
		excluido.setMatriculaAluno(Integer.parseInt(request.getParameter("matricula")));
		
		//testar impressao do indice
		//System.out.println(excluido.IndiceAluno(excluido, ListaAlunos));
		
		//excluido.IndiceAluno(excluido, ListaAlunos) != -1
		if(ListaAlunos.getIndice(a->a.getMatriculaAluno() == excluido.getMatriculaAluno()) != -1) {
			ListaAlunos.remover(a->a.getMatriculaAluno() == excluido.getMatriculaAluno());
			System.out.println("Aluno Removido com sucesso!");
			request.setAttribute("mensagem", "Aluno Removido com sucesso!");
			response.sendRedirect("aluno/exc_aluno.jsp?sucesso=1");
			
		} else {			
			System.out.println("Erro! Matricula Não cadastrada!");
			request.setAttribute("erro", "Matrícula Não cadastrada!");
			response.sendRedirect("aluno/exc_aluno.jsp?erro=1");
		}	
	}
	protected void exclui_disciplina(HttpServletRequest request, HttpServletResponse response) throws ServletException,
	IOException {
		int cod_dici = Integer.parseInt(request.getParameter("cod_disciplina"));
		
//		
//		Disciplina disci = new Disciplina();
//		disci.setCodDisciplina(cod_dici);
//		
//		
		//testar impressao do indice
		//System.out.println(excluido.IndiceAluno(excluido, ListaAlunos));				
			
		//disci.getIndice(disci, ListaDisciplinas) != -1
			if(ListaDisciplinas.getIndice(a -> a.getCodDisciplina() == cod_dici) == -1) {
				//disci.RemoverDisciplina(cod_dici, ListaDisciplinas);
				ListaDisciplinas.remover(a->a.getCodDisciplina() == cod_dici);
			
			System.out.println("Disciplina Removido com sucesso!");
			request.setAttribute("mensagem", "Disciplina Removido com sucesso!");
			response.sendRedirect("disciplina/exc_disciplina.jsp?sucesso=1");
			
		} else {			
			System.out.println("Erro! Matricula Não cadastrada!");
			request.setAttribute("erro", "Matrícula Não cadastrada!");
			response.sendRedirect("disciplina/exc_disciplina.jsp?erro=1");
		}	
	}
	protected void exclui_curso(HttpServletRequest request, HttpServletResponse response) throws ServletException,
	IOException {
		System.out.println("Entrou no metodo de excluir curso");
		int cod_dic = Integer.parseInt(request.getParameter("cod_disciplina"));
		int cod_mat = Integer.parseInt(request.getParameter("matricula"));
		int indice = ListaCursos.getIndice(a->a.getCodDisciplina()==cod_dic && a.getMatricCurso()==cod_mat);
		
		if(indice != -1) {
			ListaCursos.remover(a->a.getCodDisciplina()==cod_dic && a.getMatricCurso()==cod_mat);
			response.sendRedirect("curso/exc_cursos.jsp?sucesso=1");
		}else
		{
			request.setAttribute("mensagem", "Curso não existe!!!");
			System.out.println("CURSO NÃO EXISTE!");
			response.sendRedirect("curso/exc_cursos.jsp?erro=1");			
		}
			
		
	}
	protected void Visualiza_aluno(HttpServletRequest request, HttpServletResponse response) throws ServletException,
	IOException {

		
		int mat = Integer.parseInt(request.getParameter("matricula"));
		
		Aluno Achado = ListaAlunos.iguala(c -> c.getMatriculaAluno() == mat);
		//MontaString de cursos do aluno.
		
		 //String outra = Achado.constroi_cursos_aluno(Achado, ListaCursos, ListaDisciplinas);
		 String cursosdoaluno = ListaCursos.gerarRelatorio(
				ListaCursos,
			    curso -> (curso.getMatricCurso() == mat),
			    curso -> {
			        StringBuilder sb = new StringBuilder();
			        Disciplina disciplina = ListaDisciplinas.iguala(d -> d.getCodDisciplina() == curso.getCodDisciplina());

			        sb.append("Código: ").append(curso.getCodDisciplina()).append(" | ");
			        sb.append("Nome: ").append(disciplina != null ? disciplina.getNomeDisciplina() : "Desconhecida").append(" | ");
			        sb.append("Média Necessária: ").append(disciplina != null ? disciplina.getNotaMinima() : "N/A").append(" | ");

			        double media = curso.calculaMedia();
			        sb.append("Nota 1: ").append(curso.getNota1()).append(" | ");
			        sb.append("Nota 2: ").append(curso.getNota2()).append(" | ");
			        sb.append("Média: ").append(media).append(" | ");

			        if (disciplina != null && media >= disciplina.getNotaMinima()) {
			            sb.append("Status: APROVADO");
			        } else {
			            sb.append("Status: REPROVADO");
			        }

			        return sb.toString();
			    }
			);

		

		if(ListaAlunos.getIndice(c->c.getMatriculaAluno() == mat) != -1) {
	
			//antes aluno(so matricula) agora aluno passa ser o aluno da lista de alunos.
			//Achado = Achado.constroi_alunoCompleto(mat, ListaAlunos); // Funcao velha, era uma funcao por classe, agora é uma funcao genericao com teste.

			Achado = ListaAlunos.iguala(c -> c.getMatriculaAluno() == mat);
			
			//Preciso enviar
			request.setAttribute("Aluno", Achado);
			//Será que preciso enviar uma lista de cursos ?????????????
			request.setAttribute("listaCursos", ListaCursos);
			//Será que preciso enviar uma lista de cursos ?????????????
			request.setAttribute("cursosAluno", cursosdoaluno);
			//Será que preciso enviar uma lista de cursos ?????????????
			request.setAttribute("ListaAlunos", ListaAlunos);
			//Precisa ? testar!!!1
			request.setAttribute("mensagem", "Visualização!");
			request.getRequestDispatcher("visu_aluno.jsp").forward(request, response);

			
		} else {			
			System.out.println("Erro! Matricula Não cadastrada!");
			request.setAttribute("erro", "Matrícula Não cadastrada!");
			response.sendRedirect("visu_aluno.jsp?erro=1");
		}
		
	}
	//Funcao visualizar disciplina. Vai trazer objeto disciplina + string alunos.
	protected void Visualiza_Disciplina(HttpServletRequest request, HttpServletResponse response) throws ServletException,
	IOException {				
		
		int mat = Integer.parseInt(request.getParameter("cod_disciplina"));
		Disciplina achada = new Disciplina();
		
		
		
		
		if(ListaDisciplinas.getIndice(a->a.getCodDisciplina() == mat) != -1) {
			achada = ListaDisciplinas.iguala(j -> j.getCodDisciplina()==mat);
			float notaminima = achada.getNotaMinima();
			
			
			//String outra = Achado.constroi_cursos_aluno(Achado, ListaCursos, ListaDisciplinas);
			 String alunosnadisciplina = ListaCursos.gerarRelatorio(
					ListaCursos,
				    curso -> (curso.getCodDisciplina() == mat),
				    curso -> {
				        StringBuilder sb = new StringBuilder();
				        Aluno alunos = ListaAlunos.iguala(d -> d.getMatriculaAluno() == curso.getMatricCurso());

				        sb.append("Matricula: ").append(curso.getMatricCurso()).append(" | ");
				        sb.append("Nome: ").append(alunos != null ? alunos.getNome() : "Desconhecida").append(" | ");
				        sb.append("Média: ").append(curso != null ? curso.calculaMedia() : "N/A").append(" | ");

				        double media = curso.calculaMedia();
				        sb.append("Nota 1: ").append(curso.getNota1()).append(" | ");
				        sb.append("Nota 2: ").append(curso.getNota2()).append(" | ");

				        if (alunos != null && media >= notaminima) {
				            sb.append("Status: APROVADO");
				        } else {
				            sb.append("Status: REPROVADO");
				        }

				        return sb.toString();
				    }
				);
			 
			request.setAttribute("Disciplina", achada);
			//Passar string de alunos naquela disciplina
			request.setAttribute("Alunoscursos", alunosnadisciplina);
			
			request.getRequestDispatcher("visu_disciplina.jsp").forward(request, response);
						
		}else
		{
			System.out.println("Erro! Disciplina Não cadastrada!");
			request.setAttribute("erro", "Disciplina Não cadastrada!");
			response.sendRedirect("visu_disciplina.jsp?erro=1");
		}
	}
	protected void Visualiza_curso(HttpServletRequest request, HttpServletResponse response) throws ServletException,
	IOException {				
		
		System.out.println("Entrou no metodo!");
		//mat
		int cod = Integer.parseInt(request.getParameter("cod_disciplina"));
		int mat = Integer.parseInt(request.getParameter("mat"));
		int indice = ListaCursos.getIndice(a->a.getCodDisciplina()==cod && a.getMatricCurso()==mat);
		int indice_aluno = ListaAlunos.getIndice(a->a.getMatriculaAluno()==mat);
		int indice_disciplina = ListaDisciplinas.getIndice(a->a.getCodDisciplina()==cod);
		
		if( indice != -1) {
			request.setAttribute("Aluno", ListaAlunos.getElementoIndice(indice_aluno));
			request.setAttribute("Disciplina", ListaDisciplinas.getElementoIndice(indice_disciplina));
			request.setAttribute("Curso", ListaCursos.getElementoIndice(indice));
			
			request.getRequestDispatcher("visu_curso.jsp").forward(request, response);
		}else
		{
			System.out.println("Erro, curso não existe!!");
			request.setAttribute("erro", "Curso Não cadastrada!");
			response.sendRedirect("visu_disciplina.jsp?erro=1");
		}
		
		
	}
	//salvar_listas
	protected void salvar_listas(HttpServletRequest request, HttpServletResponse response) throws ServletException,
	IOException {				
		System.out.println("Entrou no metodo salvar listas!!!");
		ListaAlunos.SALVA("Alunos", caminhoBase, a->true, a->a.getMatriculaAluno()+";"+a.getNome()+";"+a.getIdade());
		ListaDisciplinas.SALVA("Disciplinas", caminhoBase, a->true, a->a.getCodDisciplina()+";"+a.getNomeDisciplina()+";"+a.getNotaMinima());
		ListaCursos.SALVA("Cursos", caminhoBase, a->true, a->a.getMatricCurso()+";"+a.getCodDisciplina()+";"+a.getNota1()+";"+a.getNota2());
		response.sendRedirect("Inicio.jsp");					 

	}
	}
