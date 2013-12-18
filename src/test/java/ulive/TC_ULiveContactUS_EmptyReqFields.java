package ulive;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
public class TC_ULiveContactUS_EmptyReqFields extends UliveBaseClass {
	private UliveContactUsPageHelper uliveContactUsPageHelper = new UliveContactUsPageHelper(driver);
	
	User newUser;
	
	@Parameters({ "browser" })
	public TC_ULiveContactUS_EmptyReqFields(String browser) {
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

		uliveContactUsPageHelper.selectByValue_MessageType("", "");
		uliveContactUsPageHelper.setCONTACTUS_FIRSTNAME_TEXTFIELD(Keys.TAB);
		uliveContactUsPageHelper.setCONTACTUS_LASTNAME_TEXTFIELD(Keys.TAB);
		uliveContactUsPageHelper.setCONTACTUS_EMAIL_TEXTFIELD(Keys.TAB);
		uliveContactUsPageHelper.setCONTACTUS_CONFIRMEMAIL_TEXTFIELD(Keys.TAB);
		uliveContactUsPageHelper.setCONTACTUS_ZIPCODE_TEXTFIELD(newUser.getHomeZip());	
		uliveContactUsPageHelper.setCONTACTUS_YOURMSG_TEXTFIELD(Keys.TAB);

		uliveContactUsPageHelper.verifySubmitButton(false);
		
		System.out.println(driver.findElement(By.name("fname")).getAttribute("class").contains("required invalid_contact_us_input"));
		System.out.println(driver.findElement(By.name("lname")).getAttribute("class").contains("required invalid_contact_us_input"));
		System.out.println(driver.findElement(By.name("email")).getAttribute("class").contains("required invalid_contact_us_input"));
		System.out.println(driver.findElement(By.name("confirm")).getAttribute("class").contains("required invalid_contact_us_input"));
		System.out.println(driver.findElement(By.name("optionaldata7")).getAttribute("class").contains("required invalid_contact_us_input"));
	}

}
