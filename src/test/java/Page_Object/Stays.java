package Page_Object;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.aventstack.extentreports.Status;

import Test_Cases.Base_Class;
import Test_Listener.ListenHere;
import Utilities.helper;

public class Stays extends Base_Class {

	public Stays(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		PageFactory.initElements(driver, Logo.class);
	}

	@FindBy(xpath = "//input[@id=':rh:']")
	WebElement place;

	// ul[@role= 'group']//div[@class='ad3c4dc079 e2f45f66c9']

	@FindBy(xpath = "//ul[@role= 'group']//div[@class='ad3c4dc079 e2f45f66c9']")
	List<WebElement> List_Place;

	@FindBy(xpath = "//div[@data-testid='searchbox-dates-container']")
	WebElement Date;

	@FindBy(xpath = "//button[@aria-controls='flexible-searchboxdatepicker']")
	WebElement Flexible;

	@FindBy(xpath = "//button[@aria-controls='calendar-searchboxdatepicker']")
	WebElement Calender;

	@FindBy(xpath = "(//h3[@aria-live='polite'])[1]")
	WebElement get_month_1;

	@FindBy(xpath = "(//h3[@aria-live='polite'])[2]")
	WebElement get_month_2;

	public void place() throws InterruptedException {
		helper.call.highlighter(driver, place);
		helper.call.Quick_wait();
		place.clear();
		place.sendKeys("Cali");
		helper.call.Quick_wait();
		for (WebElement one : List_Place) {
			String actual_name = one.getText();
			System.out.println(actual_name);
			if (actual_name.startsWith("California")) {
				helper.call.highlighter(driver, one);
				helper.call.Quick_wait();
				one.click();
				Assert.assertTrue(true);
				helper.call.Quick_wait();
				ListenHere.Create.log(Status.INFO, "California IS SELECTED");
				break;
			}

		}
	}

	@FindBy(xpath = "(//table[@class='c0d46ba7c8'])[1]//span")
	List<WebElement> table_1;

	@FindBy(xpath = "(//table[@class='c0d46ba7c8'])[2]//span")
	List<WebElement> table_2;

	@FindBy(xpath = "//button[@aria-label='Next month']")
	WebElement arrow;

	public void Date() throws InterruptedException {
		helper.call.highlighter(driver, Date);
		helper.call.Quick_wait();
		Date.click();
		helper.call.Quick_wait();
		Date.click();
		Reporter.log("Date is selected ");
		Flexible.click();
		helper.call.Quick_wait();
		Calender.click();
		helper.call.Quick_wait();

		// March 2025
		while (true) {
			helper.call.highlighter(driver, get_month_1);
			String Month_1 = get_month_1.getText();
			System.out.println(Month_1);

			helper.call.highlighter(driver, get_month_2);
			String Month_2 = get_month_2.getText();
			System.out.println(Month_2);

			if (Month_1.equalsIgnoreCase("March 2025")) {
				for (WebElement M1 : table_1) {
					String d1 = M1.getText();

					if (d1.equals("23")) {
						helper.call.highlighter(driver, M1);
						helper.call.Quick_wait();
						M1.click();
						helper.call.Quick_wait();
						Assert.assertTrue(true);
						break;
					}
				}
				break;
			} 
			else if (Month_2.equalsIgnoreCase("March 2025")) 
			{
				for (WebElement M2 : table_2) 
				{
					System.out.println("else if -----------1");
					String d2 = M2.getText();
					if (d2.equals("20")) 
					{
						helper.call.highlighter(driver, M2);
						helper.call.Quick_wait();
						M2.click();
						helper.call.Quick_wait();
						Assert.assertTrue(true);
						break;
					}
				}
					
				for (WebElement M3 : table_2) 
				{
					System.out.println("else if -----------2");
					String d3 = M3.getText();
					if (d3.equals("23")) 
					{
						helper.call.highlighter(driver, M3);
						helper.call.Quick_wait();
						M3.click();
						helper.call.Quick_wait();
						Assert.assertTrue(true);
						break;	
					}
				}	
					
				break;
			}

			else {
				helper.call.highlighter(driver, arrow);
				arrow.click();
				helper.call.Quick_wait();
			}
		}
	}

	@FindBy(xpath = "//button[@data-testid='occupancy-config']")
	WebElement members;

