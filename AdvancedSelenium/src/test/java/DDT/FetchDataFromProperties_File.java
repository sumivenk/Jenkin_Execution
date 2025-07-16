package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FetchDataFromProperties_File {
	public static void main(String[] args) throws Throwable {
		
		//Step 1: Connect to the Physical file path
		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.properties");
		
		//Step 2: Create the object for Properties File and load the data
		Properties pro = new Properties();
		pro.load(fis);
		
		//Step 3: Read the value using Get Property
		String BROWSER = pro.getProperty("Browser");
		String URL = pro.getProperty("Url");
		String USERNAME = pro.getProperty("UserName");
		String PASSWORD = pro.getProperty("Password");
		
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
			driver = new ChromeDriver();
		}
		
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
	}

}
