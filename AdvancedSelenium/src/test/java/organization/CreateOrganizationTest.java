package organization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
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
import Pom_Repo.CreateOrgPage;
import Pom_Repo.CreateProductPage;
import Pom_Repo.HomePage;
import Pom_Repo.Login_Page;
import Pom_Repo.OrgLookupImagePage;
import Pom_Repo.ProductLookUpPage;
import Pom_Repo.ValidatationOrgPage;
import Pom_Repo.ValidatationProductPage;

//@Test(groups = "regressionTest")
@Test
public class CreateOrganizationTest extends Base{
	public void createOrganizationTest() throws Throwable {
		
//		Login to vtiger application->click on organizations link->click on create organization lookup image->
//		Enter organisation name,phone number and email->click on save Btn->
//		verify whether the organization is created in Organization Information page and Logout from the application. 
		
//		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.properties");
//		Properties prop = new Properties();
//		prop.load(fis);
//		
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
//			driver = new FirefoxDriver();
//		}
//		else
//		{
//			driver = new FirefoxDriver();
//		}
		
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebDriver_Utility wLib = new WebDriver_Utility();
//		wLib.maximizeWindow(driver);
//		wLib.waitElementsToLoad(driver);
		
//		driver.get(URL);
		
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
		
//		Login_Page login = new Login_Page(driver);
//		login.getUserNameTextField().sendKeys(USERNAME);
//		login.getPasswordTextField().sendKeys(PASSWORD);
//		login.getLoginButton().click();
		
//		login.loginToApp(USERNAME,PASSWORD);
		
//		driver.findElement(By.linkText("Organizations")).click();
		HomePage home = new HomePage(driver);
		home.clickOnOrganization();
		
//		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		OrgLookupImagePage orgLookup = new OrgLookupImagePage(driver);
		orgLookup.clickOnCreateOrg();	
		
		//To Avoid Duplicate values
//		Random ran = new Random();
//		int ranNum = ran.nextInt(1000);
		
		Java_Utilities jLib = new Java_Utilities();
		int ranNum = jLib.getRandomNum();
		
//		FileInputStream fes = new FileInputStream("./src/test/resources/CommonData.xlsx");
//		Workbook book = WorkbookFactory.create(fes);
//		Sheet  sheet = book.getSheet("organization");
//		Row row1 = sheet.getRow(0);
//		Cell cell1 = row1.getCell(0);
//		String orgName = cell1.getStringCellValue()+ranNum;
		
		Excel_Utlities excelLib = new Excel_Utlities();
		String orgName = excelLib.getExceldata("organization", 0, 0)+ranNum;
		
//		driver.findElement(By.name("accountname")).sendKeys(orgName);
		
//---------------------------------------------------------------------------------------------------------------------
		
//		Row row2 = sheet.getRow(1);
//		Cell cell2 = row2.getCell(0);
//		DataFormatter format = new DataFormatter();
//		String phoneNum = format.formatCellValue(cell2);
		
		String phoneNum = excelLib.getExcelDataUsingFormatter("organization",1,0);
//		driver.findElement(By.id("phone")).sendKeys(phoneNum);
		
//---------------------------------------------------------------------------------------------------------------------
		
//		Row row3 = sheet.getRow(2);
//		Cell cell3 = row3.getCell(0);
//		String mailID = format.formatCellValue(cell3);
		
		String mailID = excelLib.getExcelDataUsingFormatter("organization",2,0);
//		driver.findElement(By.id("email1")).sendKeys(mailID);
		
//---------------------------------------------------------------------------------------------------------------------
		
//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		CreateOrgPage createOrg = new CreateOrgPage(driver);
		createOrg.createOrg(orgName, phoneNum, mailID);		
		
//		String actOrgName = driver.findElement(By.id("mouseArea_Organization Name")).getText();
//		
//		if(actOrgName.contains(orgName))
//		{
//			System.out.println("Organization name created");
//		}
//		else
//		{
//			System.out.println("Organization name not created");
//		}
		
		ValidatationOrgPage validatation = new ValidatationOrgPage(driver);
		validatation.orgCreteationValidatation(orgName);
		
//		home.logoutApp();
//		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//		driver.findElement(By.linkText("Sign Out")).click();
		
	}
	
	
//---------------------------------------------------------------------------------------------------------------------------------------
	
//@Test
//public void createProductTest() throws Throwable {
//					
//		File_Utilities fLib = new File_Utilities();
//	
//		Java_Utilities jLib = new Java_Utilities();
//		int ranNum = jLib.getRandomNum();
//
//		
//		Excel_Utlities excelLib = new Excel_Utlities();
//		String ProName = excelLib.getExceldata("Product", 0, 0)+ranNum;
//		
//		System.out.println(ProName);
//
//		WebDriver_Utility wLib = new WebDriver_Utility();
//		wLib.maximizeWindow(driver);
//		wLib.waitElementsToLoad(driver);
//
//		HomePage home = new HomePage(driver);
//		home.clickOnProduct();
//
//		ProductLookUpPage proLookup = new ProductLookUpPage(driver);
//		proLookup.clickOncreateProduct();
//		
//		CreateProductPage createProd = new CreateProductPage(driver);
//		createProd.createProduct(ProName);
//
//		
//		ValidatationProductPage validate = new ValidatationProductPage(driver);
//		validate.prdValidate(ProName);
//		
//	}

}
