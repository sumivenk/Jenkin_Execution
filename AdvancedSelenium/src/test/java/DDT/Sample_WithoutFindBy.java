package DDT;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pom_Repo.Login_Page_withoutFindBy;
import Pom_Repo.Login_page1;

public class Sample_WithoutFindBy {
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Without FindElement
//		Login_Page_withoutFindBy login = new Login_Page_withoutFindBy(driver);
//		login.enterUserName("admin");
//		login.enterPassword("admin");
//		login.clickSubmit();
		
		//With FindElement
		
		Login_page1 login = new Login_page1(driver);
		login.loginToApp("admin", "admin");
		
	}

}
