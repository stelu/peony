package ulive;

import java.util.Iterator;
import java.util.List;

import ulive.pages.UliveHomePage_MenuBar;
import ulive.pages.UliveHomePage_MenuNav;
import ulive.pages.UliveHomePage_Onboarding;
import ulive.pages.UliveSearchPage;
import ulive.util.UliveBaseClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import peony.asserts.PeonyAssertion;


/**
 * work in progress...
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
public class TC_ULive_OnboardingClose extends UliveBaseClass {

	@Parameters({ "browser" })
	public TC_ULive_OnboardingClose(String browser) {
		super(browser);
	}

	@Test
	public void test() throws Exception {

		loadUliveURL("qa");

		waitImplicitly(10000);

		// verify Onboarding overlay
		PeonyAssertion.verifyTrue(isTextPresent("where you find videos."),
				"'Here's where you find videos' text is displayed");
		PeonyAssertion.verifyTrue(isTextPresent("Welcome to ulive"),
				"'Welcome to ulive' text is present");

		PeonyAssertion.verifyTrue(
				isElementPresent(By.xpath(UliveHomePage_Onboarding.ONBOARDING_PARTNERLOGOS_ICON)),
				"Logos section is displayed");

		closeOnboarding();

		PeonyAssertion.assertFalse(driver.findElement(By.xpath(UliveHomePage_Onboarding.ONBOARDING_BLUEBAR_IMAGE)).isDisplayed(),
				"Blue bar is NOT displayed");
		
		driver.findElement(
				By.xpath("//div[@class='module media-module lead with-chyron-ext']/div/a/i"))
				.click();
		
		waitImplicitly(5000);
		
		PeonyAssertion.assertFalse(
				driver.findElement(By.xpath(UliveHomePage_Onboarding.ONBOARDING_BLUEBAR_IMAGE)).isDisplayed(),
				"Blue bar is NOT displayed");
		
//		System.out.println(driver.findElement(By.xpath(UliveHomePage_Onboarding.ONBOARDING_SIDEBAR_TOOLTIP)).getText());
//		System.out.println(driver.findElement(By.xpath(UliveHomePage_Onboarding.ONBOARDING_BELOWBAR_TOOLTIP)).isEnabled());
		PeonyAssertion.assertFalse(
				isElementPresent(By.xpath("//div[@class='module onboardTooltip show-tooltip']")),
				"Side bar tooltip is NOT displayed");
//
//		PeonyAssertion.assertFalse(isElementPresent(By
//				.xpath(UliveHomePage_Onboarding.ONBOARDING_BELOWBAR_TOOLTIP)),
//				"Below bar tooltip is NOT displayed");

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
