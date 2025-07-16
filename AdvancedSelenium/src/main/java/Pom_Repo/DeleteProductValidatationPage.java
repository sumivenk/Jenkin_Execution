package Pom_Repo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class DeleteProductValidatationPage {
	
	public DeleteProductValidatationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void validateProductDeleted(WebDriver driver, String PRODUCTNAME)
	{
		List<WebElement> prdData = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr//td[3])[position()>1]"));
		
		boolean flag=false;
		for (WebElement prd : prdData)
		{
			String actPrd = prd.getText();
			if(actPrd.contains(PRODUCTNAME))
			{
				flag=true;
				break;
			}
		}
		if(flag)
		{
			System.out.println("Product Name is Deleted");
		}
		else
		{
			System.out.println("Product Name is not Deleted");
		}			
	}

}
