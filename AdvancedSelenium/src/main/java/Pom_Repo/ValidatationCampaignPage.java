package Pom_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ValidatationCampaignPage {
	
	public ValidatationCampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//span[@id ='dtlview_Campaign Name']")
	private WebElement actCampaginName;

	public WebElement getActCampaginName() {
		return actCampaginName;
	}
	
	public void validateCampaignCreation(String expCampaignName)
	{
		String ACTCAMPNAME = actCampaginName.getText();
//		if(ACTCAMPNAME.equals(expCampaignName))
//		{
//			System.out.println("Campaign created successfully");
//		}
//		else
//		{
//			System.out.println("Campaign not created");
//		}
		
		System.out.println("Actual Camp Name: "+ACTCAMPNAME);
		System.out.println("Expected Camp Name: "+expCampaignName);
		
		Assert.assertEquals(ACTCAMPNAME, expCampaignName,"Campaign not created");
		System.out.println("Campaign created successfully");
		
	}

}
