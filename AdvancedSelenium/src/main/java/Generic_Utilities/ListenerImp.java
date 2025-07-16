package Generic_Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImp implements ITestListener{
	
	//Right click in source we will add option to override method
	public void onTestFailure(ITestResult result)
	{
	TakesScreenshot ts = (TakesScreenshot)Base.sdriver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	File dest = new File("./FailedScript.png");
	
	try {
		FileUtils.copyFile(src, dest);
	} 
	catch (IOException e) {
		e.printStackTrace();
	}
	
	}

}
