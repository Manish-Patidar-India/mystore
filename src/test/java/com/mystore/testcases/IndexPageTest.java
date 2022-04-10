package com.mystore.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.common.Base;
import com.mystore.pages.IndexPage;
import com.mystore.pages.SignInPage;

public class IndexPageTest extends Base {

	public static  IndexPage ip=new IndexPage();
		
//	@BeforeMethod
//	public void setup() {
//		launchApp();
//		
//	}
//	
//	@AfterMethod
//	public void close() {
//		tearDown();
//	}
	
	@Test
	public void verifyLogo() throws InterruptedException {
		
		
		boolean isLogoPrsent=ip.checkLogo();
		System.out.println(isLogoPrsent);
		Assert.assertTrue(isLogoPrsent);
		
	}
	
	@Test
	public void verifyTitle() {
		
		String expectedtitle="My Store";
		String actualTitle=ip.getTitle();
		Assert.assertEquals(expectedtitle, actualTitle);
	}
	
//	@Test
//	public void verifySignIn() {
//		
//		
//		SignInPage sp=ip.clickOnSignInButton();
//		boolean result= sp.login().contains("Welcome to your acco");
//		
//		Assert.assertTrue(result);
//	}
}
