package testcases;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import pages.Product;

public class TC002_AddProducts extends commonMethods.DriverInstanceIndependent {
	@Description("Description : Adding Products into the cart")
	@Feature("Add Prodcuts")
	@Test
	public void addProducts() throws Exception {
		Product product = new Product(driver);

		product.AddProduct("backpack_addToCart_id");
		product.AddProduct("bikeLight_addToCart_id");
		product.AddProduct("tshirt_addToCart_id");
	}

}
