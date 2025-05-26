<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <title>Cadastrar Curso</title>
    <link rel="stylesheet" href="../style.css">
</head>

<body>

<div class="container">
        <img src="../imagens/9883213.png" alt="Logo">
        <h1>Cadastrar Aluno na disciplina</h1>

        <div class="mensagem">
        <%
    String msgErro = (String) session.getAttribute("mensagemErro");
    String msgSucesso = (String) session.getAttribute("mensagemSucesso");
		%>
		
    <% if (msgSucesso != null) { %>
        <p class="sucesso">✅ <%= msgSucesso %></p>
        <% session.removeAttribute("mensagemSucesso"); %>
    <% } %>

    <% if (msgErro != null) { %>
        <p class="erro">❌ <%= msgErro %></p>
        <% session.removeAttribute("mensagemErro"); %>
    <% } %>
	</div>

<form name="frmCurso" action="<%=request.getContextPath()%>/cria_curso" method="post">
	<div class="form-group">
	    <input 
	        type="text" 
	        name="mat_aluno" 
	        placeholder="Matricula do Aluno" 
	        maxlength="5" 
	        class="caixa2" 
	        required 
	        oninput="this.value = this.value.replace(/[^0-9]/g, '')"
	        inputmode="numeric"
	    />
	
	    <input 
	        type="text" 
	        name="cod_disciplina" 
	        placeholder="Código" 
	        maxlength="3" 
	        class="caixa2" 
	        required 
	        oninput="this.value = this.value.replace(/[^0-9]/g, '')"
	        inputmode="numeric"
	    />
	
	    <input 
	        type="text" 
	        name="nota1" 
	        placeholder="Nota 1" 
	        class="caixa2"
	        maxlength="4"  
	        min="0" 
	        max="10" 
	        required
	    />
	
	    <input 
	        type="text" 
	        name="nota2" 
	        placeholder="Nota 2" 
	        class="caixa2"
	        maxlength="4"  
	        min="0" 
	        max="10" 
	        required
	    />
    </div>
    
    		<div class="rodape">
		
        <a href="curso.jsp" class="botao voltar">Voltar</a>
        <input type="submit" value="Adicionar" class="botao salvar">
        
		</div>
		
</form>
	</div> 
<script>
  window.addEventListener("DOMContentLoaded", () => {
    const params = new URLSearchParams(window.location.search);

    if (params.has("erro")) {
      const erro = document.createElement("p");
      erro.textContent = "❌ Erro: Matrícula já cadastrada!";
      erro.style.color = "red";
      erro.style.fontWeight = "bold";
      document.querySelector(".container").prepend(erro);
    }

    if (params.has("sucesso")) {
      const sucesso = document.createElement("p");
      sucesso.textContent = "✅ Aluno cadastrado com sucesso!";
      sucesso.style.color = "green";
      sucesso.style.fontWeight = "bold";
      document.querySelector(".container").prepend(sucesso);
    }
  });
</script>
</body>
</html>