package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserSetup {

	static WebDriver driver;
	public  static WebDriver BrowserStart(String browsername,String url)
	{
		if(browsername.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",".\\lib\\chromedriver_win32\\chromedriver.exe");
			
			 driver= new ChromeDriver();
			
		
		}
		if(browsername.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",".\\lib\\geckodriver-v0.21.0-win32\\geckodriver.exe");
			
			 driver= new FirefoxDriver();
			
		
		}
		else
		{
			System.out.println("unable to launch the broswer"+browsername);
			
		}
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}
}
