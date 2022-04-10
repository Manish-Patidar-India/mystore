package com.mystore.testcases;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.common.Base;
import com.mystore.dataprovider.DataFetcher;
import com.mystore.pages.AccountCreationPage;
import com.mystore.pages.IndexPage;
import com.mystore.pages.SignInPage;

public class AccountCreationpageTest extends Base{

	public static  IndexPage ip=new IndexPage();
	
	@Test
	public void verifyAccCreationlandingPage() {
		
		SignInPage sp=ip.clickOnSignInButton();
		if (sp.createAccountcheck().contains("CREATE AN ACCOUNT")) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		
	}
	
	@Test(dataProviderClass=DataFetcher.class, dataProvider="AccountCreationDetails")
	public void verifyNewAcc(HashMap<String,String> hm) {
		
		SignInPage sp=ip.clickOnSignInButton();
		AccountCreationPage acp=sp.createAccount();
		String pagesource=acp.fillDetails(hm);
		
		if(pagesource.contains("Welcome to your account")) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}
	
	
	
	
	
	
}
