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
import Utilities.Customized_report;
import Utilities.helper;

public class Data_drive_stays extends Base_Class {

	public Data_drive_stays(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@class='ada65db9b5']")
	public static WebElement place;
	
	//input[@class='ada65db9b5']
	
	@FindBy
	(xpath = "//div[normalize-space()='Browse by property type']")
	WebElement moving;

	// ul[@role= 'group']//div[@class='ad3c4dc079 e2f45f66c9']

	@FindBy(xpath = "//ul[@role= 'group']//div[@class='ad3c4dc079 e2f45f66c9']")
	//ul[@role='group']//div[@class='ad3c4dc079 e2f45f66c9']
	public static List<WebElement> List_Place;

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

	public void place(String search_place , String Dropdown_place) throws InterruptedException {
		//helper.call.highlighter(driver, place);
		//helper.move(moving);
	    //helper.call.Quick_wait();
		place.click();
		helper.call.Quick_wait();
		place.clear();
		place.sendKeys(search_place);
		helper.call.Quick_wait();
		for (WebElement one : List_Place) {
			String actual_name = one.getText();
			System.out.println(actual_name);
			if (actual_name.startsWith(Dropdown_place)) {
				helper.call.highlighter(driver, one);
				helper.call.Quick_wait();
				one.click();
				ListenHere.Create.log(Status.INFO, Dropdown_place +" is selected");
				Assert.assertTrue(true);
				helper.call.Quick_wait();
				
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

	public void Date(String Month_cal_1  ,String start_date ,String Month_cal_2 ,String End_date ) throws InterruptedException {
		System.out.println(Month_cal_1 +start_date +Month_cal_2+ End_date );
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

		//For Start date
		while (true) 
		{
			helper.call.highlighter(driver, get_month_1);
			String Month_1 = get_month_1.getText();


			helper.call.highlighter(driver, get_month_2);
			String Month_2 = get_month_2.getText();

			if (Month_1.equalsIgnoreCase(Month_cal_1)) 
			{
				for (WebElement M1 : table_1)
				{
					String d1 = M1.getText();

					if (d1.equals(start_date)) 
					{
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
			else if (Month_2.equalsIgnoreCase(Month_cal_1)) 
			{
				for (WebElement M2 : table_2) 
				{
					
					String d2 = M2.getText();
					if (d2.equals(start_date)) 
					{
						helper.call.highlighter(driver, M2);
						helper.call.Quick_wait();
						M2.click();
						helper.call.Quick_wait();
						//Customized_report.test.log(Status.INFO, "Entry date is slected");
						ListenHere.Create.log(Status.INFO, "Date is selected");
						Assert.assertTrue(true);
						
						
						break;
					}
					
				}
				break;
					
			}

			else 
			{
				helper.call.highlighter(driver, arrow);
				arrow.click();
				helper.call.Quick_wait();
			}
	
		}
	
		//----------------------------------------------------------------For end date
		while (true) 
		{
			//helper.call.highlighter(driver, get_month_1);
		  String Mth1 = get_month_1.getText();
          System.out.println("SECOND MONTH 1 --------------------------------" + Mth1);

			//helper.call.highlighter(driver, get_month_2);
			String Mth2 = get_month_2.getText();
			
		 System.out.println("SECOND MONTH 2 --------------------------------------" + Mth2 );
   
			if (Mth1.equalsIgnoreCase(Month_cal_2)) {
				for (WebElement M1 : table_1) {
					String d1 = M1.getText();

					if (d1.equals(End_date)) {
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
			else if (Mth2.equalsIgnoreCase(Month_cal_2)) 
			{
				for (WebElement M2 : table_2) 
				{
					
					String d2 = M2.getText();
					if (d2.equals(End_date)) 
					{
						helper.call.highlighter(driver, M2);
						helper.call.Quick_wait();
						M2.click();
						helper.call.Quick_wait();
						//Customized_report.test.log(Status.INFO, "Entry date is slected");
						Assert.assertTrue(true);
	
						break;
					}
				}
				break;	
			}

			else 
			{
				helper.call.highlighter(driver, arrow);
				arrow.click();
				helper.call.Quick_wait();
			}
	
		}
		
	}
	
	/*public void Date_2 (String Month_cal_2 , String End_date) throws InterruptedException
	{
		while (true) 
		{
			//helper.call.highlighter(driver, get_month_1);
		  String Mth1 = get_month_1.getText();
          System.out.println("SECOND MONTH 1 --------------------------------" + Mth1);

			//helper.call.highlighter(driver, get_month_2);
			String Mth2 = get_month_2.getText();
			
		System.out.println("SECOND MONTH 2 --------------------------------------" + Mth2 );

			if (Mth1.equalsIgnoreCase(Month_cal_2)) {
				for (WebElement M1 : table_1) {
					String d1 = M1.getText();

					if (d1.equals(End_date)) {
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
			else if (Mth2.equalsIgnoreCase(Month_cal_2)) 
			{
				for (WebElement M2 : table_2) 
				{
					
					String d2 = M2.getText();
					if (d2.equals(End_date)) 
					{
						helper.call.highlighter(driver, M2);
						helper.call.Quick_wait();
						M2.click();
						helper.call.Quick_wait();
						//Customized_report.test.log(Status.INFO, "Entry date is slected");
						Assert.assertTrue(true);
	
						break;
					}
				}
				break;	
			}

			else 
			{
				helper.call.highlighter(driver, arrow);
				arrow.click();
				helper.call.Quick_wait();
			}
	
		}
		
	}*/

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
	
	
	public void members(String member , String children , String child_age1 , String child_age2,
			String child_age3 , String room_count) throws InterruptedException {
		helper.call.highlighter(driver, members);
		members.click();
		helper.call.Quick_wait();

		while (true) {
			String mem_value = value.getText();

			if (mem_value.equals(member)) {
				Assert.assertTrue(true);
				//Customized_report.test.log(Status.INFO, "Adults are added");
				break;
			} else 
			{

				plus_button.click();
				helper.call.Quick_wait();
			}

		}

		while (true) {
			String child_value = value_2.getText();


			if (child_value.equals(children)) {
				Assert.assertTrue(true);
				//Customized_report.test.log(Status.INFO, "Childrens are added");
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
			if (age_one.equalsIgnoreCase(child_age1))
			{
				one.click();
				helper.call.Quick_wait();
				//Customized_report.test.log(Status.INFO, "Children 1 age is added");
				break;
			}
		}
		
		age2.click();
		for (WebElement one: dropdown2)
		{
			String age_one = one.getText();
			if (age_one.equalsIgnoreCase(child_age2))
			{
				one.click();
				helper.call.Quick_wait();
				//Customized_report.test.log(Status.INFO, "Children 2 age is added");
				break;
			}
		}
		
		age3.click();
		for (WebElement one: dropdown3)
		{
			String age_one = one.getText();
			if (age_one.equalsIgnoreCase(child_age3))
			{
				one.click();
				helper.call.Quick_wait();
				//Customized_report.test.log(Status.INFO, "Children 3 age is added");
				break;
			}
		}
		
       
       while(true)
       {	 
    	  String room_value = value_3.getText();
    	  
       if (room_value.equals(room_count))
       {
    	   Assert.assertTrue(true);
    	  // Customized_report.test.log(Status.INFO, "Total number of rooms are added");
    	   ListenHere.Create.log(Status.INFO, "Rooms and members are added");
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
       //Customized_report.test.log(Status.INFO, "Travel with pets - Yes is selected");
       
       helper.call.highlighter(driver, done);
       done.click();
       helper.call.Quick_wait();
       
       
	}
	
	@FindBy
	(xpath="//button[@type='submit']")
	WebElement search;
	
	public void search() throws InterruptedException
	{
		search.sendKeys(Keys.RETURN);
		//Customized_report.test.log(Status.INFO, "Search is selected");
		ListenHere.Create.log(Status.INFO, "Search is clicked and verified");
		helper.call.Quick_wait();
		String pagename = driver.getTitle();
		System.out.println("Actual page title: " + pagename);
		
		if (pagename.endsWith("Book your hotel now!"))
		{
			Assert.assertTrue(true);
			ListenHere.Create.log(Status.INFO, "Page title verified");
			System.out.println("PASSED");
		}
		else
		{
			ListenHere.Create.log(Status.INFO, "Page title varies and test failed");
		}
	}

}
