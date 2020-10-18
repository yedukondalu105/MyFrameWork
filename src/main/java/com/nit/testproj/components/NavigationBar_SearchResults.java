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

import com.nit.testproj.common.AbstractComponent;

public class NavigationBar_SearchResults extends AbstractComponent {
	
	
	public NavigationBar_SearchResults(WebDriver driver) {
		super(driver);
	}

	
	
	@FindBy(xpath="//a[text()='News']")
	private WebElement news_link;
	
	@FindBy(xpath="//div[@id='result-stats']")
	private WebElement resultsCount;
	
	public void clickNewsLink() {
		
		news_link.click();
		waitUntilPageLoads();
	}
	
	public void printResultsCount() {
		
		System.out.println("No of Results Dispalyed are :: "+resultsCount.getText());
	}
	
}
