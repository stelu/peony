package ulive;

import ulive.pages.UliveHomePage_MenuNav;
import ulive.util.UliveBaseClass;
import ulive.util.MouseHover;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import peony.asserts.PeonyAssertion;

/**
 * This testcase verifies the menu nav on the homepage load ulive, verify each
 * section menu mouse over each section menu and verify categories Note: this is
 * dependent on Content/CMS as it may change.
 * 
 * @author slu
 * 
 */
public class TC_ULiveHome_MenuSlider extends UliveBaseClass {
	// Logger logger = LogManager.getLogger(TC_ULiveHome_MenuSlider.class);
	private MouseHover mouseHover = new MouseHover(driver);

	@Parameters({ "browser" })
	public TC_ULiveHome_MenuSlider(String browser) {
		super(browser);
	}

	@Test
	public void test() throws Exception {

		loadUliveURL("qa");
		closeOnboarding();

		// menuSlider
		verifyMenuNav();
		
		verifySocialShareOnMenuNav();

		// Full Episode sublinks
		// verifyFullEpisodeSubmenu();

		// Original Series Link
		// verifyOriginalSeriesSubmenu();

		// validate Food submenus
		verifyFoodsSubmenu();

		// validate Parenting submenus
		verifyParentingSubmenu();

		// validate Wellness submenus
		verifyWellnessSubmenu();

		// validate Home submenus
		verifyHomeVideosSubmenu();

		// validate Travel submenus
		verifyTravelSubmenu();

		// validate Holiday submenu
		// verifyHolidaySubmenu();

		// validate FoodNetwork submenus
		// verifyFoodNetworkSubmenu();
	}

	private void verifyFoodNetworkSubmenu() {
		PeonyAssertion.assertTrue(driver.findElement(
				By.xpath(UliveHomePage_MenuNav.MENUNAV_FOODNETWORK_LINK))
				.isDisplayed());
		mouseHover.mouseOver(UliveHomePage_MenuNav.MENUNAV_FOODNETWORK_LINK);

	}

	private void verifyHolidaySubmenu() {
		PeonyAssertion.assertTrue(driver.findElement(
				By.xpath(UliveHomePage_MenuNav.MENUNAV_HOLIDAY_LINK))
				.isDisplayed());
		mouseHover.mouseOver(UliveHomePage_MenuNav.MENUNAV_HOLIDAY_LINK);
		PeonyAssertion.assertTrue(driver.findElement(
				By.xpath(UliveHomePage_MenuNav.HOLIDAY_4THOFJULY_LINK))
				.isDisplayed());
	}

	private void verifyTravelSubmenu() {
		PeonyAssertion.assertTrue(
				driver.findElement(
						By.xpath(UliveHomePage_MenuNav.MENUNAV_TRAVEL_LINK))
						.isDisplayed(), "Travel link is displayed");
		mouseHover.mouseOver(UliveHomePage_MenuNav.MENUNAV_TRAVEL_LINK);
		PeonyAssertion
				.assertTrue(
						driver.findElement(
								By.xpath(UliveHomePage_MenuNav.TRAVEL_CITIESTOVISIT_LINK))
								.isDisplayed(),
						"Cities to Visit link is displayed on hovering over Travel menu");
		PeonyAssertion
				.assertTrue(
						driver.findElement(
								By.xpath(UliveHomePage_MenuNav.TRAVEL_COUNTRIESTOVISIT_LINK))
								.isDisplayed(),
						"Countries to Visit link is displayed on hovering over Travel menu");
		PeonyAssertion.assertTrue(
				driver.findElement(
						By.xpath(UliveHomePage_MenuNav.TRAVEL_WHERETOEAT_LINK))
						.isDisplayed(),
				"Where to Eat link is displayed on hovering over Travel menu");
		PeonyAssertion
				.assertTrue(
						driver.findElement(
								By.xpath(UliveHomePage_MenuNav.TRAVEL_WHERETOSTAY_LINK))
								.isDisplayed(),
						"Where to Stay link is displayed on hovering over Travel menu");
		PeonyAssertion
				.assertTrue(
						driver.findElement(
								By.xpath(UliveHomePage_MenuNav.TRAVEL_PLACESTOSEE_LINK))
								.isDisplayed(),
						"Places to See link is displayed on hovering over Travel menu");
		PeonyAssertion
				.assertTrue(
						driver.findElement(
								By.xpath(UliveHomePage_MenuNav.TRAVEL_TRAVELADVENTURES_LINK))
								.isDisplayed(),
						"Travel Adventures link is displayed on hovering over Travel menu");
		PeonyAssertion
				.assertTrue(
						driver.findElement(
								By.xpath(UliveHomePage_MenuNav.TRAVEL_ROMANTICGETAWAYS_LINK))
								.isDisplayed(),
						"Romantic Getaways link is displayed on hovering over Travel menu");
		PeonyAssertion
				.assertTrue(
						driver.findElement(
								By.xpath(UliveHomePage_MenuNav.TRAVEL_BEACHTRAVEL_LINK))
								.isDisplayed(),
						"Beach Travel link is displayed on hovering over Travel menu");
		PeonyAssertion.assertTrue(
				driver.findElement(
						By.xpath(UliveHomePage_MenuNav.TRAVEL_GIRLTRIPS_LINK))
						.isDisplayed(),
				"Girl Trips link is displayed on hovering over Travel menu");
		PeonyAssertion.assertTrue(
				driver.findElement(
						By.xpath(UliveHomePage_MenuNav.TRAVEL_MANCATIONS_LINK))
						.isDisplayed(),
				"Mancations link is displayed on hovering over Travel menu");
		PeonyAssertion
				.assertTrue(
						driver.findElement(
								By.xpath(UliveHomePage_MenuNav.TRAVEL_TRAVELWITHKIDS_LINK))
								.isDisplayed(),
						"Travel With Kids link is displayed on hovering over Travel menu");
	}

