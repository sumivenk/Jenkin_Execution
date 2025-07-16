package DDT;

import java.io.File;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class FetchingDataFromPDF {
	public static void main(String[] args) throws Throwable {
		
		File fis = new File("./src/test/resources/SeleniumMasterNotes_1.pdf");
		
		PDDocument doc = PDDocument.load(fis);
		
		int pages = doc.getNumberOfPages();
		System.out.println("Number of Pages: "+pages);
		
		//To read all pages
		PDFTextStripper pdfData = new PDFTextStripper();
//		String readData = pdfData.getText(doc);
//		System.out.println(readData);
		
		//To start read from specific page
//		pdfData.setStartPage(3);
//		String readData = pdfData.getText(doc);
//		System.out.println(readData);
		
		//To read specific page
		pdfData.setStartPage(4);
		pdfData.setEndPage(4);
		String readData = pdfData.getText(doc);
		System.out.println(readData);
		
	}

}
