package Pom_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {
	
	public CreateProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "productname")
	private WebElement productNameTextarea;
	
	@FindBy(xpath = "//input[@name='button' and @title = 'Save [Alt+S]']")
	private WebElement saveBtn;

	public WebElement getProductNAmeTextarea() {
		return productNameTextarea;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	/**
	 * This method is used to create the product
	 * @param PRODUCTNAME
	 */
	
	public void createProduct(String PRODUCTNAME)
	{
		productNameTextarea.sendKeys(PRODUCTNAME);
		saveBtn.click();
	}

}
