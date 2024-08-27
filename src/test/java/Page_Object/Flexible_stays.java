package Page_Object;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import Test_Cases.Base_Class;
import Test_Listener.ListenHere;
import Utilities.helper;

public class Flexible_stays extends Base_Class {

	public Flexible_stays (WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		PageFactory.initElements(driver, Data_drive_stays.class);

	}
	
	@FindBy
	(xpath = "//div[normalize-space()='Browse by property type']")
	WebElement moving;
	
	public void Destination() throws InterruptedException
	
	{
		//helper.call.highlighter(driver, Data_drive_stays.place);
		helper.move(moving);
		helper.call.Quick_wait();
		Data_drive_stays.place.click();
		Data_drive_stays.place.clear();
		Data_drive_stays.place.sendKeys("Waterton Park");
		helper.call.Quick_wait();
		for (WebElement one : Data_drive_stays.List_Place) {
			String actual_name = one.getText();
			System.out.println(actual_name);
			if (actual_name.startsWith("Waterton Park")) {
				helper.call.highlighter(driver, one);
				helper.call.Quick_wait();
				one.click();
				helper.call.Quick_wait();
				Assert.assertTrue(true);
				helper.call.Quick_wait();
				break;
			}

		}
		
	}
	
	@FindBy(xpath = "//div[@data-testid='searchbox-dates-container']")
	WebElement Date;

	@FindBy(xpath = "//button[@aria-controls='flexible-searchboxdatepicker']")
	WebElement Flexible;
	//div[normalize-space()='A weekend']
	
	@FindBy(xpath = "//div[normalize-space()='A weekend']")
	WebElement A_weekend;
	
	//div[normalize-space()='A weekend']
	
	@FindBy(xpath = "//div[normalize-space()='A week']")
	WebElement A_week;
	
	
	
	@FindBy(xpath = "//div[text()='A month']")
	WebElement A_month;

	@FindBy(xpath = "//div[@class='e8b7ff5d69']//span")
	List<WebElement> slider;
	
	
	@FindBy(xpath = "//button[@class='dba1b3bddf e99c25fd33 f9ee700835 f42ee7b31a a86bcdb87f f2b2de6975 e17672a43b dcccc93761 cccf62b383 efbd49d12c']")
	WebElement arrow_button;
	
	
	
	@FindBy(xpath = "//span[@data-testid='flexible-dates-footer']")
	WebElement Flexible_date_footer;
	
	
	@FindBy(xpath = "//span[@class='c50e1a04a1']//span")
	List<WebElement> Sliding_months;
	
	//span[@class='c50e1a04a1']
	
	@FindBy(xpath = "//span[@class='c50e1a04a1']")
	List<WebElement> Tweleve;
	
	/*@FindBy(xpath = "//span[@class='c50e1a04a1']")
	WebElement First_month;*/
	
