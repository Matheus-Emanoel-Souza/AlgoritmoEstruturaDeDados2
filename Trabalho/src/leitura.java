import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class leitura {
	 public static void main(String[] args) {
		 int linhas = 80;
		 //estou colocando um tamanho fixo para não precisar repetir o processo de leitura do arquivo.
		 //Há alguma forma de saber o tamanho do arquivo sem precisar percorre-lo ?
		 
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Digite o caminho do arquivo: ");
	        String caminhoArquivo = scanner.nextLine();
	          
	        //Array que vão separar as inf. dos alunos.
	        String[] NomesDosAlunos = new String[linhas];
    		Float[]	NotasDosAlunos = new Float[linhas];
    		
    		
    		int contador = 0;
	        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
	            String linha;
	            while ((linha = br.readLine()) != null) {
	                //System.out.println(linha);
	            	//Array que vai dividir as linhas.
	            	String[] partes = linha.split(";");
	            	if(partes.length == 2) {
	            		NomesDosAlunos[contador] = partes[0].trim();
	            		NotasDosAlunos[contador] = Float.parseFloat(partes[1].trim());	            	
	            	}
	            	else{
	            	System.out.println("Algo no arquivo deu errado.");
	            	}
	            	
	            	}
	            	
	            		            	
	            }
	        } 
	        catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
	        scanner.close();
	        //Contagem de linhas do arquivo.
	        
	        
	        
	        
	    }
	}
//1a parte ->Ler arquivos.
//escrever -> C:\Users\mathe\Desktop\80notas.txt
//2a parte ->alocar informações em vetores agora.