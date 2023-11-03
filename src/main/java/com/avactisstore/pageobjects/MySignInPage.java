package com.avactisstore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.avactisstore.actiondriver.Action;
import com.avactisstore.base.BaseClass;

public class MySignInPage extends BaseClass {
	@FindBy(id = "account_sign_in_form_email_id")
	WebElement signInEmail; 
	
	@FindBy(id = "account_sign_in_form_passwd_id")
	WebElement signInPassword;
	
	@FindBy(xpath = "//div[@class='col-lg-8 col-md-offset-2 padding-left-0 padding-top-20']") //a[text()='Sign In']
	
	WebElement signInBtn;
	
	@FindBy(xpath = "//div[@class='note note-danger']")
	WebElement dangerAccountMgs;
	
	public MySignInPage() {
		PageFactory.initElements(driver, this);
	}
	
	public MySignInPage invalidSignInCredentials(String mail, String pass) {
		Action.type(signInEmail, mail);
		Action.type(signInPassword, pass);
		Action.click(driver, signInBtn);
		return new MySignInPage();
	}
	public String verifyDangerSignInMgs()  {
		String actualDangerAccountMgs =dangerAccountMgs.getText();
		return actualDangerAccountMgs;
		}
	
	
	public HomePage validSignInCredentials(String mail, String pass) {
		Action.type(signInEmail, mail);
		Action.type(signInPassword, pass);
		Action.click(driver, signInBtn);
		return new HomePage();
	}


}
