package Pom_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login_Page_withoutFindBy {
	
	private WebDriver driver;
	
	//Constructor
	public Login_Page_withoutFindBy(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//Locator
	private By userNameTxt = By.name("user_name");
	private By passwordTxt = By.name("user_password");
	private By submitBtn = By.id("submitButton");
	
	//Methods to interact with Elements
	
	public void enterUserName(String username)
	{
		WebElement userInput = driver.findElement(userNameTxt);
		userInput.sendKeys(username);
	}
	
	public void enterPassword(String password)
	{
		WebElement userPassword = driver.findElement(passwordTxt);
		userPassword.sendKeys(password);
	}
	
	public void clickSubmit()
	{
		WebElement submit = driver.findElement(submitBtn);
		submit.click();
	}
	
	public void loginToWebpage(String username, String password)
	{
		enterUserName(username);
		enterPassword(password);
		clickSubmit();
	}
	
	
}
