package com.avactisstore.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.avactisstore.base.BaseClass;
import com.avactisstore.pageobjects.HomePage;
import com.avactisstore.pageobjects.MySignInPage;
import com.avactisstore.pageobjects.RegisterPage;
import com.avactisstore.pageobjects.StorePage;

public class PositiveLoginScenarioTest extends BaseClass{
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
