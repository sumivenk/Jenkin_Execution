package Generic_Utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriver_Utility {
	
	/**
	 * This method is used to maximize the window
	 * @param driver
	 * @author Dilip Kumar
	 */
	
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This method is used to wait, load the the Elements in GUI
	 * @param driver
	 * @author Dilip Kumar
	 */
	
	public void waitElementsToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/**
	 * This method is used to switch the window
	 * @param driver
	 * @param partialTitle
	 * @author Dilip Kumar
	 */
	
	public void windowSwitching(WebDriver driver, String partialTitle)
	{
		Set<String> allWin1 = driver.getWindowHandles();
		Iterator<String> it1 = allWin1.iterator();
		
		while(it1.hasNext())
		{
			String win1 = it1.next();
			driver.switchTo().window(win1);
			String title1 = driver.getTitle();
			if(title1.contains(partialTitle))
			{
				break;
			}
		}
	}
	
	
	/**
	 * This method is used to move the curser to specific element
	 * @param driver
	 * @param element
	 * @author Dilip Kumar
	 */
	
	public void movingToElement(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * This MEthod is used to handle the Alert
	 * @param driver
	 * @author Dilip Kumar
	 */
	
	public void alertHandle(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	public void selectElement(WebElement element, String value)
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
		
	}
	
	public static String takeScreenshotOnScriptFail(WebDriver driver, String screenShotName) throws Throwable
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screenshots"+screenShotName+".png");
		FileUtils.copyFile(src, dest);
		return dest.getAbsolutePath();
		
	}
	

}
