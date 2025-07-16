package Pom_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactLookUpPage {
	
	public ContactLookUpPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "[alt=\"Create Contact...\"]")
	private WebElement createContactBtn;
	
	public WebElement getCreateContactBtn() {
		return createContactBtn;
	}

	public void clickOnCreateContact()
	{
		createContactBtn.click();
	}

}
