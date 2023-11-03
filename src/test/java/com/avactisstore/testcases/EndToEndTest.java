package com.avactisstore.testcases;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.avactisstore.base.BaseClass;
import com.avactisstore.dataprovider.DataProviders;
import com.avactisstore.pageobjects.AdminCustomersPage;
import com.avactisstore.pageobjects.AdminIndexPage;
import com.avactisstore.pageobjects.AdminSignInPage;
//import com.avactisstore.pageobjects.BillingAndShippingMethods;
import com.avactisstore.pageobjects.CheckoutPage;
import com.avactisstore.pageobjects.HomePage;
import com.avactisstore.pageobjects.MyAccountPage;
import com.avactisstore.pageobjects.MySignInPage;
import com.avactisstore.pageobjects.ProductList;
import com.avactisstore.pageobjects.RegisterPage;
import com.avactisstore.pageobjects.StorePage;
import com.avactisstore.pageobjects.UserIndexPage;
import com.avactisstore.utility.Log;

public class EndToEndTest extends BaseClass {
	AdminSignInPage adminSignInPage;
	AdminIndexPage adminIndexPage;
	AdminCustomersPage adminCustomersPage;
	
	StorePage storePage;
	RegisterPage registerPage;
	MyAccountPage myAccountPage;
	HomePage homePage;
	MySignInPage mySignInPage;
	UserIndexPage userIndexPage;
	CheckoutPage checkoutPage;
	//BillingAndShippingMethods billingAndShippingMethods;
	

