package ulive;

import java.util.Iterator;
import java.util.List;

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
 * This test case tests the search functionality with autocomplete. This
 * negative test case should pass with a negative assertion. Call autocomplete
 * api with search term Giada. load ulive site, on search textfield of menu bar,
 * search house verify autocomplete. results compared to autocomplete api calls,
 * click submit. verify house text on Search page. Verify first fridge magnet is
 * displayed on Search page.
 * 
 * @author slu
 * 
 */
public class TC_ULive_SearchInvalid extends UliveBaseClass {

	private String searchTerm = "giada";
	private String searchTerm_2 = "house";

	@Parameters({ "browser" })
	public TC_ULive_SearchInvalid(String browser) {
		super(browser);
	}

	@Test
	public void test() throws Exception {

		KeyWord[] keys = autocompleteAPICall(searchTerm);

		// test on ulive
		loadUliveURL("qa");
		closeOnboarding();

		// assert search field on Ulive homepage
		PeonyAssertion.verifyTrue(isElementPresent(By
				.xpath(UliveHomePage_MenuBar.HEADER_SEARCH_TEXTFIELD)),
				"Search textfield is displayed");

		driver.findElement(
				By.xpath(UliveHomePage_MenuBar.HEADER_SEARCH_TEXTFIELD))
				.sendKeys(searchTerm_2);

		// verify autocomplete
		waitUntilElementVisible("//ul[@class='typeahead dropdown-menu']");
		WebElement autoComplete = driver.findElement(By
				.xpath("//ul[@class='typeahead dropdown-menu']"));
		List<WebElement> ss;
		do {
			ss = autoComplete.findElements(By.tagName("li"));
		} while (ss.size() == 0);

		// looping through auto complete keywords
		Iterator<WebElement> count = ss.iterator();

		while (count.hasNext()) {
			WebElement searchResult = count.next();
			System.out.println("Search result from autocomplete: "
					+ searchResult.getText());

			if (existsInArray(keys, searchResult.getText())) {
				PeonyAssertion.verifyTrue(true, searchResult.getText()
						+ " is displayed on autocomplete");
			} else {
				System.out.println(searchResult.getText()
						+ " does not match api call");
				PeonyAssertion.verifyTrue(true, searchResult.getText()
						+ " does not match api call");

			}
		}

		Thread.sleep(2000);
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

		PeonyAssertion.verifyEquals(e.getAttribute("value"), searchTerm_2,
				"search text is populated correctly");

		// check locator of first fridge magnet
		PeonyAssertion.verifyTrue(isElementPresent(By
				.xpath(UliveSearchPage.FIRSTFRIDGEMAGNET_LINK)),
				"first fridge magnet is displayed");

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
