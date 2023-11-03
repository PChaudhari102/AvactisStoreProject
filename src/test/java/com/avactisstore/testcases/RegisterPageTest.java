package com.avactisstore.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.avactisstore.base.BaseClass;
import com.avactisstore.dataprovider.DataProviders;
import com.avactisstore.pageobjects.HomePage;
import com.avactisstore.pageobjects.MyAccountPage;
import com.avactisstore.pageobjects.RegisterPage;
import com.avactisstore.pageobjects.StorePage;

public class RegisterPageTest extends BaseClass {
	StorePage storePage;
	RegisterPage registerPage;
	MyAccountPage myAccountPage;
	HomePage homePage;

	@BeforeMethod
	public void setup() {
		launchApp();
		driver.get(prop.getProperty("url"));
	}

	// @AfterMethod
	public void tearDown() {
		driver.quit();
	}

	
	// RegisterData
	@Test(dataProvider = "RegistrationData", dataProviderClass = DataProviders.class)
	public void GoToRegisterNewAccount(String mail, String pass, String rePass, String fName, String lName, String code,
			String cityName, String sLine1, String sLine2, String phoneNo) {
		storePage = new StorePage();
		myAccountPage = storePage.clickOnMyAccount();
		registerPage = myAccountPage.registerNewAccount();

		String actUrl = registerPage.getRegisterPageUrl();
		String expectedUrl = "http://localhost/Avactis/register.php";
		Assert.assertEquals(actUrl, expectedUrl);

		registerPage.fillUpRegistrationForm(mail, pass, rePass, fName, lName, 
		code, cityName, sLine1, sLine2, phoneNo);	
	}

}
