import javax.swing.*;
import java.awt.*;

public class PainelPrincipal {

    public static void main(String[] args) {
        iniciarPainelPrincipal(); // só isso na main :)
    }

    public static void iniciarPainelPrincipal() {
        // Cria a janela principal
        JFrame janelaPrincipal = new JFrame("Painel Principal");
        janelaPrincipal.setSize(400, 200);
        janelaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janelaPrincipal.setLocationRelativeTo(null);

        // Painel com layout
        JPanel painel = new JPanel(new GridLayout(2, 2, 15, 15));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Botões
        JButton btnPesquisarAluno = new JButton("Pesquisar Aluno");
        JButton btnCadastrarAluno = new JButton("Cadastrar Aluno");
        JButton btnPesquisarDisciplina = new JButton("Pesquisar Disciplina");
        JButton btnCadastrarDisciplina = new JButton("Cadastrar Disciplina");

        // Adiciona botões ao painel
        painel.add(btnPesquisarAluno);
        painel.add(btnCadastrarAluno);
        painel.add(btnPesquisarDisciplina);
        painel.add(btnCadastrarDisciplina);

        // Adiciona painel à janela principal
        janelaPrincipal.add(painel);
        janelaPrincipal.setVisible(true);

        // Ações dos botões
        btnPesquisarAluno.addActionListener(e -> abrirJanelaPesquisarAluno());
        btnCadastrarAluno.addActionListener(e -> abrirJanela("Cadastrar Aluno"));
        btnPesquisarDisciplina.addActionListener(e -> abrirJanela("Pesquisar Disciplina"));
        btnCadastrarDisciplina.addActionListener(e -> abrirJanela("Cadastrar Disciplina"));
    }

    // Janela genérica
    private static void abrirJanela(String titulo) {
        JFrame novaJanela = new JFrame(titulo);
        novaJanela.setSize(300, 200);
        novaJanela.setLocationRelativeTo(null);
        novaJanela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel label = new JLabel("Janela: " + titulo, SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 14));
        novaJanela.add(label);

        novaJanela.setVisible(true);
    }

    // Janela específica de pesquisar aluno
    private static void abrirJanelaPesquisarAluno() {
        JFrame janela = new JFrame("Pesquisar Aluno");
        janela.setSize(400, 150);
        janela.setLocationRelativeTo(null);
        janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel painel = new JPanel();
        painel.setLayout(new BorderLayout(10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel label = new JLabel("Digite o nome ou matrícula do aluno:");
        JTextField campoTexto = new JTextField();

        painel.add(label, BorderLayout.NORTH);
        painel.add(campoTexto, BorderLayout.CENTER);

        janela.add(painel);
        janela.setVisible(true);
    }
}
