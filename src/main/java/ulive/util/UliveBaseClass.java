package ulive.util;

import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import ulive.pages.UliveHomePage_Footer;
import ulive.pages.UliveHomePage_MenuBar;
import ulive.pages.UliveSearchPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.map.ObjectMapper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.webdriver.SikuliFirefoxDriver;
import org.testng.annotations.AfterClass;

import peony.asserts.PeonyAssertion;

public class UliveBaseClass {

	private final String firebugPath = "/Users/162208/Downloads/firebug-1.12.1-fx.xpi";
	protected WebDriver driver = null;
	protected UliveConstant magnoliaConstant = new UliveConstant();
	protected UliveUtil magnoliaUtil = new UliveUtil();
	protected UliveHomePage_Footer uliveHomePageFooter = new UliveHomePage_Footer();
	protected UliveSearchPage uliveSearchPage = new UliveSearchPage();
	protected JsonFactory jfactory = new JsonFactory();
	protected String url = null;
	public static ThreadLocal<String> mainWindow = new ThreadLocal<String>();

	private Logger logger = LogManager.getLogger(UliveBaseClass.class);

	public UliveBaseClass(WebDriver driver) {	
		this.driver = driver;
	}
	
	public UliveBaseClass(String browser) {
		if (browser.contains("firefox")) {

			// FirefoxProfile profile = new FirefoxProfile();
			// profile.addExtension(new File(firebugPath));
			//driver = new FirefoxDriver(profile);
			//driver = new SikuliFirefoxDriver();
			driver = new FirefoxDriver();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		} else if (browser.contains("chrome")) {
			
			System.setProperty("webdriver.chrome.driver",
					"/Users/162208/PeonyStartUp/chromedriver");
			DesiredCapabilities capability = DesiredCapabilities.chrome();
			capability.setCapability("chrome.switches",
			    Arrays.asList("--verbose"));
			driver = new ChromeDriver();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		} else if (browser.contains("safari")) {
			driver = new SafariDriver();
		}         

	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	public String loadUliveURL(String environment) {

		if (environment.equalsIgnoreCase("qa")) {
			url = magnoliaConstant.uliveURL_QA;
		}else if (environment.equalsIgnoreCase("qa2")) {
			url = magnoliaConstant.uliveURL_QA2;
		}else if (environment.equalsIgnoreCase("dev")) {
			url = magnoliaConstant.uliveURL_Dev;
		} else {
			url = magnoliaConstant.uliveURL_Live;
		}

		driver.get(url);
		driver.manage().window().maximize();
		return url;
	}

	protected void closeOnboarding() {
		try {
		logger.trace("Closing Onboarding");
		waitImplicitly(10000);
		PeonyAssertion.assertTrue(
				isElementPresent(By.cssSelector("span.close")),
				"Onboarding close button is present");
		driver.findElement(By.cssSelector("span.close")).click();
		Thread.sleep(1000);
		waitUntilElementVisible(UliveHomePage_MenuBar.MENUNAV_INACTIVE_ICON);
		} catch (Exception e) {
			e.printStackTrace();
			logger.trace("Closing Onboarding error");
		}
	}

	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	public boolean isElementVisible(By by) {
		try {
			driver.findElement(by).isDisplayed();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean isTextPresent(String textToBeVerified) {
		boolean textPresent = false;
		try {
			if (driver.findElement(By.xpath("//*[contains(.,'"
					+ textToBeVerified + "')]")) != null) {
				textPresent = true;
				//return true;
			}
		} catch (Exception e) {
			return false;
		}
		return textPresent;
		//return false;
	}
	
	public boolean isURLCorrect(String url) {
		try {
			driver.getCurrentUrl().contains(url);
		
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void switchToWindows(String title) {
		Set<String> windows = driver.getWindowHandles();

		for (String window : windows) {
			driver.switchTo().window(window);
			if (driver.getTitle().contains(title)) {
				break;
			}
		}
	}
	
//	public static synchronized void getMainWindowHandle() {
//		mainWindow.set(driver.getWindowHandle());
//	}
//
	public synchronized void switchToMainWindow(String mainHandle) {
		driver.switchTo().window(mainHandle);
	}

//	 public void waitForPageToLoad(String timeout) {
//	
//	 String message = "Waiting for page to load";
//	 new Wait().wait(message, Long.parseLong(timeout));
//	 {
//	 public boolean until() {
//	 Object returnValue =
//	 driver.executeScript("return document['readyState'] == 'complete'", new
//	 Object[0]);
//	
//	 return Boolean.parseBoolean(returnValue.toString());
//
//	 }
	 
	public void waitUntilElementVisible(String elementLocator) {
		WebDriverWait wait = new WebDriverWait(driver, 10); // wait for 5
															// seconds
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(elementLocator)));
	}

	public void waitImplicitly(int waitTime) {
		driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
	}

	public void scrollIntoView(String locator) {
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView(true);",
				driver.findElement(By.xpath(locator)));
	}
	
	public  void jqClick(String selector) {
		((JavascriptExecutor) driver).executeScript("$('" + selector + "').click()");
	}

	public void windowMaximize() {
		((JavascriptExecutor) driver)
				.executeScript("window.resizeTo(1024, 768);");
	}

	public boolean existsInArray(KeyWord[] keys, String name) {

		for (int i = 0; i < keys.length; i++) {

			if (keys[i].getName().contains(name)) {
				System.out.println("Result from api call: " + keys[i]);
				System.out.println("");
				return true;
			}
		}
		return false;
	}

	protected KeyWord[] autocompleteAPICall(String searchTerm) throws Exception {
		// read json data from autocomplete api call
		driver.get(magnoliaConstant.uliveURL_QA + "/ajax/getTypeAhead.jsp?q="
				+ searchTerm);
//		driver.get("http://ulive.qa.psddev.com/ajax/getTypeAhead.jsp?q="
//				+ searchTerm);
		Thread.sleep(2000);
		String body = driver.findElement(By.tagName("body")).getText();

		ObjectMapper mapper = new ObjectMapper();

		KeyWord[] keys = null;

		try {

			// convert JSON string to Map

			keys = mapper.readValue(body, KeyWord[].class);
			
		} catch (Exception e) {
			logger.error("error in reading data from api", e);
		}
		return keys;
	}

	public void selectDropDown(By by, String value) {
		WebElement e = driver.findElement(by);
		Select select = new Select(e);
		select.selectByValue(value);
	}
}
