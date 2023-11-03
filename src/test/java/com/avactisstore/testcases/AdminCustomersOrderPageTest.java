package com.avactisstore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.avactisstore.base.BaseClass;
import com.avactisstore.pageobjects.AdminCustomersPage;
import com.avactisstore.pageobjects.AdminIndexPage;
import com.avactisstore.pageobjects.AdminSignInPage;

public class AdminCustomersOrderPageTest extends BaseClass {
	AdminSignInPage adminSignInPage;
	AdminIndexPage adminIndexPage;
	AdminCustomersPage adminCustomersPage;

	@BeforeMethod
	public void setup() {
		launchApp();
		driver.get(prop.getProperty("AdminUrl"));
		}

 @AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void verifyOrderDetails() throws Throwable {
		adminSignInPage = new AdminSignInPage();
		adminIndexPage =adminSignInPage.adminSignIn(prop.getProperty("AdminEmail"),
		        prop.getProperty("AdminPassword"));
		adminCustomersPage=adminIndexPage.clickOnCustomers();
		adminCustomersPage.clickOnPvcLink();
		adminCustomersPage.clickOnOrderBtn();
				
		String actualOrderPrice1= adminCustomersPage.verifyActOrderPrice1(); 
		String expectedOrderPrice1 = "$869.40";
		Assert.assertEquals(actualOrderPrice1, expectedOrderPrice1);
		
		
		String actualOrderPrice2= adminCustomersPage.verifyActOrderPrice2(); 
		String expectedOrderPrice2 = "$33.26";
		Assert.assertEquals(actualOrderPrice2, expectedOrderPrice2);
		
		String actualOrderPrice3= adminCustomersPage.verifyActOrderPrice3();
		String expectedOrderPrice3 = "$1,852.97";
		Assert.assertEquals(actualOrderPrice3, expectedOrderPrice3);
		
	}
}
