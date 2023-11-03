package com.avactisstore.pageobjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.avactisstore.actiondriver.Action;
import com.avactisstore.base.BaseClass;

public class AdminIndexPage extends BaseClass {

	@FindBy(xpath = "//li[@id='menu-users']")
	WebElement Customers;

	public AdminIndexPage() {
		PageFactory.initElements(driver, this);
	}

	
	public AdminCustomersPage clickOnCustomers() { 
		
		Action.click(driver, Customers);
		return new AdminCustomersPage();
	}
	
}
