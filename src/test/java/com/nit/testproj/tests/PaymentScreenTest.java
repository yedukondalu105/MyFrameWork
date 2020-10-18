package com.nit.testproj.tests;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nit.testproj.common.BaseTest;
import com.nit.testproj.pages.CreditCard;
import com.nit.testproj.pages.PaymentOption;
import com.nit.testproj.pages.PaymentScreen;
import com.nit.testproj.utilities.Data;

public class PaymentScreenTest extends BaseTest {

	private PaymentScreen paymentScreen;
	private Data data;
	private String currentMethodName;
	
	@DataProvider
	public Object[][] getData(){
		data = new Data();
		Class clas = this.getClass();
		Method[] m = clas.getDeclaredMethods();
		currentMethodName = m[1].getName();
		return data.getData("Payment", currentMethodName);
	}
	@Test(dataProvider="getData")
	public void paymentTest(Object obj) {
		Map<String,String> map=(Map<String,String>) obj;
		paymentScreen =new PaymentScreen(driver);
		paymentScreen.goTo(map.get("url"));
		paymentScreen.getUserInformation().enterDetails(map.get("FirstName"), map.get("LastName"), map.get("Email"));
		paymentScreen.setPaymentOption(new CreditCard(driver));
		paymentScreen.pay(map);
		String orderNum=paymentScreen.getOrder().placeOrder();
		System.out.println("Order number is::"+orderNum);
		
	}
	
	
}
