import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class leitura {
	 public static void main(String[] args) throws IOException {
		 
		 int linhas = 80;
		 //estou colocando um tamanho fixo para não precisar repetir o processo de leitura do arquivo.
		 //Há alguma forma de saber o tamanho do arquivo sem precisar percorre-lo ?
		 //Scanner só é util se for informar pasta pelo console ?
		 
	        //Scanner scanner = new Scanner(System.in);
	       // System.out.print("Digite o caminho do arquivo: ");
	        //String caminhoArquivo = scanner.nextLine();
	       String caminhoArquivo = "C:\\Users\\mathe\\Desktop\\Trabalho.txt";
	       
	          
	        //Array que vão separar as inf. dos alunos.
	        String[] NomesDosAlunos = new String[linhas];
	        String[] Curso = new String[linhas];
	        String[] Disciplina = new String[linhas];
    		Float[]	Nota1 = new Float[linhas];
    		Float[]	Nota2 = new Float[linhas];
    		
    		
    		int contador = 0;
	        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
	            String linha;
	            while ((linha = br.readLine()) != null) {
	                //System.out.println(linha);
	            	//Array que vai dividir as linhas.
	            	String[] partes = linha.split(";");
	            	if(partes.length == 5) {
	            		NomesDosAlunos[contador] = partes[0].trim();
	            		Curso[contador] = partes[1].trim();
	            		Disciplina[contador] = partes[2].trim();
	            		Nota1[contador] = Float.parseFloat(partes[3].trim());
	            		Nota2[contador] = Float.parseFloat(partes[4].trim());	            		
	            	}
	            	else{
	            	System.out.println("Algo no arquivo deu errado.");
	            	}
	            	contador++;
	            	//System.out.println(contador +"a "+ "Aluno registrado!");
	            	}	            	            		            		            	
	            }
	        catch (NumberFormatException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
	        }
	        //teste para ver se array está funcionando.
	        for(int i = 0; i<contador ;i++) {
            	System.out.println(NomesDosAlunos[i]+" "+Curso[i]+" "+Disciplina[i]+" "+Nota1[i]+" "+Nota2[i]);	        	
            }
	 }
}

//1a parte ->Ler arquivos.
//escrever -> C:\Users\mathe\Desktop\Trabalho.txt
//2a parte ->alocar informações em vetores agora.