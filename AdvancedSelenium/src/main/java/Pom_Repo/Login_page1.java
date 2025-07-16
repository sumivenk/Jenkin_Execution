package Pom_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class Login_page1 {
	
	public Login_page1(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "user_name")
	private WebElement userNameTxt;
	
	@FindAll({@FindBy(xpath = "//input[@type='password']"), @FindBy(name = "user_password")})
	private WebElement passwordTxt;
	
	@FindAll({@FindBy(id = "submitButton"), @FindBy(xpath="//input[@value='Login']")})
	private WebElement submitBtn; 
	
	public void loginToApp(String username, String password)
	{
		userNameTxt.sendKeys(username);
		passwordTxt.sendKeys(password);
		submitBtn.click();
		
	}

}
