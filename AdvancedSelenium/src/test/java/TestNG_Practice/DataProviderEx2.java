package TestNG_Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_Utilities.Excel_Utlities;

public class DataProviderEx2 {
	
	@Test(dataProvider = "readContactData")
	public void createContact(String firstName, String lastName)
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.name("firstname")).sendKeys(firstName);
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		
		driver.quit();
				
	}
	
	
	@DataProvider
	public Object[][] readContactData() throws Throwable
	{
		
//		obj[0][0] = "Sumitha";
//		obj[0][1] = "V";
//		
//		obj[1][0] = "Janani";
//		obj[1][1] = "V";
//		
//		obj[2][0] = "Dilip";
//		obj[2][1] = "Latha";
		
//		Excel_Utlities excelLib = new Excel_Utlities();
//		obj[0][0] = excelLib.getExceldata("contact", 0, 0);
//		obj[0][1] = excelLib.getExceldata("contact", 0, 1);
//		
//		obj[1][0] = excelLib.getExceldata("contact", 1, 0);
//		obj[1][1] = excelLib.getExceldata("contact", 1, 1);
//		
//		obj[2][0] = excelLib.getExceldata("contact", 2, 0);
//		obj[2][1] = excelLib.getExceldata("contact", 2, 1);
		
		Excel_Utlities excelLib = new Excel_Utlities();
		Object[][] obj = excelLib.readDataUsingDataProvider("contact");
		
		return obj;
		
	}
	

}
