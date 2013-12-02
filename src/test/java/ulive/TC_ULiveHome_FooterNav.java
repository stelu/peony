package ulive;

import ulive.pages.UliveHomePage_Footer;
import ulive.util.UliveBaseClass;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import peony.asserts.PeonyAssertion;
import peony.user.User;
import peony.user.UserFactory;

/**
 * This testcase verifies the footer functionalities/links load ulive, scroll
 * footer into view verify all the network icons click on each of the network
 * icons and network shows, verify subsequent pages loaded correctly verify
 * terms and conditions, privacy
 * 
 * @author slu
 * 
 */
public class TC_ULiveHome_FooterNav extends UliveBaseClass {
	private String mainHandle;
	
	@Parameters({ "browser" })
	public TC_ULiveHome_FooterNav(String browser) {
		super(browser);
	}

	@Test
	public void test() throws Exception {

		loadUliveURL("qa");
		closeOnboarding();

		mainHandle = driver.getWindowHandle();

		scrollIntoView(UliveHomePage_Footer.HOMEPAGEFOOTER_NETWORKS_LINK);

		PeonyAssertion.verifyTrue(isTextPresent("MORE FROM OUR PARTNERS"),
				"More From Our Partners text is present on the footer");

		PeonyAssertion.verifyTrue(isElementPresent(By
				.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_NETWORKS_LINK)),
				"Networks link is displayed");

		verifyPartnerShows();

