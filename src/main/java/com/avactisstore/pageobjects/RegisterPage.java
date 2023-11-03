package com.avactisstore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.avactisstore.actiondriver.Action;
import com.avactisstore.base.BaseClass;

public class RegisterPage extends BaseClass{
	
	@FindBy(name = "customer_info[Customer][Email]")
	WebElement email;

	@FindBy(name = "customer_info[Customer][Password]")
	WebElement password;

	@FindBy(name = "customer_info[Customer][RePassword]")
	WebElement rePassword;

	@FindBy(name = "customer_info[Customer][FirstName]")
	WebElement firstName;

	@FindBy(name = "customer_info[Customer][LastName]")
	WebElement lastName;

	@FindBy(xpath = "//select[@name='customer_info[Customer][Country]']/option[@value='100']")
	WebElement country;

	@FindBy(xpath = "//select[@name='customer_info[Customer][State]']/option[@value='636']")
	WebElement state;

	@FindBy(name = "customer_info[Customer][ZipCode]")
	WebElement zipCode;

	@FindBy(name = "customer_info[Customer][City]")
	WebElement city;
	
	@FindBy(name = "customer_info[Customer][Streetline1]")
	WebElement streetLine1;

	@FindBy(name = "customer_info[Customer][Streetline2]")
	WebElement streetLine2;

	@FindBy(name = "customer_info[Customer][Phone]")
	WebElement phone;

	@FindBy(xpath = "//input[@value='Register']")
	WebElement registerBtn;
	
	@FindBy(xpath = "(//div[@class='note note-danger'])[1]")
	WebElement DangerMgs;
	
	public RegisterPage() {
		PageFactory.initElements(driver, this);
	}
	
	public HomePage fillUpRegistrationForm(String mail, String pass, 
			String rePass, String fName, String lName, String code,
			String cityName, String sLine1, String sLine2, String phoneNo) {
		Action.type(email, mail);
		Action.type(password, pass);
		Action.type(rePassword, rePass);
		Action.type(firstName, fName);
		Action.type(lastName, lName);
		Action.click1(driver, country);
		Action.click1(driver, state);
		Action.type(zipCode, code);
		Action.type(city, cityName);
		Action.type(streetLine1, sLine1);
		Action.type(streetLine2, sLine2);
		Action.type(phone, phoneNo);
		return new HomePage();		
	}
	
	public void clickOnReg()  {
		Action.click(driver, registerBtn);
		
		}
	public String verifyDangerMgs()  {
		String actualDangerMgs =DangerMgs.getText();
		return actualDangerMgs;
		}
	
	public String getRegisterPageUrl() {
		String RegisterPageUrl = driver.getCurrentUrl();
		return RegisterPageUrl;
	}
}
