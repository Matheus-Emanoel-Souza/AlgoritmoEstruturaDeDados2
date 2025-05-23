package ClassPrimaria;

import java.util.function.Predicate;

import java.util.function.Function;


public class ListaDuplamenteEncadeada<T> {
    private No<T> head;
    private No<T> tail;
	private int tamanho;
    
    public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

    //Construtor para nulo
    public ListaDuplamenteEncadeada() {
        this.head = null;
        this.tail = null;
        this.tamanho = 0;
    }

    	//Criarção de um elemento generico, pode ser aluno,disciplina ou curso
    public void add(T elemento) {
        No<T> novo = new No<>(elemento);

        if (head == null) {
            head = tail = novo;
        } else {
            tail.setProximo(novo);
            novo.setAnterior(tail);
            tail = novo;
        }

        tamanho++;
    }
    
    //Adiciona na frente, igual a função de cima, posso usar para reescrever a lista
    public void addFirst(T elemento) {
        No<T> novo = new No<>(elemento);

        if (head == null) {
            head = tail = novo;
        } else {
            novo.setProximo(head);
            head.setAnterior(novo);
            head = novo;
        }

        tamanho++;
    }

    
    public boolean remove(T elemento) {
        No<T> atual = head;

        while (atual != null) {
            if (atual.getConteudo().equals(elemento)) {
                if (atual == head) {
                    head = head.getProximo();
                    if (head != null) head.setAnterior(null);
                } else if (atual == tail) {
                    tail = tail.getAnterior();
                    if (tail != null) tail.setProximo(null);
                } else {
                    atual.getAnterior().setProximo(atual.getProximo());
                    atual.getProximo().setAnterior(atual.getAnterior());
                }

                tamanho--;
                return true;
            }

            atual = atual.getProximo();
        }

        return false;
    }

    public void printForward() {
        No<T> atual = head;
        System.out.print("Lista (início → fim): ");
        while (atual != null) {
            System.out.print(atual + " ");
            atual = atual.getProximo();
        }
        System.out.println();
    }

    public void printBackward() {
        No<T> atual = tail;
        System.out.print("Lista (fim → início): ");
        while (atual != null) {
            System.out.print(atual + " ");
            atual = atual.getAnterior();
        }
        System.out.println();
    }

    public int getTamanho() {
        return tamanho;
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }

	public No<T> getHead() {
		return head;
	}

	public void setHead(No<T> head) {
		this.head = head;
	}

	public No<T> getTail() {
		return tail;
	}

	public void setTail(No<T> tail) {
		this.tail = tail;
	}
	
	public int getIndice(Predicate<T> condicao) {
	    int indice = 0;
	    No<T> percorre = this.getHead();
	    
	    while(percorre != null) {
	        if(condicao.test(percorre.getConteudo())) {
	            return indice;
	        }
	        indice++;
	        percorre = percorre.getProximo();
	    }
	    return -1;
	}
	
	
	public T iguala(Predicate<T> filtro) {
		No<T> percorre = this.getHead();
		
		while(percorre != null) {
			if(filtro.test(percorre.getConteudo())) {
				return percorre.getConteudo();
			}
				
			percorre = percorre.getProximo();
		}
		return null;
	}
	
	public void remover(Predicate<T> condicao) {
	    No<T> no = this.head;

	    while (no != null) {
	        if (condicao.test(no.getConteudo())) {
	            
	            if (no == head) {
	                head = no.getProximo();
	                if (head != null) {
	                    head.setAnterior(null);
	                } else {
	                    tail = null;
	                }
	            }
	            else if (no == tail) {
	                tail = no.getAnterior();
	                if (tail != null) {
	                    tail.setProximo(null);
	                }
	            }
	            else {
	                no.getAnterior().setProximo(no.getProximo());
	                no.getProximo().setAnterior(no.getAnterior());
	            }

	            tamanho--;
	            return;
	        }

	        no = no.getProximo();
	    }
	}

	public String gerarRelatorio(
	        ListaDuplamenteEncadeada<T> lista,
	        Predicate<T> filtro,
	        Function<T, String> formatador) {
	    
	    StringBuilder relatorio = new StringBuilder();
	    No<T> no = lista.getHead();

	    while (no != null) {
	        T elemento = no.getConteudo();
	        
	        if (filtro.test(elemento)) {
	            relatorio.append(formatador.apply(elemento));
	            relatorio.append("\n-------------------------------------------------------------\n");
	        }
	        
	        no = no.getProximo();
	    }

	    return relatorio.toString();
	}


}
