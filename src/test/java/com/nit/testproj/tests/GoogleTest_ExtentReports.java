package com.nit.testproj.tests;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.nit.testproj.common.BaseTest;
import com.nit.testproj.pages.GoogleSearchPage;
import com.nit.testproj.pages.SearchResultsPage;
import com.nit.testproj.utilities.Data;
import com.nit.testproj.utilities.Util_Properties;

public class GoogleTest_ExtentReports<T> extends BaseTest {

	public Data data;
	String currentMethodName;
	public GoogleSearchPage gsp;
	public SearchResultsPage srp;
	@DataProvider(name = "data")
	public Object[][] getData() {
		data = new Data();
		Class clas = this.getClass();
		Method[] m = clas.getDeclaredMethods();
		currentMethodName = m[1].getName();
		return data.getData("data1", currentMethodName);
	}

	@Test(dataProvider = "data")
	public void googlepage(Object obj) throws InterruptedException, IOException {
		Map<String, String> map = (Map<String, String>) obj;
		test = extent.createTest(currentMethodName);
		// System.out.println(System.getProperty("user.dir"));

		Util_Properties utilprop = new Util_Properties();
		System.out.println("Environment variable from POM Profile Is ::" + utilprop.p.get("environmentvar"));
		gsp = new GoogleSearchPage(driver);
		srp = new SearchResultsPage(driver);
		gsp.goToURL(map.get("url"));
		test.log(Status.PASS, "Navigated to Google Home page");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='Dont click me'",
				driver.findElement(By.xpath("(//input[@name='btnK'])[2]")));
		Thread.sleep(3000);
		gsp.getSearchWidget().enterSearchText(map.get("searchtext"));
		test.log(Status.PASS, "The search test is entered");
		gsp.getSearchSuggestion().clickSearchHelpOption(3);
		test.log(Status.PASS, "Third Suggestion has been selected");
		srp.getSearchWidgetInSearchResults().enterText_SearchResults(map.get("searchtext"));
		test.log(Status.PASS, "The search test selenium is entered again");
		srp.getSearchWidgetInSearchResults().autoCompleteOption_SearchResultsPage(3);
		test.log(Status.PASS, "AutoComplete option 3 has been selected");
		//Assert.assertEquals(true, false);
		srp.getNavigationBar_SearchResults().clickNewsLink();
		test.log(Status.PASS, "News link has been clicked");
		srp.getNavigationBar_SearchResults().printResultsCount();
		test.log(Status.PASS, "Search Results count has been printed");
		//stepFail("This step is failed",currentMethodName);
		// test.fail("screenshot",
		// MediaEntityBuilder.createScreenCaptureFromPath("resources/screenshots/googlepage.png").build());
		//test.pass("PassWithScreenshot", provider)
		//test.fail
		//test.pass("TestPassWithScreenPrint", MediaEntityBuilder.createScreenCaptureFromPath(System.getProperty("user.dir")+"/resources/screenshots/"+currentMethodName+".png").build());
		//test.addScreenCaptureFromPath(System.getProperty("user.dir")+"/resources/screenshots/"+currentMethodName+".png");
		// test.add
		// test.fai
	}

}
