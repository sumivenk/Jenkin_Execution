package Pom_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ValidatationOrgPage {
	
	public ValidatationOrgPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "dtlview_Organization Name")
	private WebElement actOrgNameTxt;

	public WebElement getActOrgNameTxt() {
		return actOrgNameTxt;
	}
	
	public void orgCreteationValidatation(String expOrgName)
	{
		String actOrgName = actOrgNameTxt.getText();
		
//		if(actOrgName.contains(expOrgName))
//		{
//			System.out.println("Organization name created");
//		}
//		else
//		{
//			System.out.println("Organization name not created");
//		}
		
		Assert.assertEquals(actOrgName, expOrgName,"Organization name not created");
		System.out.println("Organization name created");
		
	}

}
