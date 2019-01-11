package seleniumLearn;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


public class ActionClass {
	
	WebDriver driver;
	
	public void dragAndDrop()
	{
		
		System.setProperty("webdriver.chrome.driver","F:\\JulySelenium\\Practise_Selenium\\lib\\chromedriver_win32\\chromedriver.exe");		
	
		 driver = new ChromeDriver();
		 driver.get("http://jqueryui.com/droppable/");
		 driver.manage().window().maximize();
		 driver.switchTo().frame(driver.findElement(By.xpath("//*[@class='demo-frame']")));
		WebElement  draggable=driver.findElement(By.xpath("//*[@id='draggable']"));
		WebElement  droppable=driver.findElement(By.xpath("//*[@id='droppable']"));
		Actions action= new Actions(driver);
		action.dragAndDrop(draggable, droppable).build().perform();
		
	}
	@Test
	public void dragAndDropSlders()
	{
		
		System.setProperty("webdriver.chrome.driver","F:\\JulySelenium\\Practise_Selenium\\lib\\chromedriver_win32\\chromedriver.exe");		
	
		 driver = new ChromeDriver();
		 driver.get("http://www.seleniumeasy.com/test/drag-drop-range-sliders-demo.html");
		 driver.manage().window().maximize();
	
		WebElement  slider=driver.findElement(By.cssSelector("#slider1 > div > input[type='range']"));
		
		Actions action= new Actions(driver);
		action.dragAndDropBy(slider, 104, 0).build().perform();
		
		
	}
}
