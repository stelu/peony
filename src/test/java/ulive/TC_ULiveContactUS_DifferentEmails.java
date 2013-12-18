package ulive;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import peony.asserts.PeonyAssertion;
import peony.user.User;
import peony.user.UserFactory;
import ulive.helper.UliveContactUsPageHelper;
import ulive.pages.UliveContactUSPage;
import ulive.pages.UliveHomePage_Footer;
import ulive.util.UliveBaseClass;

/**
 * This test case completes and verifies the Contact Us page. Load ulive, click
 * Contact Us. Complete Contact Us page.
 * 
 * @author slu
 * 
 */
public class TC_ULiveContactUS_DifferentEmails extends UliveBaseClass {
	private UliveContactUsPageHelper uliveContactUsPageHelper = new UliveContactUsPageHelper(driver);
	private User newUser;
	private User newUser2;

	@Parameters({ "browser" })
	public TC_ULiveContactUS_DifferentEmails(String browser) {
		super(browser);
	}

	@BeforeClass
	public void createUser() {

		newUser = UserFactory.createUser();
		newUser2 = UserFactory.createUser();
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

		uliveContactUsPageHelper.selectByValue_MessageType("Comment", "Video");
		uliveContactUsPageHelper.completePersonalInfo_DifferentEmails(newUser, newUser2);
		uliveContactUsPageHelper.setCONTACTUS_YOURMSG_TEXTFIELD(magnoliaUtil.generateRandomCharacters(10));
		uliveContactUsPageHelper.clickCONTACTUS_SUBMIT_BUTTON();
		
		PeonyAssertion.verifyTrue(driver.findElement(By.xpath(uliveContactUsPageHelper.getCONTACTUS_EMAIL_TEXTFIELD()))
				.getAttribute("class").contains("required invalid_contact_us_input"),
				"Email textfield threw error");
		PeonyAssertion.verifyTrue(driver.findElement(By.xpath(uliveContactUsPageHelper.getCONTACTUS_CONFIRMEMAIL_TEXTFIELD()))
				.getAttribute("class").contains("required invalid_contact_us_input"),
				"Confirm email textfield threw error");
	}

}
