package stepDef;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import commonUtils.CommonUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PriceFilterStepDef extends BaseClass{
	WebDriver driver=getDriver();
	PageObject poj=new PageObject(driver);
	String mainWindow;
	
	@Given("I am on the Ubercarshare search page")
	public void i_am_on_the_ubercarshare_search_page() {
	 poj.openURL();
	 driver.manage().window().maximize();
	}

	@When("I click on the search field")
	public void i_click_on_the_search_field() {
		poj.clickSearchField();
		
	}

	@When("I enter {string} as the address")
	public void i_enter_as_the_address(String add) throws InterruptedException {
		
		poj.enterAdd(add); // Enter address in the search field 
		poj.selectAdd(); //Select the first option from the suggestion list
	}

	@When("I select filters")
	public void i_select_filters() {
		mainWindow = driver.getWindowHandle();
		WebElement modalButton = poj.clickFilter(); //Click on Filter button
		modalButton.click();
	}

	@When("I set the price range")
	public void i_set_the_price_range_as() throws InterruptedException {
		Thread.sleep(4000);
		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
		    if (!window.equals(mainWindow)) {
		        driver.switchTo().window(window);
		        break;
		    }
		}
		poj.dragSlider(); // Dragging the slider to set the max value as $185 
		
		  
	}

	@When("I click the apply filters button")
	public void i_click_the_apply_filters_button() throws InterruptedException {
		poj.applyFilter(); // Click on Apply filter button
		driver.switchTo().window(mainWindow);
		CommonUtils.waitImplicite(5);
	}

	@Then("I should see a list of car rental options within my search criteria")
	public void i_should_see_a_list_of_car_rental_options_within_my_search_criteria() throws WebDriverException,NullPointerException, InterruptedException{

		poj.viewSearchResult(); // View the search result
		poj.verifyFilteredResults(); //Verify only those results are shown which are within the raging of $20 - $185	
		}
	}

