package ulive;

import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ulive.helper.UliveHomePage_OnboardingHelper;
import ulive.pages.UliveHomePage_MenuNav;
import ulive.util.UliveBaseClass;

/**
 * 
 * This test case tests the onboarding scenario Browser clear cache/cookie load
 * ulive site, verify onboarding overlay. this will set cookie load ulive site
 * again (cookie already set), verify bluebar content load ulive site third
 * time, verify bluebar content changed load ulive site fourth time, verify
 * bluebar is not loaded
 * 
 * @author slu
 * 
 */
public class TC_ULive_Onboarding extends UliveBaseClass 
{
	private UliveHomePage_OnboardingHelper uliveHomePage_OnboardingHelper = new UliveHomePage_OnboardingHelper(driver);

	@Parameters({ "sauceLab", "browser" })
	public TC_ULive_Onboarding(boolean sauceLab, String browser) throws Exception
	{
		super(sauceLab, browser);
	}

	@Test
	public void test() throws Exception 
	{

		loadUliveURL();

		waitImplicitly(10000);

		// verify Onboarding overlay
		uliveHomePage_OnboardingHelper.verifyOnboardingOverlay();
		waitUntilElementVisible(UliveHomePage_MenuNav.MENUNAV_INACTIVE_ICON);

		loadUliveURL();

		uliveHomePage_OnboardingHelper.verifyOnboardingBluebar();

		driver.findElement(
				By.xpath("//div[@class='module media-module lead with-chyron-ext']/div/a/img"))
				.click();

		waitImplicitly(5000);

		uliveHomePage_OnboardingHelper.verifyOnboardingBluebar();

		uliveHomePage_OnboardingHelper.verifyOnboardingBubbles();

	}

}
