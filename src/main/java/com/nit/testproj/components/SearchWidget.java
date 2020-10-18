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

public class SearchWidget extends AbstractComponent {
	
	
	public SearchWidget(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(name = "q")
	private WebElement searchBox;
	
	
	public void goToURL(String url) {
		driver.get(url);
	}
	
	public void enterSearchText(String text) {
		waitUntilPageLoads();
		wait.until(ExpectedConditions.visibilityOf(searchBox));
		searchBox.sendKeys(text);
	}
	
	
	

}
