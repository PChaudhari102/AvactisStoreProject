package com.avactisstore.testcases;

import static org.testng.Assert.fail;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.avactisstore.base.BaseClass;
import com.avactisstore.dataprovider.DataProviders;
//import com.avactisstore.pageobjects.BillingAndShippingMethods;
import com.avactisstore.pageobjects.CheckoutPage;
import com.avactisstore.pageobjects.HomePage;
//import com.avactisstore.pageobjects.ConCheckoutPage;
import com.avactisstore.pageobjects.MySignInPage;
import com.avactisstore.pageobjects.ProductList;
import com.avactisstore.pageobjects.RegisterPage;
import com.avactisstore.pageobjects.StorePage;
import com.avactisstore.pageobjects.UserIndexPage;

public class UserIndexPageTest extends BaseClass{
	StorePage storePage;
	RegisterPage registerPage;
	HomePage homePage;
	
	MySignInPage mySignInPage;
	UserIndexPage userIndexPage;
	CheckoutPage checkoutPage;
//	ConCheckoutPage conCheckoutPage;
	//BillingAndShippingMethods billingAndShippingMethods;
	
	@BeforeMethod
	public void setup() {
		launchApp();
		driver.get(prop.getProperty("url"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
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
		
		storePage = new StorePage();
		//myAccountPage = storePage.clickOnMyAccount();
		mySignInPage=storePage.clickOnSignIn();
		homePage=mySignInPage.validSignInCredentials(prop.getProperty("StoreEmail"),
		     prop.getProperty("StorePassword"));
		  String actualAccountMgs = homePage.verifyManageAccountMgs();
		  String expectedAccountMgs = "MANAGE ACCOUNT AND VIEW ORDERS";
		  Assert.assertEquals(actualAccountMgs, expectedAccountMgs);
		  userIndexPage=homePage.clickOnMyLogo();
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
		
		checkoutPage=userIndexPage.clickOnCheckoutLink();
		System.out.println("CheckoutOrder called");
		CheckoutOrder(shipping_or_Tax,checkbox_subscribe,ShippingOption,expectedactProName,expectedProductTotalPrice,
				expectedShippingHandlingPrice,expectedOrderTotalPrice,OrderTotalAdd);
		//checkoutPage.clickOnConCheckout();//conCheckoutPage=
		//input[@onclick='submitStep(1);']
		System.out.println("CheckoutOrder1 called");
		//CheckoutOrder1(ShippingOptions);
		//billingAndShippingMethods=conCheckoutPage.clickOnConCheckout1();
	
	}

	private void placeOrder(ProductList productList, String productID, String size, String qty, String ProductName)  {//String subCategoryName, String productPageContent,
		
			productList.clickAddToCartButton(productID, size, qty, ProductName);
			
			
			//String actMgs = productList.verifyaddToCardMgs();
			//String expectedMgs = "PRODUCT WAS ADDED TO YOUR CART";
			//Assert.assertEquals(actMgs, expectedMgs,"Add to cart is not Successful");
			//System.out.println("Add to cart is Successful");
		//if(actMgs.equals(expectedMgs)) {
		//	System.out.println("Add to cart is Successful");
		//}else {
		//	System.out.println("Add to cart is Not Successful");
		//}
	
		
	}
	
	private void CheckoutOrder(String shipping_or_Tax, String checkbox_subscribe, String ShippingOption, String expectedactProName, String expectedProductTotalPrice, String expectedShippingHandlingPrice, String expectedOrderTotalPrice, String OrderTotalAdd)  {//String subCategoryName, String productPageContent,
		
		checkoutPage.checkoutOrderWithLink(shipping_or_Tax, checkbox_subscribe, ShippingOption,expectedactProName,expectedProductTotalPrice,expectedShippingHandlingPrice,expectedOrderTotalPrice,OrderTotalAdd);
	
}

	
}
