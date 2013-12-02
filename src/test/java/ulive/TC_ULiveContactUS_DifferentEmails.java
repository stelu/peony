package ulive;

import ulive.pages.UliveCompletedContactUSPage;
import ulive.pages.UliveContactUSPage;
import ulive.pages.UliveHomePage_Footer;
import ulive.util.UliveBaseClass;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import peony.asserts.PeonyAssertion;
import peony.user.User;
import peony.user.UserFactory;

/**
 * This test case completes and verifies the Contact Us page. Load ulive, click
 * Contact Us. Complete Contact Us page.
 * 
 * @author slu
 * 
 */
public class TC_ULiveContactUS_DifferentEmails extends UliveBaseClass {
	UserFactory user;
	User newUser;
	User newUser2;

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

		verifyContactUS();

		completeContactUSPage();

		verifyCompletedContactUSPage();
	}

	private void verifyContactUS() {

		PeonyAssertion.verifyTrue(isElementPresent(By
				.xpath(UliveContactUSPage.CONTACTUS_FAQ_LINK)),
				"FAQs link is displayed on Contact Us Page");
		PeonyAssertion.verifyTrue(isElementPresent(By
				.xpath(UliveContactUSPage.CONTACTUS_VIEWOURFAQ_LINK)),
				"View Our FAQs link is displayed on Contact Us Page");
		PeonyAssertion.verifyTrue(isElementPresent(By
				.xpath(UliveContactUSPage.CONTACTUS_ADVERTISEWITHUS_LINK)),
				"Advertise With Us link is displayed on Contact Us Page");
		PeonyAssertion.verifyTrue(isElementPresent(By
				.xpath(UliveContactUSPage.CONTACTUS_BECOMEPARTNER_LINK)),
				"Become A Partner link is displayed on Contact Us Page");

	}

	private void completeContactUSPage() {
		selectDropDown(
				By.xpath(UliveContactUSPage.CONTACTUS_MSGTYPE_SELECTDROPDOWN),
				"Comment");
		selectDropDown(
				By.xpath(UliveContactUSPage.CONTACTUS_REGARDING_SELECTDROPDOWN),
				"Video");
		driver.findElement(
				By.xpath(UliveContactUSPage.CONTACTUS_FIRSTNAME_TEXTFIELD))
				.sendKeys(newUser.getFirstName());
		driver.findElement(
				By.xpath(UliveContactUSPage.CONTACTUS_LASTNAME_TEXTFIELD))
				.sendKeys(newUser.getLastName());
		driver.findElement(
				By.xpath(UliveContactUSPage.CONTACTUS_EMAIL_TEXTFIELD))
				.sendKeys(newUser.getEmailAddress());
		driver.findElement(
				By.xpath(UliveContactUSPage.CONTACTUS_CONFIRMEMAIL_TEXTFIELD))
				.sendKeys(newUser2.getEmailAddress());
		driver.findElement(
				By.xpath(UliveContactUSPage.CONTACTUS_ZIPCODE_TEXTFIELD))
				.sendKeys(newUser.getHomeZip());
		driver.findElement(
				By.xpath(UliveContactUSPage.CONTACTUS_YOURMSG_TEXTFIELD))
				.sendKeys(magnoliaUtil.generateRandomCharacters(10));
		driver.findElement(By.xpath(UliveContactUSPage.CONTACTUS_SUBMIT_BUTTON))
				.click();

	}

	private void verifyCompletedContactUSPage() {

		PeonyAssertion.verifyTrue(
				isTextPresent("Thank you for submitting your feedback"),
				"Thank You page is displayed on Completed Contact Us Page");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
