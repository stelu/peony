package ulive;

import ulive.pages.UliveHomePage_MenuBar;
import ulive.pages.UliveHomePage_MenuNav;
import ulive.pages.UliveSearchPage;
import ulive.pages.UliveTVShowsPage;
import ulive.util.UliveBaseClass;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.internal.seleniumemulation.IsElementPresent;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import peony.asserts.PeonyAssertion;

/**
 * work in progress...
 * postpone...TVShows page getting revamped.
 * 
 * @author slu
 * 
 */
public class TC_ULive_TVShows extends UliveBaseClass {

	@Parameters({ "browser" })
	public TC_ULive_TVShows(String browser) {
		super(browser);
	}

	@Test
	public void test() throws Exception {

		loadUliveURL("qa");
		closeOnboarding();

		String trimmedURL = url.substring(7);


		// TV Shows Link
		verifyTVShowsAndOrigSeriesFB(trimmedURL);

	}

	private void verifyTVShowsAndOrigSeriesFB(String trimmedURL) {
		
		driver.findElement(By.xpath(UliveHomePage_MenuBar.HEADER_TVSHOWS_LINK))
				.click();
		PeonyAssertion.assertTrue(
				driver.getCurrentUrl().contains(trimmedURL + "/shows"),
				"URL for the TV Shows page is correct");
		
		//verify source
		System.out.println(driver.findElement(By.xpath(UliveTVShowsPage.TVSHOWS_SOURCEBAR_1_LINK)).getAttribute("href"));
		
		isElementPresent(By.xpath(UliveTVShowsPage.TVSHOWS_SOURCEBAR_1_LINK));
		isElementPresent(By.xpath(UliveTVShowsPage.TVSHOWS_SOURCEBAR_2_LINK));
		isElementPresent(By.xpath(UliveTVShowsPage.TVSHOWS_SOURCEBAR_3_LINK));
		isElementPresent(By.xpath(UliveTVShowsPage.TVSHOWS_SOURCEBAR_4_LINK));
		isElementPresent(By.xpath(UliveTVShowsPage.TVSHOWS_SOURCEBAR_5_LINK));
		isElementPresent(By.xpath(UliveTVShowsPage.TVSHOWS_SOURCEBAR_6_LINK));
		
		//video on leading module
		driver.findElement(By.xpath(UliveTVShowsPage.TVSHOWS_FIRSTMODULEVIDEO)).isDisplayed();
		String leadingModuleVideo = driver.findElement(By.xpath("//div[@class='module media-module lead with-chyron-ext']/div/a")).getAttribute("href");
		driver.findElement(By.xpath(UliveTVShowsPage.TVSHOWS_FIRSTMODULEVIDEO)).click();
		waitImplicitly(5000);
		PeonyAssertion.assertTrue(driver.getCurrentUrl().contains(leadingModuleVideo), 
				"video page url of leading module is correct");
		PeonyAssertion.assertTrue(isElementPresent(By.xpath("//div[@class='mejs-button mejs-playpause-button mejs-pause']")), 
				"video is playing on start");
	}


	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
