package com.mystore.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.common.Base;

public class AddressPage extends Base {

	
	@FindBy(xpath="//*[@name=\"processAddress\"]")
	WebElement proceedButn;
	
	
public AddressPage () {
		
		PageFactory.initElements(driver,this );
	}
	
	
public ShippingPage clickOnProceed() {
	
	proceedButn.click();
	return new ShippingPage();
}
	
	
	
	
	
}
