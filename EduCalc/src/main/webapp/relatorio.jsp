<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Relatórios Acadêmicos</title>
<link rel="icon" href="imagens/home.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
<div class="container">
<h1>Relatórios Acadêmicos</h1>

    <form action="RelatorioController" method="get">

        <!-- 1. Lista de alunos -->
        <fieldset>
        
            <legend>Lista de Alunos</legend>
            <input type="checkbox" name="relatorio" value="listaAlunos"> Gerar Lista de Alunos <br>

            <!-- Filtros -->
            <label>Filtrar por Idade:</label>
            <select name="filtroIdade">
                <option value="">Nenhum</option>
                <option value="menor18">Menor que 18</option>
                <option value="18a25">Entre 18 e 25</option>
                <option value="maior25">Maior que 25</option>
            </select>
            <br>

            <label>Filtrar por Média Geral:</label>
            <select name="filtroMedia">
                <option value="">Nenhum</option>
                <option value="menor6">Menor que 6</option>
                <option value="6a8">Entre 6 e 8</option>
                <option value="maior8">Maior que 8</option>
            </select>
        </fieldset>
        <br>

        <!-- 2. Lista de Disciplinas -->
        <fieldset>
            <legend>Lista de Disciplinas</legend>
            <input type="checkbox" name="relatorio" value="listaDisciplinas"> Gerar Lista de Disciplinas <br>

            <!-- Filtro -->
            <label>Filtrar por quantidade de alunos matriculados:</label>
            <select name="filtroQuantidade">
                <option value="">Nenhum</option>
                <option value="menor10">Menos de 10 alunos</option>
                <option value="10a30">Entre 10 e 30 alunos</option>
                <option value="maior30">Mais de 30 alunos</option>
            </select>
        </fieldset>
        <br>

        <!-- 3. Matéria específica -->
        <fieldset>
            <legend>Buscar Matéria Específica</legend>
            <input type="checkbox" name="relatorio" value="materiaEspecifica"> Buscar Matéria <br>
            <label>Código da Matéria:</label>
            <input type="text" name="nomeMateria">
        </fieldset>
        <br>

        <!-- 4. Aluno específico -->
        <fieldset>
            <legend>Buscar Aluno Específico</legend>
            <input type="checkbox" name="relatorio" value="alunoEspecifico"> Buscar Aluno <br>
            <label>Matricula do Aluno:</label>
            <input type="text" name="nomeAluno">
        </fieldset>
        <br>

        <input type="submit" value="Gerar Relatório">

    </form>
</div>
    

</body>
</html>
