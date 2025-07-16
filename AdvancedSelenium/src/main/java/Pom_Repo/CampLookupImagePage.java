package Pom_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampLookupImagePage {
	
	public CampLookupImagePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createCampBtn;

	public WebElement getCreateCampBtn() {
		return createCampBtn;
	}
	
	/**
	 * This method is launch the create Campaign page
	 */
	public void clickOncreateCampaign()
	{
		createCampBtn.click();
	}


}
