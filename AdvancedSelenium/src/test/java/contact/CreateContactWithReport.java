package contact;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import Generic_Utilities.File_Utilities;
import Generic_Utilities.Java_Utilities;
import Generic_Utilities.WebDriver_Utility;
import Pom_Repo.Login_Page;

public class CreateContactWithReport {
	public static void main(String[] args) throws Throwable {
		
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
			driver = new EdgeDriver();
		}
		else
		{
			driver = new FirefoxDriver();
		}
		
		driver.get(URL);
		
		WebDriver_Utility wLib = new WebDriver_Utility();
		wLib.maximizeWindow(driver);
		wLib.waitElementsToLoad(driver);
		
		Login_Page login = new Login_Page(driver);
		login.getUserNameTextField().sendKeys(USERNAME);;
		login.getPasswordTextField().sendKeys(PASSWORD);;
		login.getLoginButton().click();
		
		WebElement more = driver.findElement(By.linkText("More"));
		wLib.movingToElement(driver, more);
		
		driver.findElement(By.name("Reports")).click();
		
		
	}
	
}
