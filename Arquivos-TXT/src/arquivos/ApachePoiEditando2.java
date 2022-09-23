package arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoiEditando2 {
	public static void main(String[] args) throws IOException {
		
		File file = new File("C:\\\\Users\\\\Leonardo\\\\git\\\\repository12\\\\Arquivos-TXT\\\\src\\\\arquivos\\\\arquivo_excel.xls");
		
		FileInputStream entrada = new FileInputStream(file);
		
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(entrada); /* Entrada do arquivo XLS do excel */
		HSSFSheet planilha = hssfWorkbook.getSheetAt(0); /* Pegando a planilha */
		
		Iterator<Row> linhaIterator = planilha.iterator();
		
		while(linhaIterator.hasNext()) { 
			Row linha = linhaIterator.next();
						
			String valorCelula = linha.getCell(0).getStringCellValue();
			
			linha.getCell(0).setCellValue(valorCelula.indent(0) + " Villar");
		}
		
		entrada.close();
		
		FileOutputStream saida = new FileOutputStream(file);
		hssfWorkbook.write(saida);
		saida.flush();
		saida.close();
		
		System.out.println("Planilha atualizada!");
	}
}
