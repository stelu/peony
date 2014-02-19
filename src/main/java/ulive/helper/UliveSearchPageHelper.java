package ulive.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ulive.pages.UliveSearchPage;

public class UliveSearchPageHelper extends UliveSearchPage 
{
	
	public UliveSearchPageHelper(WebDriver driver) 
	{
		super(driver);
	}
	
	public void clickSearchPage_Submit_Button() 
	{
		driver.findElement(By.xpath(SEARCHPAGE_SUBMIT_BUTTON)).click();
	}

}
