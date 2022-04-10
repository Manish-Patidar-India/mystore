package com.mystore.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.common.Base;

public class ShippingPage extends Base {

	@FindBy(id="cgv")
	WebElement checkbox;
	
	
	@FindBy(xpath="//*[@name=\"processCarrier\"]")
	WebElement proceedButn;
	

public ShippingPage () {
		
		PageFactory.initElements(driver,this );
	}
	
public PaymentPage clickOnCheckboxAndproceeBtn() {
	
	checkbox.click();
	proceedButn.click();
	return new PaymentPage();
}



	
	
}
