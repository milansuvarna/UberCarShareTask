package commonUtils;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import stepDef.BaseClass;

public class CommonUtils extends BaseClass {
	public static void waitExplicit(By element_locator)
	{		 
		
		WebElement waitExp =(WebElement)new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(element_locator));
		
	}
	
	public static void waitImplicite(int duration) {
		driver.manage().timeouts().implicitlyWait(duration,TimeUnit.SECONDS);
		
	}

	
	public static void scrollPage() {
		JavascriptExecutor js =(JavascriptExecutor)driver;
		 js.executeScript("window.scrollBy(0,500)");
	}

}
