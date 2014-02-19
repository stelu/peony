package ulive.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UliveHomePage_MenuBar 
{

	//main page links
	public static final String HEADER_ULIVELOGO_ICON = "//a[contains(text(),'uLive')]";
	public static final String HEADER_TODAY_LINK =	"(//a[contains(text(),'Today')])[2]";
	public static final String HEADER_BROWSER_LINK = "//a[contains(text(),'Browse')]";
	public static final String HEADER_TVSHOWS_LINK = "//div[@class='mainnav-container']/nav/ul/li[2]/a";
	public static final String HEADER_ORIGINALSERIES_LINK = "//div[@class='mainnav-container']/nav/ul/li[3]/a";
	public static final String HEADER_SEARCH_TEXTFIELD = "//input[@id='query-field']";
	public static final String HEADER_SEARCHSUBMIT_BUTTON = "//button[@type='submit']";
	public static final String HEADER_AUTOCOMPLETE_LIST = "//ul[@class='typeahead dropdown-menu']";
	
	protected WebDriver driver;
	
	public UliveHomePage_MenuBar(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	public void setHeader_Search_Textfield(String searchString) 
	{
		driver.findElement(By.xpath(HEADER_SEARCH_TEXTFIELD)).sendKeys(searchString);
	}
	
	public WebElement getHeader_Autocomplete_list() 
	{
		return driver.findElement(By.xpath(HEADER_AUTOCOMPLETE_LIST));
	}

}
