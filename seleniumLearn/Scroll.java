package seleniumLearn;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Scroll {
WebDriver driver;

	
	@Test
	public void scrollWebpageKey() throws Exception
	{
		System.setProperty("webdriver.chrome.driver","F:\\JulySelenium\\Practise_Selenium\\lib\\chromedriver_win32\\chromedriver.exe");		
		
		 driver = new ChromeDriver();
		 driver.get("http://www.softwaretestingmaterial.com/");
		 driver.manage().window().maximize();
		 Thread.sleep(3000);
		 Actions action = new Actions(driver);
		 action.sendKeys(Keys.PAGE_DOWN).perform();
		 Thread.sleep(3000);
		 action.sendKeys(Keys.PAGE_DOWN).perform();
	}
}
