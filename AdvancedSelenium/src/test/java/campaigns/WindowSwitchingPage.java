package campaigns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WindowSwitchingPage {
	
	public WindowSwitchingPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@title='Select']")
	private WebElement addProductBtn;
	
	@FindBy(id = "search_txt")
	private WebElement productNameTxtArea;
	
	@FindBy(name = "search")
	private WebElement searchBtn;

	public WebElement getProductNameTxtArea() {
		return productNameTxtArea;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getAddProductBtn() {
		return addProductBtn;
	}
	
	public void clickPrdLukImageIncanpaign()
	{
		addProductBtn.click();
	}
	
	public void enterProductDetail(String PRODUCTNAME)
	{
		productNameTxtArea.sendKeys(PRODUCTNAME);
		searchBtn.click();
	}
	
	public void enterProductNameInCamp(String PRODUCTNAME, WebDriver driver)
	{
		driver.findElement(By.xpath("//a[text()='"+PRODUCTNAME+"']")).click();
		
	}

}
