package com.avactisstore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.avactisstore.actiondriver.Action;
import com.avactisstore.base.BaseClass;

public class StorePage extends BaseClass {

	@FindBy(xpath = "//a[@class='site-logo']")
	WebElement myStoreLogo;

	@FindBy(xpath = "//a[text()='My Account']")
	WebElement myAccountLink;
	
	
	@FindBy(xpath = "//a[text()='Sign In']")
	WebElement mySignInLink;

	public StorePage() {
		PageFactory.initElements(driver, this);
	}

	public String getMyStoreUrl() {
		String myStoreUrl = driver.getCurrentUrl();
		return myStoreUrl;
	}
	public boolean validateLogo() {
		return Action.isDisplayed(driver, myStoreLogo);
	}

	public MyAccountPage clickOnMyAccount() {
		Action.click(driver, myAccountLink);
		return new MyAccountPage();
	}	
	
	public MySignInPage clickOnSignIn() {
		Action.click(driver, mySignInLink);
		return new MySignInPage();
	}	
}
