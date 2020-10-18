package com.nit.testproj.components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchWidgetInSearchResults {
	
	public WebDriver driver;
	public WebDriverWait wait;
	public SearchWidgetInSearchResults(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
		wait = new WebDriverWait(driver,60);
	}

	@FindBy(xpath = "//input[@name='q' and @class='gLFyf gsfi']")
	private WebElement searchBox_ResultsPage;
	
	@FindBy(xpath ="//li[@class='sbct']")
	private List<WebElement> autoCompleteOptions_SearchResults;
	
	
	
	
	public void waitUntilPageLoads() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		int counter=0;
		while(counter<60) {
			boolean state=js.executeScript("return document.readyState").toString().equals("complete");
			if(state) {
				break;
			}
			counter++;
		}
	}
	
	public void enterText_SearchResults(String text) {
		waitUntilPageLoads();
		searchBox_ResultsPage.clear();
		searchBox_ResultsPage.sendKeys(text);
		
	}
	
	public void autoCompleteOption_SearchResultsPage(int option) {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//li[@class='sbct'])["+option+"]")));
		autoCompleteOptions_SearchResults.get(option-1).click();
		waitUntilPageLoads();
		
	}
	
	
	
}
