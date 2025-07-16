package product;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Generic_Utilities.Base;
import Generic_Utilities.Excel_Utlities;
import Generic_Utilities.File_Utilities;
import Generic_Utilities.Java_Utilities;
import Generic_Utilities.WebDriver_Utility;
import Pom_Repo.CreateProductPage;
import Pom_Repo.HomePage;
import Pom_Repo.Login_Page;
import Pom_Repo.ProductLookUpPage;
import Pom_Repo.ValidatationProductPage;

@Test(groups = {"smokeTest","regressionTest"})
public class CreateProductTest extends Base{
	public void createProductTest() throws Throwable {
		
//		Login to vtiger application->click on product link->
//		click on create product lookup image->Enter product name->click on save Btn->
//		verify whether the product is created in product Information page and Logout from the application. 
		
//		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.properties");
//		Properties prop = new Properties();
//		prop.load(fis);
//		String Browser = prop.getProperty("Browser");
//		String Url = prop.getProperty("Url");
//		String UserName = prop.getProperty("UserName");
//		String Password = prop.getProperty("Password");		
		
		File_Utilities fLib = new File_Utilities();
//		String BROWSER = fLib.getKeyAndValue("Browser");
//		String URL = fLib.getKeyAndValue("Url");
//		String USERNAME = fLib.getKeyAndValue("UserName");
//		String PASSWORD = fLib.getKeyAndValue("Password");
		
//		WebDriver driver;
//		if(BROWSER.equalsIgnoreCase("chrome"))
//		{
//			driver = new ChromeDriver();
//		}
//		else if(BROWSER.equalsIgnoreCase("edge"))
//		{
//			driver = new EdgeDriver();
//		}
//		else if(BROWSER.equalsIgnoreCase("firefox"))
//		{
//			driver = new EdgeDriver();
//		}
//		else
//		{
//			driver = new FirefoxDriver();
//		}
		
		//create random to avoid duplicate
//		Random ran = new Random();
//		int ranNum = ran.nextInt(1000);
		
		Java_Utilities jLib = new Java_Utilities();
		int ranNum = jLib.getRandomNum();
		
//		//Path Connection
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
//		String ProName = cell.getStringCellValue()+ranNum;
		
		Excel_Utlities excelLib = new Excel_Utlities();
		String ProName = excelLib.getExceldata("Product", 0, 0)+ranNum;
		
		System.out.println(ProName);
		
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriver_Utility wLib = new WebDriver_Utility();
		wLib.maximizeWindow(driver);
		wLib.waitElementsToLoad(driver);
		
//		driver.get(URL);

//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
		
//		Login_Page login = new Login_Page(driver);
//		login.loginToApp(USERNAME,PASSWORD);
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
//		System.out.println(actproductName);
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
		
//		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//		driver.findElement(By.linkText("Sign Out")).click();
		
//		home.logoutApp();
		
	}

}
