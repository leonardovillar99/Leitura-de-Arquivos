package arquivos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoi {
	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\Leonardo\\git\\repository12\\Arquivos-TXT\\src\\arquivos\\arquivo_excel.xls");
		
		if(!file.exists()) { /* Condicional que irá criar um novo arquivo se ele não existir */
			file.createNewFile();
		}
		
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
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		pessoas.add(pessoa1);
		pessoas.add(pessoa2);
		pessoas.add(pessoa3);
		
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(); /* Vai ser usado para escrever a planilha */
		HSSFSheet linhasPessoa = hssfWorkbook.createSheet("Planilha aula curso de java");
		
		int numeroLinha = 0;
		
		for(Pessoa p : pessoas) {
			Row linha = linhasPessoa.createRow(numeroLinha++); /* Criando a linha na planilha */
			
			int celula = 0;
			
			Cell celNome = linha.createCell(celula++); /* Célula 01 */
			celNome.setCellValue(p.getNome());
			
			Cell celEmail = linha.createCell(celula++); /* Célula 02 */
			celEmail.setCellValue(p.getEmail());
			
			Cell celIdade = linha.createCell(celula++); /* Célula 03 */
			celIdade.setCellValue(p.getIdade());
		}
		
		FileOutputStream saida = new FileOutputStream(file);
		hssfWorkbook.write(saida);
		
		saida.flush();
		saida.close();
		
		System.out.println("Planilha foi criada!");
	}
}
