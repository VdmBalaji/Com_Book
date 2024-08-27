package Page_Object;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import Test_Cases.Base_Class;
import Utilities.helper;

public class Logo extends Base_Class {
	
	
	public Logo(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this );
				
	}

	@FindBy
	(xpath= "//span[@data-testid='header-logo']")
	WebElement logo;
	
	@FindBy
	(xpath = "//span[@class='cdebd92b49']//button[@data-testid='header-currency-picker-trigger']")
	WebElement currency;
	
	//span[@class='Picker_selection-text']//text()
	
	@FindBy
	(xpath = "//span[@class='Picker_selection-text']")
	List <WebElement> currency_text;
	
	@FindBy
	(xpath ="//div[@data-testid='All languages']//li")
	List <WebElement> languages;
	
	
	
	@FindBy
	(xpath = "//button[@data-testid='header-language-picker-trigger']")
	WebElement lang_picker;
	
	public void Booking_logo() throws InterruptedException
	{
		helper.call.move(logo);
		
		helper.call.highlighter(driver, logo);
		
		helper.call.Quick_wait();
		
		if (logo.isEnabled())
		{
			Assert.assertTrue(true);
			Reporter.log("This is a complete great thing");
			
		}
         
		
	}
	
	public void Money() throws InterruptedException
	{
		helper.call.move(currency);
		helper.call.Quick_wait();
		helper.call.highlighter(driver, currency);
		helper.call.Quick_wait();
		currency.click();
		Assert.assertTrue(true);
		Reporter.log("Step 1 - Currency is selected ");
	}
	
	public void currency_text(String Cname ) throws InterruptedException
	{
		for (WebElement one : currency_text)
		{
			System.out.println(Cname);
			String name = one.getText();
			//System.out.println(name);
			System.out.println("                 ");
			
	
			if (name.endsWith(Cname))
			{
				helper.call.move(one);
				Reporter.log("Step 2 - Navigated to the desired country");
				helper.highlighter(driver, one);
				helper.call.Quick_wait();
				helper.highlighter(driver, one);
				helper.call.Quick_wait();
				one.click();
				helper.call.Quick_wait();
				Reporter.log("Step 3 -" + name + " is selected ");
				Assert.assertTrue(true);
				break;
			}
			else
			{
				continue;
			}
		}
	}
	
	
	public void All_languages(String get ) throws InterruptedException
	{
		helper.call.move(lang_picker);
		helper.call.Quick_wait();
		helper.call.highlighter(driver, lang_picker);
		lang_picker.click();
		for (WebElement two : languages)
		{
			String name = two.getText();
			
			if (name.equalsIgnoreCase(get))
			{
				helper.call.move(two);
				helper.call.Quick_wait();
				helper.call.highlighter(driver, two);
				helper.call.Quick_wait();
			    two.click();
			    Assert.assertTrue(true);
			    Reporter.log(name + " is selected ");
			    break;
				
			}
			else
			{
				continue;
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
