package ClassPrimaria;

public final class No<T> {
    private T conteudo;
    private No<T> proximo;
    private No<T> anterior;

    // Construtor
    public No(T conteudo) {
        this.conteudo = conteudo;
        this.proximo = null;
        this.anterior = null;
    }

    // obter
    public T getConteudo() {
        return conteudo;
    }

    public No<T> getProximo() {
        return proximo;
    }

    public No<T> getAnterior() {
        return anterior;
    }

    // setar
    public void setConteudo(T conteudo) {
        this.conteudo = conteudo;
    }

    public void setProximo(No<T> proximo) {
        this.proximo = proximo;
    }

    public void setAnterior(No<T> anterior) {
        this.anterior = anterior;
    }
	
	//contrutor caso eu tenha que inserir no meio da lista
	public No() {
    this.conteudo = null;
    this.anterior = null;
    this.proximo = null;
}
}
