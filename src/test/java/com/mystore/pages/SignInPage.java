package com.mystore.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.common.Base;

public class SignInPage extends Base {

	@FindBy(xpath = "//input[@id='email']")
	WebElement emailForSigninBox;

	@FindBy(xpath = " //input[@id='passwd']")
	WebElement password;

	@FindBy(xpath = "//*[@id='SubmitLogin']")
	WebElement signInButton;

	@FindBy(xpath = "//*[@name='email_create']")
	WebElement emailForCreationBox;

	@FindBy(xpath = "//button[@id='SubmitCreate']")
	WebElement createAccountButton;
	
	
	
public SignInPage() {
		
		PageFactory.initElements(driver,this );
	}
	
	
public String login() {
	
	emailForSigninBox.sendKeys(prop.getProperty("email"));
	password.sendKeys(prop.getProperty("password"));
	signInButton.click();
	String loggedInPageSource=driver.getPageSource();
	return loggedInPageSource;
}
	

public AccountCreationPage createAccount() {
	emailForCreationBox.sendKeys("manish121@gmail.com");
	createAccountButton.click();
	
	return new AccountCreationPage();
}
	
public String createAccountcheck() {
	emailForCreationBox.sendKeys("manish121@gmail.com");
	createAccountButton.click();
       String creationpPageSource=driver.getPageSource();
       
       return creationpPageSource;
}
	
public AddressPage logInCmngfromCartSumryPage() {
	
	emailForSigninBox.sendKeys(prop.getProperty("email"));
	password.sendKeys(prop.getProperty("password"));
	signInButton.click();
	return new AddressPage();
	
}
	
	

}