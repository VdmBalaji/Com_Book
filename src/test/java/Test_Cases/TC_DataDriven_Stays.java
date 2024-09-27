package Test_Cases;

import java.io.IOException;
import org.testng.annotations.Test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Page_Object.Data_drive_stays;
import Utilities.Data_stays;

public class TC_DataDriven_Stays extends Base_Class 
{

	@Test (dataProvider="data")
	public void TC_001_Stays_Smoke(String search_place , String Dropdown_place,
			String Month_cal_1 , String Month_cal_2 , String start_date , String End_date,
			String member , String children , String child_age1 , String child_age2,
			String child_age3 , String room_count) throws InterruptedException
	{
		Data_drive_stays run = new Data_drive_stays(driver);
		
		run.place(search_place ,Dropdown_place);
		run.Date(Month_cal_1, start_date ,Month_cal_2, End_date);
		
		
		run.members(member,children, child_age1, child_age2,child_age3,room_count   );
		run.search();
				
	}
	
	/*@DataProvider(name = "stay_multiple_data")
	public Object[][] stay_data() 
	{
	    return new Object[][] 
	    		{
	        {"California", "California", "March 2025", "April 2025", "10", "20", "2", "1", "5", "7", "3", "2"},
	        {"New York", "New York", "May 2025", "June 2025", "15", "25", "3", "2", "6", "8", "4", "1"},
	     
	    };*/
	
	@DataProvider (name = "data")
	public  String[][] stay_data() throws IOException
	{
		return Data_stays.Fetch_data();
		
		
		
	}
}

