package metodosAuxiliares;

import java.io.File;

public class Relatorio {
	public boolean Checarelatorio() {
	    String caminhoBase = System.getProperty("user.dir");
	    File arquivo = new File(caminhoBase, "RelatórioTXT");
	    if (arquivo.exists() && arquivo.isFile()) {
	        //System.out.println("Arquivo encontrado!");
	        return true;
	    } else {
	        //System.out.println("Arquivo não encontrado.");
	        //System.out.println(caminhoBase);
	        return false;
	    }
	}

	
	public void Criar() {
		if(Checarelatorio()) {
			
		}
	}
	public void Adiciona() {};
	public void Remove() {};
}
