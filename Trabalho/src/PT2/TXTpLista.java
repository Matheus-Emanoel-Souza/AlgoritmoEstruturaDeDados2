package PT2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import ClassPrimaria.Aluno;
import ClassPrimaria.Curso;
import ClassPrimaria.Disciplina;
import ClassPrimaria.listaEncadeada;
import ClassPrimaria.no;

public class TXTpLista {
    private no<Aluno> noaluno;
    private no<Disciplina> nodisciplina;
    private no<Curso> nocurso;
  
    public listaEncadeada<Curso> preencherCursos(listaEncadeada<Curso> ListaCursos, String caminho){
    	File arquivo = new File(caminho);
    	if(!arquivo.exists()) {
    		System.out.println("Arquivo não encontrado");
    	}
    	else {
    		try (BufferedReader leitor = new BufferedReader(new FileReader(arquivo))) {
                String linha;
                
                while((linha = leitor.readLine())!= null) {
                	if(linha.trim().isEmpty()) {
                		
                	}else {
            		String[] linhastxt = linha.split(";");
            		if(linhastxt.length == 4) {
            			int Matricula = Integer.parseInt(linhastxt[0]);
            			int CodDisciplina = Integer.parseInt(linhastxt[1]);
            			float Nota1 = Float.parseFloat(linhastxt[2]);
            			float Nota2 = Float.parseFloat(linhastxt[3]);
            			Curso curso = new Curso(Matricula,CodDisciplina,Nota1,Nota2);
            			nocurso = new no<Curso>(curso);
            			ListaCursos.AdicionarNoFinal(nocurso);
            		}
                	}               
                	}


    		}catch (IOException e) {
                System.out.println("Erro ao ler o arquivo: " + e.getMessage());               
    		} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
		return ListaCursos;
    	}
    
    public listaEncadeada<Aluno> preencheAlunos(listaEncadeada<Aluno> ListaAlunos, String caminho) {

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
    
     public listaEncadeada<Disciplina> preencheDisciplina(listaEncadeada<Disciplina> listaCursos, String caminho){
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
                            int id = Integer.parseInt(linhastxt[0]);
                            String nomeMateria = linhastxt[1];
                            float Media = Float.parseFloat(linhastxt[2]);
                            Disciplina DisciplinaLida = new Disciplina(id,nomeMateria,Media);                           
                            nodisciplina = new no<Disciplina>(DisciplinaLida);
                            listaCursos.AdicionarNoFinal(nodisciplina);                		
                        }
                    }
                }

                leitor.close();
            } catch (IOException e) {
                System.out.println("Erro ao ler o arquivo: " + e.getMessage());
            }
        }
		return listaCursos;
    	
    }
}
