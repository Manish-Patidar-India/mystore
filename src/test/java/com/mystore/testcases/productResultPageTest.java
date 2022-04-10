package com.mystore.testcases;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.common.Base;
import com.mystore.pages.IndexPage;
import com.mystore.pages.ProductSearchResult;

public class productResultPageTest extends Base {
	public static IndexPage ip = new IndexPage();
	public static ProductSearchResult psr;

	@Test(dataProviderClass=com.mystore.dataprovider.DataFetcher.class, dataProvider="data")
	public void verifyProductAvailbility(HashMap<String,String> hm) {

		psr = ip.searchInSearchBox(hm.get("product"));
		boolean result = psr.productAvailibilty();
		Assert.assertTrue(result);

	}
}
