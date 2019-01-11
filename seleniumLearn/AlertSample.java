package seleniumLearn;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AlertSample {

	WebDriver driver;
	
	
	@BeforeMethod
	public void browserSetup()
	{
		System.setProperty("webdriver.chrome.driver","F:\\JulySelenium\\Practise_Selenium\\lib\\chromedriver_win32\\chromedriver.exe");
		
		 driver= new ChromeDriver();
		 driver.manage().window().maximize();
	}
	@Test
	public void simpleAlert()
	{
		
		driver.get("file:///F:/Selenium/SimpleAlert.html");		
		WebElement alertele=driver.findElement(By.xpath("//button"));
		alertele.click();

		Alert alert=driver.switchTo().alert();
		String actual=alert.getText();
		alert.accept();
		
		Assert.assertEquals(actual, "I am an example for alert box!");
		
	}
	@Test
	public void promptAlert() throws Exception
	{
		
		driver.get("file:///F:/Selenium/PromptAlert.html");
		WebElement alertele=driver.findElement(By.xpath("//button"));
		alertele.click();

		Alert alert=driver.switchTo().alert();
		String s="Vasanth";
		alert.sendKeys(s);
		alert.accept();
		String confirmResult=driver.findElement(By.xpath("//*[@id='promptdemo']")).getText();;
		Assert.assertTrue(confirmResult.contains(s));
		Thread.sleep(10000);
		driver.navigate().refresh();
		
		WebElement alertele2=driver.findElement(By.xpath("//button"));
		alertele2.click();

		Alert alert2=driver.switchTo().alert();
		alert2.dismiss();
		String confirmResult1=driver.findElement(By.xpath("//*[@id='promptdemo']")).getText();;
		Assert.assertEquals(confirmResult1, "Bye");
		
		
	}
	@Test
	public void confirmAlert() throws Exception
	{
		
		driver.get("file:///F:/Selenium/ConfirmAlert.html");
		WebElement alertele=driver.findElement(By.xpath("//button"));
		alertele.click();

		Alert alert=driver.switchTo().alert();
		alert.accept();
		String confirmResult=driver.findElement(By.xpath("//*[@id='confirmdemo']")).getText();;
		Assert.assertEquals(confirmResult, "You Clicked on OK!");
		Thread.sleep(10000);
		driver.navigate().refresh();
		
		WebElement alertele2=driver.findElement(By.xpath("//button"));
		alertele2.click();

		Alert alert2=driver.switchTo().alert();
		alert2.dismiss();
		String confirmResult1=driver.findElement(By.xpath("//*[@id='confirmdemo']")).getText();;
		Assert.assertEquals(confirmResult1, "You Clicked on Cancel!");
		
		
	}
	@AfterTest
	void closeBrowser()
	{
		driver.quit();
	}

}