	private void verifyHomeVideosSubmenu() {
		PeonyAssertion
				.assertTrue(
						driver.findElement(
								By.xpath(UliveHomePage_MenuNav.MENUNAV_HOMEVIDEOS_LINK))
								.isDisplayed(),
						"Home 'videos' link is displayed");
		mouseHover.mouseOver(UliveHomePage_MenuNav.MENUNAV_HOMEVIDEOS_LINK);
		PeonyAssertion.assertTrue(
				driver.findElement(
						By.xpath(UliveHomePage_MenuNav.HOME_ROOMIDEAS_LINK))
						.isDisplayed(),
				"Room Ideas link is displayed on hovering over Home videos");
		PeonyAssertion.assertTrue(
				driver.findElement(
						By.xpath(UliveHomePage_MenuNav.HOME_DESIGNSTYLES_LINK))
						.isDisplayed(),
				"Design Styles link is displayed on hovering over Home videos");
		PeonyAssertion
				.assertTrue(
						driver.findElement(
								By.xpath(UliveHomePage_MenuNav.HOME_DESIGNPROJECTS_LINK))
								.isDisplayed(),
						"Design Projects link is displayed on hovering over Home videos");
		PeonyAssertion.assertTrue(
				driver.findElement(
						By.xpath(UliveHomePage_MenuNav.HOME_COLORS_LINK))
						.isDisplayed(),
				"Colors link is displayed on hovering over Home videos");
		PeonyAssertion
				.assertTrue(
						driver.findElement(
								By.xpath(UliveHomePage_MenuNav.HOME_PAINTINGIDEAS_LINK))
								.isDisplayed(),
						"Paining Ideas link is displayed on hovering over Home videos");
		PeonyAssertion
				.assertTrue(
						driver.findElement(
								By.xpath(UliveHomePage_MenuNav.HOME_HOMETYPECOLLECTION_LINK))
								.isDisplayed(),
						"Home Type Collection link is displayed on hovering over Home videos");
		PeonyAssertion
				.assertTrue(
						driver.findElement(
								By.xpath(UliveHomePage_MenuNav.HOME_STRUCTURALIMPROVEMENTS_LINK))
								.isDisplayed(),
						"Structural Improvements link is displayed on hovering over Home videos");
		PeonyAssertion.assertTrue(
				driver.findElement(
						By.xpath(UliveHomePage_MenuNav.HOME_LANDSCAPING_LINK))
						.isDisplayed(),
				"Landscaping link is displayed on hovering over Home videos");
		PeonyAssertion.assertTrue(
				driver.findElement(
						By.xpath(UliveHomePage_MenuNav.HOME_RENOVATIONS_LINK))
						.isDisplayed(),
				"Renovations link is displayed on hovering over Home videos");
		PeonyAssertion
				.assertTrue(
						driver.findElement(
								By.xpath(UliveHomePage_MenuNav.HOME_BUYINGAHOUSE_LINK))
								.isDisplayed(),
						"Buying a House link is displayed on hovering over Home videos");
		PeonyAssertion
				.assertTrue(
						driver.findElement(
								By.xpath(UliveHomePage_MenuNav.HOME_SELLINGYOURHOUSE_LINK))
								.isDisplayed(),
						"Selling Your House link is displayed on hovering over Home videos");
		PeonyAssertion
				.assertTrue(
						driver.findElement(
								By.xpath(UliveHomePage_MenuNav.HOME_STAGINGANDTOURS_LINK))
								.isDisplayed(),
						"Staging and Tours link is displayed on hovering over Home videos");
		PeonyAssertion
				.assertTrue(
						driver.findElement(
								By.xpath(UliveHomePage_MenuNav.HOME_HOMEINSPECTIONS_LINK))
								.isDisplayed(),
						"Home Inspections link is displayed on hovering over Home videos");
		PeonyAssertion
				.assertTrue(
						driver.findElement(
								By.xpath(UliveHomePage_MenuNav.HOME_HOMEBUDGETPLANNING_LINK))
								.isDisplayed(),
						"Home Budget Planning link is displayed on hovering over Home videos");
		PeonyAssertion
				.assertTrue(
						driver.findElement(
								By.xpath(UliveHomePage_MenuNav.HOME_INTLHOMETOURS_LINK))
								.isDisplayed(),
						"International Home Tours link is displayed on hovering over Home videos");
	}

