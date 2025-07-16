package Generic_Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import Pom_Repo.HomePage;
import Pom_Repo.Login_Page;

public class Base {
	
	public WebDriver driver;
	static WebDriver sdriver;
	
	@BeforeSuite(groups = {"smokeTest","regressionTest"})
	public void BS()
	{
		System.out.println("Database Connection");
	}
	
	@BeforeTest(groups = {"smokeTest","regressionTest"})
	public void BT()
	{
		System.out.println("Execution Starts");
	}
	
//	@Parameters("BROWSER")
	@BeforeClass(groups = {"smokeTest","regressionTest"})
//	public void BC(String BROWSER) throws Throwable
//	{
	public void BC() throws Throwable
	{
		System.out.println("Launch the Browser");
		
		//reading data from properties file
		File_Utilities fLib = new File_Utilities();
		String BROWSER = fLib.getKeyAndValue("Browser");
		
//		//Reading keys from cmd prompt
//		String BROWSER = System.getProperty("Browser");
		
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
			driver = new EdgeDriver();
		}
		sdriver = driver;
	}
	
//	@Parameters({"URL","USERNAME","PASSWORD"})
//	@BeforeMethod(groups = {"smokeTest","regressionTest"})
//	public void BM(String URL, String USERNAME, String PASSWORD) throws Throwable
//	{
	
	@BeforeMethod(groups = {"smokeTest","regressionTest"})
	public void BM() throws Throwable
	{
		System.out.println("Login To the Application");
		
		//reading data from properties file

		File_Utilities fLib = new File_Utilities();
		String URL = fLib.getKeyAndValue("Url");
		String USERNAME = fLib.getKeyAndValue("UserName");
		String PASSWORD = fLib.getKeyAndValue("Password");
		
		//Reading keys from cmd prompt
//		String URL = System.getProperty("url");
//		String USERNAME = System.getProperty("username");
//		String PASSWORD = System.getProperty("password");
		
		driver.get(URL);
		Login_Page login = new Login_Page(driver);
		login.loginToApp(USERNAME,PASSWORD);
		
		WebDriver_Utility wLib = new WebDriver_Utility();
		wLib.maximizeWindow(driver);
		wLib.waitElementsToLoad(driver);
	}
	
	@AfterMethod(groups = {"smokeTest","regressionTest"})
	public void AM()
	{
		HomePage home = new HomePage(driver);
		home.logoutApp();
		System.out.println("Logout from the Application");
	}
	
	@AfterClass(groups = {"smokeTest","regressionTest"})
	public void AC()
	{
		driver.close();
		System.out.println("Close the Browser");
	}
	
	@AfterTest(groups = {"smokeTest","regressionTest"})
	public void AT()
	{
		System.out.println("Execution close");
	}
	
	@AfterSuite(groups = {"smokeTest","regressionTest"})
	public void AS()
	{
		System.out.println("Close DataBase");
	}

}
