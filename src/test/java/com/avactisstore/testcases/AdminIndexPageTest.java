package com.avactisstore.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.avactisstore.base.BaseClass;
import com.avactisstore.pageobjects.AdminIndexPage;
import com.avactisstore.pageobjects.AdminSignInPage;

public class AdminIndexPageTest extends BaseClass {
	AdminSignInPage adminSignInPage;
	AdminIndexPage adminIndexPage;

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
	public void clickOnCustomers1() throws Throwable {
		adminSignInPage = new AdminSignInPage();
		adminIndexPage =adminSignInPage.adminSignIn(prop.getProperty("AdminEmail"),
		        prop.getProperty("AdminPassword"));
		adminIndexPage.clickOnCustomers();
		
	}
}
