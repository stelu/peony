package ulive.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UliveSearchPage 
{

	public static final String SEARCHPAGE_SEARCH_TEXTFIELD = "//input[@id='query-field']";
	public static final String SEARCHPAGE_SEARCH_TEXTFIELD_2 = "(//input[@id='query-field'])[2]";
	public static final String SEARCHPAGE_SUBMIT_BUTTON = "//button[@type='submit']";
	public static final String FIRSTFRIDGEMAGNET_LINK = "//div[@class='contentFilter']/ul/li/a";
	
	
	protected WebDriver driver;
	
	public UliveSearchPage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	public WebElement getSearchPage_Search_Textfield() 
	{
		return driver.findElement(By.xpath(SEARCHPAGE_SEARCH_TEXTFIELD));
	}
	
	public void setSearchPage_Search_Textfield(String searchString) 
	{
		driver.findElement(By.xpath(SEARCHPAGE_SEARCH_TEXTFIELD)).sendKeys(searchString);
	}
	
	public WebElement getSearchPage_Search_Textfield2() 
	{
		return driver.findElement(By.xpath(SEARCHPAGE_SEARCH_TEXTFIELD_2));
	}
	
	public void setSearchPage_Search_Textfield2(String searchString) 
	{
		driver.findElement(By.xpath(SEARCHPAGE_SEARCH_TEXTFIELD_2)).sendKeys(searchString);
	}
	
}
