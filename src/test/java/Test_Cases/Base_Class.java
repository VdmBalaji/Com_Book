package Test_Cases;

import java.io.File;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import Utilities.helper;

public class Base_Class {
	
	public static WebDriver driver;
	
	Properties pr = new Properties();
	
	@Parameters ("browser")
	
	@BeforeMethod (alwaysRun=true)
	public void All_browser(String browser ) throws InterruptedException, IOException
	{
		if (browser.equalsIgnoreCase("chrome"))
		{
			
			driver = new ChromeDriver();
			
			
		}
		else if (browser.equalsIgnoreCase("Firefox"))
		{
			/*FirefoxOptions headless = new FirefoxOptions();
			headless.addArguments("--headless");
			driver = new FirefoxDriver(headless);*/
			driver = new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("Edge"))
		{
			/*EdgeOptions headless = new EdgeOptions()
			headless.addArguments("--headless");*/		
			driver = new EdgeDriver();
		}
		else 
		{
			driver = null;
		}
	  
		//\\src\test\java\Utilities\Links
		String filename = File.separator +"src"+ File.separator+ "test"+ File.separator +"java"+
				File.separator +"Utilities" + File.separator + "Links";
		String location = System.getProperty("user.dir");
	
		
		FileInputStream file_path  =  new FileInputStream(location + File.separator + filename);
		
		
		pr.load(file_path);
		
		driver.manage().deleteAllCookies();
		
		//driver.get("https://www.booking.com/");
		driver.get(pr.getProperty("URL"));
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.manage().window().maximize();
		
		helper.call.Quick_wait();
		
		//button[@aria-label='Dismiss sign-in info.']
		
		try {
			
		WebDriverWait stay = new WebDriverWait(driver, Duration.ofSeconds(15));
		stay.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Dismiss sign-in info.']")));
		WebElement popup = driver.findElement(By.xpath("//button[@aria-label='Dismiss sign-in info.']"));
		popup.click();
		
		} catch (Exception Error )
		{
			System.out.print("There is no such element");
		}
		
		//driver.navigate().refresh();
		helper.call.Quick_wait();
	}
	
	@AfterMethod (alwaysRun=true)
	public void quit()
	{
		driver.close();
	}
		
		
		
				
				
	
	
	

}
