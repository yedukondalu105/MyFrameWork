package com.nit.testproj.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.nit.testproj.pages.GoogleSearchPage;
import com.nit.testproj.pages.SearchResultsPage;
import com.nit.testproj.utilities.Util_Properties;
import com.nit.testproj.utilities.Utility;

public class GoogleTest implements Utility{
	
	public GoogleSearchPage gsp;
	public SearchResultsPage srp;
	public WebDriver driver;
 @Test
  public void googlepage() throws InterruptedException {
	 
	  Util_Properties utilprop=new Util_Properties();
	  System.out.println("Environment variable from POM Profile Is ::"+utilprop.p.get("environmentvar"));
	  gsp=new GoogleSearchPage(driver);
	  srp=new SearchResultsPage(driver);
	  gsp.goToURL("https://www.google.com/");
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	 // js.executeScript("document.body.style.backgroundColor = 'red';"
	  	//	+ "function fun() {return 20}"+"alert(fun());setTimeout(function(){ document.body.style.backgroundColor = 'green'; }, 3000);");
	//  String name=(String)js.executeScript("return 'Yedukondalu';");
	 // js.executeScript("alert("+name+");");
	 // js.executeScript("function fun(){"
	  	//	+ "alert('Hi this is from javascript executor')}fun();");
	 // js.executeScript("arguments[0].value='jaffa';",driver.findElement(By.name("q")));
	 js.executeScript("arguments[0].value='Dont click me'", driver.findElement(By.xpath("(//input[@name='btnK'])[2]")));
	  Thread.sleep(3000);
	  gsp.getSearchWidget().enterSearchText("Selenium");
	  gsp.getSearchSuggestion().clickSearchHelpOption(3);
	  srp.getSearchWidgetInSearchResults().enterText_SearchResults("selenium");
	  srp.getSearchWidgetInSearchResults().autoCompleteOption_SearchResultsPage(3);
	  srp.getNavigationBar_SearchResults().clickNewsLink();
	  srp.getNavigationBar_SearchResults().printResultsCount();
	  
	  
	  
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "./BrowserDrivers/chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
	 
	  driver.quit();
  }
  @BeforeMethod
  public void beforeMethod() {
	 
	  
  }

  @AfterMethod
  public void afterMethod(ITestResult result) {
	 if(ITestResult.SUCCESS==result.getStatus()) {
	  System.out.println(result.getName()+" is passed");
	 }
	 else if(ITestResult.FAILURE==result.getStatus()) {
		 System.out.println(result.getName()+" is failed");
		 Utility.printScreen(driver, result.getName());
	 }
	  
  }


}
