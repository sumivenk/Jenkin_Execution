package Generic_Utilities;

import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportImp implements ITestListener{
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		
		test=report.createTest(result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		test.log(Status.PASS, result.getMethod().getMethodName());
		test.log(Status.PASS, result.getThrowable());
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		test.log(Status.FAIL, result.getMethod().getMethodName());
		test.log(Status.FAIL, result.getThrowable());
		String screenShot = null;
		
		try {
			screenShot = WebDriver_Utility.takeScreenshotOnScriptFail(Base.sdriver, result.getMethod().getMethodName());
		} 
		catch (Throwable e) {
			e.printStackTrace();
		}
		
		test.addScreenCaptureFromPath(screenShot);
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		test.log(Status.SKIP, result.getMethod().getMethodName());
		test.log(Status.SKIP, result.getThrowable());
		
	}

	@Override
	public void onStart(ITestContext context) {
		String dateAndTime = new Date().toString().replace(" ", "_").replace(":", "_");
		ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReport/report.html"+dateAndTime);
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("VtigerReport");
		spark.config().setReportName("Janani");
		
		//System configure
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Platform", "Window");
		report.setSystemInfo("Executed by", "Sumitha");
		report.setSystemInfo("Reviewed By", "Sobha");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		report.flush();
		
	}

}
