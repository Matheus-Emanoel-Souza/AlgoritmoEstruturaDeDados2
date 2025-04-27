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
		if(dado.getClass() == prox.getDado().getClass()) {
		this.prox = prox;
		}else 
		{
			throw new IllegalArgumentException("Tipo do próximo nó é diferente! Esperado:"+
					dado.getClass().getSimpleName() +
		            ", mas foi: " + (prox != null ? prox.getDado().getClass().getSimpleName() : "null"));
			//this.prox = null;
			//ideal é tratavar e retornar erro.
		}
		
	}		
}
