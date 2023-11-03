package com.avactisstore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.avactisstore.actiondriver.Action;
import com.avactisstore.base.BaseClass;

public class HomePage extends BaseClass{
	
	@FindBy(xpath = "(//div[@class='note note-success'])[1]")
	WebElement SuccessMgs;
	
	
	@FindBy(xpath = "//h3[text()='Manage Account and View Orders']")
	WebElement ManageAccountMgs;
	
	@FindBy(xpath = "//a[@class='site-logo']")
	WebElement myStoreLogo;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifySuccessMgs()  {
		String actualSuccessMgs =SuccessMgs.getText();
		return actualSuccessMgs;
		}
	
	public String verifyManageAccountMgs()  {
		String actualAccountMgs =ManageAccountMgs.getText();
		return actualAccountMgs;
		}
	
	public UserIndexPage clickOnMyLogo() {
		Action.click(driver, myStoreLogo);
		return new UserIndexPage();
	}
}
