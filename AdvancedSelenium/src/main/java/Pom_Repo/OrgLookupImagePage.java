package Pom_Repo;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgLookupImagePage {
	
	public OrgLookupImagePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createOrgBtn;

	public WebElement getCreateOrgBtn() {
		return createOrgBtn;
	}
	
	public void clickOnCreateOrg()
	{
		createOrgBtn.click();
	}

}
