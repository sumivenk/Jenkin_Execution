package Generic_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utlities {
	/**
	 * This method id used to read the data from Properties file(External Resource)
	 * @throws Throwable 
	 * @param sheet
	 * @param row
	 * @param cell
	 * @return
	 * @author Sumitha
	 */

	public String getExceldata(String sheet, int row, int cell) throws Throwable
	{
		FileInputStream fes = new FileInputStream("./src/test/resources/CommonData.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet  sheet1 = book.getSheet(sheet);
		Row row1 = sheet1.getRow(row);
		Cell cell1 = row1.getCell(cell);
		String excelData = cell1.getStringCellValue();
		return excelData;
	}
	
	public String getExcelDataUsingFormatter(String sheetName, int rowNum, int cellNum) throws Throwable, IOException
	{
		FileInputStream fes = new FileInputStream("./src/test/resources/CommonData.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet  sheet1 = book.getSheet(sheetName);
		Row row1 = sheet1.getRow(rowNum);
		Cell cell1 = row1.getCell(cellNum);
		DataFormatter format = new DataFormatter();
		String excelData = format.formatCellValue(cell1);
		System.out.println(excelData);
		return excelData;
		
	}
	
	public Object[][] readDataUsingDataProvider(String sheetName) throws Throwable
	{
		FileInputStream fes = new FileInputStream("./src/test/resources/CommonData.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet  sheet1 = book.getSheet(sheetName);
		int lastrow = sheet1.getLastRowNum()+1;
		int lastCell = sheet1.getRow(0).getLastCellNum();
		
		Object[][] obj = new Object[lastrow][lastCell];
		
		for(int i = 0 ; i < lastrow ; i++)
		{
			for (int j = 0; j < lastCell ; j++)
			{
				
				obj[i][j] = sheet1.getRow(i).getCell(j).toString();
					
			}
			
		}
		return obj;
	}
	
}
