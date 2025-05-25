<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Desmatricular aluno</title>
    <link rel="icon" href="<%=request.getContextPath()%>/imagens/9883213.png">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/style.css">
</head>

<body>

    <div class="container_cantoesquerdo">
        <img src="<%=request.getContextPath()%>/imagens/9883213.png" alt="Logo">
        <h1>Excluir</h1>

        <div class="mensagem">
            <% if (request.getParameter("sucesso") != null) { %>
                <p class="sucesso">✅ Aluno excluído com sucesso!</p>
            <% } %>

            <% if (request.getParameter("erro") != null) { %>
                <p class="erro">❌ Erro: Matrícula não encontrada!</p>
            <% } %>
        </div>

        <form name="frmCurso" action="<%=request.getContextPath()%>/excluir_curso" method="post">
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
                    name="cod_disciplina" 
                    placeholder="cod. disciplina" 
                    class="caixa2" 
                    maxlength="6" 
                    required 
                    oninput="this.value = this.value.replace(/[^0-9]/g, '')"
                    inputmode="numeric"
                >
            </div>

            <div class="rodape">
                <input type="submit" value="Excluir" class="botao1">
                <a href="curso.jsp" class="voltar">Voltar</a>
            </div>
        </form>
    </div>

    <script>
  window.addEventListener("DOMContentLoaded", () => {
    const params = new URLSearchParams(window.location.search);

    if (params.has("erro")) {
      const erro = document.createElement("p");
      erro.textContent = "❌ Erro: Matrícula não cadastrada!";
      erro.style.color = "red";
      erro.style.fontWeight = "bold";
      document.querySelector(".container_cantoesquerdo").prepend(erro);
    }

    if (params.has("sucesso")) {
      const sucesso = document.createElement("p");
      sucesso.textContent = "✅ Aluno removido com sucesso!";
      sucesso.style.color = "green";
      sucesso.style.fontWeight = "bold";
      document.querySelector(".container_cantoesquerdo").prepend(sucesso);
    }
  });
</script>
</body>
</html>
