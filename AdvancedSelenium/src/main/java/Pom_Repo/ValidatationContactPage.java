package Pom_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ValidatationContactPage {
	
	public ValidatationContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "dtlview_First Name")
	private WebElement firstNameTxt;
	
	@FindBy(id = "dtlview_Last Name")
	private WebElement latNameTxt;

	public WebElement getActFirstNameTxt() {
		return firstNameTxt;
	}

	public WebElement getActLatNameTxt() {
		return latNameTxt;
	}
	
	public void validateContactCreation(String expFirstName, String expLastName)
	{
		String actFirstNameTxt = firstNameTxt.getText();
		String actLatNameTxt = latNameTxt.getText();
		
//		if(actFirstNameTxt.contains(expFirstName) && actLatNameTxt.contains(expLastName))
//		{
//			System.out.println("Contact Cretaed Successfully!!");
//		}
//		else
//		{
//			System.out.println("Contact Not Cretaed");
//		}
		
		System.out.println("Act First naame: "+actFirstNameTxt);
		System.out.println("Exp First naame: "+expFirstName);
		System.out.println("Act Last naame: "+actLatNameTxt);
		System.out.println("Exp Last naame: "+expLastName);
		Assert.assertEquals(actFirstNameTxt, expFirstName,"Contact First name not cretaed");
		System.out.println("Contact First name cretaed Successfully");
		Assert.assertEquals(actLatNameTxt, expLastName,"Contact Last name not cretaed");
		System.out.println("Contact Last name cretaed Successfully");
		
	}

}
