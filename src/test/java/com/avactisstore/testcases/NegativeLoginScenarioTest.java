package com.avactisstore.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.avactisstore.base.BaseClass;
import com.avactisstore.pageobjects.HomePage;
import com.avactisstore.pageobjects.MySignInPage;
import com.avactisstore.pageobjects.RegisterPage;
import com.avactisstore.pageobjects.StorePage;

public class NegativeLoginScenarioTest extends BaseClass{
	StorePage storePage;
	RegisterPage registerPage;
	HomePage homePage;
	
	MySignInPage mySignInPage;
	
	@BeforeMethod
	public void setup() {
		launchApp();
		driver.get(prop.getProperty("url"));
	}
	
	//@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void GoToHomePage3() {
		storePage =new StorePage();
		mySignInPage=storePage.clickOnSignIn();
		mySignInPage.invalidSignInCredentials(prop.getProperty("StoreInvalidEmail"),
		        prop.getProperty("StoreInvalidPassword"));
		 String actualDangerAccountMgs = mySignInPage.verifyDangerSignInMgs();
		  String expectedDangerAccountMgs = "Account and password could not be identified. Try again or create an account.";
		  Assert.assertEquals(actualDangerAccountMgs, expectedDangerAccountMgs);
	}

}
