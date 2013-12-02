package ulive.util;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MouseHover {

	private WebDriver driver;
	private String browser = "";

	public MouseHover(WebDriver driver) {
		this.driver = driver;
	}

	public MouseHover(WebDriver driver, String browser) {
		this.driver = driver;
		this.browser = browser;
	}

	public void mouseOver(String location) {
		WebElement element = driver.findElement(By.xpath(location));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
	}

	public void mouseOverWait(String location) {
		WebDriverWait wait = new WebDriverWait(driver, 15, 100);
		WebElement element = driver.findElement(By.xpath(location));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(location)));
		actions.moveToElement(element).click().perform();
	}

//	public void doubleClick(String location) {
//		if (browser.equalsIgnoreCase("safari")) {
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			String script = "var elem = document.getElementById(\"" + location + "\");"
//					+ "if( document.createEvent) {"
//					+ "var evObj = document.createEvent('MouseEvents');"
//					+ "evObj.initEvent( 'mouseover', true, false );"
//					+ "elem.dispatchEvent(evObj);"
//					+ "} else if( document.createEventObject ) {"
//					+ "elem.fireEvent('onmouseover');" + "}";
//			System.out.println(script);
//			js.executeScript(script);
//		} else {
//			Actions action = new Actions(driver);
//			action.doubleClick(driver.findElement(By.xpath(location)));
//			action.perform();
//		}
//
//	}
	public void doubleClick(String location) {
		Actions action = new Actions(driver);
		action.doubleClick(driver.findElement(By.xpath(location)));
		action.perform();
	}
	
	public void doubleClickJS(String id) {
	
			JavascriptExecutor js = (JavascriptExecutor) driver;
			String script = "var elem = document.getElementById(\"" + id + "\");"
					+ "if( document.createEvent) {"
					+ "var evObj = document.createEvent('MouseEvents');"
					+ "evObj.initEvent( 'mouseover', true, false );"
					+ "elem.dispatchEvent(evObj);"
					+ "} else if( document.createEventObject ) {"
					+ "elem.fireEvent('onmouseover');" + "}";
			System.out.println(script);
			js.executeScript(script);

	}

	// public void doubleClick(String location) {
	// int counter = 0;
	// do {
	// Actions action = new Actions(driver);
	// action.doubleClick(driver.findElement(By.xpath(location)));
	// action.perform();
	// counter++;
	// if(driver.findElement(By.xpath(location)).isDisplayed()) {
	// break;
	// }
	// } while(counter < 5);
	//
	//
	// }
}
