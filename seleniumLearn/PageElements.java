package seleniumLearn;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PageElements {
	
	
		@FindBy(id="email")
		WebElement emailtxtbox;
	
		@FindBy(how=How.CSS, using=".inputtext[name='pass']")
		WebElement passwordtxtbox;
		
		@FindBy(how=How.XPATH,using="//input[@value='Log In']")
		WebElement loginBtn;

}
