package com.avactisstore.pageobjects;

import static org.testng.Assert.fail;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.avactisstore.actiondriver.Action;
import com.avactisstore.base.BaseClass;

public class AdminCustomersPage extends BaseClass{
	@FindBy(xpath = "(//div[@id='DeleteButton2'])[2]")
	WebElement Delete;
	
	@FindBy(xpath = "//button[@data-bb-handler='confirm']")
	WebElement Ok;
	
	@FindBy(xpath = "(//div[@class='note note-info note-bordered font-green-sharp'])[1]")
	WebElement getWarMgs;
	
	@FindBy(xpath = "(//tbody//tr//td//a[@href='javascript:void(0);'])[6]")
	WebElement pvcLink;
	
	@FindBy(xpath = "//tbody//tr//td//div[@class='panel panel-default'][4]")
	WebElement orderBtn;
	
	@FindBy(xpath = "(//div[@id='CancelButton'])[1]")
	WebElement closeBtn;
	
	
	//iframe[@class='cboxIframe']
	//@FindBy(xpath = "//iframe[@src ='popup_window.php?page_view=CustomerAccountInfo&customer_id=127']")
	@FindBy(xpath = "//iframe[@class='cboxIframe']")
	WebElement centerFrame ;
	
	//(//div[@class='panel-body']//tbody//tr//td[@class='text-center'])[33]
			//@FindBy(xpath = "(//tbody//tr//td[@class='text-center']//a[@href='javascript: void(0);'])[1]")
			
			@FindBy(xpath = "(//div[@class='panel-body']//tbody//tr//td[@class='text-center'])[33]")
			WebElement ActOrderPrice1;
			@FindBy(xpath = "(//div[@class='panel-body']//tbody//tr//td[@class='text-center'])[38]")
			WebElement ActOrderPrice2;
			@FindBy(xpath = "(//div[@class='panel-body']//tbody//tr//td[@class='text-center'])[43]")
			WebElement ActOrderPrice3;
	
	public AdminCustomersPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void deleteCustomers() {
		
		List<WebElement> allRows = driver.findElements(By.xpath("(//tbody)[2]//tr//td[1]"));

		Actions builder = new Actions(driver);
		builder.click(allRows.get(2))
		.keyDown(Keys.CONTROL)
		.click(allRows.get(3))
		.click(allRows.get(4))
		.keyUp(Keys.CONTROL).perform();
		
		Action.click(driver, Delete);
	
		
		
		
		/*
		 * String expectedWarMgs = " Accounts deleted successfully."; String
		 * actualWarMgs =getWarMgs.getText(); Assert.assertEquals(actualWarMgs,
		 * expectedWarMgs);
		 */
	}
	
	
	
	public String getWarMgs () throws Throwable {
		Action.JSClick(driver, Ok);
		String actualWarMgs =getWarMgs.getText();
		return actualWarMgs;
	}
	
	public  void clickOnPvcLink() throws InterruptedException  {//ConCheckoutPage
		Action.click(driver, pvcLink);
		//Thread.sleep(300);
		 Action.explicitWait(driver, centerFrame);
		//WebElement centerFrame = driver.findElement(By.xpath("//iframe[@src ='popup_window.php?page_view=CustomerAccountInfo&customer_id=127']"));
        
		driver.switchTo().frame(centerFrame);
		//Action.click(driver, closeBtn);

		
		//return new 	ConCheckoutPage();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
		//Action.explicitWait(driver, contentframe1);
		//WebElement contentframe1 = driver.findElement(By.xpath("//iframe[@frameborder='0']"));
		//Action.explicitWait(driver, contentframe1);
		//try {
		//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@frameborder='0']")));
		//Thread.sleep(3000);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tinymce")));
		//WebElement text = driver.findElement(By.xpath("//tbody//tr//td//div[@class='panel panel-default'][4]"));
		//Action.explicitWait(driver, text);
		//text.click();
		//Thread.sleep(3000);
		//text.sendKeys("This is a frame assignment");
		//Thread.sleep(3000);
		//} catch (NoSuchFrameException e) {
			//fail("contentframe1 Frame does not exist!!");
		}
	//	}
	
	public  void clickOnOrderBtn()  {//ConCheckoutPage
		Action.explicitWait(driver, orderBtn);
		Action.click(driver, orderBtn);
		//return new 	ConCheckoutPage();
		
		
		}
	
	public String verifyActOrderPrice1()   {
		Action.explicitWait(driver, ActOrderPrice1);
		//Thread.sleep(3000);
		String actOrderPrice1 =ActOrderPrice1.getText();
		System.out.println(actOrderPrice1);
		return actOrderPrice1;
		}
	
	public String verifyActOrderPrice2()   {
		Action.explicitWait(driver, ActOrderPrice2);
		//Thread.sleep(3000);
		String actOrderPrice2 =ActOrderPrice2.getText();
		System.out.println(actOrderPrice2);
		return actOrderPrice2;
		}
	
	public String verifyActOrderPrice3()   {
		Action.explicitWait(driver, ActOrderPrice3);
		//Thread.sleep(3000);
		String actOrderPrice3 =ActOrderPrice3.getText();
		System.out.println(actOrderPrice3);
		return actOrderPrice3;
		}
	

}
