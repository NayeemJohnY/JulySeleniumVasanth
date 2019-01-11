package seleniumLearn;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class WebDriverPractise {
 WebDriver driver;
	@Test
	public  void chrome() {
		
		System.setProperty("webdriver.chrome.driver","F:\\JulySelenium\\Practise_Selenium\\lib\\chromedriver_win32\\chromedriver.exe");
		
		 driver= new ChromeDriver();
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		String expectedtilte="Facebook – log in or sign up";
		/*if(driver.getTitle().equals(expectedtilte))
		{
			System.out.println("Pass");
		}
		else
			System.out.println("fail");*/
	
		Assert.assertTrue(driver.getTitle().equals(expectedtilte),"chrome ME");
		
		

	}
	@Test
	public   void  firefox()
	{
		System.setProperty("webdriver.gecko.driver","F:\\JulySelenium\\Practise_Selenium\\lib\\geckodriver-v0.21.0-win32\\geckodriver.exe");

		
		FirefoxOptions option= new FirefoxOptions();
		option.addPreference("dom.webnotifications.enabled", false);		
		driver= new FirefoxDriver(option);
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		//String expectedtilte="Facebook – log in or sign up";
		/*if(driver.getTitle().equals(expectedtilte))
		{
			System.out.println("Pass1");
		}
		else{
			System.out.println("fail");
	}	*/
	}	
	
	@AfterMethod	
public void LoginFB()
{
	driver.findElement(By.xpath("//*[@id='email']")).sendKeys("8015110219");
	driver.findElement(By.xpath("//*[@id='pass']")).sendKeys("Nayeem94");
	driver.findElement(By.xpath("//*[@id='pass']//following::input[1]")).click();
	String expectedtilte="Facebook";
	Assert.assertTrue(driver.getTitle().contains(expectedtilte),"MsG");
	
	/*if(driver.getTitle().equals("Facebook"))
	{
		System.out.println("Pass");
	}
	else
		System.out.println("fail");
	WebDriverWait wait=new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.alertIsPresent());
	Alert alert=driver.switchTo().alert();
	alert.dismiss();	*/ 
}
}
