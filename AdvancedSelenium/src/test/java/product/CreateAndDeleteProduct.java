package product;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_Utilities.Excel_Utlities;
import Generic_Utilities.File_Utilities;
import Generic_Utilities.Java_Utilities;
import Generic_Utilities.WebDriver_Utility;
import Pom_Repo.CreateProductPage;
import Pom_Repo.DeleteProductValidatationPage;
import Pom_Repo.HomePage;
import Pom_Repo.Login_Page;
import Pom_Repo.ProductLookUpPage;
import Pom_Repo.ValidatationProductPage;

public class CreateAndDeleteProduct {
	public static void main(String[] args) throws Throwable {
		
//Login to vtiger application->click on products link->click on create product lookup image->Enter product name->
//click on save Btn->verify whether the product is created in product Information page->click on product link->navigate to product table page ->
//select the product created checkbox->click on delete->Handle the Alert popup 
		
//		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.properties");
//		Properties prop = new Properties();
//		prop.load(fis);
//		String Browser = prop.getProperty("Browser");
//		String Url = prop.getProperty("Url");
//		String UserName = prop.getProperty("UserName");
//		String Password = prop.getProperty("Password");		
		
		File_Utilities fLib = new File_Utilities();
		String BROWSER = fLib.getKeyAndValue("Browser");
		String URL = fLib.getKeyAndValue("Url");
		String USERNAME = fLib.getKeyAndValue("UserName");
		String PASSWORD = fLib.getKeyAndValue("Password");
		
		WebDriver driver;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else
		{
			driver = new FirefoxDriver();
		}

		
//		Random ran = new Random();
//		int random = ran.nextInt(1000);
		
		Java_Utilities jLib = new Java_Utilities();
		int random = jLib.getRandomNum();
		
		//Path Connection
//		FileInputStream fes = new  FileInputStream("./src/test/resources/CommonData.xlsx");
//				
//		//Keep the WorkBook/excel in the read mode
//		Workbook book = WorkbookFactory.create(fes);
//				
//		//Navigate into mentioned sheet name
//		Sheet sheet = book.getSheet("Product");
//		
//		Row row = sheet.getRow(0);
//		Cell cell = row.getCell(0);
//		
//		String ProName = cell.getStringCellValue()+random;
		
		Excel_Utlities excelLib = new Excel_Utlities();
		String ProName = excelLib.getExceldata("Product", 0, 0)+random;
		
		System.out.println(ProName);
		
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebDriver_Utility wLib = new WebDriver_Utility();
		wLib.maximizeWindow(driver);
		wLib.waitElementsToLoad(driver);
		
		driver.get(URL);

//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
		
		Login_Page login = new Login_Page(driver);
		login.loginToApp(USERNAME,PASSWORD);
//		login.getUserNameTextField().sendKeys(USERNAME);
//		login.getPasswordTextField().sendKeys(PASSWORD);
//		login.getLoginButton().click();
		
//		driver.findElement(By.linkText("Products")).click();
		HomePage home = new HomePage(driver);
		home.clickOnProduct();		
		
//		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		
		ProductLookUpPage proLookup = new ProductLookUpPage(driver);
		proLookup.clickOncreateProduct();
		
//		driver.findElement(By.name("productname")).sendKeys(ProName);
//		driver.findElement(By.xpath("//input[@name='button' and @title = 'Save [Alt+S]']")).click();
		CreateProductPage createProd = new CreateProductPage(driver);
		createProd.createProduct(ProName);
		
//		String actproductName = driver.findElement(By.cssSelector("td[id='mouseArea_Product Name']")).getText();
//		
//		if(actproductName.contains(ProName))
//		{
//			System.out.println("Product created successfully!!");			
//		}
//		else
//		{
//			System.out.println("Product not created. Try again!!");
//		}
		
		ValidatationProductPage validate = new ValidatationProductPage(driver);
		validate.prdValidate(ProName);		
		
		//To Delete
		
//		driver.findElement(By.linkText("Products")).click();
		home.clickOnProduct();		
		
//		driver.findElement(By.xpath("//table[@class='lvt small']//a[text()='"+ProName+"']/../preceding-sibling::td[2]//input[@type=\"checkbox\"]")).click();
//		driver.findElement(By.xpath("//input[@value='Delete']")).click();
		
		proLookup.deleteProduct(driver, ProName);
		
		//switch to Alert
//		driver.switchTo().alert().accept();
		
		wLib.alertHandle(driver);
	
		//Delete Validatation
		
//		List<WebElement> prdData = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr//td[3])[position()>1]"));
//		
//		boolean flag=false;
//		for (WebElement prd : prdData)
//		{
//			String actPrd = prd.getText();
//			if(actPrd.contains(ProName))
//			{
//				flag=true;
//				break;
//			}
//		}
//		if(flag)
//		{
//			System.out.println("Product Name is Deleted");
//		}
//		else
//		{
//			System.out.println("Product Name is not Deleted");
//		}			
		
		
		DeleteProductValidatationPage deleteValidate = new DeleteProductValidatationPage(driver);
		deleteValidate.validateProductDeleted(driver, ProName);
		
		
//		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//		driver.findElement(By.linkText("Sign Out")).click();
		
		home.logoutApp();
		
		
	}

}
