package com.nit.testproj.pages;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NetBanking implements PaymentOption{
	
	private WebDriver driver;
	
	@FindBy(id="bank")
	private WebElement bank;
		
	@FindBy(id="acc number")
	private WebElement accNumber;
	
	@FindBy(id="pin")
    private WebElement pin;
	
	public NetBanking(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@Override
	public void enterPaymentInformation(Map<String, String> paymentDetails) {
		Select bankDropDown = new Select(bank);
		bankDropDown.selectByValue(paymentDetails.get("bank"));
		accNumber.sendKeys(paymentDetails.get("account"));
		pin.sendKeys(paymentDetails.get("pin"));
		
	}

}
