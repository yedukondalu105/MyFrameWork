package com.nit.testproj.tests;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.nit.testproj.common.BaseTest;
import com.nit.testproj.utilities.Data;

public class Facebook_SignUp extends BaseTest {

	public Data data;
	String currentMethodName;

	@DataProvider(name = "data")
	public Object[][] getData() {
		data = new Data();
		Class clas = this.getClass();
		Method[] m = clas.getDeclaredMethods();
		currentMethodName = m[1].getName();
		return data.getData("data1", currentMethodName);
	}

	@Test(dataProvider = "data")
	public void facebookSignUp(Object obj) throws InterruptedException, IOException {
		Map<String, String> map = (Map<String, String>) obj;
		test = extent.createTest(currentMethodName);
		driver.get("https://sspensions.ap.gov.in/searchpensionStatus.do");	
		driver.findElement(By.id("pensionSearch")).click();
		
	}

}
