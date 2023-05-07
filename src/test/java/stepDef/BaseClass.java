package stepDef;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseClass {
public static WebDriver driver;
	
	public static WebDriver getDriver()
	{
		System.setProperty("webdriver.chrome.driver","src/test/resources/Drivers/chromedriver.exe");		
		driver=new ChromeDriver();
		return driver;
	}

	
	
	public static void tearDown()
	{
		driver.quit();
	}
	

}
