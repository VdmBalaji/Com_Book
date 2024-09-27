package Page_Object;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import dev.failsafe.internal.util.Durations;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Rune {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		WebElement logo = driver.findElement(By.xpath("//a[@id='nav-logo-sprites']"));
		boolean val = logo.isEnabled();
	
        Thread.sleep(5000);
		TakesScreenshot take = (TakesScreenshot) driver;
		File first = take.getScreenshotAs(OutputType.FILE);
		File actual = new File("D:\\New path\\Hotel_Booking_AG\\capture\\SS.png");
		try {
			FileUtils.copyFile(first, actual);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Passed");
		System.out.print(val);
		
		Actions act = new Actions (driver);
		logo.sendKeys(Keys.CONTROL , Keys.RETURN);
		Set <String> all = driver.getWindowHandles();
		for (String windows:all)
		{
			driver.switchTo().window(windows);
			Thread.sleep(5000);
		}
		
		
		driver.quit();
	}

}