	private void verifyWellnessSubmenu() {
		PeonyAssertion.assertTrue(
				driver.findElement(
						By.xpath(UliveHomePage_MenuNav.MENUNAV_WELLNESS_LINK))
						.isDisplayed(), "Wellness link is displayed");
		mouseHover.mouseOver(UliveHomePage_MenuNav.MENUNAV_WELLNESS_LINK);
		PeonyAssertion
				.assertTrue(
						driver.findElement(
								By.xpath(UliveHomePage_MenuNav.WELLNESS_HEALTHYCOOKING_LINK))
								.isDisplayed(),
						"Healthy Cooking link is displayed on hovering over Wellness menu");
		PeonyAssertion.assertTrue(
				driver.findElement(
						By.xpath(UliveHomePage_MenuNav.WELLNESS_EXERCISE_LINK))
						.isDisplayed(),
				"Exercise link is displayed on hovering over Wellness menu");
		PeonyAssertion
				.assertTrue(
						driver.findElement(
								By.xpath(UliveHomePage_MenuNav.WELLNESS_WEIGHTLOSS_LINK))
								.isDisplayed(),
						"Weightloss link is displayed on hovering over Wellness menu");
		PeonyAssertion
				.assertTrue(
						driver.findElement(
								By.xpath(UliveHomePage_MenuNav.WELLNESS_MINDANDBODY_LINK))
								.isDisplayed(),
						"Mind and Body link is displayed on hovering over Wellness menu");
	}

	private void verifyParentingSubmenu() {
		PeonyAssertion.assertTrue(
				driver.findElement(
						By.xpath(UliveHomePage_MenuNav.MENUNAV_PARENTING_LINK))
						.isDisplayed(), "Parenting link is displayed");
		mouseHover.mouseOver(UliveHomePage_MenuNav.MENUNAV_PARENTING_LINK);
		PeonyAssertion
				.assertTrue(
						driver.findElement(
								By.xpath(UliveHomePage_MenuNav.PARENTING_COOKINGFORKIDS_LINK))
								.isDisplayed(),
						"Cooking For Kids link is displayed on hovering over Parenting menu");
		PeonyAssertion
				.assertTrue(
						driver.findElement(
								By.xpath(UliveHomePage_MenuNav.PARENTING_BAKINGWITHKIDS_LINK))
								.isDisplayed(),
						"Baking With Kids link is displayed on hovering over Parenting menu");
		PeonyAssertion
				.assertTrue(
						driver.findElement(
								By.xpath(UliveHomePage_MenuNav.PARENTING_ROOMDESIGNFORKIDS_LINK))
								.isDisplayed(),
						"Room Design For Kids is displayed on hovering over Parenting menu");
		PeonyAssertion
				.assertTrue(
						driver.findElement(
								By.xpath(UliveHomePage_MenuNav.PARENTING_TRAVELINGWITHKIDS_LINK))
								.isDisplayed(),
						"Traveling with Kids link is displayed on hovering over Parenting menu");
	}

