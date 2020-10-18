package com.nit.testproj.common;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class NewTest {
  @Test
  public void f() {
  }
  @BeforeTest
  public void beforeTest() {
	  System.out.println("Just running from Maven in Before Test");
	 // JustTest jt=new JustTest();
	 // jt.testing();
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("Just running from Maven in After Test");
  }

}
