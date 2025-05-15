package metodosAuxiliares;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.imageio.IIOException;

public class Relatorio {
	
    String caminhoBase = System.getProperty("user.dir");
    File arquivo = new File(caminhoBase, "RelatórioTXT");
    //montar estrutura de Data e Hora!!!
    LocalDateTime agora = LocalDateTime.now();
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    String dataformada = agora.format(formato);
    
	public boolean Checarelatorio() {
	    return arquivo.exists() && arquivo.isFile();
	}

	
	public void Criar() throws IOException {
		if(!Checarelatorio()) {
			try {
				FileWriter conteudo = new FileWriter(arquivo);
				conteudo.write("Relatório Criado em: "+dataformada);
				conteudo.close();
				
			}catch (IIOException e) {
				System.out.println("Erro ao criar arquivo!!!");
			}
		}
		
	}
	
	public void Adiciona() {};
	public void Remove() {};
}