	private void verifyFoodsSubmenu() {
		PeonyAssertion.assertTrue(
				driver.findElement(
						By.xpath(UliveHomePage_MenuNav.MENUNAV_FOOD_LINK))
						.isDisplayed(), "Food link is displayed");
		mouseHover.mouseOver(UliveHomePage_MenuNav.MENUNAV_FOOD_LINK);
		PeonyAssertion
				.assertTrue(
						driver.findElement(
								By.xpath(UliveHomePage_MenuNav.FOOD_FAVORITECUISINE_LINK))
								.isDisplayed(),
						"Favorite Cuisine link is displayed on hovering over Food menu");
		PeonyAssertion.assertTrue(
				driver.findElement(
						By.xpath(UliveHomePage_MenuNav.FOOD_AROUNDUS_LINK))
						.isDisplayed(),
				"Around US link is displayed on hovering over Food menu");
		PeonyAssertion
				.assertTrue(
						driver.findElement(
								By.xpath(UliveHomePage_MenuNav.FOOD_POPULARDISHES_LINK))
								.isDisplayed(),
						"Popular Dishes link is displayed on hovering over Food menu");
		PeonyAssertion
				.assertTrue(
						driver.findElement(
								By.xpath(UliveHomePage_MenuNav.FOOD_POPULARINGREDIENTS_LINK))
								.isDisplayed(),
						"Popular Ingredients link is displayed on hovering over Food menu");
		PeonyAssertion
				.assertTrue(
						driver.findElement(
								By.xpath(UliveHomePage_MenuNav.FOOD_QUICKANDEASYCOOKING_LINK))
								.isDisplayed(),
						"Quick and Easy Cooking link is displayed on hovering over Food menu");
		PeonyAssertion
				.assertTrue(
						driver.findElement(
								By.xpath(UliveHomePage_MenuNav.FOOD_HEALTHYCOOKING_LINK))
								.isDisplayed(),
						"Healthy Cooking link is displayed on hovering over Food menu");
		PeonyAssertion
				.assertTrue(
						driver.findElement(
								By.xpath(UliveHomePage_MenuNav.FOOD_COOKINGTECHNIQUES_LINK))
								.isDisplayed(),
						"Cooking Techniques link is displayed on hovering over Food menu");
		PeonyAssertion.assertTrue(
				driver.findElement(
						By.xpath(UliveHomePage_MenuNav.FOOD_SLOWCOOKING_LINK))
						.isDisplayed(),
				"Slow Cooking link is displayed on hovering over Food menu");
		PeonyAssertion.assertTrue(
				driver.findElement(
						By.xpath(UliveHomePage_MenuNav.FOOD_GRILLING_LINK))
						.isDisplayed(),
				"Grilling link is displayed on hovering over Food menu");
		PeonyAssertion.assertTrue(
				driver.findElement(
						By.xpath(UliveHomePage_MenuNav.FOOD_BAKING_LINK))
						.isDisplayed(),
				"Baking link is displayed on hovering over Food menu");
		PeonyAssertion.assertTrue(
				driver.findElement(
						By.xpath(UliveHomePage_MenuNav.FOOD_PARTYFOOD_LINK))
						.isDisplayed(),
				"Party Food link is displayed on hovering over Food menu");
		PeonyAssertion
				.assertTrue(
						driver.findElement(
								By.xpath(UliveHomePage_MenuNav.FOOD_COOKINGFORKIDS_LINK))
								.isDisplayed(),
						"Cooking For Kids link is displayed on hovering over Food menu");
		PeonyAssertion.assertTrue(
				driver.findElement(
						By.xpath(UliveHomePage_MenuNav.FOOD_PARTYIDEAS_LINK))
						.isDisplayed(),
				"Party Ideas link is displayed on hovering over Food menu");
		PeonyAssertion
				.assertTrue(
						driver.findElement(
								By.xpath(UliveHomePage_MenuNav.FOOD_PARTYDESSERTS_LINK))
								.isDisplayed(),
						"Party Desserts link is displayed on hovering over Food menu");
		PeonyAssertion
				.assertTrue(
						driver.findElement(
								By.xpath(UliveHomePage_MenuNav.FOOD_DRINKSANDCOCKTAILS_LINK))
								.isDisplayed(),
						"Drinks And Cocktails link is displayed on hovering over Food menu");
	}

	// private void verifyOriginalSeriesSubmenu() {
	// PeonyAssertion.assertTrue(driver.findElement(By.xpath(UliveHomePage_MenuNav.subMenu_OriginalSeriesLink)).isDisplayed(),
	// "Original Series link is displayed");
	// }

