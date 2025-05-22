/**
 * Validação de formulário.
 * @author Matheus Emanoel Gomes Souza
 */
function validar() {
  let nome = frmAluno.nome.value;
  let matricula = frmAluno.matricula.value;
  let idade = frmAluno.Idade.value;

  if (nome === "") {
    alert('Preencha o nome');
    frmAluno.nome.focus();
    return false;
  } else if (matricula === "") {
    alert('Preencha a matrícula');
    frmAluno.matricula.focus();
    return false;
  } else if (isNaN(matricula)) {
    alert('Matrícula deve conter apenas números');
    frmAluno.matricula.focus();
    return false;
  } else if (idade === "") {
    alert('Preencha a idade');
    frmAluno.Idade.focus();
    return false;
  } else if (isNaN(idade)) {
    alert('Idade deve conter apenas números');
    frmAluno.Idade.focus();
    return false;
  } else {
    document.forms["frmAluno"].submit();
  }
}
/**
 * Checagem de repetição
 * 
 */
window.addEventListener("DOMContentLoaded", () => {
  const params = new URLSearchParams(window.location.search);

  if (params.has("erro")) {
    const erro = document.createElement("p");
    erro.textContent = "Erro: Matrícula já cadastrada!";
    erro.style.color = "red";
    erro.style.fontWeight = "bold";
    document.querySelector(".container_cantoesquerdo").prepend(erro);
  }

  if (params.has("sucesso")) {
    const sucesso = document.createElement("p");
    sucesso.textContent = "Aluno cadastrado com sucesso!";
    sucesso.style.color = "green";
    sucesso.style.fontWeight = "bold";
    document.querySelector(".container_cantoesquerdo").prepend(sucesso);
  }
});
