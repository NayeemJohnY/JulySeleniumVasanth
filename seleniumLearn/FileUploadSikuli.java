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
	//@Test
	public void file() throws Exception 
	{
		Scanner scan = new Scanner(System.in);
	    int num=scan.nextInt();
	    String []name= new String [num+1];
	    boolean count=false;
	    for (int i=0; i<num; i++)
	    {
	        name[i]=scan.next();
	    }
	    	 System.out.println("Enter the name you want to search:");
		     String search=scan.next();
	         
	         
	         for (int i=0; i<num; i++)
	         {
	             if(name[i].equalsIgnoreCase(search))
	             {
	                 count=true;
	             }
	         }
		    if(count==true)
	        {
	            System.out.printf("%s found!",search);
	        }
	        else
	        System.out.printf("%s not found",search);
	     
	   
	     

		/*BufferedReader br= new BufferedReader(new InputStreamReader(System.in)); 
		DecimalFormat df = new DecimalFormat("#.00");
       
		double number =br.read();
		System.out.println(number);
		
	System.out.println("Credit Limit : "+ df.format(number));

Scanner scan= new Scanner(System.in);
        int num=scan.nextInt();
		  // String a[]= s.split;
           Double b[]= new Double[num+1];
		   double temp=0;
           String tempship=null;
          
		  for (int i=0; i<num;i++)
		  {
		      a[i]=scan.next();
		  }
          for (int i=0; i<num;i++)
    	  {
		      b[i]=scan.nextDouble();
		  }
          for(int j=0; j<num; j++)
          {
              if(b[j]>b[j+1])
              { temp=b[j];
                  b[j]=b[j+1];
                  b[j+1]=temp;
                  
                 tempship=a[j];
                  a[j]=a[j+1];
                  a[j+1]=tempship;
                  
              }
          }
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		DecimalFormat df = new DecimalFormat("#.00");

		double number = br.read();
		System.out.println("Credit Limit : " + df.format(number));
          System.out.println("Details are :");
          for (int i=0; i<num;i++)
    	  {
		      System.out.printf("%s - %.2f",a[i],b[i]);
		  }*/
	}
	
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