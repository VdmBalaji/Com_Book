package Test_Cases;

import org.testng.annotations.Test;

import Page_Object.Flexible_stays;

public class TC_Flexible extends Base_Class {
	
	@Test
	public void TC_001_Destination() throws InterruptedException
	
	{
		Flexible_stays run = new Flexible_stays(driver);
		run.Destination();
		//run.Flexible();
		run.other_options();
		
	}

}
