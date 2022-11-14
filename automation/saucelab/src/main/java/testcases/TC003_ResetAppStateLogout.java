package testcases;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import pages.Product;

public class TC003_ResetAppStateLogout extends commonMethods.DriverInstanceIndependent {
	@Description("Description : Reset App State and Logging out from an Application")
	@Feature("Reset App State & Logout")
	@Test
	public void login( )throws Exception {
		
		Product product = new Product(driver);

		product.OpenBurgerMenu();
		product.ResettingAppState();
		product.logout();
	}

	
}
