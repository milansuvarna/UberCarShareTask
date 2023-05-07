package stepDef;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import commonUtils.CommonUtils;
import commonUtils.Locators;

public class PageObject {

	WebDriver driver=null;
	WebElement filter;
	WebElement upperRangeSlider;
	ArrayList<Float> filteredResult = new ArrayList<Float>();

	PageObject(WebDriver driver)
	{
		this.driver=driver;
	}

	public void openURL()
	{
		driver.get("https://www.ubercarshare.com/search");
	}

	public void clickSearchField()
	{
		driver.findElement(Locators.searchField).clear();
		driver.findElement(Locators.searchField).click();
	}

	public void enterAdd(String address)
	{
		driver.findElement(Locators.add).sendKeys(address);
	}

	public void selectAdd()
	{
		CommonUtils.waitExplicit(Locators.selectAdd);
		driver.findElement(Locators.selectAdd).click();
	}

	public WebElement clickFilter()
	{
		filter = driver.findElement(Locators.filterModal);
		return filter;
	}
	public void dragSlider() throws InterruptedException
	{
		upperRangeSlider = driver.findElement(Locators.sliderBtn);
		Actions action = new Actions(driver);
		action.click(upperRangeSlider).build().perform();
		CommonUtils.waitImplicite(1);
		for (int i = 0; i < 63; i++) {
			action.sendKeys(Keys.ARROW_LEFT).build().perform();
			CommonUtils.waitImplicite(5);
		}

	}

	public void applyFilter()
	{
		driver.findElement(Locators.applyFilter).click();
	}

	public void  viewSearchResult() throws WebDriverException, NullPointerException, InterruptedException
	{	String price="";
		Float priceValue;
		String accessibleName="";
		CommonUtils.waitImplicite(5);
		
		List<WebElement> rent= driver.findElements(Locators.searchResultLocator);
		
		for(WebElement r:rent)
		{
			final String CURRENCY_SYMBOLS= "\\p{Sc}\u0024\u060B";
			Pattern p = Pattern.compile("[" +CURRENCY_SYMBOLS + "][\\d.]+");
			CommonUtils.waitImplicite(4);
			accessibleName=	r.getAccessibleName();
			CommonUtils.waitImplicite(5);
			Matcher m = p.matcher(accessibleName);
			while (m.find()) {
				price=m.group().replaceAll("\\$","");
				if(price!=null) {
				priceValue = Float.parseFloat(price);
				filteredResult.add(priceValue);
				}
			}	
		}
	}
	
	public void verifyFilteredResults() {
		for(int i=0;i<filteredResult.size();i++)
		{
			if(i%2!=0)
			{
				Assert.assertTrue(20 <= filteredResult.get(i) && filteredResult.get(i) <= 185);
			}
			
		}
	}
	
}
