package commonMethods;

import java.io.IOException;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverInstanceIndependent{
	
	public static WebDriver driver;

	@BeforeSuite(alwaysRun = true)
	public static void initiateDriverInstance() throws IOException, InterruptedException {
		// DriverInstance.config = config_Property_File_Path;
		if (Utility.fetchConfigPropertyValue("browserName").toString().equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (Utility.fetchConfigPropertyValue("browserName").toString().equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}
		driver.get(Utility.fetchConfigPropertyValue("applicationLoginURL").toString());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		SessionId s = ((RemoteWebDriver) driver).getSessionId();
		System.out.println("Session Id is for method1: " + s);

	}

	@AfterSuite(alwaysRun = true)
	public void closeDriverInstance() {
		//DriverInstanceIndependent.driver.quit();
	}

}
