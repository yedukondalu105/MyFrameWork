package com.nit.testproj.pages;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreditCard implements PaymentOption{
	private WebDriver driver;
	@FindBy(id="cc")
	private WebElement cc;
	
	@FindBy(id="year")
	private WebElement year;
	
	@FindBy(id="cvv")
	private WebElement cvv;
	
	public CreditCard(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@Override
	public void enterPaymentInformation(Map<String, String> paymentDetails) {
		cc.sendKeys(paymentDetails.get("cc"));
		year.sendKeys(paymentDetails.get("year"));
		cvv.sendKeys(paymentDetails.get("cvv"));
		
	}

}