	@BeforeMethod
	public void setup() {
		launchApp();
		//driver.get(prop.getProperty("AdminUrl"));
		driver.get(prop.getProperty("url"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
@Test(dataProvider = "RegistrationData", dataProviderClass = DataProviders.class)
	public void GoToRegisterNewAccount(String mail, String pass, String rePass, String fName, String lName, String code,
			String cityName, String sLine1, String sLine2, String phoneNo) {
	    Log.startTestCase("GoToRegisterNewAccount");
		driver.get(prop.getProperty("url"));
		storePage = new StorePage();
		Log.info("user is going to click on MyAccount");
		myAccountPage = storePage.clickOnMyAccount();
		Log.info("user is going to click on Register Btn");
		registerPage = myAccountPage.registerNewAccount();
		Log.info("user is going to fill Up Registration Form");
		homePage=registerPage.fillUpRegistrationForm(mail, pass, rePass, fName, lName, 
				code, cityName, sLine1, sLine2, phoneNo);
		Log.info("user is going to click on Register Btn");
		registerPage.clickOnReg();
		Log.info("Verifying Success Message is Matched or Not");
		String actualSuccessMgs = homePage.verifySuccessMgs();
        String expectedSuccessMgs = "Account created successfully. You are now registered.";
		Assert.assertEquals(actualSuccessMgs, expectedSuccessMgs);
		Log.endTestCase("GoToRegisterNewAccount");
	}
	
	
	@Test(dataProvider = "ProductData1", dataProviderClass = DataProviders.class)
	public void checkOutUsingUrls(
			 String productPageContent, 
			 String categoryID,
			 String categoryName, 
			 String subCategoryID,
			 String subCategoryName,
			 String productID,
			 String Size, 
			 String qty, 
			 String ProductName,
			 String shipping_or_Tax, 
			 String checkbox_subscribe, 
			 String ShippingOption, 
			 String expectedactProName, 
			 String expectedProductTotalPrice, 
			 String expectedShippingHandlingPrice, 
			 String expectedOrderTotalPrice, String OrderTotalAdd
			 )  {
		Log.startTestCase("checkOutUsingUrls");
		storePage = new StorePage();
		//myAccountPage = storePage.clickOnMyAccount();
		Log.info("user is going to click on SignIn");
		mySignInPage=storePage.clickOnSignIn();
		Log.info("user is going to enter valid SignIn Credentials");
		homePage=mySignInPage.validSignInCredentials(prop.getProperty("StoreEmail"),
		     prop.getProperty("StorePassword"));
		Log.info("Verifying Manage Account Message is Matched or Not");
		  String actualAccountMgs = homePage.verifyManageAccountMgs();
		  String expectedAccountMgs = "MANAGE ACCOUNT AND VIEW ORDERS";
		  Assert.assertEquals(actualAccountMgs, expectedAccountMgs);
		  Log.info("user is going to click on Logo");
		  userIndexPage=homePage.clickOnMyLogo();
		  Log.info("Verifying Welcome Message is Matched or Not");
		boolean result=userIndexPage.validateWelcome();
		Assert.assertTrue(result);
		//new
		ProductList productList=userIndexPage.goToProductPageUsingUrl(subCategoryName, 
			productPageContent, subCategoryID);
		if(productList != null)
		{
			System.out.println("placeOrder called");
			placeOrder(productList, productID, Size, qty, ProductName);
			
		}
		else {
			fail("Could not go to required product List. Menu or submenu not available or not visible");
		}
		Log.info("user is going to click on Checkout Link");
		checkoutPage=userIndexPage.clickOnCheckoutLink();
		System.out.println("CheckoutOrder called");
		CheckoutOrder(shipping_or_Tax,checkbox_subscribe,ShippingOption,expectedactProName,expectedProductTotalPrice,
				expectedShippingHandlingPrice,expectedOrderTotalPrice,OrderTotalAdd);
		//checkoutPage.clickOnConCheckout();//conCheckoutPage=
		//input[@onclick='submitStep(1);']
		System.out.println("CheckoutOrder1 called");
		//CheckoutOrder1(ShippingOptions);
		//billingAndShippingMethods=conCheckoutPage.clickOnConCheckout1();
		Log.endTestCase("checkOutUsingUrls");
	
	}

	private void placeOrder(ProductList productList, String productID, String size, String qty, String ProductName)  {//String subCategoryName, String productPageContent,
		Log.startTestCase("placeOrder");
		Log.info("user is going to click on Add To Cart Button");
			productList.clickAddToCartButton(productID, size, qty, ProductName);
			Log.endTestCase("placeOrder");
	}
	
	private void CheckoutOrder(String shipping_or_Tax, String checkbox_subscribe, String ShippingOption, String expectedactProName, String expectedProductTotalPrice, String expectedShippingHandlingPrice, String expectedOrderTotalPrice, String OrderTotalAdd)  {//String subCategoryName, String productPageContent,
		Log.startTestCase("CheckoutOrder");
		Log.info("user is going to checkout Order With Link");
		checkoutPage.checkoutOrderWithLink(shipping_or_Tax, checkbox_subscribe, ShippingOption,expectedactProName,expectedProductTotalPrice,expectedShippingHandlingPrice,expectedOrderTotalPrice,OrderTotalAdd);
		Log.endTestCase("CheckoutOrder");
}
	
	@Test
	public void verifyOrderDetails() throws Throwable {
		Log.startTestCase("verifyOrderDetails");
		driver.get(prop.getProperty("AdminUrl"));
		adminSignInPage = new AdminSignInPage();
		Log.info("user is going to enter valid Admin SignIn Credentials");
		adminIndexPage =adminSignInPage.adminSignIn(prop.getProperty("AdminEmail"),
		        prop.getProperty("AdminPassword"));
		Log.info("user is going to click on Customers Button");
		adminCustomersPage=adminIndexPage.clickOnCustomers();
		Log.info("user is going to click on specific Customer by link");
		adminCustomersPage.clickOnPvcLink();
		Log.info("user is going to click on Order Button");
		adminCustomersPage.clickOnOrderBtn();
		
		
		Log.info("Verifying 1st Order Price is Matched or Not");		
		String actualOrderPrice1= adminCustomersPage.verifyActOrderPrice1(); 
		String expectedOrderPrice1 = "$869.40";
		Assert.assertEquals(actualOrderPrice1, expectedOrderPrice1);
		
		Log.info("Verifying 2nd Order Price is Matched or Not");	
		String actualOrderPrice2= adminCustomersPage.verifyActOrderPrice2(); 
		String expectedOrderPrice2 = "$33.26";
		Assert.assertEquals(actualOrderPrice2, expectedOrderPrice2);
		
		Log.info("Verifying 3rd Order Price is Matched or Not");	
		String actualOrderPrice3= adminCustomersPage.verifyActOrderPrice3();
		String expectedOrderPrice3 = "$1,852.97";
		Assert.assertEquals(actualOrderPrice3, expectedOrderPrice3);
		Log.endTestCase("verifyOrderDetails");
		
	}
	

	
	@Test
	public void DeleteCustomers() throws Throwable {
		Log.startTestCase("DeleteCustomers");
		driver.get(prop.getProperty("AdminUrl"));
		adminSignInPage = new AdminSignInPage();
		adminIndexPage =adminSignInPage.adminSignIn(prop.getProperty("AdminEmail"),
		        prop.getProperty("AdminPassword"));
		Log.info("user is going to click on Customers");
		adminCustomersPage=adminIndexPage.clickOnCustomers();
		Log.info("user is going to Delete Customers");
		adminCustomersPage.deleteCustomers();
		Log.info("Verifying warning message is Matched or Not");	
		String actualWarMgs= adminCustomersPage.getWarMgs();
		String expectedWarMgs = " Accounts deleted successfully.";
		Assert.assertEquals(actualWarMgs, expectedWarMgs);	
		Log.endTestCase("DeleteCustomers");

	}

}
