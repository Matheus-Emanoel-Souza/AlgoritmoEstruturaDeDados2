package ClassPrimaria;

public class lista<t> {
	private no<t> primeiro;
	private int contador;
	private Class<?> tipopermitido;
	
	
	public lista(no<t> primeiro) {
		this.primeiro = primeiro;
		this.contador = 1;
		if(primeiro != null && primeiro.getDado() != null) {
			this.tipopermitido = primeiro.getDado().getClass();
		}
		else {
			//Como é o nó que vai criar a lista, impossível entrar nessa exceção.
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
		no<t> aux = this.primeiro;
		
		while(aux.getProx() != null) {
			aux = aux.getProx();
		}
		aux.setProx(noadicionado);
		this.contador++;
	}
	
}
