package com.mystore.actions;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Action {

	public static WebDriverWait wait;
	public static void clickByJS(WebDriver driver,WebElement element) {
		
		JavascriptExecutor js=(JavascriptExecutor) driver;		
		js.executeScript("arguments[0].click();", element);
		
	}
	
	public static void putExplicitWait(WebDriver driver,int seconds, WebElement element) {
		
		 wait=new WebDriverWait(driver, Duration.ofSeconds(seconds));
		 wait.until(ExpectedConditions.visibilityOf(element));
		
	}
}
