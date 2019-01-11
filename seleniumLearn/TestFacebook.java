package seleniumLearn;

import org.apache.poi.ddf.EscherColorRef.SysIndexSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utility.BrowserSetup;
import utility.ExcelHandle;

public class TestFacebook {
	
	
	@Test(dataProvider="Login")
	public void test(String email, String password,String Reults) throws Exception
	{
		WebDriver driver=BrowserSetup.BrowserStart("chrome", "https://www.facebook.com");
		PageElements elements=PageFactory.initElements(driver, PageElements.class);
		elements.emailtxtbox.sendKeys(email);
		elements.passwordtxtbox.sendKeys(password);
		elements.loginBtn.click();
		ExcelHandle excelobj= new ExcelHandle(".\\lib\\FacebookLogin.xlsx");
		excelobj.writecellData("Credentials",0 ,2 , "Pass");
	}
	
	@DataProvider (name="Login")	
	public Object[][] testData() throws Exception
	{
		 Object[][] excelData;
		 ExcelHandle excelobj= new ExcelHandle(".\\lib\\FacebookLogin.xlsx");
		 int rowcount=excelobj.rowCount("Credentials");
		 int colcount=excelobj.colCount("Credentials");
		 excelData= new Object[rowcount][colcount];
		 for (int i=0; i<rowcount; i++)
			{
				for ( int j=0; j<colcount; j++)
				{
					excelData[i][j]=excelobj.getcellData("Credentials", i, j);
					
				}
			}
		 return excelData;
		 
		
	}
}
