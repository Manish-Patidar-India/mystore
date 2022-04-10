package com.mystore.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.common.Base;

public class ProductSearchResult extends Base {
	
	 static Actions ac;

	@FindBy(xpath = "//*[@class='product-image-container']")
	List<WebElement> allImages;
	
	@FindBy(xpath="//a[contains(text(),'Add to Wishlist')]")
	List <WebElement> wishlistButtons;

	public ProductSearchResult() {

		PageFactory.initElements(driver, this);
	}

	public AddToCartPage clickOnProduct() {

		allImages.get(0).click();

		return new AddToCartPage();

	}

	public boolean productAvailibilty() {
		return allImages.get(0).isDisplayed();

	}
	
	public String clickonWishlist() {
		 ac=new Actions(driver);
		 ac.moveToElement(allImages.get(0)).perform();
		 wishlistButtons.get(0).click();
		String msg=driver.switchTo().alert().getText();
		driver.switchTo().alert().dismiss();
		return msg;
		 
		 
		
		
	}

}
