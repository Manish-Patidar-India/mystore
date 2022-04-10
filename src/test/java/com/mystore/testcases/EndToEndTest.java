package com.mystore.testcases;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.common.Base;
import com.mystore.pages.AddToCartPage;
import com.mystore.pages.AddressPage;
import com.mystore.pages.IndexPage;
import com.mystore.pages.PaymentPage;
import com.mystore.pages.ProductSearchResult;
import com.mystore.pages.ShippingPage;
import com.mystore.pages.ShopingCartSummaryPage;
import com.mystore.pages.SignInPage;

public class EndToEndTest extends Base {

	public static IndexPage ip = new IndexPage();
	public static ProductSearchResult psr;
	public static AddToCartPage acp;
	public static ShopingCartSummaryPage scsp;
	public static SignInPage sp;
	public static AddressPage ap;
	public static ShippingPage shp;
	public static PaymentPage pp;

	@Test(dataProviderClass=com.mystore.dataprovider.DataFetcher.class, dataProvider="data")
	public void placeOrderTest(HashMap<String,String> hm) {

		psr = ip.searchInSearchBox(hm.get("product"));
		acp = psr.clickOnProduct();
		acp.setQntyAndSizeAndAddtoCart(hm.get("quantity"),hm.get("size"));
		scsp = acp.clickOnProceedToChkout();
		sp = scsp.clickOnProceedBtn();
		ap = sp.logInCmngfromCartSumryPage();
		shp = ap.clickOnProceed();
		pp = shp.clickOnCheckboxAndproceeBtn();
		pp.clickOnPayByBankWireBtn();
		String succesmsg = pp.clickOnConfirmBtn();
		if (succesmsg.contains("Your order on My Store is complete")) {

			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);

		}

	}

}
