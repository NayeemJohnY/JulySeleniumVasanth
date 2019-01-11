package seleniumLearn;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RunForData {

	WebDriver driver;

	@BeforeMethod
	public  void chrome() {
		
		System.setProperty("webdriver.chrome.driver","F:\\JulySelenium\\Practise_Selenium\\lib\\chromedriver_win32\\chromedriver.exe");		
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		 driver = new ChromeDriver(options);
		driver= new ChromeDriver(options);
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
	}
	
	@Test(dataProvider="LoginCredentials")
	void Test(String email, String password) throws Exception
	{
		driver.findElement(By.cssSelector("input[type='email")).sendKeys(email);
		driver.findElement(By.cssSelector("input.inputtext[name='pass']")).sendKeys(password);
		driver.findElement(By.cssSelector("input[type='submit")).click();
		Assert.assertEquals(driver.getTitle(), "(1) Facebook");
		screenshotCapture();
	}
	
	@DataProvider(name="LoginCredentials")
	public Object[][] Testdata()
	{
		Object[][] data= new Object[2][2];
		/*data[0][0]="Vasanthjkjj";
		data[0][1]="password";
		
		data[1][0]="8015110219";
		data[1][1]="pass";*/
		
		data[0][0]="8015110219";
		data[0][1]="Nayeem94";
		
				
		return data;
		
	}
	public void screenshotCapture() throws Exception
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./Screenshots/" + "Firstscreen.png"));
	}
}
