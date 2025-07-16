package Pom_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Organizations")
	private WebElement orgLink;
	
	@FindBy(linkText = "Products")
	private WebElement productLink;
	
	@FindBy(name = "Campaigns")
	private WebElement campaignsLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdminLink;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactLink;
	
	
	//Getter Method
	public WebElement getOrganizations() {
		return orgLink;
	}
	
	public WebElement getProduct() {
		return productLink;
	}
	
	public WebElement getCampaigns() {
		return campaignsLink;
	}
	
	//Businuss Libraries
	/**
	 * This Method is used to click Organization Link
	 */

	public void clickOnOrganization()
	{
		orgLink.click();
	}
	
	/**
	 * This Method is used to click On campaign
	 */
	
	public void clickOnCampaign()
	{
		campaignsLink.click();
	}
	
	/**
	 * This Method id used to click on Product
	 */

	public void clickOnProduct()
	{
		productLink.click();
	}
	
	public void clickOnContact()
	{
		contactLink.click();
	}
	
	public void logoutApp()
	{
		AdminLink.click();
		signOutLink.click();
	}

}
