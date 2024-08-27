package Utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Test_Cases.Base_Class;

public class Customized_report extends Base_Class implements ITestListener

{
	
	public static ExtentSparkReporter spark;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public void onStart(ITestContext context)
	{
		
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String Actual_name = "Test Report" +timestamp+ ".html";
		
		String user_direc = System.getProperty("user.dir");
		String path = File.separator+"Extent_Reports" +File.separator+ Actual_name;
		
		String final_path = user_direc+path;
		
		spark = new ExtentSparkReporter(final_path);
		
		spark.config().setDocumentTitle("Booking.com");
		
		spark.config().setReportName("Auto test");
		spark.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(spark);
		extent.setSystemInfo("Application URL","https://www.booking.com/");
	
		extent.setSystemInfo("User","Balaji");
		extent.setSystemInfo("Environment","Live");
		
		String OS =context.getCurrentXmlTest().getParameter("OS");
		extent.setSystemInfo("Operating System",OS);
		
		String Browser =context.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser",Browser);
	

		
		/*List <String> Groups = context.getCurrentXmlTest().getIncludedGroups();
		if(!Groups.isEmpty())
		{
			extent.setSystemInfo("Group All",Groups.toString());
		}*/
		
	  }
	
	public void onTestSuccess(ITestResult result)
	  {
	   // String overall = result.getTestClass().getName();
	    String name = result.getName();
	    test = extent.createTest(name);
	    test.log(Status.PASS, "Test Passed: " +name);
	    
	    TakesScreenshot take = (TakesScreenshot)driver;
	    String image_Pass=take.getScreenshotAs(OutputType.BASE64);
	    test.addScreenCaptureFromBase64String(image_Pass);
	    
	  }
	
	public void onTestFailure(ITestResult result) 
	{
		    //String overall = result.getTestClass().getName();
		    String name = result.getName();
		    test = extent.createTest(name);
		    test.log(Status.FAIL, "Test Failed: " +name);
		    
		    String error = result.getThrowable().getMessage();
		    
		    test.log(Status.INFO,"Failed Message:" + error );
		    
		   TakesScreenshot take = (TakesScreenshot)driver;
		    String image_Pass=take.getScreenshotAs(OutputType.BASE64);
		    test.addScreenCaptureFromBase64String(image_Pass);
	  }
	
	public void onTestSkipped(ITestResult result) {
		
		String title =result.getName();
		String error = result.getThrowable().getMessage();
		test.log(Status.SKIP, "Test Skipped:  " +title);
		test.log(Status.INFO,"Skip Message:" + error );
	  
	  }
	
	public void onFinish(ITestContext context) 
	{
		String title =context.getName();
		test.log(Status.INFO , "Test is completed");
		
		extent.flush();
		
		  }
	  

}

