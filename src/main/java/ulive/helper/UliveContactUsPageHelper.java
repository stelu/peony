package ulive.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import peony.asserts.PeonyAssertion;
import peony.user.User;
import ulive.pages.UliveContactUSPage;
import ulive.util.UliveBaseClass;

public class UliveContactUsPageHelper extends UliveContactUSPage {
	private UliveBaseClass uliveBaseClass;
	protected WebDriver driver;
	
	public UliveContactUsPageHelper(WebDriver driver) {
		this.driver = driver;
		uliveBaseClass = new UliveBaseClass(driver);
	}
	
	public String getCONTACTUS_MSGTYPE_SELECTDROPDOWN() {
		return CONTACTUS_MSGTYPE_SELECTDROPDOWN;
	}
	
	public String getCONTACTUS_REGARDING_SELECTDROPDOWN() {
		return CONTACTUS_REGARDING_SELECTDROPDOWN; 
	}
	
	public void selectByValueCONTACTUS_MSGTYPE_SELECTDROPDOWN(String value) {
		uliveBaseClass.selectDropDown(By.xpath(CONTACTUS_MSGTYPE_SELECTDROPDOWN), value);
	}
	
	public void selectByValueCONTACTUS_REGARDING_SELECTDROPDOWN(String value) {
		uliveBaseClass.selectDropDown(By.xpath(CONTACTUS_REGARDING_SELECTDROPDOWN), value);
	}
	
	public String getCONTACTUS_FIRSTNAME_TEXTFIELD() {
		return CONTACTUS_FIRSTNAME_TEXTFIELD;
	}
	
	public void setCONTACTUS_FIRSTNAME_TEXTFIELD(String fName) {
		driver.findElement(By.xpath(CONTACTUS_FIRSTNAME_TEXTFIELD)).clear();
		driver.findElement(By.xpath(CONTACTUS_FIRSTNAME_TEXTFIELD)).sendKeys(fName);
	}
	
	public void setCONTACTUS_FIRSTNAME_TEXTFIELD(Keys key) {
		driver.findElement(By.xpath(CONTACTUS_FIRSTNAME_TEXTFIELD)).sendKeys(key);
	}
	
	public String getCONTACTUS_LASTNAME_TEXTFIELD() {
		return CONTACTUS_LASTNAME_TEXTFIELD;
	}
	
	public void setCONTACTUS_LASTNAME_TEXTFIELD(String lName) {
		driver.findElement(By.xpath(CONTACTUS_LASTNAME_TEXTFIELD)).clear();
		driver.findElement(By.xpath(CONTACTUS_LASTNAME_TEXTFIELD)).sendKeys(lName);
	}
	
	public void setCONTACTUS_LASTNAME_TEXTFIELD(Keys key) {
		driver.findElement(By.xpath(CONTACTUS_LASTNAME_TEXTFIELD)).sendKeys(key);
	}
	
	public String getCONTACTUS_EMAIL_TEXTFIELD() {
		return CONTACTUS_EMAIL_TEXTFIELD;
	}
	
	public void setCONTACTUS_EMAIL_TEXTFIELD(String email) {
		driver.findElement(By.xpath(CONTACTUS_EMAIL_TEXTFIELD)).clear();
		driver.findElement(By.xpath(CONTACTUS_EMAIL_TEXTFIELD)).sendKeys(email);
	}
	
	public void setCONTACTUS_EMAIL_TEXTFIELD(Keys key) {
		driver.findElement(By.xpath(CONTACTUS_EMAIL_TEXTFIELD)).sendKeys(key);
	}
	
	public String getCONTACTUS_CONFIRMEMAIL_TEXTFIELD() {
		return CONTACTUS_CONFIRMEMAIL_TEXTFIELD;
	}
	
	public void setCONTACTUS_CONFIRMEMAIL_TEXTFIELD(String email) {
		driver.findElement(By.xpath(CONTACTUS_CONFIRMEMAIL_TEXTFIELD)).clear();
		driver.findElement(By.xpath(CONTACTUS_CONFIRMEMAIL_TEXTFIELD)).sendKeys(email);
	}
	
	public void setCONTACTUS_CONFIRMEMAIL_TEXTFIELD(Keys key) {
		driver.findElement(By.xpath(CONTACTUS_CONFIRMEMAIL_TEXTFIELD)).sendKeys(key);
	}
	
	public String getCONTACTUS_ZIPCODE_TEXTFIELD() {
		return CONTACTUS_ZIPCODE_TEXTFIELD;
	}
	
	public void setCONTACTUS_ZIPCODE_TEXTFIELD(String zipCode) {
		driver.findElement(By.xpath(CONTACTUS_ZIPCODE_TEXTFIELD)).clear();
		driver.findElement(By.xpath(CONTACTUS_ZIPCODE_TEXTFIELD)).sendKeys(zipCode);
	}
	
