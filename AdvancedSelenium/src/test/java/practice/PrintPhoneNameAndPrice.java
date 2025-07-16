package practice;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrintPhoneNameAndPrice {
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.name("q")).sendKeys("Iphone");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		List<WebElement> allName = driver.findElements(By.xpath("//div[@class='KzDlHZ']"));
		List<WebElement> allPrice = driver.findElements(By.xpath("//div[@class='Nx9bqj _4b5DiR']"));
		
		int size = allName.size();
		for(int i = 0; i < size ; i++ )
		{
			String name = allName.get(i).getText();
			String price = allPrice.get(i).getText();
			System.out.println(name+"     "+price);
			
		}
		
		
	}

}
