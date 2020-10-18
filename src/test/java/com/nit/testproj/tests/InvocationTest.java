package com.nit.testproj.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class InvocationTest {
	int noOfIterations=0;
/*@Parameters({"count"})	
  @BeforeTest
  public void beforeTest(String count) {
	noOfIterations=Integer.parseInt(count);
  }*/
   @DataProvider
   public Object[][] getData(){
	   return new Object[3][1];
   }
  //@Parameters({"count"})
  @Test(/*invocationCount=10,*/dataProvider="getData")
  public void f(Object[][] itr) {
	  System.out.println("Print me no of times");
  }
}
