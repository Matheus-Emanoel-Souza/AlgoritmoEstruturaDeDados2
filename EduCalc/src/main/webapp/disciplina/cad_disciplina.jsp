<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html lang="pt-br">

    <head>
        <meta charset="UTF-8">
        <title>Cadastrar Aluno</title>
        <link rel="stylesheet" href="../style.css">
    </head>

    <body>
        <div class="container">
            <div class="imagem">
                <img src="../imagens/paginainicial.png" alt="Imagem">
            </div>

            <div class="conteudo">
                <h1>Cadastrar nova disciplina</h1>

                <div class="mensagem">
                    <% if (request.getParameter("sucesso") !=null) { %>
                        <p class="sucesso">✅ Disciplina cadastrado com sucesso!</p>
                        <% } %>

                            <% if (request.getParameter("erro") !=null) { %>
                                <p class="erro">❌ Erro: Código já cadastrado!</p>
                                <% } %>
                </div>

                <form name="frmAluno" action="<%=request.getContextPath()%>/cria_disciplina" method="post">

                    <div class="form-group">
                        <input type="text" name="nome" placeholder="Nome" class="caixa1" required>



                        <input type="text" name="cod_disciplina" placeholder="cod_disciplina" class="caixa2"
                            maxlength="6" required oninput="this.value = this.value.replace(/[^0-9]/g, '')"
                            inputmode="numeric">



                        <input type="text" name="media_necessaria" placeholder="Media Necessaria" class="caixa2"
                            maxlength="2" required oninput="this.value = this.value.replace(/[^0-9]/g, '')"
                            inputmode="numeric">
                    </div>

                    <div class="rodape">
                        <a href="disciplina.jsp" class="botao voltar">Voltar</a>
                        <input type="submit" value="Adicionar" class="botao1">
                    </div>

                </form>
            </div>
        </div>


        <script>
            window.addEventListener("DOMContentLoaded", () => {
                const params = new URLSearchParams(window.location.search);

                if (params.has("erro")) {
                    const erro = document.createElement("p");
                    erro.textContent = "❌ Erro: Codigo de Disciplian já cadastrada!";
                    erro.style.color = "red";
                    erro.style.fontWeight = "bold";
                    document.querySelector(".container_cantoesquerdo").prepend(erro);
                }

                if (params.has("sucesso")) {
                    const sucesso = document.createElement("p");
                    sucesso.textContent = "✅ DISCIPLINA cadastrado com sucesso!";
                    sucesso.style.color = "green";
                    sucesso.style.fontWeight = "bold";
                    document.querySelector(".container_cantoesquerdo").prepend(sucesso);
                }
            });
        </script>

    </body>

    </html>