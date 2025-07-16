package Pom_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrgPage {
	
	public CreateOrgPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "accountname")
	private WebElement orgNameTxt;
	
	@FindBy(id = "phone")
	private WebElement phoneNumTxt;
	
	@FindBy(id = "email1")
	private WebElement emailTxt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getOrgName() {
		return orgNameTxt;
	}

	public WebElement getPhoneNum() {
		return phoneNumTxt;
	}

	public WebElement getEmail() {
		return emailTxt;
	}
	
	
	public void createOrg(String ORGNAME, String PHONENUM, String MAILID)
	{
		orgNameTxt.sendKeys(ORGNAME);
		phoneNumTxt.sendKeys(PHONENUM);
		emailTxt.sendKeys(MAILID);
		saveBtn.click();
	}
	

}
