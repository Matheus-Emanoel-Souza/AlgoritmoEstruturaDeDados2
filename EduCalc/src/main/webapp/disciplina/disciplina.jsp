<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CRUD de Disciplinas</title>
<link rel="stylesheet" href="../style.css">
</head>

<body>
<div  class="container">
<img src="<%=request.getContextPath()%>/imagens/Disciplinas.jpg" alt="Logo">
<div  class="titulo"><h2>Disciplinas</h2></div>
<a href="cad_disciplina.jsp" class="botao1">Cadastrar</a><br>
<a href="exc_disciplina.jsp" class="botao1">Excluir</a><br>
<a href="visu_disciplina.jsp" class="botao1">Visualizar</a><br>
<a href="../Inicio.jsp" class="botao voltar">Voltar</a>
</div>
</body>
</html>