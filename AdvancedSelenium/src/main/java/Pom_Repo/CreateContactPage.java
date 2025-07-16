package Pom_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utilities.WebDriver_Utility;

public class CreateContactPage {
	
	public CreateContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//select[@name='salutationtype']")
	private WebElement salutationDropdown;
	
	@FindBy(name = "firstname")
	private WebElement firstElementTxt;
	
	@FindBy(name = "lastname")
	private WebElement lastNameTxt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	public WebElement getFirstElementTxt() {
		return firstElementTxt;
	}

	public WebElement getLastNameTxt() {
		return lastNameTxt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void createContact(String FIRSTNAME, String LASTNAME)
	{
		WebDriver_Utility wLib = new WebDriver_Utility();
		wLib.selectElement(salutationDropdown, "Mr.");
		firstElementTxt.sendKeys(FIRSTNAME);
		lastNameTxt.sendKeys(LASTNAME);
		saveBtn.click();
	}

}
