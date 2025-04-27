package ClassPrimaria;

public class no<t> {
	private t dado;
	private no<t> prox;
	
	public no(t dado) {
		this.setDado(dado);
		this.prox = null;
	}

	public t getDado() {
		return dado;
	}

	public void setDado(t dado) {
		this.dado = dado;
	}

	public no<t> getProx() {
		return prox;
	}

	public void setProx(no<t> prox) {
		this.prox = prox;
	}
	
	
}
