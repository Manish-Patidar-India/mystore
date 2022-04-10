package com.mystore.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.common.Base;

public class ShopingCartSummaryPage extends Base {

	@FindBy(xpath = "//*[text()=\"Proceed to checkout\"]")
	WebElement proceedToChkoutBtn;

	public ShopingCartSummaryPage() {

		PageFactory.initElements(driver, this);
	}

	public SignInPage clickOnProceedBtn() {

		proceedToChkoutBtn.click();
		return new SignInPage();
	}

}
