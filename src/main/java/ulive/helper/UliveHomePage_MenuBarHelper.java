package ulive.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import peony.asserts.PeonyAssertion;
import ulive.pages.UliveHomePage_MenuBar;
import ulive.pages.UliveHomePage_MenuNav;
import ulive.pages.UliveSearchPage;
import ulive.util.UliveBaseClass;

public class UliveHomePage_MenuBarHelper extends UliveHomePage_MenuBar 
{
	private UliveBaseClass uliveBaseClass;
	
	public UliveHomePage_MenuBarHelper(WebDriver driver) 
	{
		super(driver);
		uliveBaseClass = new UliveBaseClass(driver);
	}
	
	public void clickHeader_UliveLogo_Icon() 
	{
		driver.findElement(By.xpath(HEADER_ULIVELOGO_ICON)).click();
	}
	
	public void clickHeader_SearchSubmit_Button() 
	{
		driver.findElement(By.xpath(HEADER_SEARCHSUBMIT_BUTTON)).click();
	}
	
	public void clickHeader_TVShows_Link() 
	{
		driver.findElement(By.xpath(HEADER_TVSHOWS_LINK)).click();
	}
	
	public void clickHeader_OriginalSeries_Link() 
	{
		driver.findElement(By.xpath(HEADER_ORIGINALSERIES_LINK)).click();
	}
	
	public void verifyHeaderUliveLogo() 
	{
		PeonyAssertion.verifyTrue(driver.findElement(
				By.xpath(UliveHomePage_MenuBar.HEADER_ULIVELOGO_ICON))
				.isDisplayed(), "ulive logo is displayed");
	}
	
	public void verifySearchTextfield() 
	{
		PeonyAssertion.verifyTrue(uliveBaseClass.isElementPresent(By
				.xpath(UliveHomePage_MenuBar.HEADER_SEARCH_TEXTFIELD)),
				"Search textfield is present");
		
		PeonyAssertion.verifyTrue(uliveBaseClass.isElementPresent(By
				.xpath(UliveSearchPage.SEARCHPAGE_SUBMIT_BUTTON)), 
				"Search submit button is present");
	}
	
	public void verifyTVShowsOriginalsLinks(boolean isLinkPresent) 
	{
		if(isLinkPresent) 
		{
			PeonyAssertion.assertTrue(driver.findElement(By.xpath(HEADER_TVSHOWS_LINK)).isDisplayed(), 
					"TV Shows header is displayed");
			PeonyAssertion.assertTrue(driver.findElement(By.xpath(HEADER_ORIGINALSERIES_LINK)).isDisplayed(),
					"Original Series header is displayed");
		} else 
		{
			PeonyAssertion.assertFalse(driver.findElement(By.xpath(HEADER_TVSHOWS_LINK)).isDisplayed(),
					"TV Shows header is NOT displayed");
			PeonyAssertion.assertFalse(driver.findElement(By.xpath(HEADER_ORIGINALSERIES_LINK)).isDisplayed(),
					"Original Series header is NOT displayed");
		}
	}
	
	public void verifyAutoComplete(boolean isAutoCompletePresent) 
	{
		if(isAutoCompletePresent) 
		{
			PeonyAssertion.verifyTrue(uliveBaseClass.isElementPresent(By
					.xpath(HEADER_AUTOCOMPLETE_LIST)),
					"autocomplete dropdown is provided");
		}else 
		{
			PeonyAssertion.verifyFalse(uliveBaseClass.isElementPresent(By
					.xpath(HEADER_AUTOCOMPLETE_LIST)),
					"autocomplete dropdown is NOT provided");
		}
		
	}
	
}
