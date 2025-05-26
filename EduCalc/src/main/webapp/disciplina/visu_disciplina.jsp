<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Aluno, model.Curso,model.Disciplina, ClassPrimaria.ListaDuplamenteEncadeada" %>

<%
    Disciplina disciplina = (Disciplina) request.getAttribute("Disciplina");
    
    
%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Buscar Disciplina</title>
    
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
        <h1>Buscar Disciplina</h1>

        <form action="buscar_disciplina" method="get">
            <input 
                type="text" 
                name="cod_disciplina" 
                placeholder="Código da disciplina"
                class="caixa1" 
                required
            >
            <div class="rodape">
            <a href="disciplina.jsp" class="botao voltar">Voltar</a>
            <input type="submit" value="Buscar" class="botao salvar">
            
            </div>            
        </form>

        <% if (disciplina != null) { %>
        
            <div class="dados-disciplina">
                <h2>Informações da Disciplina</h2>
                <p><strong>Código:</strong> <%= disciplina.getCodDisciplina() %></p>
                <p><strong>Nome:</strong> <%= disciplina.getNomeDisciplina() %></p>
                <p><strong>Média necessária:</strong> <%= disciplina.getNotaMinima() %></p>

                <p><strong>Alunos matriculados:</strong></p>
				<pre><%= request.getAttribute("Alunoscursos") %></pre>
            </div>

        <% } else if (request.getParameter("Cod_disciplina") != null) { %>

            <p style="color:red;">❌ Disciplina não encontrado!</p>

        <% } %>

    </div>

</body>
</html>
