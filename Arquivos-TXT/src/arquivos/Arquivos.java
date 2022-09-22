package arquivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arquivos {
	public static void main(String[] args) throws IOException {
		
		Pessoa pessoa1 = new Pessoa();
		pessoa1.setNome("Leonardo");
		pessoa1.setEmail("l.fvillar@gmail.com");
		pessoa1.setIdade(23);
		
		Pessoa pessoa2 = new Pessoa();
		pessoa2.setNome("Giovanna");
		pessoa2.setEmail("giovannasousa@gmail.com");
		pessoa2.setIdade(22);
		
		Pessoa pessoa3 = new Pessoa();
		pessoa3.setNome("Andrey");
		pessoa3.setEmail("andreysilva@gmail.com");
		pessoa3.setIdade(26);
		
		Pessoa pessoa4 = new Pessoa();
		pessoa4.setNome("Aurea");
		pessoa4.setEmail("aurearosa@gmail.com");
		pessoa4.setIdade(80);
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoas.add(pessoa1);
		pessoas.add(pessoa2);
		pessoas.add(pessoa3);
		pessoas.add(pessoa4);
		
		File arquivo = new File("C:\\Users\\Leonardo\\eclipse-workspace\\Arquivos-TXT\\src\\arquivos\\arquivo.csv");
		
		if(!arquivo.exists()) {
			arquivo.createNewFile();
		}
		
		FileWriter escreverArquivo = new FileWriter(arquivo);
		
		for (Pessoa pessoa : pessoas) {
			escreverArquivo.write(pessoa.getNome() + ";" + pessoa.getEmail() + ";" + pessoa.getIdade() + "\n");
		}
		
		escreverArquivo.flush();
		escreverArquivo.close();
	}
}
