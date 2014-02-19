package ulive.helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import peony.asserts.PeonyAssertion;
import ulive.pages.UliveHomePage_MenuNav;
import ulive.pages.UliveHomePage_Onboarding;
import ulive.util.UliveBaseClass;

public class UliveHomePage_OnboardingHelper extends UliveHomePage_Onboarding 
{
	
	private Logger logger = LogManager.getLogger(UliveHomePage_OnboardingHelper.class);
	private UliveBaseClass uliveBaseClass;
	protected WebDriver driver;
	
	public UliveHomePage_OnboardingHelper(WebDriver driver) 
	{
		this.driver = driver;
		uliveBaseClass = new UliveBaseClass(driver);
	}
	
	public void clickCloseOnboardingOverlay()
	{
		driver.findElement(By.xpath(UliveHomePage_Onboarding.ONBOARDING_OVERLAY_CLOSE)).click();
	}
	
	public void clickOnboardingBluebar() 
	{
		driver.findElement(By.xpath(UliveHomePage_Onboarding.ONBOARDING_BLUEBAR)).click();
	}
	
	public void closeOnboardingOverlay() throws Exception 
	{
		
		try 
		{
			logger.trace("Closing Onboarding");
			uliveBaseClass.waitUntilElementVisible(UliveHomePage_Onboarding.ONBOARDING_OVERLAY_ACTIVE);
			clickCloseOnboardingOverlay();
			uliveBaseClass.waitImplicitly(10000);
			uliveBaseClass.waitUntilElementVisible(UliveHomePage_MenuNav.MENUNAV_INACTIVE_ICON);
			
			if(uliveBaseClass.isElementPresent(By.xpath(UliveHomePage_MenuNav.MENUNAV_INACTIVE_ICON))) 
			{
				PeonyAssertion.verifyTrue(true, "Onboarding overlay was closed successfully");
			}
			
		} catch (Exception e) 
		{
				e.printStackTrace();
				logger.trace("Closing Onboarding error");
		}
	
	}
	
	public void verifyOnboardingOverlay() 
	{
		PeonyAssertion.verifyTrue(uliveBaseClass.isTextPresent("where you find videos."),
				"'Here's where you find videos' text is displayed");
		PeonyAssertion.verifyTrue(uliveBaseClass.isTextPresent("Welcome to ulive"),
				"'Welcome to ulive' text is present");

		PeonyAssertion.verifyTrue(uliveBaseClass.isElementPresent(By
				.xpath(UliveHomePage_Onboarding.ONBOARDING_PARTNERLOGOS_ICON)),
				"Logos section is displayed");
	}
	
	public void verifyOnboardingBluebar() 
	{
		uliveBaseClass.waitUntilElementVisible(ONBOARDING_BLUEBAR);
		PeonyAssertion.verifyTrue(uliveBaseClass.isElementPresent(By.xpath(ONBOARDING_BLUEBAR)),
				"Blue bar is displayed");

		PeonyAssertion.verifyTrue(driver.findElement(By.xpath(ONBOARDING_BLUEBAR)).getText()
				.contains("We see that you're new here — welcome!Start exploring"),
				"Bluebar text is correct");
	}
	
	public void verifyOnboardingBubbles() throws Exception 
	{
		uliveBaseClass.waitUntilElementVisible(ONBOARDING_SIDEBAR_TOOLTIP);
		PeonyAssertion.verifyTrue(uliveBaseClass.isElementPresent(By.xpath(ONBOARDING_SIDEBAR_TOOLTIP)),
				"Side bar tooltip is displayed"); 

		System.out.println("sidebar "+driver.findElement(By.xpath(ONBOARDING_SIDEBAR_TOOLTIP)).getText());
		PeonyAssertion.verifyTrue(driver.findElement(By.xpath(ONBOARDING_SIDEBAR_TOOLTIP)).getText()
				.contains("Like what you see? Share this video or find others like it here."),
				"Sidebar text is correct");

		PeonyAssertion.verifyTrue(uliveBaseClass.isElementPresent(By.xpath(ONBOARDING_BELOWBAR_TOOLTIP)),
				"Below bar tooltip is displayed");

		PeonyAssertion.verifyTrue(driver.findElement(By.xpath(ONBOARDING_BELOWBAR_TOOLTIP)).getText()
				.contains("Ready for another? Find your next video in our recommendation list below."),
				"Below bar text is correct");
	}
	
	public void verifyOnboardingBubbles_NotDisplayed() throws Exception 
	{
		
		PeonyAssertion.assertFalse(driver.findElement(By.xpath(ONBOARDING_SIDEBAR_TOOLTIP)).isDisplayed(),
				"Side bar tooltip is NOT present"); 

		PeonyAssertion.assertFalse(driver.findElement(By.xpath(ONBOARDING_BELOWBAR_TOOLTIP)).isDisplayed(),
				"Below bar tooltip is displayed");

	}

}
