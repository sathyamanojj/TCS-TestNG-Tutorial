package Basics;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.Test;




public class Assignment5_ParallelTest {
	public WebDriver driver;

	
	String fs = System.getProperty("file.separator");
	String currDir = System.getProperty("user.dir");
	String path = currDir + fs + "drivers" + fs;
	
	@Test
	public void ChromeExecution()
	{
		System.setProperty("webdriver.chrome.driver", path + "chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.get("https://www.linkedin.com/");
		 driver.manage().window().maximize();
		 String title = driver.getTitle();
		 System.out.println("Google Chrome :  "+title);
		 Assert.assertEquals("LinkedIn: Log In or Sign Up", title);
		 System.out.println(" chrome title matched");
		 
		 //
	}
	
	@Test
	public void FirefoxExecution()
	{
		System.setProperty("webdriver.gecko.driver", path + "geckodriver.exe");
		 driver = new FirefoxDriver();
		 driver.get("https://www.linkedin.com/");
		 driver.manage().window().maximize();
		 String title = driver.getTitle();
		 System.out.println("Firefox : "+title);
		 Assert.assertEquals("LinkedIn: Log In or Sign Up", title);
		 System.out.println(" Firefox title matched");
		
	}
	
	@Test
	public void EdgeExecution()
	{
		System.setProperty("webdriver.edge.driver", path + "msedgedriver.exe");
		 driver = new EdgeDriver();
		 driver.get("https://www.linkedin.com/");
		 driver.manage().window().maximize();
		 String title = driver.getTitle();
		 System.out.println("Microsoft Edge : "+title);
		 Assert.assertEquals("LinkedIn: Log In or Sign Up", title);
		 System.out.println(" Edge title matched");
	}
	
	@AfterMethod
    public void browserclose ()
	{
        driver.quit();
        
    }

}

