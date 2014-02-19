package ulive.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import peony.asserts.PeonyAssertion;
import ulive.pages.UliveCompletedContactUSPage;
import ulive.util.UliveBaseClass;

public class UliveCompletedContactUsPageHelper extends UliveCompletedContactUSPage 
{
	private UliveBaseClass uliveBaseClass;
	protected WebDriver driver;
	
	public UliveCompletedContactUsPageHelper(WebDriver driver) 
	{
		this.driver = driver;
		uliveBaseClass = new UliveBaseClass(driver);
	}
	
	public void clickCOMPLETEDCONTACTUS_VIEWOURFAQ_LINK() 
	{
		driver.findElement(By.xpath(COMPLETEDCONTACTUS_VIEWOURFAQ_LINK)).click();
	}
	
	public void clickCOMPLETEDCONTACTUS_CONTACTUS_LINK() 
	{
		driver.findElement(By.xpath(COMPLETEDCONTACTUS_CONTACTUS_LINK)).click();
	}
	
	public void verifyCompletedContactUSPage() 
	{
		PeonyAssertion.verifyTrue(uliveBaseClass.isElementPresent(By
				.xpath(COMPLETEDCONTACTUS_VIEWOURFAQ_LINK)),
				"View Our FAQs link is displayed on the Completed Contact Us Page");
		
		PeonyAssertion.verifyTrue(uliveBaseClass.isElementPresent(By
				.xpath(COMPLETEDCONTACTUS_CONTACTUS_LINK)),
				"Contact Us link is displayed on the Completed Contact Us Page");
		
		PeonyAssertion.verifyTrue(
				uliveBaseClass.isTextPresent("Thank you for submitting your feedback"),
				"Thank You page is displayed on the Completed Contact Us Page");
	}

}
