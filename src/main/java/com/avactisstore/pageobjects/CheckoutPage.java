package com.avactisstore.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.avactisstore.actiondriver.Action;
import com.avactisstore.base.BaseClass;



public class CheckoutPage extends BaseClass{
	
	@FindBy(xpath = "//input[@onclick='submitStep(1);']")
	WebElement conCheckout;
	
	@FindBy(xpath = "//input[@onclick='submitStep(2);']")
	WebElement conCheckout1;
	
	//@FindBy(xpath = "//input[@value='BCE5D24D-666C-43CA-94A0-D6F775903BE2_3']")
	@FindBy(xpath = "//h3[@class='shipping_methods']")
	WebElement clickOp;
	
	//h3[@class='shipping_methods']
	
	
	@FindBy(xpath = "(//tbody)//tr//td[1]//a")
	WebElement ProName;	//a[text()='Apple MacBook Air']
	
	@FindBy(xpath = "(//tbody)//tr//th[1]")
	WebElement item;
	
	
	@FindBy(xpath = "(//tbody)//tr//td[4]//span")
	WebElement productTotalPrice;
	
	@FindBy(xpath = "//input[@value='Place Order']")
	WebElement PlaceOrderBtn;
	
	@FindBy(xpath = "(//strong[@class='price'])[2]")
	WebElement shippingHandlingPrice;
	
	@FindBy(xpath = "//div[@class='note note-success note-bordered']") //(//strong[@class='price'])[4]
	WebElement conOrderBox;
	
	@FindBy(xpath = "(//div[@class='col-lg-6'])[1]")
	WebElement orderId;
	

