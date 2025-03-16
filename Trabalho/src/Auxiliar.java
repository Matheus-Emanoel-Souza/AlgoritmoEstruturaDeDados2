import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class Auxiliar {
	String Caminho1 = "C:\\Users\\mathe\\Desktop\\AlgoritmoEstruturaDeDados2\\Alunos.txt";
	String Caminho2 = "C:\\Users\\mathe\\Desktop\\AlgoritmoEstruturaDeDados2\\Curso.txt";
	String Caminho3 = "C:\\Users\\mathe\\Desktop\\AlgoritmoEstruturaDeDados2\\Disciplina.txt";
	int Qtdlinhas;
	String linhas;
	int Contador =0;
	Curso[] ArrayCurso;
	Aluno[] ArrayAluno;
	Disciplina[] ArrayDisciplina;
	
	public void MontaCursos() throws IOException {
		Qtdlinhas=0;
		Contador=0;
		//Rodar o txt para contar e criar a lista. Jeito feio de fazer.
		try (BufferedReader br = new BufferedReader(new FileReader(Caminho2))) {
	        while ((linhas = br.readLine()) != null) {
	        	Qtdlinhas++;	        	
	        }
	    } catch (FileNotFoundException e) {System.out.println("Arquivo não encontrado!");
	    
	     ArrayCurso = new Curso[Qtdlinhas];
	    
	    try (BufferedReader br = new BufferedReader(new FileReader(Caminho2))) {
	        while ((linhas = br.readLine()) != null) {
	        	String[] partes = linhas.split(";");
	        	int matricula = Integer.parseInt(partes[0]);
                int codDisciplina = Integer.parseInt(partes[1]);
                float nota1 = Float.parseFloat(partes[2]);
                float nota2 = Float.parseFloat(partes[3]);
                
                Curso novoCurso = new Curso(matricula,codDisciplina,nota1,nota2);
                ArrayCurso[Contador]=novoCurso;
                Contador++;
	        }}}}

	@SuppressWarnings({ "unused" })
	public void MontaAluno() throws IOException {
		Qtdlinhas=0;
		Contador=0;
		//Rodar o txt para contar e criar a lista. Jeito feio de fazer.
		try (BufferedReader br = new BufferedReader(new FileReader(Caminho1))) {
	        while ((linhas = br.readLine()) != null) {
	        	Qtdlinhas++;	        	
	        }
	    } catch (FileNotFoundException e) {System.out.println("Arquivo não encontrado!");
	    
	    ArrayAluno = new Aluno[Qtdlinhas];
	    
	    try (BufferedReader br = new BufferedReader(new FileReader(Caminho1))) {
	        while ((linhas = br.readLine()) != null) {
	        	String[] partes = linhas.split(";");	        	
	        	int Matricula = Integer.parseInt(partes[0]);
	        	String Nome = partes[1];
    			int idade = Integer.parseInt(partes[2]);
    			
                Aluno NovoAluno= new Aluno(Matricula,Nome,idade);
                
                ArrayAluno[Contador]=NovoAluno;
                Contador++;
	        }}}}
			
	public void MontaDisciplina() throws FileNotFoundException, IOException {
		Qtdlinhas=0;
		Contador=0;
		//Rodar o txt para contar e criar a lista. Jeito feio de fazer.
		try (BufferedReader br = new BufferedReader(new FileReader(Caminho3))) {
	        while ((linhas = br.readLine()) != null) {
	        	Qtdlinhas++;	        	
	        }
	    } catch (FileNotFoundException e) {System.out.println("Arquivo não encontrado!");
	    
	    ArrayDisciplina = new Disciplina[Qtdlinhas];
	    
	    try (BufferedReader br = new BufferedReader(new FileReader(Caminho3))) {
	        while ((linhas = br.readLine()) != null) {
	        	String[] partes = linhas.split(";");	        	
	        	int CodigoDisciplina = Integer.parseInt(partes[0]);
	        	String NomeDisciplina = partes[1];
    			Float NotaMinima = Float.parseFloat(partes[2]);
    			
                Disciplina NovaDisciplina= new Disciplina(CodigoDisciplina,NomeDisciplina,NotaMinima);
                
                ArrayDisciplina[Contador]=NovaDisciplina;
                Contador++;
	        }}}
		
	}
			
	public void BuscarAluno() {
		System.out.println("Digite o nome ou a matricula do aluno:");
		Scanner scanner = new Scanner(System.in);
		String busca = scanner.nextLine();
		scanner.close();
		for(int i=0; i<ArrayAluno.length;i++) {
			if(busca == ArrayAluno[i].getNome()||Integer.parseInt(busca) ==ArrayAluno[i].getMatriculaAluno()) {
			System.out.println("Aluno encontrado!!");
			System.out.println(ArrayAluno[i].getNome());
			System.out.println(ArrayAluno[i].getMatriculaAluno());
			System.out.println("Pressione qualquer tecla para voltar ao Menu Inicial!!");
			scanner.nextLine();
			break;
			}else
			{
				System.out.println("Aluno não encontrado");
				System.out.println("Tente novamente!");
				BuscarAluno();
			}
			}
		}
	}
	
