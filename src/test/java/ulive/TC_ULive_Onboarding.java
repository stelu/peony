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
public class TC_ULive_Onboarding extends UliveBaseClass {

	@Parameters({ "browser" })
	public TC_ULive_Onboarding(String browser) {
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

		PeonyAssertion.verifyTrue(isElementPresent(By
				.xpath(UliveHomePage_Onboarding.ONBOARDING_PARTNERLOGOS_ICON)),
				"Logos section is displayed");

		waitUntilElementVisible(UliveHomePage_MenuNav.MENUNAV_INACTIVE_ICON);
		// closeOnboarding();

		loadUliveURL("qa");

		PeonyAssertion.verifyTrue(isElementPresent(By
				.xpath(UliveHomePage_Onboarding.ONBOARDING_BLUEBAR_IMAGE)),
				"Blue bar is displayed");

		PeonyAssertion
				.verifyTrue(
						driver.findElement(
								By.xpath(UliveHomePage_Onboarding.ONBOARDING_BLUEBAR_IMAGE))
								.getText()
								.contains(
										"We see that you're new here — welcome!Start exploring"),
						"Bluebar text is correct");

		driver.findElement(
				By.xpath("//div[@class='module media-module lead with-chyron-ext']/div/a/i"))
				.click();

		waitImplicitly(5000);

		PeonyAssertion.verifyTrue(isElementPresent(By
				.xpath(UliveHomePage_Onboarding.ONBOARDING_BLUEBAR_IMAGE)),
				"Blue bar is displayed");

		PeonyAssertion.verifyTrue(isElementPresent(By
				.xpath(UliveHomePage_Onboarding.ONBOARDING_SIDEBAR_TOOLTIP)),
				"Side bar tooltip is displayed");

		PeonyAssertion
				.verifyTrue(
						driver.findElement(
								By.xpath(UliveHomePage_Onboarding.ONBOARDING_SIDEBAR_TOOLTIP))
								.getText()
								.contains(
										"Like what you see? Share this video or find out more about it over here."),
						"Sidebar text is correct");

		PeonyAssertion.verifyTrue(isElementPresent(By
				.xpath(UliveHomePage_Onboarding.ONBOARDING_BELOWBAR_TOOLTIP)),
				"Below bar tooltip is displayed");

		PeonyAssertion
				.verifyTrue(
						driver.findElement(
								By.xpath(UliveHomePage_Onboarding.ONBOARDING_SIDEBAR_TOOLTIP))
								.getText()
								.contains(
										"Ready for another? Find your next video in our recommendation list below."),
						"Sidebar text is correct");

		// WebElement autoComplete = driver.findElement(By
		// .xpath(UliveHomePage_Onboarding.ONBOARDING_BLUEBAR_IMAGE));
		// WebElement e = autoComplete.findElement(By.tagName("span"));
		//
		// System.out.println("message " + autoComplete.getText());
		// System.out.println(driver.findElement(By.xpath("//span[@class='message]")).getText());

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
