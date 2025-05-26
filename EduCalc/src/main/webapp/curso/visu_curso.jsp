<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Aluno,model.Disciplina, model.Curso, ClassPrimaria.ListaDuplamenteEncadeada" %>

<%
    @SuppressWarnings("unchecked")
    ListaDuplamenteEncadeada<Curso> listaCursos = 
        (ListaDuplamenteEncadeada<Curso>) request.getAttribute("listaCursos");

    Aluno aluno = (Aluno) request.getAttribute("Aluno");
	Disciplina disciplina = (Disciplina) request.getAttribute("Disciplina");
	Curso curso = (Curso) request.getAttribute("Curso");
%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Visualizar Curso</title>
    
    <link rel="stylesheet" href="../style.css">
</head>
<body>

    <div class="container">
    <div class="mensagem">
<%--             <% if (request.getParameter("sucesso") != null) { %> --%>
<!--                 <p class="sucesso">✅ Aluno excluído com sucesso!</p> -->
<%--             <% } %> --%>

            <% if (request.getParameter("erro") != null) { %>
                <p class="erro">❌ Erro: Matrícula não encontrada!</p>
            <% } %>
        </div>
        <h1>Visualizar Curso</h1>

        <form class="form-group" action="buscar_curso" method="get">
            <input 
                type="text" 
                name="mat" 
                placeholder="Matrícula"
                class="caixa1" 
                required
            >
            <input 
                type="text" 
                name="cod_disciplina" 
                placeholder="Codigo"
                class="caixa1"  
                required
            >
            <div class="rodape">
            <a href="curso.jsp" class="botao voltar">Voltar</a>
            <input type="submit" value="Buscar" class="botao salvar">
            </div>
            
            
        </form>
        
        		

        <% if (aluno != null) { %>
        
            <div class="dados-aluno">
                <h2>Dados do Aluno</h2>
                <p><strong>Matrícula: </strong> <%= aluno.getMatriculaAluno() %></p>
                <p><strong>Nome: </strong> <%= aluno.getNome() %></p>
                <p><strong>Idade: </strong> <%= aluno.getIdade() %></p>

				<h2>Dados da Disciplina</h2>
                <p><strong>Nome:</strong></p><%= disciplina.getNomeDisciplina() %>
                <p><strong>Cod: </strong> <%= disciplina.getCodDisciplina() %></p>
                <p><strong>Nota Mínima: </strong> <%= disciplina.getNotaMinima()%></p>
                
                <h2>Notas</h2>
                <p><strong>Nota 1: </strong><%= curso.getNota1() %></p>
                <p><strong>Nota 2: </strong><%= curso.getNota2() %></p>
                <p><strong>Média do Alunon: </strong><%= curso.calculaMedia() %></p>
            </div>
		

		
        <% } else if (request.getParameter("matricula") != null) { %>

            <p style="color:red;">❌ Aluno não encontrado!</p>

        <% } %>

    </div>

</body>
</html>
