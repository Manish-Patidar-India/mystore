package com.mystore.dataprovider;



import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import com.mystore.utility.ReadingFromExcel;

public class DataFetcher {

	@DataProvider(name="data")
	public Object[] getProductData(Method m) throws IOException, Throwable {
		   
		return ReadingFromExcel.readData("productDetails");
		
		 
	}
	
	@DataProvider(name="AccountCreationDetails")
	public Object[] getDataForACCCreation(Method m) throws IOException, Throwable {
		   
		return ReadingFromExcel.readData("AccountCreation");
		
		 
	}
	
}
