package com.avactisstore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.avactisstore.actiondriver.Action;
import com.avactisstore.base.BaseClass;

public class MyAccountPage extends BaseClass {
	@FindBy(xpath = "//button[text()='Register']")
	WebElement registerBtn;
	
	public MyAccountPage() {
		PageFactory.initElements(driver, this);
	}

	public RegisterPage registerNewAccount() {
		Action.click1(driver, registerBtn);
		return new RegisterPage();
	}
	
	public String getMyAccountStoreUrl() {
		String myAccountUrl = driver.getCurrentUrl();
		return myAccountUrl;
	}
	

}
