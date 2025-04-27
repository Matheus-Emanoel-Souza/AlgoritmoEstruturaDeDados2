package ClassPrimaria;

public class lista<t> {
	private no<t> primeiro;
	private int contador;
	private Class<?> tipopermitido;
	
	
	public no<t> getPrimeiro() {
		return primeiro;
	}

	public void setPrimeiro(no<t> primeiro) {
		this.primeiro = primeiro;
	}

	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}

	public Class<?> getTipopermitido() {
		return tipopermitido;
	}

	public void setTipopermitido(Class<?> tipopermitido) {
		this.tipopermitido = tipopermitido;
	}

	public lista() {
	    this.primeiro = null;
	    this.contador = 0;
	    this.tipopermitido = null;
	}

	public lista(no<t> primeiro) {
		this.primeiro = primeiro;
		this.contador = 1;
		if(primeiro != null && primeiro.getDado() != null) {
			this.tipopermitido = primeiro.getDado().getClass();
		}
		else {
			//Como ja criei uma metodo nulo, impossível cair aqui.
		}
	}
	
	public void AdicionarNoInicio(no<t> noadicionado) {
		if(noadicionado.getDado().getClass() != tipopermitido.getClass()) {
			throw new IllegalArgumentException("Tipos de dado imcompatível com a lista");
		}else {
			noadicionado.setProx(this.primeiro);
			this.primeiro = noadicionado;
			this.contador++;
		}
	}
	public void AdicionarNoFinal(no<t> noadicionado) {
		if(this.primeiro == null) {
			this.primeiro = noadicionado;
		}
		else {
			no<t> aux = this.primeiro;
			
			while(aux.getProx() != null) {
				aux = aux.getProx();
			}
					aux.setProx(noadicionado);
		}
		this.contador++;
	}
	
}
