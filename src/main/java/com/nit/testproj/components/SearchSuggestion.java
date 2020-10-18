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

public class SearchSuggestion extends AbstractComponent {
	
	
	public SearchSuggestion(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath = "//li[@class='sbct']")
	private List<WebElement> helpOptions;
	
	
		
	public void clickSearchHelpOption(int option) {
		//wait.until(ExpectedConditions.visibilityOf(helpOptions.get(option-1)));
		//wait.until(ExpectedConditions.p);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//li[@class='sbct'])["+option+"]")));
		/*try {
			Thread.sleep(4000);
		}
		catch(InterruptedException e) {
			
		}*/
		helpOptions.get(option-1).click();
	}
	

}
