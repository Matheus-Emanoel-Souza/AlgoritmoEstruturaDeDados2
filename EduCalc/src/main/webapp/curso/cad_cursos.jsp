<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <title>Cadastrar Curso</title>
    <link rel="stylesheet" href="../style.css">
</head>

<body>

    <div class="container_cantoesquerdo">
        <img src="../imagens/9883213.png" alt="Logo">
        <h1>Cadastrar Aluno na disciplina</h1>

        <div class="mensagem">
            <% if (request.getParameter("sucesso") != null) { %>
                <p class="sucesso">✅ Curso cadastrado com sucesso!</p>
            <% } %>

            <% if (request.getParameter("erro") != null) { %>
                <p class="erro">❌ Erro: Aluno ou disciplina não cadastrados!</p>
            <% } %>
        </div>

<form name="frmCurso" action="<%=request.getContextPath()%>/cria_curso" method="post">
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
        placeholder="Código da disciplina" 
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
        maxlength="2"  
        min="0" 
        max="10" 
        required
    />

    <input 
        type="text" 
        name="nota2" 
        placeholder="Nota 2" 
        class="caixa2"
        maxlength="2"  
        min="0" 
        max="10" 
        required
    />

    <div class="rodape">
        <input type="submit" value="Adicionar" class="botao1">
        <a href="curso.jsp" class="voltar">Voltar</a>
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
      document.querySelector(".container_cantoesquerdo").prepend(erro);
    }

    if (params.has("sucesso")) {
      const sucesso = document.createElement("p");
      sucesso.textContent = "✅ Aluno cadastrado com sucesso!";
      sucesso.style.color = "green";
      sucesso.style.fontWeight = "bold";
      document.querySelector(".container_cantoesquerdo").prepend(sucesso);
    }
  });
</script>

</body>

</html>