	private void verifyFullEpisodeSubmenu() {
		// mouse-over Full Episodes link to get submenus
		PeonyAssertion
				.assertTrue(
						driver.findElement(
								By.xpath(UliveHomePage_MenuNav.MENUNAV_FULLEPISODES_LINK))
								.isDisplayed(),
						"Full Episode link is displayed");
		mouseHover.mouseOver(UliveHomePage_MenuNav.MENUNAV_FULLEPISODES_LINK);
		PeonyAssertion
				.assertTrue(
						driver.findElement(
								By.xpath(UliveHomePage_MenuNav.FULLEPISODES_DINEOUT_LINK))
								.isDisplayed(),
						"Dine Out link is displayed on hovering over Full Episode menu");
		PeonyAssertion
				.assertTrue(
						driver.findElement(
								By.xpath(UliveHomePage_MenuNav.FULLEPISODES_RESTAURANT_LINK))
								.isDisplayed(),
						"Restaurant link is displayed on hovering over Full Episode menu");
		PeonyAssertion
				.assertTrue(
						driver.findElement(
								By.xpath(UliveHomePage_MenuNav.FULLEPISODES_COOKINGCOMPETITION_LINK))
								.isDisplayed(),
						"Cooking Competition link is displayed on hovering over Full Episode menu");
		PeonyAssertion
				.assertTrue(
						driver.findElement(
								By.xpath(UliveHomePage_MenuNav.FULLEPISODES_REALESTATE_LINK))
								.isDisplayed(),
						"Real Estate link is displayed on hovering over Full Episode menu");
		PeonyAssertion
				.assertTrue(
						driver.findElement(
								By.xpath(UliveHomePage_MenuNav.FULLEPISODES_TRAVEL_LINK))
								.isDisplayed(),
						"Travel link is displayed on hovering over Full Episode menu");
		PeonyAssertion
				.assertTrue(
						driver.findElement(
								By.xpath(UliveHomePage_MenuNav.FULLEPISODES_SCARY_LINK))
								.isDisplayed(),
						"Scary link is displayed on hovering over Full Episode menu");
	}

	private void verifyMenuNav() {
		PeonyAssertion.assertTrue(
				driver.findElement(
						By.xpath(UliveHomePage_MenuNav.MENUNAV_INACTIVE_ICON))
						.isDisplayed(), "Menu Navigator is closed");

		// click menuSlider and validate elements
		driver.findElement(
				By.xpath(UliveHomePage_MenuNav.MENUNAV_INACTIVE_ICON)).click();

		// validate Home link
		PeonyAssertion.assertTrue(
				driver.findElement(
						By.xpath(UliveHomePage_MenuNav.MENUNAV_ACTIVE_ICON))
						.isDisplayed(),
				"Menu Navigator is open after clicking on the Menu button");
		driver.findElement(By.xpath(UliveHomePage_MenuNav.MENUNAV_ACTIVE_ICON))
				.click();
		PeonyAssertion.assertTrue(
				driver.findElement(
						By.xpath(UliveHomePage_MenuNav.MENUNAV_INACTIVE_ICON))
						.isDisplayed(),
				"Menu Navigator is closed after clicking on the Menu button");

		// validate Full Episodes link and sublinks
		driver.findElement(
				By.xpath(UliveHomePage_MenuNav.MENUNAV_INACTIVE_ICON)).click();
		waitUntilElementVisible(UliveHomePage_MenuNav.MENUNAV_ACTIVE_ICON);
	}
	
	private void verifySocialShareOnMenuNav() {
		
		if(isElementPresent(By.xpath(UliveHomePage_MenuNav.MENUNAV_INACTIVE_ICON))) {
			driver.findElement(
					By.xpath(UliveHomePage_MenuNav.MENUNAV_INACTIVE_ICON)).click();
		}
		
		PeonyAssertion.assertTrue(isTextPresent("Follow uLive"),
				"\"Follow Ulive\" is displayed");

		// verify facebook, twitter, and google+ icons
		PeonyAssertion.assertTrue(isElementPresent(By
				.cssSelector(UliveHomePage_MenuNav.MENUNAV_FACEBOOKCSS_ICON)),
				"Facebook icon is displayed on menu nav");
		
		PeonyAssertion.assertTrue(isElementPresent(By
				.cssSelector(UliveHomePage_MenuNav.MENUNAV_TWITTERCSS_ICON)),
				"Twitter icon is displayed on menu nav");
	
		PeonyAssertion.assertTrue(isElementPresent(By
				.cssSelector(UliveHomePage_MenuNav.MENUNAV_GOOGLEPLUSCSS_ICON)),
				"Google+ icon is displayed on menu nav");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
