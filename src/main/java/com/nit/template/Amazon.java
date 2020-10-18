package com.nit.template;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.util.concurrent.Uninterruptibles;

public class Amazon extends ShoppingTemplate{
	private WebDriver driver;
	private Map<String,String> data;
	private WebDriverWait wait;
	@FindBy(id="twotabsearchtextbox")
	private WebElement searchBox_Amazon;
	
	@FindBy(css="input[value='Go']")
	private WebElement Search_Button;
	
	@FindBy(xpath="//span[text()='Apple iPhone XR (128GB) - Black']")
	private WebElement appleIphone;
	
	public Amazon(WebDriver driver,Map<String,String> data) {
		this.driver=driver;
		this.data=data;
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver,60);
	}
	@Override
	public void launchSite() {
		
		driver.get(data.get("amazonurl"));
	}

	@Override
	public void searchProduct() {
		searchBox_Amazon.sendKeys(data.get("product"));
		Search_Button.click();
		
		
	}

	@Override
	public void selectProduct() {
		wait.until(ExpectedConditions.visibilityOf(appleIphone));
		appleIphone.click();		
	}

}
