package ulive.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import peony.asserts.PeonyAssertion;
import peony.user.User;
import ulive.pages.UliveContactUSPage;
import ulive.util.UliveBaseClass;
import ulive.util.UliveUtil;

public class UliveContactUsPageHelper extends UliveContactUSPage 
{
	private UliveBaseClass uliveBaseClass;
	private UliveUtil uliveUtil = new UliveUtil();
	
	public UliveContactUsPageHelper(WebDriver driver) 
	{
		super(driver);
		uliveBaseClass = new UliveBaseClass(driver);
	}
	
	public void selectByValueCONTACTUS_MSGTYPE_SELECTDROPDOWN(String value) 
	{
		uliveBaseClass.selectDropDown(By.xpath(CONTACTUS_MSGTYPE_SELECTDROPDOWN), value);
	}
	
	public void selectByValueCONTACTUS_REGARDING_SELECTDROPDOWN(String value) 
	{
		uliveBaseClass.selectDropDown(By.xpath(CONTACTUS_REGARDING_SELECTDROPDOWN), value);
	}
	
	public void clickCONTACTUS_SUBMIT_BUTTON() 
	{
		driver.findElement(By.xpath(CONTACTUS_SUBMIT_BUTTON)).click();
	}
	
	public void selectByValue_MessageType(String msgTypeValue, String regardingValue) 
	{
		selectByValueCONTACTUS_MSGTYPE_SELECTDROPDOWN(msgTypeValue);
		selectByValueCONTACTUS_REGARDING_SELECTDROPDOWN(regardingValue);
	}
	
	public void completePersonalInfo(User user) 
	{
		setCONTACTUS_FIRSTNAME_TEXTFIELD(user.getFirstName());
		setCONTACTUS_LASTNAME_TEXTFIELD(user.getLastName());
		setCONTACTUS_EMAIL_TEXTFIELD(user.getEmailAddress());
		setCONTACTUS_CONFIRMEMAIL_TEXTFIELD(user.getEmailAddress());
		setCONTACTUS_ZIPCODE_TEXTFIELD(user.getHomeZip());
	}
	
	public void completePersonalInfo_DifferentEmails(User user1, User user2) throws Exception
	{
		setCONTACTUS_FIRSTNAME_TEXTFIELD(user1.getFirstName());
		setCONTACTUS_LASTNAME_TEXTFIELD(user1.getLastName());
		setCONTACTUS_EMAIL_TEXTFIELD(user1.getEmailAddress());
		setCONTACTUS_CONFIRMEMAIL_TEXTFIELD(user2.getEmailAddress());
		setCONTACTUS_ZIPCODE_TEXTFIELD(user1.getHomeZip());
	}
	
	public void completeContactUsPage(String msgType, String regardingValue, User user, String msg) 
	{
		selectByValue_MessageType(msgType, regardingValue);
		completePersonalInfo(user);
		
		if(msg==null) 
		{
			msg = uliveUtil.generateRandomCharacters(10);
		}
		
		setCONTACTUS_YOURMSG_TEXTFIELD(msg);
	}
	
	public void completeContactUsPageSubmit(String msgType, String regardingValue, User user, String msg) 
	{
		completeContactUsPage(msgType, regardingValue, user, msg);
		
		//temporary fix for bug...need to click outside the message textfield to access the submit button
		setCONTACTUS_YOURMSG_TEXTFIELD(Keys.TAB);
				
		clickCONTACTUS_SUBMIT_BUTTON();
	}
	
	public void verifyContactUSLinks() 
	{

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
	
	public void verifySubmitButton(boolean isEnabled) 
	{
		if(isEnabled==false) 
		{
			PeonyAssertion.verifyTrue(getCONTACTUS_SUBMIT_BUTTON().getAttribute("disabled").contains("true"),
					"Submit button is disabled when required fields are not completed");
		}else 
		{
//			PeonyAssertion.verifyTrue(getCONTACTUS_SUBMIT_BUTTON().getAttribute("disabled").equals(null),
//					"Submit button is enabled when required fields are completed");
		}
			
	}

}