		verifyFooterTerms();
	}

	private void verifyPartnerShows() {
		verifyFooterHGTV();

		verifyFooterDIY();

		verifyFooterFoodNetwork();

		verifyFooterCookingChannel();

		verifyFooterTravelChannel();

		verifyFooterGAC();

		verifyFooterCityEats();
	}

	private void verifyFooterCityEats() {
		// footernav for CityEats
		PeonyAssertion.verifyTrue(isElementPresent(By
				.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_CITYEATS_ICON)),
				"City Eats icon is displayed");
		driver.findElement(
				By.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_CITYEATS_ICON))
				.click();

		switchToWindows("CityEats by Food Network");
		PeonyAssertion.verifyTrue(driver.getTitle().contains("CityEats"),
				"clicking on City Eats icon opens City Eats page.");
		driver.close();
		switchToMainWindow(mainHandle);

		// shows for CityEats
		PeonyAssertion.verifyTrue(isElementPresent(By
				.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_BESTEATS_LINK)),
				"City Eats submenu Best Eats is displayed");
		driver.findElement(
				By.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_BESTEATS_LINK))
				.click();

		switchToWindows("New Orleans Restaurant Reservations");
		PeonyAssertion
				.assertTrue(
						driver.getTitle().contains(
								"New Orleans Restaurant Reservations"),
						"clicking on Best Eats link opens New Orleans Restaurant Reservations page.");
		driver.close();
		switchToMainWindow(mainHandle);

		PeonyAssertion
				.verifyTrue(
						isElementPresent(By
								.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_OUTDOORDINING_LINK)),
						"City Eats submenu Outdoor Dining is displayed");
		driver.findElement(
				By.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_OUTDOORDINING_LINK))
				.click();

		switchToWindows("Al Fresco Dining");
		PeonyAssertion.assertTrue(driver.getTitle()
				.contains("Al Fresco Dining"),
				"clicking on Outdoor Dining link opens Al Fresco Dining page.");
		driver.close();
		switchToMainWindow(mainHandle);

		PeonyAssertion.verifyTrue(isElementPresent(By
				.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_LOYALTY_LINK)),
				"City Eats submenu Loyalty is displayed");
		driver.findElement(
				By.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_LOYALTY_LINK))
				.click();

		switchToWindows("CityEats by Food Network");
		PeonyAssertion.assertTrue(isTextPresent("CityEats Rewards"),
				"clicking on Loyalty link opens CityEats Rewards page.");
		driver.close();
		switchToMainWindow(mainHandle);
	}

	private void verifyFooterGAC() {
		// footernav for GAC
		PeonyAssertion.verifyTrue(isElementPresent(By
				.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_GAC_ICON)),
				"GAC icon is displayed");
		driver.findElement(
				By.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_GAC_ICON)).click();

		switchToWindows("GAC - Great American Country");
		PeonyAssertion
				.verifyTrue(
						driver.getTitle().contains(
								"GAC - Great American Country"),
						"clicking on GAC icon opens GAC - Great American Country page.");
		driver.close();
		switchToMainWindow(mainHandle);

		// shows for GAC
		PeonyAssertion.verifyTrue(isElementPresent(By
				.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_FARMKINGS_LINK)),
				"GAC submenu Farm Kings is displayed");
		driver.findElement(
				By.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_FARMKINGS_LINK))
				.click();

		switchToWindows("Farm Kings : Great American Country");
		PeonyAssertion
				.verifyTrue(
						driver.getTitle().contains(
								"Farm Kings : Great American Country"),
						"clicking on Farm Kings link opens Farm Kings : Great American Country page.");
		driver.close();
		switchToMainWindow(mainHandle);

		PeonyAssertion.verifyTrue(isElementPresent(By
				.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_WILLISCLAN_LINK)),
				"GAC submenu Willis Clan is displayed");
		driver.findElement(
				By.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_WILLISCLAN_LINK))
				.click();

		switchToWindows("The Willis Clan : Great American Country");
		PeonyAssertion
				.verifyTrue(
						driver.getTitle().contains(
								"The Willis Clan : Great American Country"),
						"clicking on Willis Clan link opens The Willis Clan : Great American Country page.");
		driver.close();
		switchToMainWindow(mainHandle);

		PeonyAssertion
				.verifyTrue(
						isElementPresent(By
								.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_CELECRATEAMERICA_LINK)),
						"GAC submenu Celebrate America is displayed");
		driver.findElement(
				By.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_CELECRATEAMERICA_LINK))
				.click();

		switchToWindows("Dear America");
		PeonyAssertion.verifyTrue(driver.getTitle().contains("Dear America"),
				"clicking on Celebrate America link opens Dear America page.");
		driver.close();
		switchToMainWindow(mainHandle);

	}

	private void verifyFooterTravelChannel() {
		// footernav for Travel Channel
		PeonyAssertion
				.verifyTrue(
						isElementPresent(By
								.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_TRAVELCHANNEL_ICON)),
						"Travel Channel icon is displayed");
		driver.findElement(
				By.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_TRAVELCHANNEL_ICON))
				.click();

		switchToWindows("Travel Videos, Shows, and Guides - Travel Channel");
		PeonyAssertion
				.verifyTrue(
						driver.getTitle().contains("Travel Channel"),
						"clicking on Travel Channel icon opens Travel Videos, Shows, and Guides - Travel Channel page.");
		driver.close();
		switchToMainWindow(mainHandle);

		// shows for Travel Channel
		PeonyAssertion.verifyTrue(isElementPresent(By
				.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_ADAMRICHMAN_LINK)),
				"Travel Channel submenu Adam Richman is displayed");
		driver.findElement(
				By.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_ADAMRICHMAN_LINK))
				.click();

		switchToWindows("Adam Richman's Fandemonium");
		PeonyAssertion
				.verifyTrue(
						driver.getTitle()
								.contains("Adam Richman's Fandemonium"),
						"clicking on Adam Richman's link opens Adam Richman's Fandemonium page.");
		driver.close();
		switchToMainWindow(mainHandle);

		PeonyAssertion.verifyTrue(isElementPresent(By
				.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_ROCKMYRV_LINK)),
				"Travel Channel submenu Rock My RV is displayed");
		driver.findElement(
				By.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_ROCKMYRV_LINK))
				.click();

		switchToWindows("Rock My RV");
		PeonyAssertion
				.verifyTrue(driver.getTitle().contains("Rock My RV"),
						"clicking on Rock My RV link opens Rock My RV With Bret Michaels page.");
		driver.close();
		switchToMainWindow(mainHandle);

		PeonyAssertion
				.verifyTrue(
						isElementPresent(By
								.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_HOTELIMPOSSIBLE_LINK)),
						"Travel Channel submenu Hotel Impossible is displayed");
		driver.findElement(
				By.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_HOTELIMPOSSIBLE_LINK))
				.click();

		switchToWindows("Hotel Impossible");
		PeonyAssertion
				.verifyTrue(driver.getTitle().contains("Hotel Impossible"),
						"clicking on Hotel Impossible link opens Hotel Impossible page.");
		driver.close();
		switchToMainWindow(mainHandle);
	}

	private void verifyFooterCookingChannel() {
		// footernav for Cooking Channel
		PeonyAssertion
				.verifyTrue(
						isElementPresent(By
								.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_COOKINGCHANNEL_ICON)),
						"Cooking Channel icon is displayed");
		driver.findElement(
				By.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_COOKINGCHANNEL_ICON))
				.click();

		switchToWindows("Cooking Channel");
		PeonyAssertion.verifyTrue(
				driver.getTitle().contains("Cooking Channel"),
				"clicking on Cooking Channel icon opens Cooking Channel page.");
		driver.close();
		switchToMainWindow(mainHandle);

		// shows for Cooking Channel
		PeonyAssertion
				.verifyTrue(
						isElementPresent(By
								.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_RESTAURANTTAKEOVER_LINK)),
						"Cooking Channel submenu Restaurant TakeOver is displayed");
		driver.findElement(
				By.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_RESTAURANTTAKEOVER_LINK))
				.click();

		switchToWindows("Restaurant Takeover");
		PeonyAssertion
				.verifyTrue(driver.getTitle().contains("Restaurant Takeover"),
						"clicking on Restaurant Takeover link opens Restaurant Takeover page.");
		driver.close();
		switchToMainWindow(mainHandle);

		PeonyAssertion.verifyTrue(isElementPresent(By
				.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_UNIQUEEATS_LINK)),
				"Cooking Channel submenu Unique Eats is displayed");
		driver.findElement(
				By.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_UNIQUEEATS_LINK))
				.click();

		switchToWindows("Unique Eats");
		PeonyAssertion.verifyTrue(driver.getTitle().contains("Unique Eats"),
				"clicking on Unique Eats link opens Unique Eats page.");
		driver.close();
		switchToMainWindow(mainHandle);

		PeonyAssertion
				.verifyTrue(
						isElementPresent(By
								.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_KELSEYESSENTIAL_LINK)),
						"Cooking Channel submenu Kelsey's Essential link is displayed");
		driver.findElement(
				By.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_KELSEYESSENTIAL_LINK))
				.click();

		switchToWindows("Kelsey's Essentials");
		PeonyAssertion
				.verifyTrue(driver.getTitle().contains("Kelsey's Essentials"),
						"clicking on Kelsey's Essentials link opens Kelsey's Essentials page.");
		driver.close();
		switchToMainWindow(mainHandle);

	}

	private void verifyFooterFoodNetwork() {
		// footernav for Food Network
		PeonyAssertion.verifyTrue(isElementPresent(By
				.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_FOODNETWORK_ICON)),
				"Food Network Icon is displayed");
		driver.findElement(
				By.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_FOODNETWORK_ICON))
				.click();

		switchToWindows("Food Network - Easy Recipes, Healthy Eating Ideas and Chef Recipe Videos");
		PeonyAssertion.verifyTrue(driver.getTitle().contains("Food Network"),
				"clicking on Food Network icon opens Food Network page.");
		driver.close();
		switchToMainWindow(mainHandle);

		// shows for Food Network
		PeonyAssertion
				.verifyTrue(
						isElementPresent(By
								.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_CUTTHROATKITCHEN_LINK)),
						"Food Network submenu Cutthroat Kitchen is displayed");
		driver.findElement(
				By.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_CUTTHROATKITCHEN_LINK))
				.click();

		switchToWindows("Cutthroat Kitchen");
		PeonyAssertion
				.verifyTrue(driver.getTitle().contains("Cutthroat Kitchen"),
						"clicking on Cutthroat Kitchen link opens Cutthroat Kitchen page.");
		driver.close();
		switchToMainWindow(mainHandle);

		PeonyAssertion
				.verifyTrue(
						isElementPresent(By
								.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_GREATFOODTRUCK_LINK)),
						"Food Network submeu The Great Food Truck Race is displayed");
		driver.findElement(
				By.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_GREATFOODTRUCK_LINK))
				.click();

		switchToWindows("The Great Food Truck Race");
		PeonyAssertion
				.verifyTrue(
						driver.getTitle().contains("The Great Food Truck Race"),
						"clicking on The Great Food Truck Race link opens The Great Food Truck Race page.");
		driver.close();
		switchToMainWindow(mainHandle);

		PeonyAssertion.verifyTrue(isElementPresent(By
				.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_THESHED_LINK)),
				"Food Network submenu The Shed is displayed");
		driver.findElement(
				By.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_THESHED_LINK))
				.click();

		switchToWindows("The Shed");
		PeonyAssertion.verifyTrue(driver.getTitle().contains("The Shed"),
				"clicking on The Shed link opens The Shed page.");
		driver.close();
		switchToMainWindow(mainHandle);

	}

	private void verifyFooterDIY() {
		// footernav for DIY
		PeonyAssertion.verifyTrue(isElementPresent(By
				.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_DIYNETWORK_ICON)),
				"DIY icon is displayed");
		driver.findElement(
				By.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_DIYNETWORK_ICON))
				.click();

		switchToWindows("DIY Network");
		PeonyAssertion.verifyTrue(driver.getTitle().contains("DIY Network"),
				"clicking on DIY Network icon opens DIY Network page.");
		driver.close();
		switchToMainWindow(mainHandle);

		// shows for DIY
		PeonyAssertion.verifyTrue(isElementPresent(By
				.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_HOLMESISBACK_LINK)),
				"DIY submenu Holmes Is Back is displayed");
		driver.findElement(
				By.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_HOLMESISBACK_LINK))
				.click();

		switchToWindows("Holmes Makes It Right");
		PeonyAssertion
				.verifyTrue(
						driver.getTitle().contains("Holmes Makes It Right"),
						"clicking on Holmes Makes It Right link opens Holmes Makes It Right page.");
		driver.close();
		switchToMainWindow(mainHandle);

		PeonyAssertion.verifyTrue(isElementPresent(By
				.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_BLOGCABIN_LINK)),
				"DIY submenu Blog Cabin is displayed");
		driver.findElement(
				By.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_BLOGCABIN_LINK))
				.click();

		switchToWindows("Blog Cabin");
		PeonyAssertion.verifyTrue(driver.getTitle().contains("Blog Cabin"),
				"clicking on Blog Cabin link opens Blog Cabin page.");
		driver.close();
		switchToMainWindow(mainHandle);

		PeonyAssertion.verifyTrue(isElementPresent(By
				.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_SALVAGEDAWGS_LINK)),
				"DIY submenu Salvage Dawgs is displayed");
		driver.findElement(
				By.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_SALVAGEDAWGS_LINK))
				.click();

		switchToWindows("Salvage Dawgs");
		PeonyAssertion.verifyTrue(driver.getTitle().contains("Salvage Dawgs"),
				"clicking on Salvage Dawgs link opens Salvage Dawgs page.");
		driver.close();
		switchToMainWindow(mainHandle);
	}

	private void verifyFooterHGTV() {
		// FooterNav for HGTV
		PeonyAssertion.verifyTrue(isElementPresent(By
				.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_HGTV_ICON)),
				"HGTV icon is displayed");
		driver.findElement(
				By.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_HGTV_ICON))
				.click();

		switchToWindows("HGTV");
		PeonyAssertion.verifyTrue(driver.getTitle().contains("HGTV"),
				"clicking on HGTV icon opens HGTV page.");
		driver.close();
		switchToMainWindow(mainHandle);

		// shows for HGTV
		PeonyAssertion
				.verifyTrue(
						isElementPresent(By
								.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_BROTHERVSBROTHER_LINK)),
						"HGTV submenu Brother vs Brother is displayed");
		driver.findElement(
				By.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_BROTHERVSBROTHER_LINK))
				.click();

		switchToWindows("Brother Vs. Brother");
		PeonyAssertion
				.verifyTrue(driver.getTitle().contains("Brother Vs. Brother"),
						"clicking on Brother Vs. Brother link opens Brother Vs. Brother page.");
		driver.close();
		switchToMainWindow(mainHandle);

		PeonyAssertion
				.verifyTrue(
						isElementPresent(By
								.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_RENOVATIONRAIDERS_LINK)),
						"HGTV submenu Renovation Raiders is displayed");
		// driver.findElement(By.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_RENOVATIONRAIDERS_LINK)).click();
		// switchToWindows("Renovation Raiders");
		// PeonyAssertion.verifyTrue(driver.getTitle().contains("Renovation Raiders"),
		// "clicking on Renovation Raiders link opens Renovation Raiders page.");
		// driver.close();
		// switchToMainWindow(mainHandle);

		PeonyAssertion.verifyTrue(isElementPresent(By
				.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_LOVEITLISTIT_LINK)),
				"HGTV submenu Love It or List It is displayed");
		driver.findElement(
				By.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_LOVEITLISTIT_LINK))
				.click();

		switchToWindows("Love It Or List It");
		PeonyAssertion
				.verifyTrue(driver.getTitle().contains("Love It Or List It"),
						"clicking on Love It Or List It link opens Love It Or List It page.");
		driver.close();
		switchToMainWindow(mainHandle);
	}

	private void verifyFooterTerms() {
		PeonyAssertion.verifyTrue(
				isTextPresent("2013 Scripps Networks, LLC. All rights reserved"),
				"copyright message is displayed");

		PeonyAssertion.verifyTrue(isElementPresent(By
				.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_CONTACTUS_LINK)),
				"Contact Us link is displayed");
		PeonyAssertion
				.verifyEquals(
						driver.findElement(
								By.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_CONTACTUS_LINK))
								.getAttribute("href"), url + "/contact-us",
						"Contact Us link is correct");
		PeonyAssertion.verifyTrue(isElementPresent(By
				.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_FAQ_LINK)),
				"FAQ link is displayed");
		PeonyAssertion.verifyEquals(
				driver.findElement(
						By.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_FAQ_LINK))
						.getAttribute("href"), url + "/help-faq",
				"FAQ link is correct");
		PeonyAssertion.verifyTrue(isElementPresent(By
				.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_ADCHOICES_LINK)),
				"AD Choices icon is displayed");
		PeonyAssertion
				.verifyTrue(
						isElementPresent(By
								.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_INFRINGEMENTS_LINK)),
						"Infringement link is displayed");
		PeonyAssertion
				.verifyEquals(
						driver.findElement(
								By.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_INFRINGEMENTS_LINK))
								.getAttribute("href"), url + "/infringements",
						"Infringement link is correct");
		PeonyAssertion.verifyTrue(isElementPresent(By
				.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_TERMS_LINK)),
				"Terms of Use link is displayed");
		PeonyAssertion
				.verifyEquals(
						driver.findElement(
								By.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_TERMS_LINK))
								.getAttribute("href"),
						"http://www.scrippsnetworksinteractive.com/terms-of-use/",
						"Terms of Use link is correct");
		PeonyAssertion.verifyTrue(isElementPresent(By
				.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_PRIVACY_LINK)),
				"Privacy Policy link is displayed");
		PeonyAssertion
				.verifyEquals(
						driver.findElement(
								By.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_PRIVACY_LINK))
								.getAttribute("href"),
						"http://www.scrippsnetworksinteractive.com/privacy-policy/",
						"Privacy Policy link is correct");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