	public void Flexible()throws InterruptedException
	{
		helper.call.highlighter(driver, Date);
		helper.call.Quick_wait();
		Date.click();
		helper.call.Quick_wait();
		Date.click();
		Flexible.click();
		helper.call.Quick_wait();
		A_weekend.click();
		helper.call.Quick_wait();
		
		for (WebElement month :Tweleve )
		{
			String month_list = month.getText();
			System.out.println(month_list);
			String trimmed = month_list.trim();
			if (month_list.startsWith("Sep"))
			{
				
				helper.move(month);
				helper.call.highlighter(driver, month);
				System.out.println("Inside the loop");
				month.click();
				Assert.assertTrue(true);
				ListenHere.Create.log(Status.INFO, "Month is selected");
				helper.call.Quick_wait();
				String text_output = Flexible_date_footer.getText();
				if (text_output.startsWith("A weekend in"))
				{
					ListenHere.Create.log(Status.INFO, text_output);
					helper.call.Quick_wait();
					Assert.assertTrue(true);
					break;
				}
				}
			else	
			{
				arrow_button.click();
			}
				
				
		}
			
			for (WebElement month2 :Tweleve )
			{
				String month_list2 = month2.getText();
				System.out.println(month_list2);
				if (month_list2.startsWith("May"))
				{
					
					helper.move(month2);
					helper.call.highlighter(driver, month2);
					System.out.println("Inside the loop");
					month2.click();
					Assert.assertTrue(true);
					ListenHere.Create.log(Status.INFO, "Month is selected");
					helper.call.Quick_wait();
					String text_output = Flexible_date_footer.getText();
					if (text_output.startsWith("A weekend in"))
					{
						ListenHere.Create.log(Status.INFO, text_output);
						helper.call.Quick_wait();
						Assert.assertTrue(true);
						break;
					}
					}
				else	
				{
					arrow_button.click();
				}
					
					
			}
				
				for (WebElement month3 :Tweleve )
				{
					String month_list3 = month3.getText();
					System.out.println(month_list3);
					if (month_list3.startsWith("Jun"))
					{
						
						helper.move(month3);
						helper.call.highlighter(driver, month3);
						System.out.println("Inside the loop");
						month3.click();
						Assert.assertTrue(true);
						ListenHere.Create.log(Status.INFO, "Month is selected");
						helper.call.Quick_wait();
						helper.move(month3);
						helper.call.highlighter(driver, month3);
						month3.click();
						ListenHere.Create.log(Status.INFO, "Month is removed");
						String text_output = Flexible_date_footer.getText();
						if (text_output.startsWith("A weekend in"))
						{
							ListenHere.Create.log(Status.INFO, text_output);
							helper.call.Quick_wait();
							Assert.assertTrue(true);
							break;
						}
						}
					else	
					{
						arrow_button.click();
					}
						
						
					}
				helper.call.highlighter(driver, A_week);
				A_week.click();
				helper.call.Quick_wait();
				ListenHere.Create.log(Status.INFO, "A week is selected");
				String text_output_week = Flexible_date_footer.getText();
				ListenHere.Create.log(Status.INFO, text_output_week);
				Assert.assertTrue(true);
				
				helper.call.highlighter(driver, A_month);
				A_month.click();
				helper.call.Quick_wait();
				ListenHere.Create.log(Status.INFO, "A Month is selected");
				String text_output_month = Flexible_date_footer.getText();
				ListenHere.Create.log(Status.INFO, text_output_month);
				Assert.assertTrue(true);
				
				}
	
	
	@FindBy
	(xpath = "//div[normalize-space()='Other']")
	WebElement other;
	
	//div[@class='e2585683de eb02592978'][text()='Other']
	@FindBy
	(xpath = "//input[@type='number']")
	WebElement nights;
	
	
	@FindBy
	(xpath = "//select[@class='ef7e348457 b4a4349e48']")
	WebElement Dropdown_days;
	
	//select[@class='ef7e348457 b4a4349e48']//option
	@FindBy
	(xpath = "//select[@class='ef7e348457 b4a4349e48']")
	List <WebElement> days_dropdown_list;
	
	
	
	@FindBy
	(xpath = "//div[@class='e2585683de be323bc46b']")
	WebElement Test_click;
	
	public void other_options() throws InterruptedException
	{
		helper.call.highlighter(driver, Date);
		helper.call.Quick_wait();
		Date.click();
		helper.call.Quick_wait();
		Date.click();
		Flexible.click();
		helper.call.Quick_wait();
		helper.call.highlighter(driver, other);
		other.click();
		helper.call.Quick_wait();
		
		if (Test_click.isDisplayed())
		{
			Test_click.click();
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		
		for (WebElement month :Tweleve )
		{
			String month_list = month.getText();
			System.out.println(month_list);
			String trimmed = month_list.trim();
			if (month_list.startsWith("Sep"))
			{
				
				helper.move(month);
				helper.call.highlighter(driver, month);
				System.out.println("Inside the loop");
				month.click();
				Assert.assertTrue(true);
				ListenHere.Create.log(Status.INFO, "Month is selected");
				helper.call.Quick_wait();
				String text_output = Flexible_date_footer.getText();
				if (text_output.startsWith("A weekend in"))
				{
					ListenHere.Create.log(Status.INFO, text_output);
					helper.call.Quick_wait();
					Assert.assertTrue(true);
					break;
				}
				}
			else	
			{
				arrow_button.click();
			}
			
		}
		
		
		/*helper.move(Dropdown_days);
		Select sl = new Select(Dropdown_days);
		sl.selectByValue("4");*/
		//helper.call.highlighter(driver, nights);
		//nights.click();
	
					
		/*helper.move(nights);
		nights.clear();
		helper.call.Quick_wait();
		nights.sendKeys("12");
		helper.call.Quick_wait();*/
		
		/*for (WebElement one : days_dropdown_list)
		{
			System.out.println("INside the for");
			one.click();
			String days_fetch = one.getText();
			System.out.println(days_fetch);
			if (days_fetch.startsWith("From Thursday"))
			{
				
				one.click();
				
				Assert.assertTrue(true);
				helper.call.Quick_wait();
				break;
			}
			else
			{
				continue;
			}
		}
		*/
		
	
	
	
}
		
}
		
				
	

