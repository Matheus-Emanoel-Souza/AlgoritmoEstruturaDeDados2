import ClassPrimaria.Aluno;
import ClassPrimaria.lista;
import PT2.ExibirPT2;
import PT2.TxtAlunosListaAlunos;

public class Main {
    public static void main(String[] args) {

    	//ystem.out.println(new File("").getAbsolutePath());

    	lista<Aluno> ListaAlunos = new lista<Aluno>();
    	String caminhoBase = System.getProperty("user.dir");
    	String CaminhoAlunos = caminhoBase + "\\src\\TXT\\Alunos.txt";
    	
    	TxtAlunosListaAlunos FormandoLista = new TxtAlunosListaAlunos();
    	ExibirPT2 exibir = new ExibirPT2();
    	
    	FormandoLista.preencheAlunos(ListaAlunos, CaminhoAlunos);
    	exibir.exibirNomeAlunosDeLista(ListaAlunos);
    	
    }
}
