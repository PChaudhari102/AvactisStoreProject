package com.avactisstore.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.avactisstore.base.BaseClass;
import com.avactisstore.pageobjects.AdminCustomersPage;
import com.avactisstore.pageobjects.AdminIndexPage;
import com.avactisstore.pageobjects.AdminSignInPage;

public class AdminCustomersPageTest extends BaseClass {
	AdminSignInPage adminSignInPage;
	AdminIndexPage adminIndexPage;
	AdminCustomersPage adminCustomersPage;

	@BeforeMethod
	public void setup() {
		launchApp();
		driver.get(prop.getProperty("AdminUrl"));
		}

	// @AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void deleteCustomers() throws Throwable {
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
