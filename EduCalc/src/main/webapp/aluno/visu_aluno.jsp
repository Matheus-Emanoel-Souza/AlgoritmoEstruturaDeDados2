<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Aluno, model.Curso, ClassPrimaria.ListaDuplamenteEncadeada" %>

<%
    @SuppressWarnings("unchecked")
    ListaDuplamenteEncadeada<Curso> listaCursos = 
        (ListaDuplamenteEncadeada<Curso>) request.getAttribute("listaCursos");

@SuppressWarnings("unchecked")
ListaDuplamenteEncadeada<Aluno> ListaAlunos = (ListaDuplamenteEncadeada<Aluno>) request.getAttribute("ListaAlunos");
    Aluno aluno = (Aluno) request.getAttribute("Aluno");
%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Buscar Aluno</title>
    
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
        <h1>Buscar Aluno</h1>

        <form action="buscar_aluno" method="get">
            <input 
                type="text" 
                name="matricula" 
                placeholder="Digite a matrícula"
                class="caixa1" 
                required
            >
   		<div class="rodape">
	        <a href="aluno.jsp" class="botao voltar">Voltar</a>
	        <input type="submit" value="Buscar" class="botao salvar">        
        </div>            
        </form>
        

        <% if (aluno != null) { %>
        
            <div class="dados-aluno">
                <h2>Dados do Aluno</h2>
                <p><strong>Matrícula:</strong> <%= aluno.getMatriculaAluno() %></p>
                <p><strong>Nome:</strong> <%= aluno.getNome() %></p>
                <p><strong>Idade:</strong> <%= aluno.getIdade() %></p>

                <p><strong>Cursos:</strong></p>
				<pre><%= request.getAttribute("cursosAluno") %></pre>
            </div>

        <% } else if (request.getParameter("matricula") != null) { %>

            <p style="color:red;">❌ Aluno não encontrado!</p>

        <% } %>

    </div>

</body>
</html>
