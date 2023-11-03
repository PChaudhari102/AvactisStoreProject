package com.avactisstore.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.avactisstore.actiondriver.Action;
import com.avactisstore.base.BaseClass;
public class ProductList extends BaseClass{
	
	@FindBy(xpath = "//div[@class='ajax_message_box_text']/h2[text()='Product was added to your cart']")
	WebElement addToCardMgs;
	//div[@class='ajax_message_box_text']/h2[text()='Product was added to your cart']
	
	@FindBy(xpath = "//div[@class='product_name']")
	WebElement productName;
	
	
	@FindBy(xpath = "//div[@class='top-cart-block']")
	WebElement cartBlock;
	
	public ProductList(String subCategoryName) {
		PageFactory.initElements(driver, this);
	}
	
	public boolean clickAddToCartButton(String productID, String size, String qty, String ProductName) {
		
		String AddToCartButtonForGivenProduct = "ProductForm_"+ productID;
		System.out.println(AddToCartButtonForGivenProduct);
		
		WebElement formElementOfAddToCartButton;
		WebElement formElementOfDetailsButton;
		
		String sizeForGivenProduct = size;
		System.out.println(sizeForGivenProduct);
		
		
		
		WebElement formElementOfSize;
		//select[@name='po[22]' and option[@value="55" ]]-red
		//select[@name='po[18]' and option[@value="39" ]]-blue
		WebElement formElementOfQty;
		
		String QtyForGivenProduct = qty;
		System.out.println(QtyForGivenProduct);
		
		String ProductNameForGivenProduct = ProductName;
		System.out.println(ProductNameForGivenProduct);
		
		WebElement formElementOfProductName;
		
		
		try {
			
			formElementOfAddToCartButton=driver.findElement(By.xpath("//*[@id='" + AddToCartButtonForGivenProduct + "']/descendant::input[contains(@value,'Add To Cart')]"));
			System.out.println(formElementOfAddToCartButton);
			Action.click(driver, formElementOfAddToCartButton);
			//System.out.println("Add to cart is Successful");
			
			
			String actMgs = verifyaddToCardMgs();
			String expectedMgs = "PRODUCT WAS ADDED TO YOUR CART";
			//Assert.assertEquals(actMgs, expectedMgs,"Add to cart is not Successful");
			//System.out.println("Add to cart is Successful");
			
			
			
		if(actMgs.equals(expectedMgs)) {
			System.out.println("Add to cart is Successful");
			Action.click(driver, cartBlock);
			formElementOfProductName=driver.findElement(By.xpath("//a[text()='"+ProductName+"']"));
			//a[text()='Apple MacBook Air']
			Action.explicitWait(driver, formElementOfProductName);
			Action.isDisplayed(driver, formElementOfProductName);
			System.out.println("Product is Visible in cart");
			
			
		}else {
			System.out.println("Add to cart is Not Successful");
		}
		}catch(NoSuchElementException e)
		{
			try {
				formElementOfDetailsButton=driver.findElement(By.xpath("//*[@id='" + AddToCartButtonForGivenProduct + "']/descendant::a[contains(text(),'Details')]"));
				System.out.println(formElementOfDetailsButton);
				Action.click(driver, formElementOfDetailsButton);
				verifyProductName();
				System.out.println("Product Name is Displayed");
				
				formElementOfSize=driver.findElement(By.xpath("//option[@value='"+sizeForGivenProduct+"']"));
				//option[@value='39']
				//formElementOfSize=driver.findElement(By.xpath("//*[@name='po[18]' and option[@value='"+sizeForGivenProduct+"']]"));
				System.out.println(formElementOfSize);
				Action.explicitWait(driver, formElementOfSize);
				Action.click1(driver, formElementOfSize);
				
				
				formElementOfQty=driver.findElement(By.xpath("//option[@value='"+QtyForGivenProduct+"']"));
				//option[@value='39']
				//formElementOfSize=driver.findElement(By.xpath("//*[@name='po[18]' and option[@value='"+sizeForGivenProduct+"']]"));
				System.out.println(formElementOfQty);
				Action.explicitWait(driver, formElementOfQty);
				Action.click1(driver, formElementOfQty);
				
				formElementOfAddToCartButton=driver.findElement(By.xpath("//*[@id='" + AddToCartButtonForGivenProduct + "']/descendant::input[contains(@value,'Add To Cart')]"));
				System.out.println(formElementOfAddToCartButton);
				Action.click(driver, formElementOfAddToCartButton);
				//System.out.println("Add to cart is Successful");
				
				
				String actMgs = verifyaddToCardMgs();
				String expectedMgs = "PRODUCT WAS ADDED TO YOUR CART";
				//Assert.assertEquals(actMgs, expectedMgs,"Add to cart is not Successful");
				//System.out.println("Add to cart is Successful");
				
				
				
			if(actMgs.equals(expectedMgs)) {
				System.out.println("Add to cart is Successful");
				Action.click(driver, cartBlock);
				formElementOfProductName=driver.findElement(By.xpath("//a[text()='"+ProductName+"']"));
				//a[text()='Apple MacBook Air']
				Action.explicitWait(driver, formElementOfProductName);
				Action.isDisplayed(driver, formElementOfProductName);
				System.out.println("Product is Visible in cart");
			}else {
				System.out.println("Add to cart is Not Successful");
			}
				
			}catch(NoSuchElementException e1)
			{
				System.out.println("Problem with Page Loading");
			}
			
		}
		return false;
		
	}
	
	public String verifyaddToCardMgs()   {
		
		Action.explicitWait(driver, addToCardMgs);
		//Thread.sleep(3000);
		String actMgs =addToCardMgs.getText();
		return actMgs;
		}
    public void verifyProductName()   {
		
		Action.explicitWait(driver, productName);
		//Thread.sleep(3000);
		Action.isDisplayed(driver, productName);		
		}
    
 public void verifycartBlock()   {
		
		Action.explicitWait(driver, productName);
		//Thread.sleep(3000);
		Action.isDisplayed(driver, productName);		
		}
	
	}