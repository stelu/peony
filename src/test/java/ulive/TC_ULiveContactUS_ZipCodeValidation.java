package ulive;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import peony.asserts.PeonyAssertion;
import peony.user.User;
import peony.user.UserFactory;
import ulive.helper.UliveCompletedContactUsPageHelper;
import ulive.helper.UliveContactUsPageHelper;
import ulive.pages.UliveHomePage_Footer;
import ulive.util.UliveBaseClass;

/**
 * Bug: zipcode validation is not available yet.
 * 
 * This test case completes the Contact Us page with various permutation of zipcode validation. Load ulive, click
 * Contact Us. Complete Contact Us page.
 * 
 * 
 * 
 * @author slu
 * 
 */
public class TC_ULiveContactUS_ZipCodeValidation extends UliveBaseClass {
	private UliveContactUsPageHelper uliveContactUsPageHelper = new UliveContactUsPageHelper(driver);
	private UliveCompletedContactUsPageHelper uliveCompletedContactUsPageHelper = new UliveCompletedContactUsPageHelper(driver);
	
	User newUser;
	String messageContent = magnoliaUtil.generateRandomCharacters(10);
	
	@Parameters({ "browser" })
	public TC_ULiveContactUS_ZipCodeValidation(String browser) {
		super(browser);
	}

	@BeforeClass
	public void createUser() {

		newUser = UserFactory.createUser();
	}

	@Test
	public void test() throws Exception {

		loadUliveURL("qa");
		closeOnboarding();

		scrollIntoView(UliveHomePage_Footer.HOMEPAGEFOOTER_CONTACTUS_LINK);

		driver.findElement(
				By.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_CONTACTUS_LINK))
				.click();

		uliveContactUsPageHelper.verifyContactUSLinks();

		uliveContactUsPageHelper.completeContactUsPage("Comment", "Video", newUser, messageContent);
		uliveContactUsPageHelper.setCONTACTUS_ZIPCODE_TEXTFIELD("WETSER");
		//uliveContactUsPageHelper.verifySubmitButton(true);
		uliveContactUsPageHelper.clickCONTACTUS_SUBMIT_BUTTON();

		uliveCompletedContactUsPageHelper.verifyCompletedContactUSPage();
	}
}
