package com.avactisstore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.avactisstore.base.BaseClass;
import com.avactisstore.dataprovider.DataProviders;
import com.avactisstore.pageobjects.HomePage;
import com.avactisstore.pageobjects.MyAccountPage;
import com.avactisstore.pageobjects.MySignInPage;
import com.avactisstore.pageobjects.RegisterPage;
import com.avactisstore.pageobjects.StorePage;

public class HomePageTest extends BaseClass{
	StorePage storePage;
	RegisterPage registerPage;
	MyAccountPage myAccountPage;
	HomePage homePage;
	
	MySignInPage mySignInPage;
	@BeforeMethod
	public void setup() {
		launchApp();
		driver.get(prop.getProperty("url"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void GoToHomePage(String mail, String pass, String rePass, String fName, String lName, String code,
			String cityName, String sLine1, String sLine2, String phoneNo) {
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
	
	@Test
	public void GoToHomePage2() {
		storePage = new StorePage();
		//myAccountPage = storePage.clickOnMyAccount();
		mySignInPage=storePage.clickOnSignIn();
		homePage=mySignInPage.validSignInCredentials(prop.getProperty("StoreEmail"),
		     prop.getProperty("StorePassword"));
		  String actualAccountMgs = homePage.verifyManageAccountMgs();
		  String expectedAccountMgs = "MANAGE ACCOUNT AND VIEW ORDERS";
		  Assert.assertEquals(actualAccountMgs, expectedAccountMgs);
		  homePage.clickOnMyLogo();
		 
	}
}
