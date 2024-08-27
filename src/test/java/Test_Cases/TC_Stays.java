package Test_Cases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Page_Object.Stays;

public class TC_Stays extends Base_Class{

	
   @Test (groups = {"Unit"})
	public void TC_001_Place () throws InterruptedException
	{
		Stays st = new Stays(driver);
		st.place();
		
	}
   
   @Test (groups = {"Unit"})
   public void TC_002_Date () throws InterruptedException
	{
		Stays st = new Stays(driver);
		st.Date();
	}
   
   @Test (groups = {"Unit"})
   public void TC_003_members () throws InterruptedException
	{
		Stays st = new Stays(driver);
		
		st.members();

	
	}
   
   @Test (groups = {"Integrated Flow"})
	public void TC_004_Search () throws InterruptedException
	{
		Stays st = new Stays(driver);
		st.place();
		st.Date();
		st.members();
		st.search();
	}
}
