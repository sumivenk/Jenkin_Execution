package Pom_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductLookUpPage {
	
	public ProductLookUpPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@alt='Create Product...']")
	private WebElement createProductBtn;
	
	@FindBy(xpath = "//input[@value='Delete']")
	private WebElement deleteProductBtn;

	public WebElement getCreateProductBtn() {
		return createProductBtn;
	}
	
	public WebElement getDeleteProductBtn() {
		return deleteProductBtn;
	}
	
	/**
	 * This Method is used to Launch create Product PAge
	 */
	
	public void clickOncreateProduct()
	{
		createProductBtn.click();
	}
	
	/**
	 * This MEthod is to Delete the Product
	 * @param driver
	 * @param productName
	 */
	
	public void deleteProduct(WebDriver driver, String productName)
	{
		driver.findElement(By.xpath("//table[@class='lvt small']//a[text()='"+productName+"']/../preceding-sibling::td[2]//input[@type=\"checkbox\"]")).click();
		deleteProductBtn.click();
	}


}
