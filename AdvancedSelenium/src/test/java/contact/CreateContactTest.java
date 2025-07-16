package contact;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Utilities.Base;
import Generic_Utilities.Excel_Utlities;
import Generic_Utilities.File_Utilities;
import Generic_Utilities.WebDriver_Utility;
import Pom_Repo.ContactLookUpPage;
import Pom_Repo.CreateContactPage;
import Pom_Repo.HomePage;
import Pom_Repo.Login_Page;
import Pom_Repo.ValidatationContactPage;

//@Listeners(Generic_Utilities.ListenerImp.class)
//@Listeners(Generic_Utilities.ExtentReportImp.class)
public class CreateContactTest extends Base{
//	@Test(groups = "regressionTest")
//	@Test(retryAnalyzer = Generic_Utilities.RetryAnalyzerImp.class)
	
	@Test
	public void createContactTest() throws Throwable {
		
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
		
//		driver.get(URL);
//		
		WebDriver_Utility wLib = new WebDriver_Utility();
//		wLib.maximizeWindow(driver);
//		wLib.waitElementsToLoad(driver);
//		
//		Login_Page login = new Login_Page(driver);
//		login.loginToApp(USERNAME, PASSWORD);
		
		HomePage home = new HomePage(driver);
		home.clickOnContact();
		
		ContactLookUpPage contactLookup = new ContactLookUpPage(driver);
		contactLookup.clickOnCreateContact();
		
		Excel_Utlities excelLib = new Excel_Utlities();
		String firstName = excelLib.getExceldata("contact", 0, 0);
		String lastName = excelLib.getExceldata("contact", 0, 1);
		
		CreateContactPage createContact = new CreateContactPage(driver);
		createContact.createContact(firstName, lastName);
		
//		Assert.fail("Manually failed for testing");
		
		ValidatationContactPage validatation = new ValidatationContactPage(driver);
		validatation.validateContactCreation(firstName, lastName);	
		
		
//		home.logoutApp();		
		
	}
	
	@Test
	public void m2()
	{
		System.out.println("For Executing particular method");
	}

}
