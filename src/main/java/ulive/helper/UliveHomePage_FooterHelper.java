package ulive.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import peony.asserts.PeonyAssertion;
import ulive.pages.UliveHomePage_Footer;
import ulive.util.UliveBaseClass;

public class UliveHomePage_FooterHelper extends UliveHomePage_Footer 
{
	private UliveBaseClass uliveBaseClass;
	
	public UliveHomePage_FooterHelper(WebDriver driver) 
	{
		super(driver);
		uliveBaseClass = new UliveBaseClass(driver);
	}
	
	public void clickHOMEPAGEFOOTER_SIGNUP_BUTTON() 
	{
		driver.findElement(By.xpath(HOMEPAGEFOOTER_SIGNUP_BUTTON)).click();
	}
	
	public void clickHOMEPAGEFOOTER_FACEBOOK_ICON() 
	{
		driver.findElement(By.xpath(HOMEPAGEFOOTER_FACEBOOK_ICON)).click();
	}
	
	public void clickHOMEPAGEFOOTER_TWITTER_ICON() 
	{
		driver.findElement(By.xpath(HOMEPAGEFOOTER_TWITTER_ICON)).click();
	}
	
	public void clickHOMEPAGEFOOTER_GOOGLEPLUS_ICON() 
	{
		driver.findElement(By.xpath(HOMEPAGEFOOTER_GOOGLEPLUS_ICON)).click();
	}
	
	public void verifyFooterSignUpButton(boolean isEnabled) 
	{
		if(isEnabled) 
		{
			PeonyAssertion.assertTrue(getHOMEPAGEFOOTER_SIGNUP_BUTTON()
					.getAttribute("class").contains(""), 
					"Sign Up button is enabled");
		}else 
		{
			PeonyAssertion.assertTrue(getHOMEPAGEFOOTER_SIGNUP_BUTTON()
					.getAttribute("class").contains("disabled"), 
					"Sign Up button is disabled");
		}
		
	}
	
	public void verifyFooterSocialShare(String mainhandle) 
	{
		clickHOMEPAGEFOOTER_FACEBOOK_ICON();
		
		uliveBaseClass.switchToWindows("uLive | Facebook");
		PeonyAssertion.assertTrue(driver.getCurrentUrl().contains("facebook"),
				"clicking on Facebook icon redirects to Facebook page");
		driver.close();

		driver.switchTo().window(mainhandle);

		clickHOMEPAGEFOOTER_TWITTER_ICON();
		uliveBaseClass.switchToWindows("ulive.com (ulive) on Twitter");
		PeonyAssertion.assertTrue(driver.getCurrentUrl().contains("twitter"),
				"clicking on Twitter icon redirects to Twitter page");
		driver.close();

		driver.switchTo().window(mainhandle);

		clickHOMEPAGEFOOTER_GOOGLEPLUS_ICON();
		uliveBaseClass.switchToWindows("Google+");
		PeonyAssertion.assertTrue(driver.getCurrentUrl().contains("google"),
				"clicking on Google+ redirects to Google+ page");
		driver.close();
		driver.switchTo().window(mainhandle);
	}

}
