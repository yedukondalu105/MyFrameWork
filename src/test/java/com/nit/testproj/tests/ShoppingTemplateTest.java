package com.nit.testproj.tests;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nit.template.Amazon;
import com.nit.template.Flipkart;
import com.nit.template.ShoppingPage;
import com.nit.testproj.common.BaseTest;
import com.nit.testproj.utilities.Data;

public class ShoppingTemplateTest extends BaseTest{
	private Data data;
	private String currentMethodName;
	private ShoppingPage shoppingPage;	
	@DataProvider
	public Object[][] getData(){
		data = new Data();
		Class clas = this.getClass();
		Method[] m = clas.getDeclaredMethods();
		currentMethodName = m[1].getName();
		return data.getData("shopping", currentMethodName);
	}
	
	
	@Test(dataProvider="getData")
	public void shoppingTest(Object obj) {
		Map<String,String> map=(Map<String,String>)obj;
		shoppingPage = new ShoppingPage(driver,map);
		//shoppingPage.shopProduct(new Amazon(driver,map));
		shoppingPage.shopProduct(new Flipkart(driver, map));
		
		
	}
	
	
}
