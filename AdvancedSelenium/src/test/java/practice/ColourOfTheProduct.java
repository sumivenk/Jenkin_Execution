package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ColourOfTheProduct {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.com/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
		driver.findElement(By.id("nav-search-submit-button")).click();
		Thread.sleep(4000);
		List<WebElement> allColour = driver.findElements(By.xpath("//span[contains(text(),'Apple iPhone 14, 128GB, Midnight - Unlocked (Renewed)')]/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']//div[@class='a-section a-spacing-none a-spacing-top-mini s-color-swatch-container-list-view']/div/div//a"));
		
		
		for(WebElement colour: allColour)
		{
			System.out.println(colour.getAttribute("aria-label"));
		}
		
	}

}
