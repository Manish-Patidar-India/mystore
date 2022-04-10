package com.mystore.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.common.Base;

public class PaymentPage extends Base {

	
	@FindBy(xpath="//*[@title='Pay by bank wire']")
	WebElement payByBankWireBtn;
	
	@FindBy(xpath="//*[text()='I confirm my order']")
	WebElement confirmOrderBtn;
	
	
	public PaymentPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnPayByBankWireBtn() {
		
		payByBankWireBtn.click();
		
	}
	
	public String clickOnConfirmBtn() {
		
		confirmOrderBtn.click();
		String orderCompletemsg=driver.getPageSource();
		return orderCompletemsg;
	}
	
	
	
	
	
	
	
	
}
