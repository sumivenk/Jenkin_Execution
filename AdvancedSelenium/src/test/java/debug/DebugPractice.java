package debug;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import debugPractice.Methods;

public class DebugPractice {
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		
		Methods data = new Methods();
		data.maximize(driver);
		data.wait(driver);
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Mobiles");
		driver.findElement(By.id("nav-search-submit-button")).click();
		
	}

}
