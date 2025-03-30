import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Sistema sistema = new Sistema(); // Classe que vai orquestrar as ações do sistema
        sistema.carregarDados(); // Carrega os dados de arquivos

        while (true) {
            System.out.println("\n====Bem-vindo!====");
            System.out.println("1 - Buscar Resultados");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida. Tente novamente.");
                scanner.next(); // Limpa entrada inválida
                continue;
            }

            int escolha = scanner.nextInt();
            scanner.nextLine(); // Consome quebra de linha

            switch (escolha) {
                case 1:
                    sistema.buscar();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
    }
}
