package ulive;

import ulive.pages.UliveHomePage_MenuBar;
import ulive.pages.UliveHomePage_MenuNav;
import ulive.pages.UliveSearchPage;
import ulive.util.UliveBaseClass;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import peony.asserts.PeonyAssertion;

/**
 * This testcase tests the Menu header bar load ulive, verify page title on
 * homepage. click ulive logo and ulive homepage from redirecting from logo
 * verify search textfield and search submit button are displayed verify TV
 * Shows and Original Series are displayed on menu header click menu nav, verify
 * TV Shows and Original Series are NOT repeated there, close menu nav resize
 * browser to (480, 1024), verify TV Shows and Original Series are not displayed
 * on menu header click menu nav, verify TV Shows and Original Series are
 * displayed
 * 
 * @author slu
 * 
 */
public class TC_ULiveHome_MenuBar extends UliveBaseClass {

	@Parameters({ "browser" })
	public TC_ULiveHome_MenuBar(String browser) {
		super(browser);
	}

	@Test
	public void test() throws Exception {

		loadUliveURL("qa");
		closeOnboarding();

		String trimmedURL = url.substring(7);
		// assert page title
		PeonyAssertion.verifyTrue(
				driver.getTitle().contains(
						"Video On Recipes, Design, Home, Travel, Parenting"),
				"Page title is correct");

		// assert items on menu bar
		// Ulive Logo
		PeonyAssertion.verifyTrue(
				driver.findElement(
						By.xpath(UliveHomePage_MenuBar.HEADER_ULIVELOGO_ICON))
						.isDisplayed(), "ulive logo is displayed");
		driver.findElement(
				By.xpath(UliveHomePage_MenuBar.HEADER_ULIVELOGO_ICON)).click();
		PeonyAssertion.verifyEquals(
				driver.findElement(
						By.xpath(UliveHomePage_MenuBar.HEADER_ULIVELOGO_ICON))
						.getAttribute("href"), url + "/",
				"uLive url for the ULive logo is incorrect");

		/**
		 * As of 9/7/13, removed Today link
		 */
		// //Today Link
		// PeonyAssertion.verifyTrue(driver.findElement(By.xpath(UliveHomePage_MenuBar.HEADER_TODAY_LINK)).isDisplayed(),
		// "Today link is displayed");
		// driver.findElement(By.xpath(UliveSearchPage.searchPage_SearchTextField)).click();
		// waitUntilElementVisible(UliveHomePage_MenuBar.HEADER_BROWSER_LINK);
		// PeonyAssertion.assertTrue(driver.getCurrentUrl().contains(trimmedURL
		// + "/today"),
		// "URL for the Today page is correct");

		// //Browse Link
		// PeonyAssertion.assertTrue(driver.findElement(By.xpath(UliveHomePage_MenuBar.HEADER_BROWSER_LINK)).isDisplayed());
		// driver.findElement(By.xpath(UliveHomePage_MenuBar.HEADER_BROWSER_LINK)).click();
		// waitUntilElementPresent(By.xpath(UliveSearchPage.searchPage_SubmitButton));

		verifySearch();

		// TV Shows Link
		verifyTVShowsAndOrigSeriesFB(trimmedURL);

		verifyTVShowsAndOrigSeriesResized();
	}

	private void verifyTVShowsAndOrigSeriesResized() {
		driver.manage().window().setSize(new Dimension(480, 1024));
		PeonyAssertion
				.assertFalse(
						driver.findElement(
								By.xpath(UliveHomePage_MenuBar.HEADER_TVSHOWS_LINK))
								.isDisplayed(),
						"TV Shows header is NOT displayed after resizing window to mobile length of 480");
		PeonyAssertion
				.assertFalse(
						driver.findElement(
								By.xpath(UliveHomePage_MenuBar.HEADER_ORIGINALSERIES_LINK))
								.isDisplayed(),
						"Original Series header is NOT displayed after resizing window to mobile length of 480");

		driver.findElement(
				By.xpath(UliveHomePage_MenuBar.MENUNAV_INACTIVE_ICON)).click();
		PeonyAssertion
				.assertTrue(
						driver.findElement(
								By.xpath(UliveHomePage_MenuNav.MENUNAV_TVSHOWS_LINK))
								.isDisplayed(),
						"TV Shows is displayed in subNav after resizing window to mobile length of 480");
		PeonyAssertion
				.assertTrue(
						driver.findElement(
								By.xpath(UliveHomePage_MenuNav.MENUNAV_ORIGINALSERIES_LINK))
								.isDisplayed(),
						"Original Series is displayed in subNav after resizing window to mobile length of 480");
	}

	private void verifyTVShowsAndOrigSeriesFB(String trimmedURL) {
		PeonyAssertion.assertTrue(
				driver.findElement(
						By.xpath(UliveHomePage_MenuBar.HEADER_TVSHOWS_LINK))
						.isDisplayed(), "TV Shows header is displayed");
		driver.findElement(By.xpath(UliveHomePage_MenuBar.HEADER_TVSHOWS_LINK))
				.click();
		PeonyAssertion.assertTrue(
				driver.getCurrentUrl().contains(trimmedURL + "/shows"),
				"URL for the TV Shows page is correct");

		// Original Series
		PeonyAssertion
				.assertTrue(
						driver.findElement(
								By.xpath(UliveHomePage_MenuBar.HEADER_ORIGINALSERIES_LINK))
								.isDisplayed(),
						"Original Series header is displayed");
		driver.findElement(
				By.xpath(UliveHomePage_MenuBar.HEADER_ORIGINALSERIES_LINK))
				.click();
		PeonyAssertion.assertTrue(
				driver.getCurrentUrl()
						.contains(trimmedURL + "/ulive-originals"),
				"URL for the Original Series page is correct");

		driver.findElement(
				By.xpath(UliveHomePage_MenuBar.MENUNAV_INACTIVE_ICON)).click();
		PeonyAssertion.assertFalse(
				driver.findElement(
						By.xpath(UliveHomePage_MenuNav.MENUNAV_TVSHOWS_LINK))
						.isDisplayed(), "TV Shows is NOT displayed in subNav");
		PeonyAssertion
				.assertFalse(
						driver.findElement(
								By.xpath(UliveHomePage_MenuNav.MENUNAV_ORIGINALSERIES_LINK))
								.isDisplayed(),
						"Original Series is NOT displayed in subNav");
		driver.findElement(
				By.xpath(UliveHomePage_MenuBar.MENUNAV_INACTIVE_ICON)).click();
	}

	private void verifySearch() {
		PeonyAssertion.assertTrue(
				driver.findElement(
						By.xpath(UliveSearchPage.SEARCHPAGE_SEARCH_TEXTFIELD))
						.isDisplayed(), "Search textfield is displayed");
		PeonyAssertion.assertTrue(
				driver.findElement(
						By.xpath(UliveSearchPage.SEARCHPAGE_SUBMIT_BUTTON))
						.isDisplayed(), "Search submit button is displayed");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
