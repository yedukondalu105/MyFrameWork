package com.nit.testproj.tests;

import java.lang.reflect.Method;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.nit.testproj.common.BaseTest;
import com.nit.testproj.pages.GoogleSearchPage;
import com.nit.testproj.pages.SearchResultsPage;
import com.nit.testproj.utilities.Data;
//@Listeners(com.nit.testproj.listeners.lItestListener.class)
public class Google_DataProvider extends BaseTest {
	
	public GoogleSearchPage gsp;
	public SearchResultsPage srp;
	public WebDriver driver;
	String currentClassName;
	public Data data=null;
	@DataProvider(name="data")
	public Object[][] getData(){
		data=new Data();
		Class clas=this.getClass();
		Method[] m=clas.getDeclaredMethods();
		currentClassName=m[1].getName();
		return data.getData("data1",currentClassName);
	}
 @Test(dataProvider="data")
  public void googlepage(Object obj) throws InterruptedException {
	 Map<String,String> map=(Map<String,String>)obj;
	 System.out.println(map);
	 Actions act=new Actions(driver);
	 act.sendKeys("").build().perform();
	 
  }
 
  @BeforeTest
  public void beforeTest() {
	 /* System.setProperty("webdriver.chrome.driver", "./BrowserDrivers/chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();*/
  }

  @AfterTest
  public void afterTest() {
	 // driver.quit();
  }
  @BeforeMethod
  public void beforeMethod() {
	 
	  
  }

  @AfterMethod
  public void afterMethod() {
	  
	  
  }

}
