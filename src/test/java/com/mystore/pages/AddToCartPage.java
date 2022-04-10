package com.mystore.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mystore.actions.Action;
import com.mystore.common.Base;

public class AddToCartPage extends Base{
    
	Select sc;
	
	@FindBy(xpath="//span[@id='our_price_display']")
	WebElement priceDisplay;
	
	@FindBy(xpath="//input[@id='quantity_wanted']")
	WebElement quantity;
	
	@FindBy(xpath="//select[@id='group_1']")
	WebElement size;
	
	@FindBy(xpath="//span[contains(text(),'Add to cart')]")
	WebElement addToCartButton;
	
	@FindBy(xpath="//a[@id='wishlist_button']")
	WebElement wishlistBtn;
	
	@FindBy(xpath="//span[@class='ajax_block_cart_total']")
	WebElement TotalPriceDisplay;
	
	@FindBy(xpath="//*[@id='layer_cart']/div/div/div/a")
	WebElement proceedToCheckoutButn;
	
	
	
	
	
public AddToCartPage () {
		
		PageFactory.initElements(driver,this );
	}


public void setQntyAndSizeAndAddtoCart(String quant ,String fiting ) {
	
	quantity.clear();
	quantity.sendKeys(quant);
	sc=new Select(size);
	sc.selectByVisibleText(fiting);
	addToCartButton.click();
	
}

public String getUnitPrice() {
	
	String price =priceDisplay.getText().replace("$", "");
	return price;

}

public String getTotalPrice() {
	
	String TotalPrice=TotalPriceDisplay.getText().replace("$", "");
	return TotalPrice;
	
}
public String successAddToCartMsg()
{
	
	String cartMsg=driver.getPageSource();
	return cartMsg;	
	
}

public ShopingCartSummaryPage clickOnProceedToChkout() {
	
	Action.clickByJS(driver, proceedToCheckoutButn);
	return new ShopingCartSummaryPage();
}








	
}
