package Test_Cases;



import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Page_Object.Logo;
import Utilities.helper;

public class TC_Logo extends Base_Class {

	@Test
	public void TC_001() throws InterruptedException
	{
		Logo run = new Logo(driver);
		run.Booking_logo();
	}
	
	@Test
	public void TC_002() throws InterruptedException
	{
		Logo run = new Logo(driver);
		run.Money();
	}
	
	@Test (dataProvider = "data")
	public void TC_003_Currency(String cname) throws InterruptedException
	{
		Logo run = new Logo(driver);
		run.Money();
		run.currency_text(cname);
	}
	
	@DataProvider(name = "data")
	public String [] data_for_currency()
	{
		return helper.call.Cname();
		 
	}
	
	@Test (dataProvider = "Language")
	public void TC_004_Lang(String get) throws InterruptedException
	{
		Logo run = new Logo(driver);
		run.All_languages(get);
	}
	
	@DataProvider (name = "Language")
	public String [] language_data ()
	{
		return helper.call.langu();
		
	}
}
