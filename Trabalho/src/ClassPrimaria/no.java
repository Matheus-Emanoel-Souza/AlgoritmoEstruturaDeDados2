package ClassPrimaria;

public class no<t> {
	private t dado;
	private no<t> prox;
	
	public no(t dado) {
		this.setDado(dado);
		this.setProx(null);
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
	    if (prox != null && dado.getClass() == prox.getDado().getClass()) {
	        this.prox = prox;
	    } else if (prox != null) {
	        throw new IllegalArgumentException("Tipo do próximo nó é diferente! Esperado:" +
	                dado.getClass().getSimpleName() +
	                ", mas foi: " + prox.getDado().getClass().getSimpleName());
	    } else {
	        // Caso o prox seja null, podemos atribuir null
	        this.prox = null;
	    }
	}		
}
