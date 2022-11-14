package commonMethods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Attachment;

public class BaseClass extends DriverInstanceIndependent {


	public static void navigate(WebDriver driver, String navaigateToURL) {
		driver.get(navaigateToURL.toString());
	}

	
	public static void click(WebDriver driver, String locator) {
		String key = "";
		WebElement element = null;
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		WebDriverWait shortWait = new WebDriverWait(driver, 20);
		try {
			key = Utility.fetchLocatorKey(locator);
		} catch (Exception e) {
			System.out.println("Exception in enterValue method, " + e.getMessage());
		}
		if (key.endsWith("id")) {
			element = shortWait.until(ExpectedConditions.elementToBeClickable(By.id(locator)));
			driver.findElement(By.id(locator)).click();
		} else if (key.endsWith("cssselector")) {
			element = shortWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(locator)));
			driver.findElement(By.cssSelector(locator)).click();
		} else if (key.endsWith("linktext")) {
			element = shortWait.until(ExpectedConditions.elementToBeClickable(By.linkText(locator)));
			driver.findElement(By.linkText(locator)).click();
		} else if (key.endsWith("xpath")) {
			element = shortWait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
			driver.findElement(By.xpath(locator)).click();
		} else if (key.endsWith("classname")) {
			element = shortWait.until(ExpectedConditions.elementToBeClickable(By.className(locator)));
			driver.findElement(By.className(locator)).click();
		} else {
			element = shortWait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
			driver.findElement(By.xpath(locator)).click();
		}
	}
	
	
	// Method to send value in any text box by ID
		public static void enterValue(WebDriver driver, String locator, String value) {
			String key = "";
			WebElement element = null;
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, 200);
			try {
				key = Utility.fetchLocatorKey(locator);
			} catch (Exception e) {
				System.out.println("Exception in enterValue method, " + e.getMessage());
			}
			if (key.endsWith("id")) {
				element = wait.until(ExpectedConditions.elementToBeClickable(By.id(locator)));
				element.clear();
				element.sendKeys(value);
			}
			if (key.endsWith("cssselector")) {
				element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(locator)));
				element.clear();
				element.sendKeys(value);
			} else if (key.endsWith("linktext")) {
				element = wait.until(ExpectedConditions.elementToBeClickable(By.linkText(locator)));
				element.clear();
				element.sendKeys(value);
			} else if (key.endsWith("xpath")) {
				element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
				element.clear();
				element.sendKeys(value);
			}
		}

	

	@Attachment(value = "My Screenshot", type = "image/png")
	public static byte[] saveScreenshots(WebDriver driver) {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}
}
