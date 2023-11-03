package com.avactisstore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.avactisstore.actiondriver.Action;
import com.avactisstore.base.BaseClass;

public class AdminSignInPage extends BaseClass {
	@FindBy(xpath = "//input[@type='text' and @name='AdminEmail']")
	WebElement AdminEmail;
	
	@FindBy(xpath = "//input[@type='password' and @name='Password']")
	WebElement AdminPassword;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement Adminsubmit;
	
	public AdminSignInPage() {
		PageFactory.initElements(driver, this);
	}
	
	public AdminIndexPage adminSignIn(String amail, String apass) {
		Action.type(AdminEmail, amail);
		Action.type(AdminPassword, apass);
		Action.click(driver, Adminsubmit);
		return new AdminIndexPage();
	}
	
}
