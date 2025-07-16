package Pom_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Login_Page {
	
	//Element Initialization
	public Login_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//Element Declaration
	@FindBy(name="user_name")
	private WebElement userNameTextField;
	
	@FindBy(name = "user_password")
	private WebElement passwordTextField;
	
	@FindBy(id = "submitButton")
	private WebElement loginButton;

	//Getter Method
	public WebElement getUserNameTextField() {
		return userNameTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	/**
	 * Businusses Logic. This medthod is used to login to Webpage
	 * @param userName
	 * @param password
	 */
	public void loginToApp(String userName, String password)
	{
		userNameTextField.sendKeys(userName);
		passwordTextField.sendKeys(password);
		loginButton.click();
		
	}
	
	

}
