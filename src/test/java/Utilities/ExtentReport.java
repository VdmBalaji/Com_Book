package Utilities;

import java.io.File;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.TestListenerAdapter;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport  extends TestListenerAdapter {

	
	
	
	public static ExtentReports GenerateReport()
	{
		//String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String timestamp = new SimpleDateFormat("yyyy.MM.dd").format(new Date());
		String timestamp2 = new SimpleDateFormat("HH.mm.ss").format(new Date());
		String Actual_name = "Test Report-" +" Date-" +timestamp+ " Time-"+timestamp2 +".html";
		
		String user_direc = System.getProperty("user.dir");
		String path = File.separator+"ER" +File.separator+ Actual_name;
		String final_path = user_direc+path;
	
	
	File filename = new File(final_path);
	
	ExtentSparkReporter ext=new ExtentSparkReporter(filename);
	ext.config().setDocumentTitle("Booking.com");
	
	ext.config().setReportName("Auto test");
	
	ext.config().setTheme(Theme.DARK);
	
	ext.config().setReportName("Testing Report 2024");
	
	//ext.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
	ExtentReports extent = new ExtentReports();
	
	extent = new ExtentReports();
	extent.attachReporter(ext);
	extent.setSystemInfo("Application URL","https://www.booking.com/");

	extent.setSystemInfo("User","Balaji");
	extent.setSystemInfo("Environment","Live");
	
      
		
	return extent;
	
	}
	
}
