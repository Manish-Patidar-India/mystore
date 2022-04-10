package com.mystore.testcases;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.common.Base;
import com.mystore.pages.AddToCartPage;
import com.mystore.pages.IndexPage;
import com.mystore.pages.ProductSearchResult;
import com.mystore.pages.ShopingCartSummaryPage;
import com.mystore.pages.SignInPage;

public class AddToCartPageTest extends Base {

	public static IndexPage ip = new IndexPage();
	public static ProductSearchResult psr;
	public static AddToCartPage acp;
	public static SignInPage sp;

	
	
	@Test(dataProviderClass=com.mystore.dataprovider.DataFetcher.class, dataProvider="data")
	public void verifyAddToCart(HashMap<String,String> hm ) {

		psr = ip.searchInSearchBox(hm.get("product"));
		acp = psr.clickOnProduct();
		acp.setQntyAndSizeAndAddtoCart(hm.get("quantity"),hm.get("size"));
		if (acp.successAddToCartMsg().contains("Product successfully added")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	@Test(dataProviderClass=com.mystore.dataprovider.DataFetcher.class, dataProvider="data")
	public void verifyTotalPrice(HashMap<String,String> hm) {

		psr = ip.searchInSearchBox(hm.get("product"));
		acp = psr.clickOnProduct();
		acp.setQntyAndSizeAndAddtoCart(hm.get("quantity"),hm.get("size"));
		double untprice = Double.parseDouble(acp.getUnitPrice());
		double totalprice = Double.parseDouble(acp.getTotalPrice());
		double expectedprice = (untprice * Double.parseDouble(((hm.get("quantity"))))) + 2.00;
		Assert.assertEquals(totalprice, expectedprice);

	}

	@Test(dataProviderClass=com.mystore.dataprovider.DataFetcher.class, dataProvider="data")
	public void verifyWishlist(HashMap<String,String> hm) {

		sp = ip.clickOnSignInButton();
		sp.login();
		psr = ip.searchInSearchBox(hm.get("product"));
		if (psr.clickonWishlist().contains("Added to your wishlist")) {

			Assert.assertTrue(true);

		} else {
			Assert.assertTrue(false);
		}

	}
}