	public CheckoutPage() {
		PageFactory.initElements(driver, this);
	}
	
	
public void checkoutOrderWithLink(String shipping_or_Tax, String checkbox_subscribe, String ShippingOption, 
		String expectedactProName, String expectedProductTotalPrice, String expectedShippingHandlingPrice, 
		String expectedOrderTotalPrice, String OrderTotalAdd) {
		

		
		String checkbox_shipping_or_Tax_ForGivenProduct = shipping_or_Tax;
		System.out.println(checkbox_shipping_or_Tax_ForGivenProduct);		
		WebElement formElementOfShippingOrTax;
		
		String checkbox_subscribe_ForGivenProduct = checkbox_subscribe;
		System.out.println(checkbox_subscribe_ForGivenProduct);		
		WebElement formElementOfSubscribe;
		
		String ShippingOptions_ForGivenProduct = ShippingOption;
		System.out.println(ShippingOptions_ForGivenProduct); 
		WebElement formElementOfShippingOptions;
		
		String OrderTotal_ForGivenProduct = OrderTotalAdd;
		System.out.println(OrderTotal_ForGivenProduct);		
		WebElement formElementOfOrderTotal;
		

			
			formElementOfShippingOrTax=driver.findElement(By.xpath("//input[@name='"+checkbox_shipping_or_Tax_ForGivenProduct+"']"));
			//option[@value='39']
			//formElementOfSize=driver.findElement(By.xpath("//*[@name='po[18]' and option[@value='"+sizeForGivenProduct+"']]"));
			System.out.println(formElementOfShippingOrTax);
			//Action.explicitWait(driver, formElementOfShippingOrTax);
			Action.click1(driver, formElementOfShippingOrTax);
			
			
			formElementOfSubscribe=driver.findElement(By.xpath("//input[@name='"+checkbox_subscribe_ForGivenProduct+"']"));
			//option[@value='39']
			//formElementOfSize=driver.findElement(By.xpath("//*[@name='po[18]' and option[@value='"+sizeForGivenProduct+"']]"));
			System.out.println(formElementOfSubscribe);
			//Action.explicitWait(driver, formElementOfShippingOrTax);
			Action.click1(driver, formElementOfSubscribe);
			
			clickOnConCheckout();
			
			Action.explicitWait(driver, clickOp);
			
			formElementOfShippingOptions=driver.findElement(By.xpath("//input[@value='"+ShippingOptions_ForGivenProduct+"']"));
			System.out.println(formElementOfShippingOptions);
			//Action.explicitWait(driver, formElementOfShippingOrTax);
			//Action.scrollByVisibilityOfElement(driver, formElementOfShippingOptions);
			//driver.navigate().refresh(); 
			Action.explicitWait(driver, formElementOfShippingOptions);
			
			Action.click1(driver, formElementOfShippingOptions);
			clickOnConCheckout1();
			
			
			String actProName = verifyProdName();
			
			formElementOfOrderTotal=driver.findElement(By.xpath("(//strong[@class='price'])["+OrderTotal_ForGivenProduct+"]"));
			System.out.println(formElementOfOrderTotal);
			//String expectedactProName = "Apple MacBook Air";
			
			//Assert.assertEquals(actProName, expectedactProName,"Product is Apple MacBook Air");
			//a[text()='Apple MacBook Air']
			
			 if(actProName.equals(expectedactProName)) {
				 System.out.println("Product is same as expected");
				//String actProductTotalPrice = verifyProductTotalPrice();
				 String actProductTotalPrice =productTotalPrice.getText();
				 System.out.println(actProductTotalPrice);
				 System.out.println(expectedProductTotalPrice);
				 if (actProductTotalPrice.equals(expectedProductTotalPrice)) {
					 System.out.println("Total Price of Product is same as expected");
					//strong[text()='$107.94']
					 String actShippingHandlingPrice =shippingHandlingPrice.getText();
					 System.out.println(actShippingHandlingPrice);
						System.out.println(expectedShippingHandlingPrice);
					 Assert.assertEquals(actShippingHandlingPrice, expectedShippingHandlingPrice,"Shipping Handling Price not Same");
					 
					 String actOrderTotalPrice =formElementOfOrderTotal.getText();
					 System.out.println(actOrderTotalPrice);
						System.out.println(expectedOrderTotalPrice);
					 Assert.assertEquals(actOrderTotalPrice, expectedOrderTotalPrice,"Order Total Price not Same");
					 clickOnPlaceOrderBtn();
					 validateConOrderBox();
					 verifyOrderId();
				}else {
					 System.out.println("Total Price of Product is not same");				  
				}
				 //Action.isDisplayed(driver, formElementOfProductName);
			  
			// clickOnPlaceOrderBtn();
			 } else {
			  System.out.println("Product is not same as expected");
			  }
			
		}

public  void clickOnConCheckout()  {//ConCheckoutPage
	Action.click(driver, conCheckout);
	//return new 	ConCheckoutPage();
	}

public  void clickOnConCheckout1()  {//ConCheckoutPage
	Action.click(driver, conCheckout1);
	//return new 	ConCheckoutPage();
	}

public String verifyProdName()   {
	Action.explicitWait(driver, item);
	
	Action.explicitWait(driver, ProName);
	//Thread.sleep(3000);
	String actProName =ProName.getText();
	System.out.println(actProName);
	return actProName;
	}

public String verifyProductTotalPrice()   {
	
	Action.explicitWait(driver, productTotalPrice);
	//Thread.sleep(3000);
	String actProductTotalPrice =productTotalPrice.getText();
	System.out.println(actProductTotalPrice);
	return actProductTotalPrice;
	}

	/*
	 * public String verifyShippingHandlingPrice() {
	 * 
	 * Action.explicitWait(driver, shippingHandlingPrice); //Thread.sleep(3000);
	 * String actShippingHandlingPrice =shippingHandlingPrice.getText();
	 * System.out.println(actShippingHandlingPrice); return
	 * actShippingHandlingPrice; }
	 */
public  void clickOnPlaceOrderBtn()  {//ConCheckoutPage
	Action.click(driver, PlaceOrderBtn);
	//return new 	ConCheckoutPage();
	}

public boolean validateConOrderBox() { 
	 Action.isDisplayed(driver, conOrderBox); 
	 System.out.println("Your order is placed.");
	return false; 
	 }

public String verifyOrderId()   {
	Action.explicitWait(driver, orderId);
	//Thread.sleep(3000);
	String actOrderId =orderId.getText();
	System.out.println(actOrderId);
	return actOrderId;
	}


}
