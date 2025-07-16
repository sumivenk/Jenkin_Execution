package campaigns;

import java.awt.Desktop.Action;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

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
import org.testng.annotations.Test;

import Generic_Utilities.Base;
import Generic_Utilities.Excel_Utlities;
import Generic_Utilities.File_Utilities;
import Generic_Utilities.Java_Utilities;
import Generic_Utilities.WebDriver_Utility;
import Pom_Repo.CampLookupImagePage;
import Pom_Repo.ContactLookUpPage;
import Pom_Repo.CreateContactPage;
import Pom_Repo.CreatecampaignPage;
import Pom_Repo.HomePage;
import Pom_Repo.Login_Page;
import Pom_Repo.ValidatationCampaignPage;
import Pom_Repo.ValidatationContactPage;


//@Test(groups = "smokeTest")
@Test

public class CreateCampaignTest extends Base{
	public void createCampaignTest() throws Throwable {
	//I am pulling Pull1
		//Push back
		//Pull2
		
//		Login to vtiger application->mouseOverOn more Link->click on campaigns->click on create campaign lookup image->Enter campaignName->
//		click on save Btn->verify whether the campaign is created in campaign Information page and Logout from the application. 
		
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
		
		WebElement more = driver.findElement(By.linkText("More"));
//		Actions act = new Actions(driver);
//		act.moveToElement(more).perform();
		
		wLib.movingToElement(driver, more);
		
//		driver.findElement(By.name("Campaigns")).click();
		HomePage home = new HomePage(driver);
		home.clickOnCampaign();
		CampLookupImagePage CampLookUp = new CampLookupImagePage(driver);
		CampLookUp.clickOncreateCampaign();
		
//		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		Java_Utilities jLib = new Java_Utilities();
		int random = jLib.getRandomNum();
		
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
		
		Excel_Utlities excelLib = new Excel_Utlities();
		String campaignName = excelLib.getExceldata("campaign", 0, 0)+random;
		System.out.println(campaignName);
		

//		driver.findElement(By.name("campaignname")).sendKeys(campaignName);
//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();	
		
		CreatecampaignPage createCamp = new CreatecampaignPage(driver);
		createCamp.createCampaign(campaignName);
		
//		String actCampaignName = driver.findElement(By.xpath("//span[@id ='dtlview_Campaign Name']")).getText();
//		
//		if(actCampaignName.equals(campaignName))
//		{
//			System.out.println("Campaign created successfully");
//		}
//		else
//		{
//			System.out.println("Campaign not created");
//		}
		
		ValidatationCampaignPage validatecamp = new ValidatationCampaignPage(driver);
		validatecamp.validateCampaignCreation(campaignName);
		
//		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//		driver.findElement(By.linkText("Sign Out")).click();
		
//		home.logoutApp();
		
		
	}
	
//-------------------------------------------------------------------------------------------------------------------------
//		@Test
//		public void createContactTest() throws Throwable {
//			
//			File_Utilities fLib = new File_Utilities();
//		
//			WebDriver_Utility wLib = new WebDriver_Utility();
//			
//			HomePage home = new HomePage(driver);
//			home.clickOnContact();
//			
//			ContactLookUpPage contactLookup = new ContactLookUpPage(driver);
//			contactLookup.clickOnCreateContact();
//			
//			Excel_Utlities excelLib = new Excel_Utlities();
//			String firstName = excelLib.getExceldata("contact", 0, 0);
//			String lastName = excelLib.getExceldata("contact", 0, 1);
//			
//			CreateContactPage createContact = new CreateContactPage(driver);
//			createContact.createContact(firstName, lastName);
//			
//			ValidatationContactPage validatation = new ValidatationContactPage(driver);
//			validatation.validateContactCreation(firstName, lastName);
//	
//			
//		}
}
