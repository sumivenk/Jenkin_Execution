package Pom_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatecampaignPage {
	public CreatecampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name = "campaignname")
	private WebElement campaignName;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	//Getter Methods
	public WebElement getCampaignName() {
		return campaignName;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}


	/**
	 * This Method is to create the campaign Name
	 * @param CAMPAIGNNAME
	 * @return
	 */
	public void createCampaign(String CAMPAIGNNAME)
	{
		campaignName.sendKeys(CAMPAIGNNAME);
		saveBtn.click();		
	}
	
	public void enterCampaignName(String CAMPAIGNNAME)
	{
		campaignName.sendKeys(CAMPAIGNNAME);
	}
	
	public void clickSaveBtn()
	{
		saveBtn.click();
	}

}
