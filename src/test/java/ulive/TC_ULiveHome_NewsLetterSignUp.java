package ulive;

import ulive.pages.UliveHomePage_Footer;
import ulive.pages.UliveHomePage_MenuNav;
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
 * This testcase verifies the signup capability of the Newsletter load ulive,
 * scroll newsletter sign up field into view Verify sign up text, verify email
 * textfield is enabled enter email address, click sign up, verify success and
 * sign up button disabled
 * 
 * @author slu
 * 
 */
public class TC_ULiveHome_NewsLetterSignUp extends UliveBaseClass {
	String mainhandle = null;
	UserFactory user;
	User newUser;

	@Parameters({ "browser" })
	public TC_ULiveHome_NewsLetterSignUp(String browser) {
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

		mainhandle = driver.getWindowHandle();

		scrollIntoView(UliveHomePage_Footer.HOMEPAGEFOOTER_SIGNUP_BUTTON);
		PeonyAssertion.assertTrue(
				isTextPresent("Sign up for the uLive newsletter!"),
				"Newsletter sign up text is displayed");

		// Sign up for newsletter
		if (isElementPresent(By
				.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_SIGNUP_BUTTON))
				&& isElementPresent(By.xpath("//button[@class='disabled']"))) {
			PeonyAssertion.assertTrue(
					driver.findElement(By.xpath("//button[@class='disabled']"))
							.isDisplayed(),
					"Sign Up button is initially disabled");
		}

		driver.findElement(
				By.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_EMAIL_TEXTFIELD))
				.sendKeys(newUser.getEmailAddress());

		if (isElementPresent(By
				.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_SIGNUP_BUTTON))
				&& isElementPresent(By.xpath("//button[@class='']"))) {
			PeonyAssertion
					.assertTrue(
							driver.findElement(By.xpath("//button[@class='']"))
									.isDisplayed(),
							"Sign Up button is enabled after completing email textfield");
		}

		driver.findElement(
				By.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_SIGNUP_BUTTON))
				.click();
		Thread.sleep(4000);
		PeonyAssertion.assertTrue(
				driver.findElement(
						By.xpath("//input[@class='hasChar checking success']"))
						.isDisplayed(),
				"email is accepted on the email textfield");

		if (isElementPresent(By
				.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_SIGNUP_BUTTON))
				&& isElementPresent(By.xpath("//button[@class='disabled']"))) {
			PeonyAssertion.assertTrue(
					driver.findElement(By.xpath("//button[@class='disabled']"))
							.isDisplayed(),
					"Sign Up button is disabled after email is accepted");
		}

		verifySocialShare();
		
	}

	private void verifySocialShare() {
		// verify facebook, twitter, and google+ icons
		driver.findElement(
				By.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_FACEBOOK_ICON))
				.click();
		switchToWindows("uLive | Facebook");
		PeonyAssertion.assertTrue(driver.getCurrentUrl().contains("facebook"),
				"clicking on Facebook icon redirects to Facebook page");
		driver.close();

		driver.switchTo().window(mainhandle);

		driver.findElement(
				By.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_TWITTER_ICON))
				.click();
		switchToWindows("ulive.com (ulive) on Twitter");
		PeonyAssertion.assertTrue(driver.getCurrentUrl().contains("twitter"),
				"clicking on Twitter icon redirects to Twitter page");
		driver.close();

		driver.switchTo().window(mainhandle);

		driver.findElement(
				By.xpath(UliveHomePage_Footer.HOMEPAGEFOOTER_GOOGLEPLUS_ICON))
				.click();
		switchToWindows("Google+");
		PeonyAssertion.assertTrue(driver.getCurrentUrl().contains("google"),
				"clicking on Google+ redirects to Google+ page");
		driver.close();
		driver.switchTo().window(mainhandle);
	}

	

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
