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

  //validação de objeto para lista.
    public int getIndice(int cod, ListaDuplamenteEncadeada<Disciplina> listaDisciplina) {
    	int indice =0;
    	No<Disciplina> percorre = listaDisciplina.getHead();
    	while(percorre.getProximo()!=null) {
    		if(cod == percorre.getConteudo().getCodDisciplina()) {
    			return indice;
    		}
    		indice ++;
    		percorre = percorre.getProximo();
    	}
    	return indice;
    }
    
    public String nomeDisciplina(int CodDisciplina, ListaDuplamenteEncadeada<Disciplina> listaDisciplina) {
    	String nomeDisciplina = null;
    	No<Disciplina> per = listaDisciplina.getHead();
    	while(per != null) {
    		if(per.getConteudo().getCodDisciplina() == CodDisciplina) {
    			nomeDisciplina = per.getConteudo().getNomeDisciplina();
    		}
    		per = per.getProximo();
    	}
    	return nomeDisciplina;
    }
}
