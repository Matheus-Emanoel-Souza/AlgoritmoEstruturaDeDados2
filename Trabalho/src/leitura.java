import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class leitura {
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Digite o caminho do arquivo: ");
	        String caminhoArquivo = scanner.nextLine();
	        
	        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
	            String linha;
	            while ((linha = br.readLine()) != null) {
	                System.out.println(linha);
	            }
	        } catch (IOException e) {
	            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
	        }
	        
	        scanner.close();
	    }
	}
//escrever -> C:\Users\mathe\Desktop\80notas.txt