package ulive;

import ulive.pages.UliveHomePage_MenuBar;
import ulive.pages.UliveSearchPage;
import ulive.util.KeyWord;
import ulive.util.UliveBaseClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import peony.asserts.PeonyAssertion;

/**
 * 
 * This test case tests the search functionality with autocomplete, returning no
 * results load ulive site, on search textfield of menu bar, search XXXXX verify
 * autocomplete return no results compared to no results from autocomplete api
 * calls click submit. verify XXXXX text on Search page. Verify first fridge
 * magnet is Not displayed on Search page.
 * 
 * @author slu
 * 
 */
public class TC_ULive_SearchNoResults extends UliveBaseClass {

	private String searchTerm = "XXXXX";

	@Parameters({ "browser" })
	public TC_ULive_SearchNoResults(String browser) {
		super(browser);
	}

	@Test
	public void test() throws Exception {

		KeyWord[] keys = autocompleteAPICall(searchTerm);

		// test on ulive
		loadUliveURL("qa");
		closeOnboarding();

		// assert search field on Ulive homepage

		driver.findElement(
				By.xpath(UliveHomePage_MenuBar.HEADER_SEARCH_TEXTFIELD))
				.sendKeys(searchTerm);

		// verify autocomplete
		PeonyAssertion.verifyFalse(isElementPresent(By
				.xpath("//ul[@class='typeahead dropdown-menu']")),
				"autocomplete dropdown is NOT provided");

		Thread.sleep(2000);
		waitUntilElementVisible(UliveHomePage_MenuBar.HEADER_SEARCHSUBMIT_BUTTON);
		driver.findElement(
				By.xpath(UliveHomePage_MenuBar.HEADER_SEARCHSUBMIT_BUTTON))
				.click();

		int i = 0;
		do {
			if (!isElementPresent(By
					.xpath(UliveSearchPage.SEARCHPAGE_SEARCH_TEXTFIELD_2))) {
				Thread.sleep(1000);
			} else {
				break;
			}
		} while (i < 5);

		WebElement e = driver.findElement(By
				.xpath(UliveSearchPage.SEARCHPAGE_SEARCH_TEXTFIELD_2));

		PeonyAssertion.verifyEquals(e.getAttribute("value"), searchTerm,
				"search text is populated correctly");

		// check locator of first fridge magnet
		PeonyAssertion.verifyFalse(isElementPresent(By
				.xpath(UliveSearchPage.FIRSTFRIDGEMAGNET_LINK)),
				"first fridge magnet is NOT displayed");

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
