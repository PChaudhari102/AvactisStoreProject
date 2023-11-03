package com.avactisstore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.avactisstore.actiondriver.Action;
import com.avactisstore.base.BaseClass;

public class UserIndexPage extends BaseClass{
	@FindBy(xpath = "//span[@class='header_wel' and text()='Welcome,']")
	WebElement welcome;
	
	@FindBy(xpath = "//a[@href='checkout.php']")
	WebElement checkoutLink;
	
	
	
	public UserIndexPage() {
		PageFactory.initElements(driver, this);
	}
	
	 public boolean validateWelcome() { 
		 return Action.isDisplayed(driver, welcome); 
		 }
	 
	 public ProductList goToProductPageUsingUrl(String subCategoryName, 
			 String productPageContent, String subCategoryID) {
		 String url = "http://localhost/Avactis/";
		 String constructedUrl = url + "product-list.php?"+subCategoryName
				 +productPageContent.trim()+subCategoryID+".html";
		 System.out.println(constructedUrl);
		 driver.get(constructedUrl);
		 ProductList productList=new ProductList(subCategoryName);
			return productList;		
		}
	 
	 public CheckoutPage clickOnCheckoutLink()  {
			Action.click(driver, checkoutLink);
			return new 	CheckoutPage();
			}
	 
	
}
