package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locator {
	
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.name("q")).sendKeys("iphone");
		driver.findElement(By.linkText("iphone")).click();
		List<WebElement> allPrice = driver.findElements(By.xpath("//div[@class='Nx9bqj _4b5DiR']"));
		
		for(WebElement price:allPrice)
		{
			String actPrice = price.getText();
			String expPrice = actPrice.replace("₹","").replace(",", "");
			int price1 = Integer.parseInt(expPrice);
			
			if(price1>70000)
			{
				System.out.println(price1);
			}
		}
	}

}
