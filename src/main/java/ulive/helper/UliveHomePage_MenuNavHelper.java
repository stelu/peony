package ulive.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;

import peony.asserts.PeonyAssertion;
import ulive.pages.UliveHomePage_MenuNav;
import ulive.util.MouseHover;
import ulive.util.UliveBaseClass;
import ulive.util.UliveUtil;

public class UliveHomePage_MenuNavHelper extends UliveHomePage_MenuNav 
{
	private UliveBaseClass uliveBaseClass;
	private MouseHover mouseHover;
	
	public UliveHomePage_MenuNavHelper(WebDriver driver) 
	{
		super(driver);
		uliveBaseClass = new UliveBaseClass(driver);
		mouseHover = new MouseHover(driver);
	}
	
	public void clickHeader_TVShows_Link() 
	{
		driver.findElement(By.xpath(MENUNAV_TVSHOWS_LINK)).click();
	}
	
	public void clickHeader_OriginalSeries_Link() 
	{
		driver.findElement(By.xpath(MENUNAV_ORIGINALSERIES_LINK)).click();
	}
	
	public void clickMenuNav_Active_Icon() 
	{
		driver.findElement(By.xpath(MENUNAV_ACTIVE_ICON)).click();
	}
	
	public void clickMenuNav_Inactive_Icon() 
	{
		driver.findElement(By.xpath(MENUNAV_INACTIVE_ICON)).click();
	}
	
	public void clickMenuNav_HealthyCooking_Link() 
	{
		driver.findElement(By.xpath(FOOD_HEALTHYCOOKING_LINK)).click();
	}
	
	public void verifyTVShowsOriginalsLinks(boolean isLinkPresent) 
	{
		if(isLinkPresent) {
			PeonyAssertion.assertTrue(driver.findElement(By.xpath(MENUNAV_TVSHOWS_LINK)).isDisplayed(), 
					"TV Shows header is displayed");
			PeonyAssertion.assertTrue(driver.findElement(By.xpath(MENUNAV_ORIGINALSERIES_LINK)).isDisplayed(),
					"Original Series header is displayed");
		} else {
			PeonyAssertion.assertFalse(driver.findElement(By.xpath(MENUNAV_TVSHOWS_LINK)).isDisplayed(),
					"TV Shows header is NOT displayed");
			PeonyAssertion.assertFalse(driver.findElement(By.xpath(MENUNAV_ORIGINALSERIES_LINK)).isDisplayed(),
					"Original Series header is NOT displayed");
		}
	}
	
	public void verifyMenuNav() 
	{
		PeonyAssertion.assertTrue(driver.findElement(By.xpath(MENUNAV_INACTIVE_ICON)).isDisplayed(), 
				"Menu Navigator is closed");

		clickMenuNav_Inactive_Icon();

		PeonyAssertion.assertTrue(driver.findElement(By.xpath(MENUNAV_ACTIVE_ICON)).isDisplayed(),
				"Menu Navigator is open after clicking on the Menu button");
		
		clickMenuNav_Active_Icon();
		
		PeonyAssertion.assertTrue(driver.findElement(By.xpath(MENUNAV_INACTIVE_ICON)).isDisplayed(),
				"Menu Navigator is closed after clicking on the Menu button");

		clickMenuNav_Inactive_Icon();
		uliveBaseClass.waitUntilElementVisible(UliveHomePage_MenuNav.MENUNAV_ACTIVE_ICON);
	}
	
	public void verifySocialShare() 
	{
		
//		if(uliveBaseClass.isElementPresent(By.xpath(MENUNAV_INACTIVE_ICON))) {
//			driver.findElement(By.xpath(MENUNAV_INACTIVE_ICON)).click();
//		}
		
		PeonyAssertion.verifyTrue(uliveBaseClass.isTextPresent("Follow ulive"),
				"\"Follow ulive\" is displayed");

		// verify facebook, twitter, and google+ icons
		PeonyAssertion.verifyTrue(uliveBaseClass.isElementPresent(By.cssSelector(MENUNAV_FACEBOOKCSS_ICON)),
				"Facebook icon is displayed on menu nav");
		
		PeonyAssertion.verifyTrue(uliveBaseClass.isElementPresent(By.cssSelector(MENUNAV_TWITTERCSS_ICON)),
				"Twitter icon is displayed on menu nav");
	
		PeonyAssertion.verifyTrue(uliveBaseClass.isElementPresent(By.cssSelector(MENUNAV_GOOGLEPLUSCSS_ICON)),
				"Google+ icon is displayed on menu nav");
	}
	
	public void verifyFoodSubmenu() throws Exception
	{
		PeonyAssertion.verifyTrue(driver.findElement(By.xpath(MENUNAV_FOOD_LINK)).isDisplayed(),
				"Food menu nav is displayed");
		mouseHover.mouseOver(UliveHomePage_MenuNav.MENUNAV_FOOD_LINK);
		Thread.sleep(500);
		String backgroundColour = Color.fromString(driver.findElement(By.xpath(MENUNAV_FOOD_LI)).getCssValue("background-color")).asHex();
		System.out.println("color hex: "+backgroundColour);
		PeonyAssertion.verifyEquals(backgroundColour, "#f67437",
				"Food menu nav is highlighted in orange");
	}
	
	public void verifyAndClickHealthyCookingLink() throws Exception
	{
		PeonyAssertion.verifyTrue(driver.findElement(By.xpath(UliveHomePage_MenuNavHelper.FOOD_HEALTHYCOOKING_LINK)).isDisplayed(),
				"Healthy Cooking submenu nav is displayed");
		mouseHover.mouseOver(UliveHomePage_MenuNav.FOOD_HEALTHYCOOKING_LINK);
		Thread.sleep(500);
		String backgroundColour = Color.fromString(driver.findElement(By.xpath(UliveHomePage_MenuNavHelper.FOOD_HEALTHYCOOKING_LI)).getCssValue("background-color")).asHex();
		System.out.println("color hex: "+backgroundColour);
		PeonyAssertion.verifyEquals(backgroundColour, "#f67437",
				"Healthy Cooking is highlighted in orange");
		
		clickMenuNav_HealthyCooking_Link();
		
		PeonyAssertion.verifyTrue(driver.getTitle().contains("Healthy Cooking Videos"),
				"Healthy Cooking Page is loaded correctly");
	}

}
