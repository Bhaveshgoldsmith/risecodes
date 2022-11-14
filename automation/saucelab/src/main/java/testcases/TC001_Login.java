package testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import commonMethods.DataGenerators;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import pages.LoginPage;

public class TC001_Login extends commonMethods.DriverInstanceIndependent {
	
	@Description("Description : Perform a login flow to the application")
	@Feature("Login")
	@Test(dataProvider = "Authentication")
	public void login(String uname, String pass) throws Exception {
		// Created a login page object
		LoginPage login = new LoginPage(driver);

		// passing username and calling enter username method
		login.enterUsername(uname);
		// passing password and calling enter password method
		login.enterPassword(pass);
		// logging into an application
		login.Login();

	}

	@DataProvider
	public Object[][] Authentication() throws Exception {
		// Object[][] testObjArray =
		// DataGenerators.TestDataGenerator("testdata/testdatalogin.xlsx", "login");
		Object[][] testObjArray = DataGenerators.TestDataGenerator(
				TC001_Login.class.getClassLoader().getResource("testdata/testdatalogin.xlsx").getFile(), "Login");
		return (testObjArray);
	}
}
