package seleniumLearn;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelPractise {
	
	@Test(dataProvider="LoginCredentials")
	public  void TestDrive(String emailid, String password) throws Exception {
		
		System.setProperty("webdriver.chrome.driver",".\\lib\\chromedriver_win32\\chromedriver.exe");
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");
		driver.findElement(By.cssSelector("#email")).sendKeys(emailid);
		driver.findElement(By.cssSelector(".inputtext[name='pass']")).sendKeys(password);
		driver.findElement(By.cssSelector("input[value^='Log']")).click();
		FileInputStream finput= new FileInputStream(".\\lib\\FacebookLogin.xlsx");
		 XSSFWorkbook wb= new XSSFWorkbook(finput);
		 finput.close();
		FileOutputStream fout=new FileOutputStream(".\\lib\\FacebookLogin.xlsx");
		
		 XSSFSheet sheet=wb.getSheet("Credentials");
		 XSSFRow row=sheet.getRow(0);
		 XSSFCell cell=row.createCell(2);
		
		if(driver.getTitle().equalsIgnoreCase("Facebook"))
		{
			cell.setCellValue("Pass");
		}
		else
			cell.setCellValue("Fail");
		
		wb.write(fout);
		fout.close();
	}
	@DataProvider(name="LoginCredentials")
	public Object[][] testdate() throws Exception{
		Object[][] data= new Object[1][2];
		 FileInputStream finput= new FileInputStream(".\\lib\\FacebookLogin.xlsx");
		 XSSFWorkbook wb= new XSSFWorkbook(finput);
		 finput.close();
		 XSSFSheet sheet=wb.getSheet("Credentials");
		 XSSFRow row=sheet.getRow(0);
		 XSSFCell cell=row.getCell(0);
		data[0][0]= cell.getStringCellValue();
		XSSFCell cell2=row.getCell(1);
		data[0][1]= cell2.getStringCellValue();
		/*XSSFRow row2=sheet.getRow(1);
		XSSFCell cell3=row2.getCell(0);
		data[1][0]= cell3.getStringCellValue();
		XSSFCell cell4=row2.getCell(1);
		data[1][1]= cell4.getStringCellValue();*/
		
		 
		return data ;
		
	}

}
