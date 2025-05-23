<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <title>Cadastrar Aluno</title>
    <link rel="stylesheet" href="../style.css">
</head>

<body>

    <div class="container_cantoesquerdo">
        <img src="../imagens/9883213.png" alt="Logo">
        <h1>Cadastrar Novo Aluno</h1>

        <div class="mensagem">
            <% if (request.getParameter("sucesso") != null) { %>
                <p class="sucesso">✅ Aluno cadastrado com sucesso!</p>
            <% } %>

            <% if (request.getParameter("erro") != null) { %>
                <p class="erro">❌ Erro: Matrícula já cadastrada!</p>
            <% } %>
        </div>

        <form name="frmAluno" action="<%=request.getContextPath()%>/cria_aluno" method="post">

            <div class="form-group">
                <input 
                    type="text" 
                    name="nome" 
                    placeholder="Nome" 
                    class="caixa" 
                    required
                >
            </div>

            <div class="form-group">
                <input 
                    type="text" 
                    name="matricula" 
                    placeholder="Matrícula" 
                    class="caixa2" 
                    maxlength="6" 
                    required 
                    oninput="this.value = this.value.replace(/[^0-9]/g, '')"
                    inputmode="numeric"
                >
            </div>

            <div class="form-group">
                <input 
                    type="text" 
                    name="idade" 
                    placeholder="Idade" 
                    class="caixa2" 
                    maxlength="3" 
                    required 
                    oninput="this.value = this.value.replace(/[^0-9]/g, '')"
                    inputmode="numeric"
                >
            </div>

            <div class="rodape">
                <input type="submit" value="Adicionar" class="botao1">
                <a href="aluno.jsp" class="voltar">Voltar</a>
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
