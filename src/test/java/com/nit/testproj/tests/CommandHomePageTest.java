package com.nit.testproj.tests;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.util.concurrent.Uninterruptibles;
import com.nit.command.ElementValidator;
import com.nit.command.HomePage;
import com.nit.testproj.common.BaseTest;
import com.nit.testproj.utilities.Data;

public class CommandHomePageTest extends BaseTest{
	
	private HomePage homePage;
	private Data data;
	private String currentMethodName;
	
	@DataProvider
	public Object[][] getData(){
		data = new Data();
		Class clas = this.getClass();
		Method[] m = clas.getDeclaredMethods();
		currentMethodName = m[1].getName();
		return data.getData("CommandPatternHomePage", currentMethodName);
	}	
	
	@Test(dataProvider="getData")
	public void homePageTest(Object obj) {
		Map<String,String> map=(Map<String,String>)obj;
		homePage=new HomePage(driver);
		homePage.goTo(map.get("url"));
		/*for(ElementValidator ev:homePage.getElementValidators()) {
			boolean result=ev.validate();
			Assert.assertTrue(result);
		}*/
		
		homePage.getElementValidators()
		.stream()
		.parallel()
		.map(ev->ev.validate())
		.forEach(b->Assert.assertTrue(b));
		Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
	}
	
}
