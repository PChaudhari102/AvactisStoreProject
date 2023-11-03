package com.avactisstore.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.avactisstore.base.BaseClass;
import com.avactisstore.pageobjects.HomePage;
import com.avactisstore.pageobjects.MyAccountPage;
import com.avactisstore.pageobjects.RegisterPage;
import com.avactisstore.pageobjects.StorePage;

public class MyAccountPageTest extends BaseClass {
	StorePage storePage;
	RegisterPage registerPage;
	MyAccountPage myAccountPage;
	HomePage homePage;
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
	public void GoToRegisterNewAccount() {
		storePage =new StorePage();
		myAccountPage=storePage.clickOnMyAccount();
		String actUrl= myAccountPage.getMyAccountStoreUrl();
		String expectedUrl ="http://localhost/Avactis/sign-in.php";
		Assert.assertEquals(actUrl, expectedUrl);
		registerPage=myAccountPage.registerNewAccount();
		//homePage=myAccountPage.signInAccount(prop.getProperty("Email"), prop.getProperty("Password"));		
	}
}
