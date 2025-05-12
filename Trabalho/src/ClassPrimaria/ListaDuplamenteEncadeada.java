package ClassPrimaria;
public class ListaDuplamenteEncadeada<T> {
    private No<T> head;
    private No<T> tail;
    private int tamanho;

    public ListaDuplamenteEncadeada() {
        this.head = null;
        this.tail = null;
        this.tamanho = 0;
    }

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
}
