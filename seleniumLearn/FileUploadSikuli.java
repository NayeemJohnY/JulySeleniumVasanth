package seleniumLearn;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Scanner;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

public class FileUploadSikuli {

	WebDriver driver;
	
	@Test
	public void SikuliFileUpload() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"F:\\JulySelenium\\Practise_Selenium\\lib\\chromedriver_win32\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();
		Screen screen = new Screen();
		// driver.findElement(By.xpath("//*[@id='imagesrc']")).click();
		screen.click("F:\\JulySelenium\\Practise_Selenium\\sikuli\\BrowseButton.PNG");
		Thread.sleep(15000);
		Pattern fileinputTextbox = new Pattern("F:\\JulySelenium\\Practise_Selenium\\sikuli\\FileInputTextBox.PNG");
		screen.type(fileinputTextbox, "F:\\JulySelenium\\Practise_Selenium\\Screenshots\\Firstscreen.png");
		Pattern openBtn = new Pattern("F:\\JulySelenium\\Practise_Selenium\\sikuli\\OpenButton.PNG");
		screen.click(openBtn);
	}
}
