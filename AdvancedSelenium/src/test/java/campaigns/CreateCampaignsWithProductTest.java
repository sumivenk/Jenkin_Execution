package campaigns;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Utilities.Base;
import Generic_Utilities.Excel_Utlities;
import Generic_Utilities.File_Utilities;
import Generic_Utilities.Java_Utilities;
import Generic_Utilities.WebDriver_Utility;
import Pom_Repo.CampLookupImagePage;
import Pom_Repo.CreateProductPage;
import Pom_Repo.CreatecampaignPage;
import Pom_Repo.HomePage;
import Pom_Repo.ProductLookUpPage;
import Pom_Repo.ValidatationCampaignPage;




//@Listeners(Generic_Utilities.ExtentReportImp.class)
public class CreateCampaignsWithProductTest extends Base{
	@Test
	public void createCampaignsWithProductTest() throws Throwable {
		
//Login to vtiger application->mouseOverOn more Link->click on campaigns->click on create campaign lookup image->Enter campaignName->Click on Product plus img->
//Handle the PopUp->Product name should be added to campaign createpage->click on save Btn->
//verify whether the campaign name is created in campaign Information page and Logout from the application. 
		
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
//		login.loginToApp(USERNAME,PASSWORD);
//		login.getUserNameTextField().sendKeys(USERNAME);
//		login.getPasswordTextField().sendKeys(PASSWORD);
//		login.getLoginButton().click();
		
		//To avoid Duplicate
//		Random rannum = new Random();
//		int random = rannum.nextInt(1000);
		
		Java_Utilities jLib = new Java_Utilities();
		int random = jLib.getRandomNum();
		
		//Add Product
//		FileInputStream fes = new FileInputStream("./src/test/resources/CommonData.xlsx");
//		
//		Workbook book1 = WorkbookFactory.create(fes);
//		
//		Sheet sheet1 = book1.getSheet("Product");
//		
//		Row row1 = sheet1.getRow(0);
//		 
//		Cell cell1 = row1.getCell(0);
//		
//		String productName = cell1.getStringCellValue()+random;
		
		Excel_Utlities excelLib = new Excel_Utlities();
		String productName = excelLib.getExceldata("Product", 0, 0)+random;
		System.out.println(productName);
			
//		driver.findElement(By.linkText("Products")).click();
		
		HomePage home = new HomePage(driver);
		home.clickOnProduct();
		
//		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		
		ProductLookUpPage productLookup = new ProductLookUpPage(driver);
		productLookup.clickOncreateProduct();
		
//		driver.findElement(By.name("productname")).sendKeys(productName);
//		driver.findElement(By.xpath("//input[@name='button' and @title = 'Save [Alt+S]']")).click();
		
		CreateProductPage createPRoduct = new CreateProductPage(driver);
		createPRoduct.createProduct(productName);
		
		WebElement more = driver.findElement(By.linkText("More"));
//		Actions act = new Actions(driver);
//		act.moveToElement(more).perform();
		
		wLib.movingToElement(driver, more);
		
//		driver.findElement(By.name("Campaigns")).click();
		home.clickOnCampaign();
		
//		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		CampLookupImagePage CampLookUp = new CampLookupImagePage(driver);
		CampLookUp.clickOncreateCampaign();
		
//		FileInputStream fisExcel = new FileInputStream("./src/test/resources/CommonData.xlsx");
//		
//		Workbook book = WorkbookFactory.create(fisExcel);
//		
//		Sheet sheet = book.getSheet("campaign");
//		
//		Row row = sheet.getRow(0);
//		 
//		Cell cell = row.getCell(0);
//		
//		String campaignName = cell.getStringCellValue()+random;
		
		String campaignName = excelLib.getExceldata("campaign", 0, 0)+random;
		System.out.println(campaignName);
		

//		driver.findElement(By.name("campaignname")).sendKeys(campaignName);
		
		CreatecampaignPage createCamp = new CreatecampaignPage(driver);
		createCamp.enterCampaignName(campaignName);
		
//		driver.findElement(By.xpath("//img[@title='Select']")).click();
		
		WindowSwitchingPage winSwitch = new WindowSwitchingPage(driver);
		winSwitch.clickPrdLukImageIncanpaign();
		
		//Switching to new window
	
//		Set<String> allWin = driver.getWindowHandles();
//		Iterator<String> it = allWin.iterator();
//		
//		while(it.hasNext())
//		{
//			String win = it.next();
//			driver.switchTo().window(win);
//			String title = driver.getTitle();
//			if(title.contains("Products&action"))
//			{
//				break;
//			}
//		}
		
		wLib.windowSwitching(driver, "Products&action");
			
		//search and add product
				
//		driver.findElement(By.id("search_txt")).sendKeys(productName);
//		driver.findElement(By.name("search")).click();
		
		winSwitch.enterProductDetail(productName); 
		
		//Dynamic xpath
//		driver.findElement(By.xpath("//a[text()='"+productName+"']")).click();
		
		winSwitch.enterProductNameInCamp(productName, driver);
		
		//Driver control back to parent window
		Set<String> allWin1 = driver.getWindowHandles();
		Iterator<String> it1 = allWin1.iterator();
		
//		while(it1.hasNext())
//		{
//			String win1 = it1.next();
//			driver.switchTo().window(win1);
//			String title1 = driver.getTitle();
//			if(title1.contains("Campaigns&action"))
//			{
//				break;
//			}
//		}
		
		wLib.windowSwitching(driver, "Campaigns&action");
		
//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		createCamp.clickSaveBtn();
		
//		String actCampaignName = driver.findElement(By.xpath("//span[@id ='dtlview_Campaign Name']")).getText();
//		
//		if(actCampaignName.contains(campaignName))
//		{
//			System.out.println("Campaign created successfully");
//		}
//		else
//		{
//			System.out.println("Campaign not created");
//		}
		
		ValidatationCampaignPage validateCamp = new ValidatationCampaignPage(driver);
		validateCamp.validateCampaignCreation(campaignName);
				
//		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//		driver.findElement(By.linkText("Sign Out")).click();
		
//		home.logoutApp();
		
	}

}
