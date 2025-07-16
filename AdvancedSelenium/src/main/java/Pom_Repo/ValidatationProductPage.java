package Pom_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ValidatationProductPage {
	
	public ValidatationProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "dtlview_Product Name")
	private WebElement productName;

	public WebElement getActProductName() {
		return productName;
	}
	
	public void prdValidate(String EXPPRODUCTNAME)
	{
		String actProductName = productName.getText();
		
//		if(actProductName.contains(EXPPRODUCTNAME))
//		{
//			System.out.println("Product created successfully!!");			
//		}
//		else
//		{
//			System.out.println("Product not created. Try again!!");
//		}
		Assert.assertEquals(actProductName, EXPPRODUCTNAME,"Product name not created");
		System.out.println("Product name created");
		
	}

}
