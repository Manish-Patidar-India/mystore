package com.mystore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.common.Base;
import com.mystore.utility.Logging;

public class IndexPage extends Base {

	Actions ac;
	
	@FindBy(xpath ="//a[contains(text(),'Sign in')]")
	WebElement signInButton;

	@FindBy(xpath ="//*[@id='search_query_top']")
	WebElement searchBox;

	@FindBy(xpath ="//img[@class='logo img-responsive']")
	WebElement logo;

public IndexPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public SignInPage clickOnSignInButton() {
        
		Logging.logInfo("clicking on sign in button");      //we have creted logginf class in utility package and creed there different functions
		signInButton.click();
		return new SignInPage();
	}

	public ProductSearchResult searchInSearchBox(String product) {

		searchBox.sendKeys(product);
		ac = new Actions(driver);
		ac.keyDown(Keys.ENTER).perform();
		ac.keyDown(Keys.ENTER).perform();

		return new ProductSearchResult();
	}

	public boolean checkLogo() throws InterruptedException {
		return driver.findElement(By.xpath("//img[@class='logo img-responsive']")).isDisplayed();

//                   logo.isDisplayed();
		
	}

	public String getTitle() {

		String title = driver.getTitle();
		return title;
	}
}
