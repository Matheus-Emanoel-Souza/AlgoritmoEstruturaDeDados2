import ClassPrimaria.Aluno;
import ClassPrimaria.Curso;
import ClassPrimaria.Disciplina;
import ClassPrimaria.listaEncadeada;
import PT2.ExibirPT2;
import PT2.TXTpLista;

public class Main {
    public static void main(String[] args) {

    	//ystem.out.println(new File("").getAbsolutePath());

    	listaEncadeada<Aluno> ListaAlunos = new listaEncadeada<Aluno>();
    	listaEncadeada<Disciplina> ListaDisciplinas = new listaEncadeada<Disciplina>();
    	listaEncadeada<Curso> ListaCursos = new listaEncadeada<Curso>();
    	
    	String caminhoBase = System.getProperty("user.dir");
    	String CaminhoAlunos = caminhoBase + "\\src\\TXT\\Alunos.txt";
    	String CaminhoDisciplinas = caminhoBase + "\\src\\TXT\\Disciplinas.txt";
    	String CaminhoCursos = caminhoBase + "\\src\\TXT\\Cursos.txt";
    	
    	TXTpLista FormandoLista = new TXTpLista();
    	ExibirPT2 exibir = new ExibirPT2();
    	
    	//Alunos
    	FormandoLista.preencheAlunos(ListaAlunos, CaminhoAlunos);
    	exibir.exibirNomeAlunosDeLista(ListaAlunos);
    	//Disciplinas
    	FormandoLista.preencheDisciplina(ListaDisciplinas, CaminhoDisciplinas);
    	exibir.exibirNomeDisciplinaDaLista(ListaDisciplinas);
    	//Cursos
    	FormandoLista.preencherCursos(ListaCursos, CaminhoCursos);
    	exibir.exibirMediaDoCurso(ListaCursos);
    	
    	
    }
}
