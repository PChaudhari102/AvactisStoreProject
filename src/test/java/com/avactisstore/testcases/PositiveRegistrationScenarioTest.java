package com.avactisstore.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.avactisstore.base.BaseClass;
import com.avactisstore.dataprovider.DataProviders;
import com.avactisstore.pageobjects.AdminCustomersPage;
import com.avactisstore.pageobjects.AdminIndexPage;
import com.avactisstore.pageobjects.AdminSignInPage;
import com.avactisstore.pageobjects.HomePage;
import com.avactisstore.pageobjects.MyAccountPage;
import com.avactisstore.pageobjects.RegisterPage;
import com.avactisstore.pageobjects.StorePage;

public class PositiveRegistrationScenarioTest extends BaseClass {
	AdminSignInPage adminSignInPage;
	AdminIndexPage adminIndexPage;
	AdminCustomersPage adminCustomersPage;
	
	StorePage storePage;
	RegisterPage registerPage;
	MyAccountPage myAccountPage;
	HomePage homePage;

	@BeforeMethod
	public void setup() {
		launchApp();
	}
	
	// @AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(dataProvider = "RegistrationData", dataProviderClass = DataProviders.class)
	public void GoToRegisterNewAccount(String mail, String pass, String rePass, String fName, String lName, String code,
			String cityName, String sLine1, String sLine2, String phoneNo) {
		driver.get(prop.getProperty("url"));
		storePage = new StorePage();
		myAccountPage = storePage.clickOnMyAccount();
		registerPage = myAccountPage.registerNewAccount();
		homePage=registerPage.fillUpRegistrationForm(mail, pass, rePass, fName, lName, 
				code, cityName, sLine1, sLine2, phoneNo);
		registerPage.clickOnReg();
		String actualSuccessMgs = homePage.verifySuccessMgs();
        String expectedSuccessMgs = "Account created successfully. You are now registered.";
		Assert.assertEquals(actualSuccessMgs, expectedSuccessMgs);
	}
	
	//@Test
	public void DeleteCustomers() throws Throwable {
		driver.get(prop.getProperty("AdminUrl"));
		adminSignInPage = new AdminSignInPage();
		adminIndexPage =adminSignInPage.adminSignIn(prop.getProperty("AdminEmail"),
		        prop.getProperty("AdminPassword"));
		
		adminCustomersPage=adminIndexPage.clickOnCustomers();
		adminCustomersPage.deleteCustomers();
		String actualWarMgs= adminCustomersPage.getWarMgs();
		String expectedWarMgs = " Accounts deleted successfully.";
		
		Assert.assertEquals(actualWarMgs, expectedWarMgs);	

	}

}
