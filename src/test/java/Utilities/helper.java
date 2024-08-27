package Utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Test_Cases.Base_Class;

public class helper extends Base_Class {
	
	
	public static helper call = new helper();
	
	public static void Quick_wait () throws InterruptedException
	{
	  Thread.sleep(3000);
	}
	
	
	public static void move(WebElement name) throws InterruptedException
	{
	  Actions act = new Actions(driver);
	  act.moveToElement(name).build().perform();
	}
	
	public static void highlighter(WebDriver driver , WebElement dynamic )

	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background:red; border: 1px solid red;');", dynamic);
	}
	// List of few others colurs 
    /* Honeydew: rgba(240, 255, 240, 0.5)
     LightSteelBlue: rgba(176, 196, 222, 0.5)
     Sky Blue: rgba(135, 206, 235, 0.5)
      MediumVioletRed: rgba(199, 21, 133, 0.5)
      HotPink: rgba(255, 105, 180, 0.5)
      Tomato: rgba(255, 99, 71, 0.5)
      DarkMagenta: rgba(139, 0, 139, 0.5)
     */

	
	public String [] Cname()
	{
		String []Currency_name = {"NZD" , "NOK", "PLN", "GBP" 
				,"SGD", "INR" , "AUD" };
		
		return Currency_name;
	}
	
	public  String [] langu()
	{
		
		String [] b = {"Nederlands", "Français", "Español (MX)", "English (UK)"};
		return b;
		
	}
	
}
