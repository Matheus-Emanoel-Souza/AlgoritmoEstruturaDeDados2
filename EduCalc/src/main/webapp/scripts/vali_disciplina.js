/**
 * Validação de formulário de Disciplina.
 * @author Matheus Emanoel Gomes Souza
 */
function validar() {
  let codigo = frmDisciplina.codigo.value;
  let nome = frmDisciplina.nome.value;
  let media = frmDisciplina.media.value;

  if (nome === "") {
    alert('Preencha o nome da disciplina');
    frmDisciplina.nome.focus();
    return false;
  } else if (codigo === "") {
    alert('Preencha o código da disciplina');
    frmDisciplina.codigo.focus();
    return false;
  } else if (isNaN(codigo)) {
    alert('O código deve conter apenas números');
    frmDisciplina.codigo.focus();
    return false;
  } else if (media === "") {
    alert('Preencha a média');
    frmDisciplina.media.focus();
    return false;
  } else if (isNaN(media)) {
    alert('A média deve conter apenas números');
    frmDisciplina.media.focus();
    return false;
  } else {
    document.forms["frmDisciplina"].submit();
  }
}
