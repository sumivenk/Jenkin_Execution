package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcel {
	public static void main(String[] args) throws Throwable {
		
		//Step 1: Path Connection
		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.xlsx");
		
		//Step 2: keeps the workbook/excel file in read mode
		Workbook book = WorkbookFactory.create(fis);
		
		//Step 3: Navigates to a mentioned sheet
		Sheet sheet = book.getSheet("Product");
		
		//Step 4: Navigate to mentioned row 
		Row row = sheet.getRow(0);
		
		//Step 5: Navigate to mentioned Cell
		Cell cell = row.getCell(0);
		
		String ExcelData = cell.getStringCellValue();
		System.out.println(ExcelData);
		
		Row row1 = sheet.getRow(1);
		Cell cell1 = row1.getCell(0);
		
		DataFormatter format = new DataFormatter();
		String excelData1 = format.formatCellValue(cell1);
		
		System.out.println(excelData1);
		
	}

}
