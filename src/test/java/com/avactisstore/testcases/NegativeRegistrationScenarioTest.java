package com.avactisstore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.avactisstore.base.BaseClass;
import com.avactisstore.dataprovider.DataProviders;
import com.avactisstore.pageobjects.AdminIndexPage;
import com.avactisstore.pageobjects.AdminSignInPage;
import com.avactisstore.pageobjects.HomePage;
import com.avactisstore.pageobjects.MyAccountPage;
import com.avactisstore.pageobjects.RegisterPage;
import com.avactisstore.pageobjects.StorePage;

public class NegativeRegistrationScenarioTest extends BaseClass {
	AdminSignInPage adminSignInPage;
	AdminIndexPage adminIndexPage;
	
	StorePage storePage;
	RegisterPage registerPage;
	MyAccountPage myAccountPage;
	HomePage homePage;

	@BeforeMethod
	public void setup() {
		launchApp();
	}
	
	 @AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void GoToRegisterNewAccount(String mail, String pass, String rePass, String fName, String lName, String code,
			String cityName, String sLine1, String sLine2, String phoneNo) {
		driver.get(prop.getProperty("url"));
		storePage = new StorePage();
		myAccountPage = storePage.clickOnMyAccount();
		registerPage = myAccountPage.registerNewAccount();

		String actUrl = registerPage.getRegisterPageUrl();
		String expectedUrl = "http://localhost/Avactis/register.php";
		Assert.assertEquals(actUrl, expectedUrl);

		homePage=registerPage.fillUpRegistrationForm(mail, pass, rePass, fName, lName, 
				code, cityName, sLine1, sLine2, phoneNo);
		registerPage.clickOnReg();

		String actualDangerMgs = registerPage.verifyDangerMgs();
        String expectedDangerMgs = "This account name is already taken. Please choose a different account name.";
		Assert.assertEquals(actualDangerMgs, expectedDangerMgs);
	}

}
