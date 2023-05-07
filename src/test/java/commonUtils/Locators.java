package commonUtils;

import org.openqa.selenium.By;

public class Locators {

	public static By searchField=By.xpath("//input[@placeholder='City, hotel or address']");
	public static By add=By.xpath("//input[@placeholder='City, hotel or address']");
	public static By selectAdd=By.cssSelector("li[class=' active'] div[class='mapboxgl-ctrl-geocoder--suggestion-address']");
	public static By filterModal=By.xpath("//button[normalize-space()='Filters']");
	public static By sliderBtn=By.xpath("//*[not(contains(@class,'cnd-hidden')) and contains(@data-target,'search--filters.filtersModal')]//child::*[contains(@class,'cnd-slider__thumb--upper')]");
	public static By applyFilter=By.xpath("//button[@data-value='filtersModal' and contains(text(),'Apply filters')]");
	public static By searchResultLocator=By.xpath("//*[contains(@data-target,'search--vehicle-search.results')]//div//a");

}
