package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import commonMethods.BaseClass;
import commonMethods.Utility;
import io.qameta.allure.Step;

public class LoginPage extends BaseClass {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Entering username in Username field on login page")	
	public void enterUsername(String uname) throws IOException {
		BaseClass.enterValue(driver, Utility.fetchElementPropertyValue("login_username_id"), uname);		
		BaseClass.saveScreenshots(driver);
	}

	@Step("Entering Password in Password field on login page")	
	public void enterPassword(String pass) throws IOException {
		BaseClass.enterValue(driver, Utility.fetchElementPropertyValue("login_password_id"), pass);		
		BaseClass.saveScreenshots(driver);
	}

	@Step("Clicking on Login Button")	
	public void Login() throws IOException, InterruptedException {
		BaseClass.click(driver, Utility.fetchElementPropertyValue("login_button_id"));
		System.out.println("User has clicked on the Login Button");		
		BaseClass.saveScreenshots(driver);
	}

}