	public void setCONTACTUS_ZIPCODE_TEXTFIELD(Keys key) {
		driver.findElement(By.xpath(CONTACTUS_ZIPCODE_TEXTFIELD)).sendKeys(key);
	}
	
	public String getCONTACTUS_YOURMSG_TEXTFIELD() {
		return CONTACTUS_YOURMSG_TEXTFIELD;
	}
	
	public void setCONTACTUS_YOURMSG_TEXTFIELD(String msg) {
		driver.findElement(By.xpath(CONTACTUS_YOURMSG_TEXTFIELD)).clear();
		driver.findElement(By.xpath(CONTACTUS_YOURMSG_TEXTFIELD)).sendKeys(msg);
	}
	
	public void setCONTACTUS_YOURMSG_TEXTFIELD(Keys key) {
		driver.findElement(By.xpath(CONTACTUS_YOURMSG_TEXTFIELD)).sendKeys(key);
	}
	
	public WebElement getCONTACTUS_SUBMIT_BUTTON() {
		return driver.findElement(By.xpath(CONTACTUS_SUBMIT_BUTTON));
	}
	
	public void clickCONTACTUS_SUBMIT_BUTTON() {
		driver.findElement(By.xpath(CONTACTUS_SUBMIT_BUTTON)).click();
	}
	
	public void selectByValue_MessageType(String msgTypeValue, String regardingValue) {
		selectByValueCONTACTUS_MSGTYPE_SELECTDROPDOWN(msgTypeValue);
		selectByValueCONTACTUS_REGARDING_SELECTDROPDOWN(regardingValue);
	}
	
	public void completePersonalInfo(User user) {
		setCONTACTUS_FIRSTNAME_TEXTFIELD(user.getFirstName());
		setCONTACTUS_LASTNAME_TEXTFIELD(user.getLastName());
		setCONTACTUS_EMAIL_TEXTFIELD(user.getEmailAddress());
		setCONTACTUS_CONFIRMEMAIL_TEXTFIELD(user.getEmailAddress());
		setCONTACTUS_ZIPCODE_TEXTFIELD(user.getHomeZip());
	}
	
	public void completePersonalInfo_DifferentEmails(User user1, User user2) throws Exception{
		setCONTACTUS_FIRSTNAME_TEXTFIELD(user1.getFirstName());
		setCONTACTUS_LASTNAME_TEXTFIELD(user1.getLastName());
		setCONTACTUS_EMAIL_TEXTFIELD(user1.getEmailAddress());
		setCONTACTUS_CONFIRMEMAIL_TEXTFIELD(user2.getEmailAddress());
		setCONTACTUS_ZIPCODE_TEXTFIELD(user1.getHomeZip());
	}
	
	public void completeContactUsPage(String msgType, String regardingValue, User user, String msg) {
		selectByValue_MessageType(msgType, regardingValue);
		completePersonalInfo(user);
		setCONTACTUS_YOURMSG_TEXTFIELD(msg);
	}
	
	public void completeContactUsPageSubmit(String msgType, String regardingValue, User user, String msg) {
		completeContactUsPage(msgType, regardingValue, user, msg);
		clickCONTACTUS_SUBMIT_BUTTON();
	}
	
	public void verifyContactUSLinks() {

		PeonyAssertion.verifyTrue(uliveBaseClass.isElementPresent(By
				.xpath(CONTACTUS_FAQ_LINK)),
				"FAQs link is displayed on Contact Us Page");
		PeonyAssertion.verifyTrue(uliveBaseClass.isElementPresent(By
				.xpath(CONTACTUS_VIEWOURFAQ_LINK)),
				"View Our FAQs link is displayed on Contact Us Page");
		PeonyAssertion.verifyTrue(uliveBaseClass.isElementPresent(By
				.xpath(CONTACTUS_ADVERTISEWITHUS_LINK)),
				"Advertise With Us link is displayed on Contact Us Page");
		PeonyAssertion.verifyTrue(uliveBaseClass.isElementPresent(By
				.xpath(CONTACTUS_BECOMEPARTNER_LINK)),
				"Become A Partner link is displayed on Contact Us Page");
	}
	
	public void verifySubmitButton(boolean isEnabled) {
		if(isEnabled=false) {
			PeonyAssertion.verifyTrue(getCONTACTUS_SUBMIT_BUTTON().getAttribute("disabled").contains("true"),
					"Submit button is disabled when required fields are not completed");
		}else {
//			PeonyAssertion.verifyTrue(getCONTACTUS_SUBMIT_BUTTON().getAttribute("disabled").equals(null),
//					"Submit button is enabled when required fields are completed");
		}
			
	}

}
