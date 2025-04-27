package PT2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import ClassPrimaria.Aluno;
import ClassPrimaria.lista;
import ClassPrimaria.no;

public class TxtAlunosListaAlunos {
    private no<Aluno> noaluno;
  

    public lista<Aluno> preencheAlunos(lista<Aluno> ListaAlunos, String caminho) {

        File arquivo = new File(caminho);
        if (!arquivo.exists()) {
            System.out.println("Arquivo não encontrado");
        } else {
            try {
                BufferedReader leitor = new BufferedReader(new FileReader(arquivo));
                String linha;

                while ((linha = leitor.readLine()) != null) { 
                    if (linha.trim().isEmpty()) {
                        // System.out.println("Linha vazia");
                    } else {
                        String[] linhastxt = linha.split(";");
                        if (linhastxt.length == 3) {
                            int matricula = Integer.parseInt(linhastxt[0]);
                            String nome = linhastxt[1];
                            int idade = Integer.parseInt(linhastxt[2]); 
                            Aluno alunoLido = new Aluno(matricula, nome, idade);
                            noaluno = new no<Aluno>(alunoLido);
                            ListaAlunos.AdicionarNoFinal(noaluno);                		
                        }
                    }
                }

                leitor.close();
            } catch (IOException e) {
                System.out.println("Erro ao ler o arquivo: " + e.getMessage());
            }
        }
        return ListaAlunos;
    }
}
