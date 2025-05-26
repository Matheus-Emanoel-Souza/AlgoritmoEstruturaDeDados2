package model;

import ClassPrimaria.ListaDuplamenteEncadeada;
import ClassPrimaria.No;

public class Disciplina {
 
    private int CodDisciplina;
    private String NomeDisciplina;
    private float NotaMinima;

    public Disciplina(int CodDisciplina, String NomeDisciplina, float NotaMinima) {
        this.CodDisciplina = CodDisciplina;
        this.NomeDisciplina = NomeDisciplina;
        this.NotaMinima = NotaMinima;
    }
    public Disciplina(int CodDisciplina) {
        this.CodDisciplina = CodDisciplina;
    }

    public Disciplina() {
	}
	public int getCodDisciplina() {
        return CodDisciplina;
    }

    public void setCodDisciplina(int codDisciplina) {
        CodDisciplina = codDisciplina;
    }

    public String getNomeDisciplina() {
        return NomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        NomeDisciplina = nomeDisciplina;
    }

    public float getNotaMinima() {
        return NotaMinima;
    }

    public void setNotaMinima(float notaMinima) {
        NotaMinima = notaMinima;
    }
    
    public int qtd_alunos(ListaDuplamenteEncadeada<Curso> ListaCursos) {
    	int qtd=0;
    	No<Curso> no= ListaCursos.getHead();
    	while(no!=null) {
    		if(no.getConteudo().getCodDisciplina() == CodDisciplina) {
    			qtd++;
    		}
    	}
    	return qtd;
    }

	/*
	 * //validação de objeto para lista. public int getIndice(Disciplina disc,
	 * ListaDuplamenteEncadeada<Disciplina> listaDisciplina) {
	 * 
	 * int indice =0; No<Disciplina> percorre = listaDisciplina.getHead();
	 * while(percorre != null) { if(disc.getCodDisciplina() ==
	 * percorre.getConteudo().getCodDisciplina()) { return indice; } indice ++;
	 * percorre = percorre.getProximo(); } return -1; }
	 */
    
	/*
	 * //buscar nome da disciplina public Disciplina disciplinaporcodigo( int
	 * CodDisciplina, ListaDuplamenteEncadeada<Disciplina> listaDisciplina) {
	 * Disciplina achada = new Disciplina(); No<Disciplina> per =
	 * listaDisciplina.getHead(); while(per != null) {
	 * if(per.getConteudo().getCodDisciplina() == CodDisciplina) {
	 * achada.setNomeDisciplina(per.getConteudo().getNomeDisciplina());
	 * achada.setCodDisciplina(CodDisciplina);
	 * achada.setNotaMinima(per.getConteudo().getNotaMinima()); return achada; } per
	 * = per.getProximo(); } return achada; }
	 */
    
    //funcao remover disciplina da lista.
    public void RemoverDisciplina(int cod_disciplina, ListaDuplamenteEncadeada<Disciplina> listaDeDisciplina) {
        No<Disciplina> no = listaDeDisciplina.getHead();

        while (no != null) {
            if (no.getConteudo().CodDisciplina == cod_disciplina) {
                
                if (no == listaDeDisciplina.getHead()) {
                	listaDeDisciplina.setHead(no.getProximo());
                    if (listaDeDisciplina.getHead() != null) {
                    	listaDeDisciplina.getHead().setAnterior(null);
                    } else {
                        
                    	listaDeDisciplina.setTail(null);
                    }
                }
                
                else if (no == listaDeDisciplina.getTail()) {
                	listaDeDisciplina.setTail(no.getAnterior());
                    if (listaDeDisciplina.getTail() != null) {
                    	listaDeDisciplina.getTail().setProximo(null);
                    }
                }
                
                else {
                    no.getAnterior().setProximo(no.getProximo());
                    no.getProximo().setAnterior(no.getAnterior());
                }

                listaDeDisciplina.setTamanho(listaDeDisciplina.getTamanho()-1);
                return;
            }

            no = no.getProximo();
        }
    }
    //funçao busca alunoporcódigo 
    
    
}
