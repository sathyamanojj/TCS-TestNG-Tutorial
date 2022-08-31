package Basics;

import java.awt.AWTException;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;

public class Assignment8_FileUpload_RobotClass 
{
public WebDriver driver;
	@Test
	public void BrowserInitiation() throws AWTException
	{
		
	String fs = System.getProperty("file.separator");
	String currDir = System.getProperty("user.dir");
	String path = currDir + fs + "drivers" + fs;
	
	
		System.setProperty("webdriver.chrome.driver", path + "chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.get("https://gofile.io/uploadFiles");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		 driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg mb-1 uploadButton']")).click();
	
	String filePath = "c:\\simple.png";
	 StringSelection sel = new StringSelection(filePath);
	 //Copy the path to the Clip board
	 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel, null);
	 // Initialize the object of Robot class and paste the file path which copied and click the Open button by press Enter Key
	 Robot robot = new Robot();
	 robot.keyPress(KeyEvent.VK_ENTER);
	 robot.keyRelease(KeyEvent.VK_ENTER);
	 robot.keyPress(KeyEvent.VK_CONTROL);
	 robot.keyPress(KeyEvent.VK_V);
	 robot.keyRelease(KeyEvent.VK_V);
	 robot.keyRelease(KeyEvent.VK_CONTROL);
	 robot.keyPress(KeyEvent.VK_ENTER);
	 robot.keyRelease(KeyEvent.VK_ENTER);
	 
	}
	
	@AfterTest
	public void Browserclose()
	{
	
		System.out.println("File was successfully uploaded ");
		
		driver.quit();
	}

}
