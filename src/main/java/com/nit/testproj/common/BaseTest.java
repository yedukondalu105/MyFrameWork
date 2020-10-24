package com.nit.testproj.common;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.util.concurrent.Uninterruptibles;
import com.nit.testproj.utilities.Utility;


public abstract class BaseTest {
  
	public static WebDriver driver;
	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	
	  @BeforeTest
	  public void beforeTest() {
		  htmlReporter=new ExtentHtmlReporter("test-output/myReport.html");
		  htmlReporter.config().setDocumentTitle("Automation Report");
		  htmlReporter.config().setReportName("Functional Report");
		  htmlReporter.config().setTheme(Theme.STANDARD);
		  
		  extent = new ExtentReports();
		  extent.attachReporter(htmlReporter);
		  extent.setSystemInfo("Hostname", "LocalHost");
		  extent.setSystemInfo("OS", "LINUX");
		  extent.setSystemInfo("TesterName", "Yedukondalu");
		  extent.setSystemInfo("Browser", "chrome");
		 System.out.println(System.getProperty("env"));
	  }

	  @AfterTest
	  public void afterTest() {
		  extent.flush();
		 
	  }
	  @BeforeMethod
	  public void beforeMethod()  {
		//String host="localhost";
		String host="127.0.0.1";
		//http://127.0.0.1:4444/grid/console
		
		//  String nodeURL="http://192.168.1.102:14216/wd/hub";
		  DesiredCapabilities dc=DesiredCapabilities.chrome();
		  if(System.getProperty("BROWSER")!=null && System.getProperty("BROWSER").equalsIgnoreCase("firefox")) {
			  dc=DesiredCapabilities.firefox();
		  }
		  if(System.getProperty("HUB_HOST")!=null) {
			  host=System.getProperty("HUB_HOST");
		  }
		  String completeUrl="http://"+host+":4444/wd/hub";
		 	//  cap.setPlatform(Platform.LINUX);
		  
		  //driver=new RemoteWebDriver(new URL(nodeURL), cap);
		  System.setProperty("webdriver.chrome.driver", "BrowserDrivers/chromedriverlinux");
		  try {
			driver=new RemoteWebDriver(new URL(completeUrl),dc);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		//  driver=new ChromeDriver();
		//  driver.manage().window().maximize();
		  
	  }

	  @AfterMethod
	  public void afterMethod(ITestResult result) {
		 /*if(ITestResult.SUCCESS==result.getStatus()) {
		  System.out.println(result.getName()+" is passed");
		  
		 }
		 else if(ITestResult.FAILURE==result.getStatus()) {
			 System.out.println(result.getName()+" is failed");
			 Utility.printScreen(driver, result.getName());
			 test.log(Status.FAIL, result.getName());
			 
			 try {
				test.addScreenCaptureFromPath(System.getProperty("user.dir")+"/resources/screenshots/"+result.getName()+".png");
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		 }*/
		  Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
		 driver.quit();
	  }
	  public void stepFail(String failMsg,String testName) {
		 String path= Utility.printScreen(driver, testName);
		 try {
			test.fail(failMsg, MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
}
