package DDT;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FetchingJsonDetails {
	
	public static void main(String[] args) throws Throwable {
		File file = new File("./src/test/resources/JsonTestData.json"); 
		ObjectMapper obj = new ObjectMapper();
		JsonNode data = obj.readTree(file);
		
		String browser = data.get("browser").asText();
		String url = data.get("url").asText();
		
		WebDriver driver;
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		else
		{
			driver = new FirefoxDriver();
		}
		
		driver.get(url);
		
	}

}
