package com.avactisstore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.avactisstore.base.BaseClass;
import com.avactisstore.pageobjects.StorePage;
import com.avactisstore.utility.Log;


public class StorePageTest extends BaseClass {
	StorePage storePage;
	@BeforeMethod
	public void setup() {
		launchApp();
		driver.get(prop.getProperty("url"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void GoToMyAccountPage() {
		Log.startTestCase("GoToMyAccountPage");
		storePage =new StorePage();
		Log.info("Verifying Url is Matched or Not");
		String actUrl= storePage.getMyStoreUrl();
		
		Assert.assertEquals(actUrl, "http://localhost/Avactis/");
		boolean result=storePage.validateLogo();
		Assert.assertTrue(result);
		Log.info("user is going to click on MyAccount");
		storePage.clickOnMyAccount();
		Log.info("user is going to click on SignIn");
		storePage.clickOnSignIn();
		 Log.endTestCase("GoToMyAccountPage");
	}

}
