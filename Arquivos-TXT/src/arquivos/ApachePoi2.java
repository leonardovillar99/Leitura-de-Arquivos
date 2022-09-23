package arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoi2 {
	public static void main(String[] args) throws IOException {
		
		/* Aqui o arquivo está sendo lido */
		
		FileInputStream entrada = new FileInputStream(new File("C:\\Users\\Leonardo\\git\\repository12\\Arquivos-TXT\\src\\arquivos\\arquivo_excel.xls"));
		
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(entrada); /* Prepara a entrada do arquivo excel para leitura */
		HSSFSheet planilha = hssfWorkbook.getSheetAt(0); /* Pega a primeira planilha do nosso arquivo excel */
		
		Iterator<Row> linhaIterator = planilha.iterator();
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		while(linhaIterator.hasNext()) { /* Enquanto tiver linhas no arquivo do excel ele irá entrar e pegar a linha */
			
			Row linha = linhaIterator.next(); /* Dados da pessoa na linha */
			
			Iterator<Cell> celula = linha.iterator();
			
			Pessoa pessoa = new Pessoa();
			
			while(celula.hasNext()) { /* Percorrer as células */
				Cell cell = celula.next();
				
				switch(cell.getColumnIndex()) {
				case 0:
					pessoa.setNome(cell.getStringCellValue());
					break;
					
				case 1:
					pessoa.setEmail(cell.getStringCellValue());
					break;
					
				case 2:
					pessoa.setIdade(Double.valueOf(cell.getNumericCellValue()).intValue());
					break;
				}
			} /* Fim das células */
			
			pessoas.add(pessoa);
		}
		
		entrada.close();
		
		for (Pessoa pessoa : pessoas) {
			System.out.println(pessoa);
		}
	}
}