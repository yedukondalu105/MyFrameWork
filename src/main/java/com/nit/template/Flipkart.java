package com.nit.template;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Flipkart extends ShoppingTemplate {
	private WebDriver driver;
	private Map<String,String> data;
	private WebDriverWait wait;
	@FindBy(name="q")
	private WebElement searchBox_Flipkart;
	
	@FindBy(css="button[type='submit']")
	private WebElement searchButton_Flipkart;
	
	@FindBy(css="a[title='Apple iPhone 7 (Black, 32 GB)']")
	private WebElement iphone;
	
	@FindBy(css="button._2AkmmA")
	private List<WebElement> signIn_PopUp_Close;
	
	public Flipkart(WebDriver driver,Map<String,String> data) {
		this.driver=driver;
		this.data=data;
		wait=new WebDriverWait(driver,60);
		PageFactory.initElements(driver, this);
	}
	
	@Override
	public void launchSite() {
		driver.get(data.get("flipkarturl"));
		Predicate<List<WebElement>> p=i->i.size()>0;
		if(p.test(signIn_PopUp_Close)){
			signIn_PopUp_Close.get(0).click();
		}
		
	}

	@Override
	public void searchProduct() {
		searchBox_Flipkart.sendKeys(data.get("product"));
		searchButton_Flipkart.click();
//		Uninterruptibles.sleepUninterruptibly(30, TimeUnit.SECONDS);
		
	}

	@Override
	public void selectProduct() {
		wait.until(ExpectedConditions.visibilityOf(iphone));
		iphone.click();
		
	}

}
