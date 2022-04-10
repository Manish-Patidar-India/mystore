package com.mystore.pages;

import java.util.HashMap;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mystore.common.Base;

public class AccountCreationPage extends Base {

	@FindBy(id = "uniform-id_gender1")
	WebElement mrRadioBtn;

	@FindBy(id = "uniform-id_gender2")
	WebElement mrsRadioBtn;

	@FindBy(xpath = "//input[@id='customer_firstname']")
	WebElement firstName;

	@FindBy(xpath = "//input[@id='customer_lastname']")
	WebElement lastName;

	@FindBy(xpath = "//input[@id='passwd']")
	WebElement password;

	@FindBy(xpath = "//select[@id='days']")
	WebElement date;

	@FindBy(xpath = "//select[@id='months']")
	WebElement month;

	@FindBy(xpath = "//select[@id='years']")
	WebElement year;

//	@FindBy(xpath="//input[@id='firstname']")
//	WebElement addressFirstName;
//	
//	@FindBy(xpath="//input[@id='lastname']")
//	WebElement addressLastName;

	@FindBy(xpath = "//input[@id='address1']")
	WebElement address;

	@FindBy(xpath = "//input[@id='city']")
	WebElement city;

	@FindBy(xpath = "//select[@id='id_state']")
	WebElement state;

	@FindBy(xpath = "//input[@id='postcode']")
	WebElement postalCode;

	@FindBy(xpath = "//select[@id='id_country']")
	WebElement country;

	@FindBy(xpath = "//input[@id='phone_mobile']")
	WebElement mobileNo;

	@FindBy(xpath = "//button[@id='submitAccount']")
	WebElement submitBtn;

	Select s;

	AccountCreationPage() {

		PageFactory.initElements(driver, this);
	}

	public String fillDetails(HashMap<String, String> hb) {

		if (hb.get("gender").equalsIgnoreCase("M")) {
			mrRadioBtn.click();
		} else {
			mrsRadioBtn.click();
		}

		firstName.sendKeys(hb.get("firstname"));
		lastName.sendKeys(hb.get("lastname"));
		password.sendKeys(hb.get("password"));
		s = new Select(date);
		s.selectByValue(hb.get("date"));
		s = new Select(month);
		s.selectByVisibleText(hb.get("month"));
		s = new Select(year);
		s.selectByValue(hb.get("year"));

		address.sendKeys(hb.get("address"));
		city.sendKeys(hb.get("city"));

		s = new Select(state);
		s.selectByVisibleText(hb.get("state"));

		postalCode.sendKeys(hb.get("zipcode"));

		s = new Select(country);
		s.selectByVisibleText(hb.get("country"));

		mobileNo.sendKeys(hb.get("mobileno"));

		submitBtn.click();
		
		return driver.getPageSource();
		
		

	}

}
