package ulive;

import ulive.pages.UliveHomePage_SourceLogo;
import ulive.util.UliveBaseClass;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import peony.asserts.PeonyAssertion;

/**
 * 
 * This test case tests the source logo section of the ulive homepage.
 * clear cache/cookie load ulive site, close onboarding overlay. 
 * verify source logo section text, verify logos and click on logo.
 * verify url of source video page.  Resize to 480, verify source logo 
 * section is not loaded.ooo
 * 
 * @author slu
 * 
 */
public class TC_ULive_SourceLogo extends UliveBaseClass {

	@Parameters({ "browser" })
	public TC_ULive_SourceLogo(String browser) {
		super(browser);
	}

	@Test
	public void test() throws Exception {
		
		
		loadUliveURL("qa");

		closeOnboarding();
	
		verifySourceLogoText();
		
		verifyHGTVLogo();
		
		verifyFoodNetworkLogo();
		
		verifyDIYLogo();

		verifyCookingChannelLogo();
		
		verifyTravelChannelLogo();
		
		verifyUliveLogo();	
		
		sourceLogoResized();

	}

	private void verifySourceLogoText() {
		PeonyAssertion.assertTrue(isElementPresent(By.xpath(UliveHomePage_SourceLogo.SOURCELOGO_FAVORITESHOWLOGOS_IMAGE)), 
				"Favorite Network shows text is displayed");
		
		PeonyAssertion.assertTrue(isTextPresent("Watch featured episodes from your favorite TV networks"),
				"'Watch featured episodes from TV networks' is displayed");
	}

	private void verifyHGTVLogo() {
		PeonyAssertion.assertTrue(isElementPresent(By.xpath(UliveHomePage_SourceLogo.SOURCELOGO_HGTV_IMAGE)), 
				"HGTV logo is displayed");
		driver.findElement(By.xpath(UliveHomePage_SourceLogo.SOURCELOGO_HGTV_IMAGE)).click();
		PeonyAssertion.verifyTrue(driver.getCurrentUrl().contains("/hgtv"),
				"clicking on HGTV icon opens HGTV source page.");	
		driver.navigate().back();
	}

	private void verifyFoodNetworkLogo() {
		PeonyAssertion.assertTrue(isElementPresent(By.xpath(UliveHomePage_SourceLogo.SOURCELOGO_FOODNETWORK_IMAGE)), 
				"FoodNetwork logo is displayed");
		driver.findElement(By.xpath(UliveHomePage_SourceLogo.SOURCELOGO_FOODNETWORK_IMAGE)).click();
		PeonyAssertion.verifyTrue(driver.getCurrentUrl().contains("/food-network"),
				"clicking on HGTV icon opens HGTV source page.");	
		driver.navigate().back();
	}

	private void verifyDIYLogo() {
		PeonyAssertion.assertTrue(isElementPresent(By.xpath(UliveHomePage_SourceLogo.SOURCELOGO_DIYNETWORK_IMAGE)), 
				"DIY logo is displayed");
		driver.findElement(By.xpath(UliveHomePage_SourceLogo.SOURCELOGO_DIYNETWORK_IMAGE)).click();
		PeonyAssertion.verifyTrue(driver.getCurrentUrl().contains("/diy"),
				"clicking on DIY icon opens DIY source page.");	
		driver.navigate().back();
	}

	private void verifyCookingChannelLogo() {
		PeonyAssertion.assertTrue(isElementPresent(By.xpath(UliveHomePage_SourceLogo.SOURCELOGO_COOKINGCHANNEL_IMAGE)), 
				"Cooking Channel logo is displayed");
		driver.findElement(By.xpath(UliveHomePage_SourceLogo.SOURCELOGO_COOKINGCHANNEL_IMAGE)).click();
		PeonyAssertion.verifyTrue(driver.getCurrentUrl().contains("/cooking-channel"),
				"clicking on Cooking Channel icon opens Cooking Channel source page.");	
		driver.navigate().back();
	}

	private void verifyTravelChannelLogo() {
		PeonyAssertion.assertTrue(isElementPresent(By.xpath(UliveHomePage_SourceLogo.SOURCELOGO_TRAVELCHANNEL_IMAGE)), 
				"Travel Channel logo is displayed");
		driver.findElement(By.xpath(UliveHomePage_SourceLogo.SOURCELOGO_TRAVELCHANNEL_IMAGE)).click();
		PeonyAssertion.verifyTrue(driver.getCurrentUrl().contains("/travel-channel"),
				"clicking on Travel Channel icon opens Travel Channel source page.");	
		driver.navigate().back();
	}

	private void verifyUliveLogo() {
		PeonyAssertion.assertTrue(isElementPresent(By.xpath(UliveHomePage_SourceLogo.SOURCELOGO_ULIVE_IMAGE)), 
				"Ulive logo is displayed");
		driver.findElement(By.xpath(UliveHomePage_SourceLogo.SOURCELOGO_ULIVE_IMAGE)).click();
		
		PeonyAssertion.verifyTrue(driver.getCurrentUrl().contains("ulive-originals"),
				"clicking on Ulive icon opens ulive originals page.");
		
		driver.navigate().back();
	}
	
	private void sourceLogoResized() {
		driver.manage().window().setSize(new Dimension(480, 1024));
		
		PeonyAssertion.assertFalse(driver.findElement(By.xpath(UliveHomePage_SourceLogo.SOURCELOGOBAR_IMAGE)).isDisplayed(),
				"Source Logo section is NOT displayed when resized to mobile 480x1024");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
