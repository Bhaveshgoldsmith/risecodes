package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import commonMethods.BaseClass;
import commonMethods.Utility;
import io.qameta.allure.Step;

public class Product extends BaseClass {
	WebDriver driver;

	public Product(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Adding Product to Cart")	
	public void AddProduct(String elementKey) throws IOException, InterruptedException {
		BaseClass.click(driver, Utility.fetchElementPropertyValue(elementKey));
		BaseClass.saveScreenshots(driver);
	}

	@Step("Opening Burger Menu")
	public void OpenBurgerMenu() throws IOException, InterruptedException {
		BaseClass.click(driver, Utility.fetchElementPropertyValue("burgerMenu_id"));
		BaseClass.saveScreenshots(driver);
	}

	@Step("Resetting App State")
	public void ResettingAppState() throws IOException, InterruptedException {
		BaseClass.click(driver, Utility.fetchElementPropertyValue("resetAppState_id"));
		BaseClass.saveScreenshots(driver);
	}
	
	@Step("Clicking on Logout")
	public void logout() throws IOException, InterruptedException {
		BaseClass.click(driver, Utility.fetchElementPropertyValue("logout_id"));
		BaseClass.saveScreenshots(driver);
	}

}