	@FindBy(xpath = "(//button[@class='dba1b3bddf e99c25fd33 aabf155f9a f42ee7b31a a86bcdb87f e137a4dfeb d1821e6945'])[1]")
	WebElement plus_button;

	@FindBy(xpath = "(//span[@class='fb7047f72a'])[1]")
	WebElement value;

	@FindBy(xpath = "(//button[@class='dba1b3bddf e99c25fd33 aabf155f9a f42ee7b31a a86bcdb87f e137a4dfeb d1821e6945'])[2]")
	WebElement plus_child;

	@FindBy(xpath = "(//span[@class='fb7047f72a'])[2]")
	WebElement value_2;

	@FindBy(xpath = "(//select[@name='age'])[1]")
	WebElement age1;

	@FindBy(xpath = "(//select[@name='age'])[2]")
	WebElement age2;

	@FindBy(xpath = "(//select[@name='age'])[3]")
	WebElement age3;
	
	@FindBy
	(xpath="(//select[@name='age'])[1]//option")
	List <WebElement> dropdown1;
	
	@FindBy
	(xpath="(//select[@name='age'])[2]//option")
	List <WebElement> dropdown2;
	
	@FindBy
	(xpath="(//select[@name='age'])[3]//option")
	List <WebElement> dropdown3;
	
	@FindBy
	(xpath ="(//button[@class='dba1b3bddf e99c25fd33 aabf155f9a f42ee7b31a a86bcdb87f e137a4dfeb d1821e6945'])[3]")
	WebElement room_plus;
	
	@FindBy(xpath = "(//span[@class='fb7047f72a'])[3]")
	WebElement value_3;
	
	//span[@class='aa33d1ad7a']
	
	@FindBy(xpath = "//span[@class='aa33d1ad7a']")
	WebElement toggle;
	
	
	@FindBy(xpath = "//span[normalize-space()='Done']")
	WebElement done;
	
	
	public void members() throws InterruptedException {
		helper.call.highlighter(driver, members);
		members.click();
		helper.call.Quick_wait();

		while (true) {
			String mem_value = value.getText();
			System.out.println(mem_value);

			if (mem_value.equals("5")) {
				Assert.assertTrue(true);
				break;
			} else {

				plus_button.click();
				helper.call.Quick_wait();
			}

		}

		while (true) {
			String child_value = value_2.getText();
			System.out.println(child_value);

			if (child_value.equals("3")) {
				Assert.assertTrue(true);
				break;
			} else {
				plus_child.click();
				helper.call.Quick_wait();
			}
		}
		
		age1.click();
		for (WebElement one: dropdown1)
		{
			String age_one = one.getText();
			if (age_one.equalsIgnoreCase("15 years old"))
			{
				one.click();
				helper.call.Quick_wait();
				break;
			}
		}
		
		age2.click();
		for (WebElement one: dropdown2)
		{
			String age_one = one.getText();
			if (age_one.equalsIgnoreCase("10 years old"))
			{
				one.click();
				helper.call.Quick_wait();
				break;
			}
		}
		
		age3.click();
		for (WebElement one: dropdown3)
		{
			String age_one = one.getText();
			if (age_one.equalsIgnoreCase("7 years old"))
			{
				one.click();
				helper.call.Quick_wait();
				break;
			}
		}
		
       
       while(true)
       {	 
    	  String room_value = value_3.getText();
    	  
       if (room_value.equals("4"))
       {
    	   Assert.assertTrue(true);
		   break;
       }
       else
       {
    	   room_plus.click();
    	   helper.call.Quick_wait();
    	   
       }
       }
       
       helper.call.highlighter(driver, toggle);
       toggle.click();
       helper.call.Quick_wait();
       Reporter.log("Travel with pets - Yes");
       
       helper.call.highlighter(driver, done);
       done.click();
       helper.call.Quick_wait();
       Reporter.log("Done and Dusted");
       
       
	}
	
	@FindBy
	(xpath="//button[@type='submit']")
	WebElement search;
	
	public void search() throws InterruptedException
	{
		search.sendKeys(Keys.RETURN);
		ListenHere.Create.log(Status.INFO, "Search IS SELECTED");
		helper.call.Quick_wait();
		String pagename = driver.getTitle();
		System.out.println("Actual page title: " + pagename);
		Assert.assertEquals("Booking.com: Hotels in California. Book your hotel now!", pagename);
		
		if (pagename.contains("Booking.com:Book your hotel now!"))
		{
			Assert.assertTrue(true);
		}
	}

}
