package Test_Listener;



import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;


import Test_Cases.Base_Class;
import Utilities.ExtentReport;


public class ListenHere extends Base_Class implements ITestListener {

	

	public static ExtentReports extent;
	public static ExtentTest Create;
	
	
	

	@Override
	public void onStart(ITestContext context) 
	{
		
		
		extent = ExtentReport.GenerateReport();
		
		
		String OS =context.getCurrentXmlTest().getParameter("OS");
		extent.setSystemInfo("Operating System",OS);
		
		String Browser =context.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser",Browser);
		
		
	}
	
	/*public void onStart(ITestContext context , String browser) 
	{
		Execute = ExtentReport.GenerateReport(browser);
	}*/
	
	
	@Override
	public void onTestStart(ITestResult result) 
	{
		 String title =result.getName();
		
		 Create = extent.createTest(title);
		 
		 Create.log(Status.INFO, "TEST STARTED:  " +title);
		 
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result)
	{
		String title = result.getName();
		
		Create.log(Status.PASS, "TEST PASSED:  " + title );
		
		TakesScreenshot ss = (TakesScreenshot) driver;
		String Image=ss.getScreenshotAs(OutputType.BASE64);
		
		Create.addScreenCaptureFromBase64String(Image);
	
		 
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		String title =result.getName();
		
		System.out.print(title);
		
		
		
		Create.log(Status.FAIL,"TEST FAILED:  " +title);
		
		
        Throwable title2 =result.getThrowable ();
		
		//Create.log(Status.FAIL ,title2 +" Error" );
		
		Create.log(Status.WARNING ,"THROWABLE ERROR:  " +title2 );
		
		TakesScreenshot ss = (TakesScreenshot) driver;
		String Image=ss.getScreenshotAs(OutputType.BASE64);
		
		Create.addScreenCaptureFromBase64String(Image);
		
		
	
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		String title =result.getName();
		Create.log(Status.SKIP, "TEST SKIPPED:  " +title);
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		String title =context.getName();
		Create.log(Status.INFO , "Test is completed");
		extent.flush();
		
	}
	
}
