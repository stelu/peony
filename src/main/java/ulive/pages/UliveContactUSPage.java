package ulive.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class UliveContactUSPage 
{
	
	protected WebDriver driver;

	//Contact US header links
	public static final String CONTACTUS_FAQ_LINK = "//div[@id='frmContainer']/p/span/a/b";
	public static final String CONTACTUS_VIEWOURFAQ_LINK = "//div[@id='frmContainer']/p/a/b";
	public static final String CONTACTUS_ADVERTISEWITHUS_LINK = "//div[@id='frmContainer']/p/a[2]/b";
	public static final String CONTACTUS_BECOMEPARTNER_LINK = "//div[@id='frmContainer']/p/b[4]/a";
	
	public static final String CONTACTUS_MSGTYPE_SELECTDROPDOWN = "//select[@id='qc']";
	public static final String CONTACTUS_REGARDING_SELECTDROPDOWN = "//select[@id='topicSelect']";
	public static final String CONTACTUS_FIRSTNAME_TEXTFIELD = "//form[@id='contactUs']/fieldset[2]/div/div/div/div/input";
	public static final String CONTACTUS_LASTNAME_TEXTFIELD = "//form[@id='contactUs']/fieldset[2]/div/div[2]/div/div/input";
	public static final String CONTACTUS_EMAIL_TEXTFIELD = "//form[@id='contactUs']/fieldset[2]/div[2]/div/div/div/input";
	public static final String CONTACTUS_CONFIRMEMAIL_TEXTFIELD = "//form[@id='contactUs']/fieldset[2]/div[2]/div[2]/div/div/input";
	public static final String CONTACTUS_ZIPCODE_TEXTFIELD = "//form[@id='contactUs']/fieldset[2]/div[3]/div/div/div/input";
	public static final String CONTACTUS_YOURMSG_TEXTFIELD = "//form[@id='contactUs']/div/div/textarea";
	public static final String CONTACTUS_SUBMIT_BUTTON = "//button[@id='submitBttn']";
	
	public UliveContactUSPage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	public String getCONTACTUS_MSGTYPE_SELECTDROPDOWN() 
	{
		return CONTACTUS_MSGTYPE_SELECTDROPDOWN;
	}
	
	public String getCONTACTUS_REGARDING_SELECTDROPDOWN() 
	{
		return CONTACTUS_REGARDING_SELECTDROPDOWN; 
	}
	
	public String getCONTACTUS_FIRSTNAME_TEXTFIELD() 
	{
		return CONTACTUS_FIRSTNAME_TEXTFIELD;
	}
	
	public void setCONTACTUS_FIRSTNAME_TEXTFIELD(String fName) 
	{
		driver.findElement(By.xpath(CONTACTUS_FIRSTNAME_TEXTFIELD)).clear();
		driver.findElement(By.xpath(CONTACTUS_FIRSTNAME_TEXTFIELD)).sendKeys(fName);
	}
	
	public void setCONTACTUS_FIRSTNAME_TEXTFIELD(Keys key) 
	{
		driver.findElement(By.xpath(CONTACTUS_FIRSTNAME_TEXTFIELD)).sendKeys(key);
	}
	
	public String getCONTACTUS_LASTNAME_TEXTFIELD() 
	{
		return CONTACTUS_LASTNAME_TEXTFIELD;
	}
	
	public void setCONTACTUS_LASTNAME_TEXTFIELD(String lName) 
	{
		driver.findElement(By.xpath(CONTACTUS_LASTNAME_TEXTFIELD)).clear();
		driver.findElement(By.xpath(CONTACTUS_LASTNAME_TEXTFIELD)).sendKeys(lName);
	}
	
	public void setCONTACTUS_LASTNAME_TEXTFIELD(Keys key) 
	{
		driver.findElement(By.xpath(CONTACTUS_LASTNAME_TEXTFIELD)).sendKeys(key);
	}
	
	public String getCONTACTUS_EMAIL_TEXTFIELD() 
	{
		return CONTACTUS_EMAIL_TEXTFIELD;
	}
	
	public void setCONTACTUS_EMAIL_TEXTFIELD(String email) 
	{
		driver.findElement(By.xpath(CONTACTUS_EMAIL_TEXTFIELD)).clear();
		driver.findElement(By.xpath(CONTACTUS_EMAIL_TEXTFIELD)).sendKeys(email);
	}
	
	public void setCONTACTUS_EMAIL_TEXTFIELD(Keys key) 
	{
		driver.findElement(By.xpath(CONTACTUS_EMAIL_TEXTFIELD)).sendKeys(key);
	}
	
	public String getCONTACTUS_CONFIRMEMAIL_TEXTFIELD() 
	{
		return CONTACTUS_CONFIRMEMAIL_TEXTFIELD;
	}
	
	public void setCONTACTUS_CONFIRMEMAIL_TEXTFIELD(String email) 
	{
		driver.findElement(By.xpath(CONTACTUS_CONFIRMEMAIL_TEXTFIELD)).clear();
		driver.findElement(By.xpath(CONTACTUS_CONFIRMEMAIL_TEXTFIELD)).sendKeys(email);
	}
	
	public void setCONTACTUS_CONFIRMEMAIL_TEXTFIELD(Keys key) 
	{
		driver.findElement(By.xpath(CONTACTUS_CONFIRMEMAIL_TEXTFIELD)).sendKeys(key);
	}
	
	public String getCONTACTUS_ZIPCODE_TEXTFIELD() 
	{
		return CONTACTUS_ZIPCODE_TEXTFIELD;
	}
	
	public void setCONTACTUS_ZIPCODE_TEXTFIELD(String zipCode) 
	{
		driver.findElement(By.xpath(CONTACTUS_ZIPCODE_TEXTFIELD)).clear();
		driver.findElement(By.xpath(CONTACTUS_ZIPCODE_TEXTFIELD)).sendKeys(zipCode);
	}
	
	public void setCONTACTUS_ZIPCODE_TEXTFIELD(Keys key) 
	{
		driver.findElement(By.xpath(CONTACTUS_ZIPCODE_TEXTFIELD)).sendKeys(key);
	}
	
	public String getCONTACTUS_YOURMSG_TEXTFIELD() 
	{
		return CONTACTUS_YOURMSG_TEXTFIELD;
	}
	
	public void setCONTACTUS_YOURMSG_TEXTFIELD(String msg) 
	{
		driver.findElement(By.xpath(CONTACTUS_YOURMSG_TEXTFIELD)).sendKeys(msg);
	}
	
	public void setCONTACTUS_YOURMSG_TEXTFIELD(Keys key) 
	{
		driver.findElement(By.xpath(CONTACTUS_YOURMSG_TEXTFIELD)).sendKeys(key);
	}
	
	public WebElement getCONTACTUS_SUBMIT_BUTTON() 
	{
		return driver.findElement(By.xpath(CONTACTUS_SUBMIT_BUTTON));
	}
	
}
