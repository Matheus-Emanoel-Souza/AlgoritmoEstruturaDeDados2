import ClassPrimaria.Aluno;
import ClassPrimaria.lista;
import PT2.ExibirPT2;
import PT2.TxtAlunosListaAlunos;

public class Main {
    public static void main(String[] args) {

    	lista<Aluno> ListaAlunos = new lista<Aluno>();
    	String CaminhoAlunos = "TXT/Alunos.txt";
    	
    	TxtAlunosListaAlunos FormandoLista = new TxtAlunosListaAlunos();
    	ExibirPT2 exibir = new ExibirPT2();
    	
    	FormandoLista.preencheAlunos(ListaAlunos, CaminhoAlunos);
    	exibir.exibirNomeAlunosDeLista(ListaAlunos);
    	
    }
}
